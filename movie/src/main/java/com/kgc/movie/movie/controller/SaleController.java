package com.kgc.movie.movie.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.movie.movie.pojo.Movie_ticket;
import com.kgc.movie.movie.service.SaleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wangyifan
 * @create 2020-11-12 19:41
 */
@Controller

public class SaleController {
    @Resource
    SaleService saleService;


    @RequestMapping("/toshowSale")
    public String toshowSale(@RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                             @RequestParam(value = "startDay", defaultValue = "2000-00-00", required = false) String startDay,
                             @RequestParam(value = "endDay", defaultValue = "2099-12-31", required = false) String endDay, Model model) {
        PageInfo<Movie_ticket> pageInfo = saleService.showList(pageNum, startDay, endDay);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("size", pageInfo.getTotal());
        model.addAttribute("startDay", startDay);
        model.addAttribute("endDay", endDay);
        return "order-list";
    }


    @RequestMapping("/showData")
  //  @ResponseBody
    public String toshowData(Model model) {
        // Map<Integer,Integer> map =null;
        Map<String, Integer> map2 = saleService.selectByMovieYingchengId();
        model.addAttribute("map", map2);
        ArrayList arrayList = new ArrayList();
        for (Integer integer : map2.values()) {
            arrayList.add(integer);
        }
        model.addAttribute("list", map2);
        return "echarts4";
    }


    @RequestMapping("/toShowMovieInfoByDay")
    public String toshowMovieInfoByDay(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, Model model) {
        int pageSize = 5;
        PageInfo pageInfo = saleService.showMovieInfoByDay(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        return "echarts1";
    }

}
