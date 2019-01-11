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
import java.nio.charset.Charset;
import java.util.concurrent.*;

@Slf4j
public class MoraProcessor {
    private MoraScheduler ms;

    private void complete() {
        while (true) {
            if (!ms.hasResponse()) {
                CommonUtils.sleep(100);
                continue;
            }
            MoraResponse res = ms.nextResponse();
            InputStreamReader reader = new InputStreamReader(res.getIs(), Charset.forName(res.getCharset()));
            MoraMaterialEntity me = new Gson().fromJson(reader, MoraMaterialEntity.class);
            log.info("[{}] : {}",res.getId(),me.getTitle());
        }
    }

    public void start() {
        ThreadFactory listenerThreadFactory = new ThreadFactoryBuilder().setNameFormat("Mora-Catch-%02d").build();
        ExecutorService p = new ThreadPoolExecutor(16, 16, 10L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(1024), listenerThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        ms = new MoraScheduler(31, 12_876_924);
        for (int i = 0; i < 1; i++) {
            p.execute(new MoraDownloader(ms));
        }
        this.complete();
    }

    public static void main(String[] args) {
        MoraProcessor mp = new MoraProcessor();
        mp.start();
    }

}
