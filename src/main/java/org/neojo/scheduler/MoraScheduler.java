package org.neojo.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.neojo.response.MoraResponse;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Slf4j
public class MoraScheduler {
    private BlockingQueue<MoraResponse> result  = new LinkedBlockingQueue<>();
    private final int label;
    private int no;
    private int max;

    public MoraScheduler(int label,int no) {
        this.label = label;
        this.no = no;
        this.max = no + 100000;
    }

    public int getLabel() {
        return label;
    }

    public int max() {
        return max;
    }

    public synchronized int max(int no) {
        if (max < no) {
            max = no;
        }
        return max;
    }

    public synchronized int no() {
        return no++;
    }

    public void addResponse(MoraResponse response) {
        try {
            this.result.put(response);
        } catch (InterruptedException e) {
            log.error("向调度器添加 Response 出错", e);
        }
    }

    public boolean hasResponse() {
        return result.size() > 0;
    }

    public MoraResponse nextResponse() {
        try {
            return result.take();
        } catch (InterruptedException e) {
            log.error("从调度器获取 Response 出错", e);
            return null;
        }
    }
}
