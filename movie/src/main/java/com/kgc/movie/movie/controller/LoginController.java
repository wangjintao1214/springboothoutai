package com.kgc.movie.movie.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.movie.movie.pojo.Admins;
import com.kgc.movie.movie.service.AdminsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-11-11 16:34
 */
@Controller
public class LoginController {
    @Resource
    AdminsService adminsService;

    @RequestMapping("/")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/doLogin")
    public String doLogin(String name, String passwd, Model model, HttpSession session) {
        Admins admins = adminsService.selectByName(name);
        if (admins == null) {
            model.addAttribute("msg", "用户名输入错误！！！");
            return "login";
        } else if (admins.getPasswd().equals(passwd) == false) {
            model.addAttribute("msg", "用户名密码输入错误！！！");
            return "login";
        } else {
            session.setAttribute("name", name);
            return "index";
        }
    }

    @RequestMapping("/doLogout")
    public String doLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

  /*  //查询管理员表
    @RequestMapping("/member-kiss.html")
    public String memberkiss(HttpSession session, Model model, String name, String pageNumStr) {
        //分页
        int pageSize = 1;
        int pageNum = 1;
        if (pageNumStr != null) {
            pageNum = Integer.parseInt(pageNumStr);
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Admins> adminsList = adminsService.selectAllName(name);
        PageInfo<Admins> PageInfo = new PageInfo<>(adminsList);
        model.addAttribute("PageInfo", PageInfo);
        session.setAttribute("name", name);
        return "member-kiss";
    }*/
}
