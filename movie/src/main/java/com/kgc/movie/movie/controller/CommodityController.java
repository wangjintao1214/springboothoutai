package com.kgc.movie.movie.controller;


import com.kgc.movie.movie.pojo.Commodity;
import com.kgc.movie.movie.service.CommodityService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Controller
public class CommodityController {
    @Resource
    CommodityService commodityService;
    @RequestMapping("/commodity")//查询所有
    public String commodity(Model model){
        List<Commodity> commodities=commodityService.selectAll();
        model.addAttribute("list",commodities);
        return "product-list";
    }
    @RequestMapping("/addcommodity")
    public String add(){
        return "product-add";
    }
    @RequestMapping("/doadd")//添加
    public String insertCommodity(Commodity commodity, Model model, HttpServletRequest request, MultipartFile product_img) {
//获取上传路径
        String path="";
        try {
            path = ResourceUtils.getURL("classpath:").getPath()+"/static/images/uploadfiles";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//获取源文件名
        String originalFilename = product_img.getOriginalFilename();

//扩展名
        String prefix = FilenameUtils.getExtension(originalFilename);

//生成新的文件名
        String fileName=System.currentTimeMillis() + (RandomUtils.nextInt(10000)+"_text.")+prefix;
//封装File对象
        File file=new File(path,fileName);
//上传
        try {
            product_img.transferTo(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
        commodity.setPicture(fileName);
        commodityService.addCommodity(commodity);
        return "redirect:/commodity";
    }
    @RequestMapping("/toupd")
    public String toUpdateCommodity(Integer id, Model model) {
        Commodity commodity = commodityService.getCommodity(id);
        model.addAttribute("list", commodity);
        return "product-edit";
    }
    //修改
    @RequestMapping("/doupd")
    public String doupd(Commodity commodity, Model model, HttpServletRequest request, MultipartFile product_img) {
//获取上传路径
        String path="";
        try {
            path = ResourceUtils.getURL("classpath:").getPath()+"/static/images/uploadfiles";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//获取源文件名
        String originalFilename = product_img.getOriginalFilename();

//扩展名
        String prefix = FilenameUtils.getExtension(originalFilename);

//生成新的文件名
        String fileName=System.currentTimeMillis() + (RandomUtils.nextInt(10000)+"_text.")+prefix;
//封装File对象
        File file=new File(path,fileName);
//上传
        try {
            product_img.transferTo(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
        commodity.setPicture(fileName);
        commodityService.updateCommdity(commodity);
        return "redirect:/commodity";
    }
    //删除
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        commodityService.del(id);
        return "redirect:/commodity";
    }

}
