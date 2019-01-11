package org.neojo.processor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import lombok.extern.slf4j.Slf4j;
import org.neojo.downloader.MoraDownloader;
import org.neojo.scheduler.MoraScheduler;

import java.util.concurrent.*;

@Slf4j
public class MoraProcessor {
    public static void main(String[] args) {
        ThreadFactory listenerThreadFactory = new ThreadFactoryBuilder().setNameFormat("Mora-Catch-%02d").build();
        ExecutorService p = new ThreadPoolExecutor(16, 16, 10L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(1024), listenerThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        MoraScheduler ms = new MoraScheduler(31, 12_876_924);
        for (int i = 0; i < 1; i++) {
            p.execute(new MoraDownloader(ms));
        }

//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                log.info("Maxpno: {}", ms.getMax());
//            }
//        }, 1000, 1000);
    }

}
