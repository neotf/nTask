package org.neojo.util;

public class MoraUtil {
    private static String BASE_URL = "https://cf.mora.jp/contents/package/%04d/%08d/%04d/%03d/%03d/packageMeta.json";

    public static String getPackageUrl(int mountPoint, int labelId, int materialNo) {
        return String.format(BASE_URL, mountPoint, labelId, materialNo / 1000000, materialNo % 1000000 / 1000, materialNo % 1000);
    }

    public static String getPackageUrl(int labelId, int materialNo) {
        return getPackageUrl(0, labelId, materialNo);
    }
}
