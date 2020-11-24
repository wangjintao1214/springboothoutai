package com.kgc.movie.movie.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.movie.movie.pojo.Membership_level;
import com.kgc.movie.movie.service.Membership_levelService;
import com.kgc.movie.movie.service.DevuserService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.naming.Name;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DevuserController {
    @Resource
    DevuserService devuserService;
    @Resource
    Membership_levelService membership_levelService;

/*    @RequestMapping("/member-list.html")
    public String memberlist(Integer grade, String pageNumStr, Model model, String uname, HttpSession session,Integer id,String type) {
        List<Membership_level> membership_levels = membership_levelService.select(type);
        model.addAttribute("membership_levels", membership_levels);
        Integer pageNum = 1;
        if (pageNumStr != null) {
            pageNum = Integer.valueOf(pageNumStr);
        }
        Integer pageSize = 2;
        PageInfo<Devuser> devuserPageInfo = devuserService.select(pageNum, pageSize, grade, uname);
        model.addAttribute("devuser", devuserPageInfo);
        session.setAttribute("uname", uname);
        session.setAttribute("grade",grade);
        return "member-list";
    }*/
    //会员等级查询    @GetMapping("/emp/{id}")
@RequestMapping("/member-level.html")
    public String memberlevel(Model model,String type,HttpSession session){
    List<Membership_level> membership_levels = membership_levelService.select(type);
    PageInfo<Membership_level> membership_levelPageInfo=new PageInfo<>(membership_levels);
    model.addAttribute("membership_levelPageInfo", membership_levelPageInfo);
    session.setAttribute("type",type);
    return "member-level";
}
/*    //会员等级添加跳页面
@RequestMapping("level-add.html")
public String leveladdhtml(){
        return "level-add";
}
    //会员等级添加
@PostMapping("level-add")
    public String leveladd(Membership_level membership_level){
membership_levelService.insert(membership_level);
        return "redirect:member-level.html";
}*/
/*//跳转修改页面
    @RequestMapping("kiss-edit.html")
    public String kissedit(Integer levelId, Model model){
Membership_level membership_level=membership_levelService.slectById(levelId);
        model.addAttribute("membership_level",membership_level);
        return "kiss-edit";
    }
    //修改
    @RequestMapping("member-level-upd")
    public String memberlevlupd(Membership_level membership_level){
        membership_levelService.meberlevlupd(membership_level);
        return "redirect:member-level.html";
    }*/
}
