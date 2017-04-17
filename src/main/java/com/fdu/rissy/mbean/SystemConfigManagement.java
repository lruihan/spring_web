package com.fdu.rissy.mbean;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * Created by lins13 on 4/17/17.
 */
public class SystemConfigManagement {

    private static final int DEFAULT_NO_THREADS = 10;
    private static final String DEFAULT_SCHEMA = "default";

    public static void main(String[] args) throws Exception{
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        SystemConfig systemConfig = new SystemConfig(DEFAULT_NO_THREADS, DEFAULT_SCHEMA);
        ObjectName name = new ObjectName("com.fdu.rissy.mbean:type=SystemConfig");
        mBeanServer.registerMBean(systemConfig, name);
        do {
            Thread.sleep(3000);
            System.out.println("Thread Count=" + systemConfig.getThreadCount() + ":Schema Name=" + systemConfig.getSchemaName());
        }while(systemConfig.getThreadCount() != 0);
    }
}
