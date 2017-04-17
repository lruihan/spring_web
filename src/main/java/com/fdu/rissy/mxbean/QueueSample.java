package com.fdu.rissy.mxbean;

import java.beans.ConstructorProperties;
import java.util.Date;

/**
 * Created by lins13 on 4/17/17.
 */
public class QueueSample {

    private final Date date;
    private final int size;
    private final String head;

    @ConstructorProperties({"date", "size", "head"})
    public QueueSample(Date date, int size, String head) {
        this.date = date;
        this.size = size;
        this.head = head;
    }

    public Date getDate() {
        return date;
    }

    public int getSize() {
        return size;
    }

    public String getHead() {
        return head;
    }

}
