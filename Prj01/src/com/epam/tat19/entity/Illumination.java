package com.epam.tat19.entity;

public class Illumination {
    private String lampName;
    private Integer lampLk=0;
    private static final Integer MIN_ILLUM = 300;
    private static final Integer MAX_ILLUM = 4000;

    public Illumination(String lampName, Integer lampLk) {
        this.lampName = lampName;
        this.lampLk = lampLk;
    }

    public String getLampName() {
        return lampName;
    }

    public void setLampName(String lampName) {
        this.lampName = lampName;
    }

    public Integer getLampLk() {
        return lampLk;
    }

    public void setLampLk(Integer lampLk) {
        this.lampLk = lampLk;
    }

    public static Integer getMIN_ILLUM() {
        return MIN_ILLUM;
    }

    public static Integer getMAX_ILLUM() {
        return MAX_ILLUM;
    }
}


