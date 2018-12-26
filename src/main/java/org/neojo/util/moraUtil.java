package org.neojo.util;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class moraUtil {
    private static String BASE_URL = "https://cf.mora.jp/contents/package/%04d/%08d/%04d/%03d/%03d/packageMeta.json";

    public static void setBaseUrl(String baseUrl) {
        BASE_URL = baseUrl;
    }

    public static List<String> getUrlList(int labelId, int materialNo , int num) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(getPackageUrl(labelId, materialNo + i));
        }
        return list;
    }

    public static String getPackageUrl(int mountPoint, int labelId, int materialNo) {
        return String.format(BASE_URL, mountPoint, labelId, materialNo / 1000000, materialNo % 1000000 / 1000, materialNo % 1000);
    }

    public static String getPackageUrl(int labelId, int materialNo) {
        return getPackageUrl(0, labelId, materialNo);
    }

    public static String[] getMateriaNo(String url){
        log.info(new Gson().toJson(url.split("/")));
        return null;
    }

    @Test
    public void test(){
        getMateriaNo("https://cf.mora.jp/contents/package/0000/00000031/0012/876/924/packageMeta.json");
    }
}
