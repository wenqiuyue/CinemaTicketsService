package com.wqy.cinematickets.controller.receptioncontroller;

import com.wqy.cinematickets.entity.*;
import com.wqy.cinematickets.service.receptionservice.ReceptionService;
import com.wqy.cinematickets.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/manager")
public class ReceptionController {
    @Autowired
    private ReceptionService receptionService;


    //获取近期热门影片
    @RequestMapping(value = "/GetAllPopularRecentFilms",method = RequestMethod.GET)
    public Result<List<Film>> GetAllPopularRecentFilms(){
        List<Film> filmList = receptionService.GetAllPopularRecentFilmsService();
        Result<List<Film>> listResult = new Result<List<Film>>();
        if(filmList != null){
            listResult.setCode(0);
            listResult.setBody(filmList);
        }else {
            listResult.setCode(100);
            listResult.setMessage("没有查询到数据");
        }
        return listResult;
    }

    //根据电影id查询电影信息
    @RequestMapping(value = "/GetFilmById",method = RequestMethod.GET)
    public Result<Film> GetFilmById(int mid){
        Film film = receptionService.GetFilmByIdService(mid);
        Result<Film> filmResult = new Result<Film>();
        if(film != null){
            filmResult.setCode(0);
            filmResult.setBody(film);
        }else {
            filmResult.setCode(1000);
            filmResult.setMessage("没有查询到数据");
        }
        return filmResult;
    }

    //根据电影id查询电影排片
    @RequestMapping(value = "/GetExclusivePieceById",method = RequestMethod.GET)
    public Result<List<ExclusivePiece>> GetExclusivePieceById(int mid){
        List<ExclusivePiece> exclusivePieceList = receptionService.GetExclusivePieceByIdService(mid);
        Result<List<ExclusivePiece>> listResult = new Result<List<ExclusivePiece>>();
        if(exclusivePieceList != null){
            listResult.setCode(0);
            listResult.setBody(exclusivePieceList);
        }else {
            listResult.setCode(1000);
            listResult.setMessage("没有查询到数据");
        }
        return listResult;
    }

    //添加影评
    @RequestMapping(value = "/AddFilmReview",method = RequestMethod.POST)
    public Boolean AddFilmReview(@RequestBody FilmReview filmReview){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = sdf.format(date);
        filmReview.setEvaluatetime(str);
        return receptionService.AddFilmReviewService(filmReview);
    }

    //根据影片id获取该影片影评
    @RequestMapping(value = "/GetFilmReviewByMid",method = RequestMethod.GET)
    public Result<List<Integer>> GetFilmReviewByMid(int mid){
        List<Integer> list = receptionService.GetFilmReviewByMidService(mid);
        Result<List<Integer>> listResult = new Result<List<Integer>>();
        if(list != null){
            listResult.setCode(0);
            listResult.setBody(list);
        }else {
            listResult.setCode(1000);
            listResult.setMessage("没有查询到数据");
        }
        return listResult;
    }

    //获取所有影片分数
    @RequestMapping(value = "/GetFilmScore",method = RequestMethod.GET)
    public Result<List<FilmReview>> GetFilmScore(){
        List<FilmReview> list = receptionService.GetFilmScoreService();
        Result<List<FilmReview>> listResult = new Result<List<FilmReview>>();
        if(list != null){
            listResult.setCode(0);
            listResult.setBody(list);
        }else {
            listResult.setCode(1000);
            listResult.setMessage("没有查询到数据");
        }
        return listResult;
    }

    //改变影片分数
    @RequestMapping(value = "/UpdateFilmScore",method = RequestMethod.POST)
    public Boolean UpdateFilmScore(@RequestBody Film film){
        return receptionService.UpdateFilmScoreService(film);
    }

    //根据影片id获取该影片所有评价
    @RequestMapping(value = "/GetFilmReviewInfoById",method = RequestMethod.GET)
    public Result<List<FilmReview>> GetFilmReviewInfoById(int mid){
        List<FilmReview> list = receptionService.GetFilmReviewInfoByIdService(mid);
        System.out.print(list);
        Result<List<FilmReview>> listResult = new Result<List<FilmReview>>();
        if(list != null){
            listResult.setCode(0);
            listResult.setBody(list);
        }else {
            listResult.setCode(1000);
            listResult.setMessage("没有查询到数据");
        }
        return listResult;
    }

