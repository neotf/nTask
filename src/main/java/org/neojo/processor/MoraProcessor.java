package org.neojo.processor;

import com.google.gson.Gson;
import io.github.biezhi.elves.Elves;
import io.github.biezhi.elves.config.Config;
import io.github.biezhi.elves.pipeline.Pipeline;
import io.github.biezhi.elves.response.Response;
import io.github.biezhi.elves.response.Result;
import io.github.biezhi.elves.spider.Spider;
import lombok.extern.slf4j.Slf4j;
import org.neojo.entity.MoraMaterialEntity;
import org.neojo.util.moraUtil;
import java.util.List;

@Slf4j
public class MoraProcessor extends Spider {

    public MoraProcessor(String name) {
        super(name);
        this.startUrls(moraUtil.getPackageUrl(31, 12876924));
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
        Result<List<String>> result   = new Result<>();
        MoraMaterialEntity m = new Gson().fromJson(response.body().toString(),MoraMaterialEntity.class);
        log.info(new Gson().toJson(m));
        return result;
    }

    public static void main(String[] args) {
        Elves.me(new MoraProcessor("Mora Database")).start();
    }

}
