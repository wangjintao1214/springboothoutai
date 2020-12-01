package com.kgc.movie.movie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.movie.movie.mapper.Movie_ticketMapper;
import com.kgc.movie.movie.pojo.Movie_ticket;
import com.kgc.movie.movie.pojo.Movie_ticketExample;
import com.kgc.movie.movie.pojo.Saleinfo;
import com.kgc.movie.movie.service.SaleService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangyifan
 * @create 2020-11-12 20:10
 */
@Service
@CacheConfig(cacheNames = "Movie_ticket")
public class SaleServiceImpl implements SaleService {

    @Resource
    Movie_ticketMapper movie_ticketMapper;


    @Override
    public PageInfo<Movie_ticket> showList(Integer pagenum, String startData, String endDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Movie_ticketExample movie_ticketExample = new Movie_ticketExample();
        Movie_ticketExample.Criteria criteria = movie_ticketExample.createCriteria();
        try {
            if (startData != null && endDate != null && startData == "2000-00-00" && endDate == "2099-12-31") {
                startData = "";
                endDate = "";
                criteria.andMovieDateBetween(dateFormat.parse(startData), dateFormat.parse(endDate));
            }
            if (startData != null && endDate != null && startData != "2000-00-00" && endDate != "2099-12-31") {
                criteria.andMovieDateBetween(dateFormat.parse(startData), dateFormat.parse(endDate));
            }
            if (startData != null && endDate == null) {
                criteria.andMovieDateGreaterThan(dateFormat.parse(startData));
                criteria.andMovieDateEqualTo(dateFormat.parse(startData));
            }
            if (endDate != null && startData == null) {

                criteria.andMovieDateLessThan(dateFormat.parse(endDate));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        PageHelper.orderBy("movie_id desc");
        int pageSize = 10;
        PageHelper.startPage(pagenum, pageSize);
        List<Movie_ticket> movie_tickets = movie_ticketMapper.selectByExample(movie_ticketExample);
        for (Movie_ticket movie_ticket : movie_tickets) {
            movie_ticket.setMovieSeat(movie_ticket.getMovieSeat().replaceAll("\\_", "排").replaceAll("\\_", "座,").replaceAll(",$", ""));
        }
        PageInfo<Movie_ticket> pageInfo = new PageInfo<>(movie_tickets);
        return pageInfo;
    }

    @Override
    public Map selectByMovieYingchengId() {
        //定义数组，将不同的电影id存放在数组中
        ArrayList<String> yingchengid = new ArrayList();  //先判断共有几部电影
        List<Movie_ticket> movie_tickets = movie_ticketMapper.selectByExample(null);
        for (int k = 0; k < movie_tickets.size(); k++) {
            //获取到订单集合，循环
            if (yingchengid.size() == 0)//数组为空
            {
                yingchengid.add(0, movie_tickets.get(k).getMovieName());
                // yingchengid[0].add(movie_ticket.getMovieYingchengid());
            } else {//数组不为空
                for (int i = 0; i < yingchengid.size(); i++) {
                    if (yingchengid.get(i).equals(movie_tickets.get(k).getMovieName()) == true) {
                        break;//相等直接下一个

                    } else if (yingchengid.get(i).equals(movie_tickets.get(k).getMovieName()) == false && i < yingchengid.size() - 1)//不相等，查看是否是集合中最后一个元素，不是
                    {
                        continue;
                    } else if (yingchengid.get(i).equals(movie_tickets.get(k).getMovieName()) == false && i == yingchengid.size() - 1) {//不相等，也是数组中最后一个
                        yingchengid.add(yingchengid.size(), movie_tickets.get(k).getMovieName());//添加到数组中
                    }
                }
            }
        }

        //定义Map集合
        Map<String, Integer> map = new HashMap<>();
        //数组为电影id
        for (int i = 0; i < yingchengid.size(); i++) {
            int totalPrice = 0; //定义价格
            Movie_ticketExample movie_ticketExample = new Movie_ticketExample();
            Movie_ticketExample.Criteria criteria = movie_ticketExample.createCriteria();
            criteria.andMovieNameEqualTo(yingchengid.get(i));
            List<Movie_ticket> OrderPriceList = movie_ticketMapper.selectByExample(movie_ticketExample);// //根据电影名稱获取所有相同电影的订单
            for (int j = 0; j < OrderPriceList.size(); j++) {//循环相加,
                totalPrice += OrderPriceList.get(j).getMoviePrice();//计算得出同一部电影共消费了多少元
            }
            map.put(yingchengid.get(i), totalPrice); //以电影id为键，总价格为值，存放进map集合
        }
        return map;
    }


    @Override//根据不同电影名称按照每天销售额展示
    public PageInfo showMovieInfoByDay(Integer pageNum, Integer pageSize) {
        List<Saleinfo> list = new ArrayList();
        List<Movie_ticket> movie_tickets = movie_ticketMapper.selectByExample(null);//销售表全部数据
        //定义数组，将不同的电影id存放在数组中
        ArrayList<String> yingchengid = new ArrayList();  //先判断共有几部电影
        for (int k = 0; k < movie_tickets.size(); k++) {
            //获取到订单集合，循环
            if (yingchengid.size() == 0)//数组为空
            {
                yingchengid.add(0, movie_tickets.get(k).getMovieName());
                // yingchengid[0].add(movie_ticket.getMovieYingchengid());
            } else {//数组不为空
                for (int i = 0; i < yingchengid.size(); i++) {
                    if (yingchengid.get(i).equals(movie_tickets.get(k).getMovieName()) == true) {
                        break;//相等直接下一个

                    } else if (yingchengid.get(i).equals(movie_tickets.get(k).getMovieName()) == false && i < yingchengid.size() - 1)//不相等，查看是否是集合中最后一个元素，不是
                    {
                        continue;
                    } else if (yingchengid.get(i).equals(movie_tickets.get(k).getMovieName()) == false && i == yingchengid.size() - 1) {//不相等，也是数组中最后一个
                        yingchengid.add(yingchengid.size(), movie_tickets.get(k).getMovieName());//添加到数组中

                    }
                }
            }
        }
        //假如以电影名称为键，电影名称为值，存放在Map中
        // Saleinfo saleinfo = new Saleinfo();//声明saleInfo对象，将最后的数据(时间，电影名称，总价)保存在对象中
        //声明不同时间数组
        //  ArrayList<String> listDate = new ArrayList<>();
        //定义Map集合
        Map<String, List> map = new HashMap<>();

        // 数组为电影id
        for (int i = 0; i < yingchengid.size(); i++) {
            //循环下一部电影时，将listDate设置为空
            //声明不同时间数组
            ArrayList<String> listDate = new ArrayList<>();
            //   listDate.clear();//电影不同，时间重新计入
            Movie_ticketExample movie_ticketExample = new Movie_ticketExample();
            Movie_ticketExample.Criteria criteria = movie_ticketExample.createCriteria();
            criteria.andMovieNameEqualTo(yingchengid.get(i));
            List<Movie_ticket> OrderPriceList = movie_ticketMapper.selectByExample(movie_ticketExample);// //根据电影名稱获取所有相同电影的订单
            //根据相同的电影名称中不同时间区分
            for (int j = 0; j < OrderPriceList.size(); j++) {
                if (listDate.size() == 0) {//为空直接添加
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    listDate.add(dateFormat.format(OrderPriceList.get(j).getMovieDate()).substring(0, 10));
                } else {//数组不为空
                    //循环数据和获取数据比较
                    for (int k = 0; k < listDate.size(); k++) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        if (listDate.get(k).equals(dateFormat.format(OrderPriceList.get(j).getMovieDate()).substring(0, 10)) == true) {//相等，循环订单
                            break;
                        } else if (listDate.get(k).equals(dateFormat.format(OrderPriceList.get(j).getMovieDate()).substring(0, 10)) == false && k < listDate.size() - 1) {
                            //和数组中的前几个不想等，但没有循环完，继续循环
                            continue;
                        } else if (listDate.get(k).equals(dateFormat.format(OrderPriceList.get(j).getMovieDate()).substring(0, 10)) == false && k == listDate.size() - 1) {
                            //数组循环完后，没有相等的，添加到数组中
                            listDate.add(dateFormat.format(OrderPriceList.get(j).getMovieDate()).substring(0, 10));
                        }
                    }
                }
            }
            map.put(yingchengid.get(i), listDate);//HashMap根据键的hashcode值排序，所以Map中的键(电影名称)顺序和数组中的顺序不一致
        }
        //将存放电影的数组转化为Map集合
        //声明存放电影名称的Map集合
        Map<String, String> mapMovieName = new HashMap<>();

        for (int i = 0; i < yingchengid.size(); i++) {
            mapMovieName.put(yingchengid.get(i), yingchengid.get(i));
        }
        //再将Map集合轉換成Lis数组
        List<String> yingchengid1 = new ArrayList<>();
        for (String s : mapMovieName.keySet()) {
            yingchengid1.add(mapMovieName.get(s));
        }
        // 数组只能添加一个姜子牙对应的各个时间其他电影无法添加
        //如果使用map集合，需要循环map得到键(电影名)值(电影名对应时间段)
        for (int i = 0; i < yingchengid1.size(); i++) {
            List<String> listDateByMovieName = map.get(yingchengid1.get(i));//根据电影名数组作为键取到值(时间集合)
            //获取到时间
            for (int j = 0; j < listDateByMovieName.size(); j++) {  //每次时间改变，条件改变，得到数据不同，总价清零
                //总价
                Saleinfo saleinfo = new Saleinfo();//每次时间条件改变，查询出数据不同，
                int totalPrice = 0;
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                Movie_ticketExample movie_ticketExample1 = new Movie_ticketExample();
                Movie_ticketExample.Criteria criteria1 = movie_ticketExample1.createCriteria();
                criteria1.andMovieNameEqualTo(yingchengid1.get(i));//电影名作为条件
                if (j == 0 && listDateByMovieName.size() != 1) {
                    try {
                        criteria1.andMovieDateLessThan(df.parse(listDateByMovieName.get(1)));//时间条件
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                } else if (j == 0 && listDateByMovieName.size() == 1) {
                    try {
                        criteria1.andMovieDateGreaterThan(df.parse(listDateByMovieName.get(j)));//时间条件
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                } else if (j > 0 && j < listDateByMovieName.size() - 1) {
                    try {
                        criteria1.andMovieDateBetween(df.parse(listDateByMovieName.get(j)), df.parse(listDateByMovieName.get(j + 1)));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                } else if (j == listDateByMovieName.size() - 1) {
                    try {
                        criteria1.andMovieDateGreaterThan(df.parse(listDateByMovieName.get(j)));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

                List<Movie_ticket> DateAndNameList = movie_ticketMapper.selectByExample(movie_ticketExample1);//根据时间和电影名称作为条件得到数据
                //计算总价
                for (int k = 0; k < DateAndNameList.size(); k++) {
                    totalPrice += DateAndNameList.get(k).getMoviePrice();
                    saleinfo.setSaleMoney(totalPrice);
                    try {
                        saleinfo.setId(list.size() + 1);
                        saleinfo.setSaleDate(df.parse(listDateByMovieName.get(j)));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    saleinfo.setMovieName(yingchengid1.get(i));
                }
                list.add(saleinfo);
            }
        }

       /* //如果新建一张表，将list集合中的数据插入表中
       //再查询出表中的数据，
       //根据表中的数据和集合中的数据，判断应该往表中插入几条
       for (int k = 0; k <  list.size(); k++) {//循环list
           //再循环表中的数据
           //如果k和表中的id相等就continue
           //如果不相等list.get(下标)得到对象就插入表中

        }*/
//        int pageSize=5;
        PageHelper.startPage(pageNum, 5);
        PageHelper.orderBy("saleDate desc");
        PageInfo<Saleinfo> pageInfo = new PageInfo<Saleinfo>(list);
        return pageInfo;
    }

   /* @Override
    public List<Movie_ticket> selectAll() {
        return movie_ticketMapper.selectByExample(null);
    }*/
}
