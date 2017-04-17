package com.fdu.rissy.mbean;

/**
 * Created by lins13 on 4/17/17.
 */
public class SystemConfig implements SystemConfigMBean {

    private int threadCount;
    private String schemaName;

    public SystemConfig(int threadCount, String schemaName) {
        this.threadCount = threadCount;
        this.schemaName = schemaName;
    }

    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }

    public int getThreadCount() {
        return this.threadCount;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public String doConfig() {
        return "No of Threads=" + this.threadCount + " and DB Schema Name=" + this.schemaName;
    }
}
