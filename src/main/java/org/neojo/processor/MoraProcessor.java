package org.neojo.processor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.*;
import org.neojo.downloader.MoraDownloader;
import org.neojo.entity.MoraMaterialEntity;
import org.neojo.response.MoraResponse;
import org.neojo.scheduler.MoraScheduler;
import org.neojo.util.CommonUtils;
import org.neojo.util.MoraUtil;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.*;

/**
 * @author neo
 */
@Slf4j
public class MoraProcessor {
    private final ExecutorService p;
    private final ScheduledExecutorService executor;
    private MoraScheduler ms;
    private final int threads;
    private final int label;
    private int no;
    private boolean running = true;

    private SimpleDateFormat frsdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private SimpleDateFormat tosdf = new SimpleDateFormat("yyMMdd");

    private MoraProcessor(int label, int no, int threads) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("Mora-Catch-%02d").build();
        p = new ThreadPoolExecutor(threads, threads, 10L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(1024), threadFactory, new ThreadPoolExecutor.AbortPolicy());
        executor = Executors.newScheduledThreadPool(2);
        this.threads = threads;
        this.label = label;
        this.no = no;
        this.ms = new MoraScheduler(label, no);
    }

    private void complete() {
        while (running) {
            if (!ms.hasResponse()) {
                CommonUtils.sleep(100);
                continue;
            }
            MoraResponse res = ms.nextResponse();
            InputStreamReader reader = new InputStreamReader(res.getIs(), Charset.forName(res.getCharset()));
            MoraMaterialEntity me = new Gson().fromJson(reader, MoraMaterialEntity.class);
            try {
                Integer mediaFormatNo = me.getMediaFormatNo();
                log.info("[{}] : {}[{}] {} - {} {}", res.getId(),
                        (mediaFormatNo==12||mediaFormatNo==13)?"[Hi-Res]":"",
                        tosdf.format(frsdf.parse(me.getDispStartDate())),
                        me.getArtistName(), me.getTitle(),  MoraUtil.getMediaFormat(me));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    private void monitor() {
        int now = ms.getNo();
        int spd = (now - no) / 5;
        int activeCount = ((ThreadPoolExecutor) p).getActiveCount();
        no = now;
        if (activeCount > 0 || ms.hasResponse()) {
            log.info("Label:{} - {}/{} Speed: {}/s", label, now, ms.getMax(), spd);
        } else {
            log.info("Label:{} - {}/{} Speed: {}/s \nTask Complete", label, now, ms.getMax(), spd);
            running = false;
            executor.shutdown();
        }
    }

    private void heartbeat() {
        MoraResponse mr = new MoraDownloader(ms).request(31, 12876924);
        if (mr.getCode() != HttpURLConnection.HTTP_OK) {
            log.warn("Heartbeat Failed ");
        }
    }

    public void start() {
        log.info("Mora Catch Processor Start, Threads: {}", threads);
        for (int i = 0; i < threads; i++) {
            p.execute(new MoraDownloader(ms));
        }
        executor.scheduleAtFixedRate(this::monitor, 1, 5, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(this::heartbeat, 1, 1, TimeUnit.SECONDS);
        this.complete();
    }

    public static void main(String[] args) {
        Options options = new Options();
        options.addRequiredOption("l", "label-id", true, "Mora Label ID");
        options.addRequiredOption("n", "material-no", true, "Mora MaterialNo");
        options.addOption("t", true, "number of threads");

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();

        try {
            CommandLine cmd = parser.parse(options, args);
            int label = Integer.parseInt(cmd.getOptionValue("l"));
            int no = Integer.parseInt(cmd.getOptionValue("n"));
            int threads = cmd.hasOption("t")
                    ? Integer.parseInt(cmd.getOptionValue("t"))
                    : Runtime.getRuntime().availableProcessors() * 4;

            MoraProcessor mp = new MoraProcessor(label, no, threads);
            mp.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);
        } finally {
            System.exit(1);
        }
    }
}
