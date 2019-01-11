package org.neojo.util;

import java.util.concurrent.TimeUnit;

public class CommonUtils {
    public static void sleep(long time){
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
