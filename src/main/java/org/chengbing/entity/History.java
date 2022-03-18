package org.chengbing.entity;

public class History {
    public String historyId;
    public String historyName;
    public String historyPath;
    public String historyType;
    public String historyLastTime;

    public History() {
    }

    public History(String historyId, String historyName, String historyPath, String historyType) {
        this.historyId = historyId;
        this.historyName = historyName;
        this.historyPath = historyPath;
        this.historyType = historyType;
    }

    public History(String historyId, String historyName, String historyPath, String historyType, String historyLastTime) {
        this.historyId = historyId;
        this.historyName = historyName;
        this.historyPath = historyPath;
        this.historyType = historyType;
        this.historyLastTime = historyLastTime;
    }

    public String getHistoryLastTime() {
        return historyLastTime;
    }

    public void setHistoryLastTime(String historyLastTime) {
        this.historyLastTime = historyLastTime;
    }

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }

    public String getHistoryName() {
        return historyName;
    }

    public void setHistoryName(String historyName) {
        this.historyName = historyName;
    }

    public String getHistoryPath() {
        return historyPath;
    }

    public void setHistoryPath(String historyPath) {
        this.historyPath = historyPath;
    }

    public String getHistoryType() {
        return historyType;
    }

    public void setHistoryType(String historyType) {
        this.historyType = historyType;
    }
}
