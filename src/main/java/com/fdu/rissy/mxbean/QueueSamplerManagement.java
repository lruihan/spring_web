package com.fdu.rissy.mxbean;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by lins13 on 4/17/17.
 */
public class QueueSamplerManagement {

    public static void main(String[] args) throws Exception{
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName mxbeanName = new ObjectName("com.fdu.rissy.mxbean:type=QueueSampler");

        Queue<String> queue = new ArrayBlockingQueue<String>(10);

        queue.add("Request-1");
        queue.add("Request-2");
        queue.add("Request-3");

        QueueSampler mxbean = new QueueSampler(queue);

        mBeanServer.registerMBean(mxbean, mxbeanName);

        System.out.println("Waiting...");
        Thread.sleep(Long.MAX_VALUE);
    }
}
