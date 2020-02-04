package com.wqy.cinematickets.service.receptionservice.impl;

import com.wqy.cinematickets.dao.receptiondao.ReceptionDao;
import com.wqy.cinematickets.entity.*;
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

    @Override
    //根据电影id查询电影信息
    public Film GetFilmByIdService(int mid){
        return receptionDao.getFilmById(mid);
    }

    @Override
    //根据电影id查询电影排片
    public List<ExclusivePiece> GetExclusivePieceByIdService(int mid){
        return receptionDao.getExclusivePieceById(mid);
    }

    @Override
    //添加影评
    public Boolean AddFilmReviewService(FilmReview filmReview){
        int i = receptionDao.addFilmReview(filmReview);
        if(i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    //根据影片id获取该影片影评
    public List<Integer> GetFilmReviewByMidService(int mid){
        return receptionDao.getFilmReviewByMid(mid);
    }

    @Override
    //获取所有影片分数
    public List<FilmReview> GetFilmScoreService(){
        return receptionDao.getFilmScore();
    }

    @Override
    //改变影片分数
    public Boolean UpdateFilmScoreService(Film film){
        int i = receptionDao.updateFilmScore(film);
        if(i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    //根据影片id获取该影片所有评价
    public List<FilmReview> GetFilmReviewInfoByIdService(int mid){
        return receptionDao.getFilmReviewInfoById(mid);
    }

    @Override
    //添加想看的影片
    public int AddWantSeeFilmService(WantFilm wantFilm){
        int code = 0;
        int i = receptionDao.isAddWantSeeFilm(wantFilm);
        if(i>0){
            code = 1001; //想看的影片已存在
        }else {
            int j =receptionDao.addWantSeeFilm(wantFilm);
            if(j>0){
                code = 1002;  //添加成功
            }else {
                code = 1003;  //添加失败
            }
        }
        return code;
    }

    @Override
    //查询添加想看的影片是否已添加
    public Boolean IsAddWantSeeFilmService(WantFilm wantFilm){
        int i = receptionDao.isAddWantSeeFilm(wantFilm);
        if(i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    //根据排片id多表获取排片信息
    public ExclusivePiece GetExclusivepieceInfoByEidService(int eid){
        return receptionDao.getExclusivepieceInfoByEid(eid);
    }

    @Override
    //插入订单
    public Boolean AddOrderService(Order order){
        //插入订单信息
        int i = receptionDao.addOrder(order);
        Boolean isAdd = false;
        if(i>0){
            //插入已选的座位
           for(SeatSelection seatSelection:order.getSeatSelectionList()){
                seatSelection.setOid(order.getOid());
                seatSelection.setEid(order.getEid());
               int j=receptionDao.addSeatselection(seatSelection);
               if(j>0){
                   isAdd = true;
               }else {
                  isAdd = false;
               }
           }
        }else {
            isAdd = false;
        }
        return isAdd;
    }

    @Override
    //获取某场次已被选的座位
    public List<SeatSelection> GetSeatselectionByEidService(int eid){
        return receptionDao.getSeatselectionByEid(eid);
    }

    @Override
    //根据订单编号获取订单信息
    public Order GetOrderInfoService(String oid){
        Order order = receptionDao.getOrderInfo(oid);
        List<SeatSelection> seatList = receptionDao.getSeatselectionByOid(oid);
        order.setSeatSelectionList(seatList);
        return order;
    }

    @Override
    //根据用户id查询用户姓名和头像
    public User GetNameAndPicByIdService(int id){
        return receptionDao.getNameAndPicById(id);
    }

    @Override
    //修改用户头像和用户名
    public Boolean UpdatePicAndNameService(User user){
        int i = receptionDao.updatePicAndName(user);
        if(i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    //查询想看的电影
    public List<Film> GetMyLikeFilmService(int uid){
        return receptionDao.getMyLikeFilm(uid);
    }


}
