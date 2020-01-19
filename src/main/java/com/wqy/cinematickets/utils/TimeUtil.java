package com.wqy.cinematickets.utils;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
public class TimeUtil {
    //日期转换为时间戳 (精确到毫秒)
    public long timeToStamp() {
        Date d = new Date();
        long timeStemp = 0;
        timeStemp = d.getTime();
        return timeStemp;
    }
}
