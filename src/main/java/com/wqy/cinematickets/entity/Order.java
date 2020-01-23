package com.wqy.cinematickets.entity;

import java.util.List;

public class Order {
    private String oid;
    private int eid;
    private int uid;
    private String oprice;
    private List<SeatSelection> seatSelectionList;
    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getOprice() {
        return oprice;
    }

    public void setOprice(String oprice) {
        this.oprice = oprice;
    }

    public List<SeatSelection> getSeatSelectionList() {
        return seatSelectionList;
    }

    public void setSeatSelectionList(List<SeatSelection> seatSelectionList) {
        this.seatSelectionList = seatSelectionList;
    }
}
