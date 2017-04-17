package com.fdu.rissy.mbean;

/**
 * Created by lins13 on 4/17/17.
 */
public interface SystemConfigMBean {

    void setThreadCount(int noOfThreads);
    int getThreadCount();
    void setSchemaName(String schemaName);
    String getSchemaName();
    String doConfig();
}
