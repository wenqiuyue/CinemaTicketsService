package com.wqy.cinematickets.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ExclusivePiece {
    private int eid;
    private int mid;
    private int pid;
    private Date timebegin;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date timeend;
    private Film film;
    private String mlanguage;
    private String meffect;
    private String mprice;
    private ProjectionHall projectionHall;
    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Date getTimebegin() {
        return timebegin;
    }

    public void setTimebegin(Date timebegin) {
        this.timebegin = timebegin;
    }

    public Date getTimeend() {
        return timeend;
    }

    public void setTimeend(Date timeend) {
        this.timeend = timeend;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public String getMlanguage() {
        return mlanguage;
    }

    public void setMlanguage(String mlanguage) {
        this.mlanguage = mlanguage;
    }

    public String getMeffect() {
        return meffect;
    }

    public void setMeffect(String meffect) {
        this.meffect = meffect;
    }

    public String getMprice() {
        return mprice;
    }

    public void setMprice(String mprice) {
        this.mprice = mprice;
    }

    public ProjectionHall getProjectionHall() {
        return projectionHall;
    }

    public void setProjectionHall(ProjectionHall projectionHall) {
        this.projectionHall = projectionHall;
    }
}
