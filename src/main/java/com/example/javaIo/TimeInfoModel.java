package com.example.javaIo;

public class TimeInfoModel {
    private String abr;
    private String time;

    public String getAbr() {
        return abr;
    }

    public void setAbr(String abr) {
        this.abr = abr;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Time{" +
                "abr='" + abr + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
