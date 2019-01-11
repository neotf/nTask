package org.neojo.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.neojo.response.MoraResponse;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Slf4j
public class MoraScheduler {
    private BlockingQueue<MoraResponse> result  = new LinkedBlockingQueue<>();
    private final int label;
    private int mNo;
    private int maxNo;

    public MoraScheduler(int label,int mNo) {
        this.label = label;
        this.mNo = mNo;
        this.maxNo = mNo + 10000;
    }

    public int getLabel() {
        return label;
    }

    public int getMax() {
        return maxNo;
    }

    public synchronized int getMax(int mno) {
        if (maxNo < mno) {
            maxNo = mno;
        }
        return maxNo;
    }

    public synchronized int getNo() {
        return mNo++;
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
