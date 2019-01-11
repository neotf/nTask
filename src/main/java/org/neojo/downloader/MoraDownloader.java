package org.neojo.downloader;

import com.google.gson.Gson;
import io.github.biezhi.request.Request;
import lombok.extern.slf4j.Slf4j;
import org.neojo.entity.MoraMaterialEntity;
import org.neojo.scheduler.MoraScheduler;
import org.neojo.util.MoraUtil;

import java.util.concurrent.TimeUnit;

@Slf4j
public class MoraDownloader implements Runnable {
    private MoraScheduler ms;
    private int label;
    private boolean isRunning = true;

    public MoraDownloader(MoraScheduler ms) {
        this.ms = ms;
        this.label = ms.getLabel();
    }

    @Override
    public void run() {
        log.info("Start");
        sleep(1000L);
        while (isRunning) {
            int mNo = ms.getNo();
            if (ms.getMax() < mNo) {
                sleep(1000L);
            }
            Request httpReq = Request.get(MoraUtil.getPackageUrl(label, mNo));
            Request req = httpReq.connectTimeout(60_000).readTimeout(60_000);
            int code = req.code();
            if (code == 200) {
                MoraMaterialEntity m = new Gson().fromJson(req.reader(), MoraMaterialEntity.class);
                log.info("HTTP-{} - [{}] : {}", code, mNo, m.getTitle());
            } else {
                log.debug("HTTP-{} - [{}]", code, mNo);
            }
            sleep(500L);
        }
    }

    private void sleep(long time) {
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
