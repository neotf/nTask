package org.neojo.processor;

import com.google.gson.Gson;
import io.github.biezhi.elves.Elves;
import io.github.biezhi.elves.config.Config;
import io.github.biezhi.elves.pipeline.Pipeline;
import io.github.biezhi.elves.request.Request;
import io.github.biezhi.elves.response.Response;
import io.github.biezhi.elves.response.Result;
import io.github.biezhi.elves.spider.Spider;
import lombok.extern.slf4j.Slf4j;
import org.neojo.entity.MoraMaterialEntity;
import org.neojo.util.moraUtil;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Slf4j
public class MoraProcessor extends Spider {
    private int labelId;

    public MoraProcessor(int labelId, int startNo) {
        super("Mora Processor");
        this.labelId = labelId;
        moraUtil.maxpno = startNo+1;
        this.startUrls(moraUtil.getPackageUrl(labelId, startNo));
    }

    @Override
    public void onStart(Config config) {
        this.addPipeline((Pipeline<List<String>>) (item, request) -> item.forEach(System.out::println));
//        this.requests.forEach(request -> {
//            request.contentType("text/html; charset=gb2312");
//            request.charset("UTF-8");
//        });
    }

    @Override
    protected Result parse(Response response) {
        Result<List<String>> result = new Result<>();
        if (response.code() == 200) {
            MoraMaterialEntity m = new Gson().fromJson(response.body().toString(), MoraMaterialEntity.class);
            log.info("获取到 [{}] - {}",m.getMaterialNo(),m);
            for (int i = moraUtil.maxpno; i < moraUtil.maxpno(m.getMaterialNo()+50000); i++) {
                Request req = this.makeRequest(moraUtil.getPackageUrl(labelId, i), this::parse);
                result.addRequest(req);
            }
        }else{
            log.info("不存在 [{}]",moraUtil.getMateriaNo(response.getRequest().getUrl()));
        }

        return result;
    }

    public static void main(String[] args) {
        Thread downloadTread = new Thread(() ->
                Elves.me(
                        new MoraProcessor(31, 12876924),
                        new Config().delay(100).delayOffset(100)
                ).start()
        );
        downloadTread.setDaemon(true);
        downloadTread.start();


        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                log.info("Maxpno:" + moraUtil.maxpno);
            }
        },1000,1000);
    }

}
