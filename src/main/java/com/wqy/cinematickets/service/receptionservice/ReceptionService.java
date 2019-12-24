package com.wqy.cinematickets.service.receptionservice;

import com.wqy.cinematickets.entity.Film;

import java.util.List;

public interface ReceptionService {
    //获取近期热门影片
    List<Film> GetAllPopularRecentFilmsService();
}
