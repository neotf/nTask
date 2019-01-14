package org.neojo.processor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.neojo.downloader.MoraDownloader;
import org.neojo.entity.MoraMaterialEntity;
import org.neojo.response.MoraResponse;
import org.neojo.scheduler.MoraScheduler;
import org.neojo.util.CommonUtils;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.util.concurrent.*;

/**
 * @author neo
 */
@Slf4j
public class MoraProcessor {
    private MoraScheduler ms;
    private final int threads;
    private final int label;
    private int no;

    public MoraProcessor(int label, int no, int threads) {
        this.threads = threads;
        this.label = label;
        this.no = no;
        this.ms = new MoraScheduler(label, no);
    }

    private void complete() {
        while (true) {
            if (!ms.hasResponse()) {
                CommonUtils.sleep(100);
                continue;
            }
            MoraResponse res = ms.nextResponse();
            InputStreamReader reader = new InputStreamReader(res.getIs(), Charset.forName(res.getCharset()));
            MoraMaterialEntity me = new Gson().fromJson(reader, MoraMaterialEntity.class);
            log.info("[{}] : {}", res.getId(), me.getTitle());
        }
    }

    private void monitor() {
        int now = ms.no();
        int spd = (now - no) / 5;
        no = now;
        log.info("Label:{} - {}/{} Speed: {}/s", label, now, ms.max(), spd);
    }

    private void heartbeat() {
        MoraResponse mr = new MoraDownloader(ms).request(31, 12876924);
        if (mr.getCode() != HttpURLConnection.HTTP_OK) {
            log.warn("Heartbeat Failed ");
        }
    }

    public void start() {
        ThreadFactory listenerThreadFactory = new ThreadFactoryBuilder().setNameFormat("Mora-Catch-%02d").build();
        ExecutorService p = new ThreadPoolExecutor(threads, threads, 10L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(1024), listenerThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < threads; i++) {
            p.execute(new MoraDownloader(ms));
        }

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.scheduleAtFixedRate(this::monitor, 5, 5, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(this::heartbeat, 1, 1, TimeUnit.SECONDS);
        this.complete();
    }

    public static void main(String[] args) {
        int label = Integer.parseInt(args[0]);
        int no = Integer.parseInt(args[1]);
        int threads = Integer.parseInt(args[2]);
        MoraProcessor mp = new MoraProcessor(label, no, threads);
        mp.start();
    }

}
