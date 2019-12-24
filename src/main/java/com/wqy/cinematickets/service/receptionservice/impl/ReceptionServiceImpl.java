package com.wqy.cinematickets.service.receptionservice.impl;

import com.wqy.cinematickets.dao.receptiondao.ReceptionDao;
import com.wqy.cinematickets.entity.Film;
import com.wqy.cinematickets.service.receptionservice.ReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReceptionServiceImpl implements ReceptionService {
    @Autowired
     private ReceptionDao receptionDao;

    @Override
    //获取近期热门影片
    public List<Film> GetAllPopularRecentFilmsService(){
        return receptionDao.getAllPopularRecentFilms();
    }
}
