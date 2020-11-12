package com.kgc.movie.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shkstart
 * @create 2020-11-11 16:34
 */
@Controller
public class LoginController {
    @RequestMapping("/")
    public String toLogin(){
        return "login";
    }

}
