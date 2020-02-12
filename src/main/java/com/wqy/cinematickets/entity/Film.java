package com.wqy.cinematickets.entity;

import java.util.Date;

public class Film {
    private int mid;
    private String mname;
    private String mtype;
    private String mcountry;
    private Date releasetime;
    private int mduration;
    private String mpicture;
    private String mintroduction;
    private float score;
    private int filmnum;
    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
    }

    public String getMcountry() {
        return mcountry;
    }

    public void setMcountry(String mcountry) {
        this.mcountry = mcountry;
    }

    public Date getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(Date releasetime) {
        this.releasetime = releasetime;
    }

    public int getMduration() {
        return mduration;
    }

    public void setMduration(int mduration) {
        this.mduration = mduration;
    }

    public String getMpicture() {
        return mpicture;
    }

    public void setMpicture(String mpicture) {
        this.mpicture = mpicture;
    }

    public String getMintroduction() {
        return mintroduction;
    }

    public void setMintroduction(String mintroduction) {
        this.mintroduction = mintroduction;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getFilmnum() {
        return filmnum;
    }

    public void setFilmnum(int filmnum) {
        this.filmnum = filmnum;
    }
}
