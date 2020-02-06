package com.wqy.cinematickets.service.receptionservice;

import com.wqy.cinematickets.entity.*;

import java.util.List;

public interface ReceptionService {
    //获取近期热门影片
    List<Film> GetAllPopularRecentFilmsService();
    //根据电影id查询电影信息
    Film GetFilmByIdService(int mid);
    //根据电影id查询电影排片
    List<ExclusivePiece> GetExclusivePieceByIdService(int mid);
    //添加影评
    Boolean AddFilmReviewService(FilmReview filmReview);
    //根据影片id获取该影片影评
    List<Integer> GetFilmReviewByMidService(int mid);
    //获取所有影片分数
    List<FilmReview> GetFilmScoreService();
    //改变影片分数
    Boolean UpdateFilmScoreService(Film film);
    //根据影片id获取该影片所有评价
    List<FilmReview> GetFilmReviewInfoByIdService(int mid);
    //添加想看的影片
    int AddWantSeeFilmService(WantFilm wantFilm);
    //查询添加想看的影片是否已添加
    Boolean IsAddWantSeeFilmService(WantFilm wantFilm);
    //根据排片id多表获取排片信息
    ExclusivePiece GetExclusivepieceInfoByEidService(int eid);
    //插入订单
    Boolean AddOrderService(Order order);
    //获取某场次已被选的座位
    List<SeatSelection> GetSeatselectionByEidService(int eid);
    //根据订单编号获取订单信息
    Order GetOrderInfoService(String oid);
    //根据用户id查询用户姓名和头像
    User GetNameAndPicByIdService(int id);
    //修改用户头像和用户名
    Boolean UpdatePicAndNameService(User user);
    //查询想看的电影
    List<Film> GetMyLikeFilmService(int uid);
    //修改密码
    Boolean UpdatePasswordService(User user);
    //根据用户id获取订单列表
    List<Order> GetUserOrderListService(int uid);

}
