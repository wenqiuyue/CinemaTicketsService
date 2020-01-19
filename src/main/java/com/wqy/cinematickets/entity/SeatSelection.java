package com.wqy.cinematickets.entity;

public class SeatSelection {
    private int rowsel;
    private int columnsel;
    private long oid;
    private int eid;

    public int getRowsel() {
        return rowsel;
    }

    public void setRowsel(int rowsel) {
        this.rowsel = rowsel;
    }

    public int getColumnsel() {
        return columnsel;
    }

    public void setColumnsel(int columnsel) {
        this.columnsel = columnsel;
    }

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }
}
