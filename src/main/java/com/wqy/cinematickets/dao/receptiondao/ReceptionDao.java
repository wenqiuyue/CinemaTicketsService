package com.wqy.cinematickets.dao.receptiondao;

import com.wqy.cinematickets.entity.Film;

import java.util.List;

public interface ReceptionDao {
    //获取近期热门影片
    List<Film> getAllPopularRecentFilms();
}
