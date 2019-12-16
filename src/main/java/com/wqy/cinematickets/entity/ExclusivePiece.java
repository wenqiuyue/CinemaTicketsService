package com.wqy.cinematickets.entity;

import java.util.Date;

public class ExclusivePiece {
    private int eid;
    private int rid;
    private int pid;
    private Date projectiontime;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Date getProjectiontime() {
        return projectiontime;
    }

    public void setProjectiontime(Date projectiontime) {
        this.projectiontime = projectiontime;
    }
}
