package org.neojo.test;

import org.neojo.processor.MoraProcessor;

/**
 * @Author: neo
 * @Date: 2019/1/14 23:32
 */
public class MoraTest {
    public static void main(String[] args) {
        MoraProcessor.main(new String[]{"-l", "68", "-n", "13187000", "-t", "64"});
    }
}
