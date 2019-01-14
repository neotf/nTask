package org.neojo.downloader;

import io.github.biezhi.request.Request;
import io.github.biezhi.request.RequestException;
import lombok.extern.slf4j.Slf4j;
import org.neojo.config.Config;
import org.neojo.config.RequestConfig;
import org.neojo.response.MoraResponse;
import org.neojo.scheduler.MoraScheduler;
import org.neojo.util.CommonUtils;
import org.neojo.util.MoraUtil;

import java.net.HttpURLConnection;

/**
 * @author neo
 */
@Slf4j
public class MoraDownloader implements Runnable {
    private final MoraScheduler ms;
    private final Config CFG = new Config();
    private final RequestConfig RC = new RequestConfig();
    private final int label;
    private boolean isRunning = true;

    public MoraDownloader(MoraScheduler ms) {
        this.ms = ms;
        this.label = ms.getLabel();
    }

    public MoraResponse request(int no) {
        return request(label, no);
    }

    public MoraResponse request(int label, int no) {
        Request req = Request.get(MoraUtil.getPackageUrl(label, no))
                .headers(RC.getHeaders())
                .connectTimeout(CFG.timeout()).readTimeout(CFG.timeout());
        int code;
        try {
            code = req.code();
        } catch (RequestException e) {
            CommonUtils.sleep(500);
            return request(label, no);
        }
        if (code != HttpURLConnection.HTTP_OK) {
            log.debug("HTTP-{} - [{}]", code, no);
        }
        return new MoraResponse(code, no, req.stream(), req.charset());
    }

    @Override
    public void run() {
        log.info("Start");
        CommonUtils.sleep(1000L);
        while (isRunning) {
            int no = ms.no();
            if (ms.max() < no) {
                CommonUtils.sleep(1000L);
            }
            MoraResponse mr = request(no);
            if (mr.getCode() == HttpURLConnection.HTTP_OK) {
                ms.addResponse(mr);
                ms.max(no + 100000);
            }
            CommonUtils.sleep(100);
        }
    }

    public void stop() {
        this.isRunning = false;
    }
}
