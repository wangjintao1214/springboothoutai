package com.kgc.movie.movie.pojo;

import java.io.Serializable;

public class Membership_level /*implements Serializable*/ {
    private Integer levelId;

    private String type;

    private String gradeIscount;

    @Override
    public String toString() {
        return "Membership_level{" +
                "levelId=" + levelId +
                ", type='" + type + '\'' +
                ", gradeIscount='" + gradeIscount + '\'' +
                '}';
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getGradeIscount() {
        return gradeIscount;
    }

    public void setGradeIscount(String gradeIscount) {
        this.gradeIscount = gradeIscount == null ? null : gradeIscount.trim();
    }
}