package com.kgc.movie.movie.controller;

import com.kgc.movie.movie.pojo.Admins;
import com.kgc.movie.movie.service.AdminsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author shkstart
 * @create 2020-11-11 16:34
 */
@Controller
public class LoginController {
    @Resource
    AdminsService adminsService;
    @RequestMapping("/")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/doLogin")
    public String doLogin(String name, String passwd, Model model, HttpSession session){
        Admins admins = adminsService.selectByName(name);
        if(admins==null){
            model.addAttribute("msg","用户名输入错误！！！");
            return "login";
        }else if(admins.getPasswd().equals(passwd)==false){
            model.addAttribute("msg","用户名密码输入错误！！！");
            return "login";
        }else {
            session.setAttribute("name",name);
            return "index";
        }
    }
    @RequestMapping("/doLogout")
    public String doLogout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