    //添加想看的影片
    @RequestMapping(value = "/AddWantSeeFilm",method = RequestMethod.POST)
    public Result AddWantSeeFilm(@RequestBody WantFilm wantFilm){
        int i = receptionService.AddWantSeeFilmService(wantFilm);
        Result result = new Result();
        if(i == 1001){
            result.setCode(i);
            result.setMessage("想看的影片已存在");
        }else if(i == 1002){
            result.setCode(i);
            result.setMessage("添加成功");
        }else {
            result.setCode(i);
            result.setMessage("添加失败");
        }
        return result;
    }

    //查询添加想看的影片是否已添加
    @RequestMapping(value = "/IsAddWantSeeFilm",method = RequestMethod.POST)
    public Boolean IsAddWantSeeFilm(@RequestBody WantFilm wantFilm){
        return receptionService.IsAddWantSeeFilmService(wantFilm);
    }

    //根据排片id多表获取排片信息
    @RequestMapping(value = "/GetExclusivepieceInfoByEid",method = RequestMethod.GET)
    public Result<ExclusivePiece> GetExclusivepieceInfoByEid(int eid){
        ExclusivePiece exclusivePiece = receptionService.GetExclusivepieceInfoByEidService(eid);
        Result<ExclusivePiece> exclusivePieceResult = new Result<ExclusivePiece>();
        if(exclusivePiece != null){
            exclusivePieceResult.setCode(0);
            exclusivePieceResult.setBody(exclusivePiece);
        }else {
            exclusivePieceResult.setCode(1000);
            exclusivePieceResult.setMessage("没有查询到数据");
        }
        return exclusivePieceResult;
    }

    //插入订单
    @RequestMapping(value = "/AddOrder",method = RequestMethod.POST)
    public Result<String> AddOrder(@RequestBody Order order){
        Date d = new Date();
        order.setOid(Long.toString(d.getTime())+""+Integer.toString(order.getEid()));
        Boolean isOrder = receptionService.AddOrderService(order);
        Result<String> stringResult = new Result<String>();
        if(isOrder == true){
            stringResult.setCode(0);
            stringResult.setBody(order.getOid());
        }else {
            stringResult.setCode(1000);
            stringResult.setMessage("订单生成失败");
        }
        return stringResult;
    }

    //获取某场次已被选的座位
    @RequestMapping(value = "/GetSeatselectionByEid",method = RequestMethod.GET)
    public Result<List<SeatSelection>> GetSeatselectionByEid(int eid){
        Result<List<SeatSelection>> listResult = new Result<List<SeatSelection>> ();
        List<SeatSelection> seatSelectionList = receptionService.GetSeatselectionByEidService(eid);
        if(seatSelectionList!=null){
            listResult.setCode(0);
            listResult.setBody(seatSelectionList);
        }else {
            listResult.setCode(1000);
            listResult.setMessage("没有查询到数据");
        }
        return listResult;
    }

    //根据订单编号获取订单信息
    @RequestMapping(value = "/GetOrderInfo",method = RequestMethod.GET)
    public Result<Order> GetOrderInfo(String oid){
       Order order = receptionService.GetOrderInfoService(oid);
        Result<Order> orderResult = new Result<Order>();
        if(order != null){
            orderResult.setCode(0);
            orderResult.setBody(order);
        }else {
            orderResult.setCode(1000);
            orderResult.setMessage("没有查询到数据");
        }
        return orderResult;
    }

    //根据用户id查询用户姓名和头像
    @RequestMapping(value = "/GetNameAndPicById",method = RequestMethod.GET)
    public Result<User> GetNameAndPicById(int uid){
        User user = receptionService.GetNameAndPicByIdService(uid);
        Result<User> userResult = new Result<User>();
        if(user != null){
            userResult.setCode(0);
            userResult.setBody(user);
        }else {
            userResult.setCode(1000);
            userResult.setMessage("没有查询到数据");
        }
        return userResult;
    }
}
