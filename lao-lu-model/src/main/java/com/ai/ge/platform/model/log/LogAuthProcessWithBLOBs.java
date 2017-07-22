package com.ai.ge.platform.model.log;

public class LogAuthProcessWithBLOBs extends LogAuthProcess implements LoggerStorageObject{
    private String oldVal;

    private String newVal;

    public String getOldVal() {
        return oldVal;
    }

    public void setOldVal(String oldVal) {
        this.oldVal = oldVal;
    }

    public String getNewVal() {
        return newVal;
    }

    public void setNewVal(String newVal) {
        this.newVal = newVal;
    }
}