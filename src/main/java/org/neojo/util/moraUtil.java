package org.neojo.util;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class moraUtil {
    private static String BASE_URL = "https://cf.mora.jp/contents/package/%04d/%08d/%04d/%03d/%03d/packageMeta.json";

    public static int maxpno;

    public static void setBaseUrl(String baseUrl) {
        BASE_URL = baseUrl;
    }

    public static String getPackageUrl(int mountPoint, int labelId, int materialNo) {
        return String.format(BASE_URL, mountPoint, labelId, materialNo / 1000000, materialNo % 1000000 / 1000, materialNo % 1000);
    }

    public static String getPackageUrl(int labelId, int materialNo) {
        return getPackageUrl(0, labelId, materialNo);
    }

    public static int getMateriaNo(String url) {
        String[] strs = url.split("/");
        return Integer.parseInt(strs[7]+strs[8]+strs[9]);
    }

    public static int maxpno(int pno) {
        if (maxpno < pno) maxpno = pno;
        return maxpno;
    }

    @Test
    public void test() {
        getMateriaNo("https://cf.mora.jp/contents/package/0000/00000031/0012/876/924/packageMeta.json");
    }
}
