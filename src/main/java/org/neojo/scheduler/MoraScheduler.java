package org.neojo.scheduler;

public class MoraScheduler {
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
}
