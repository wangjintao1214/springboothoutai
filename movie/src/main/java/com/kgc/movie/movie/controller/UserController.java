package com.kgc.movie.movie.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.movie.movie.pojo.*;
import com.kgc.movie.movie.service.AdminsService;
import com.kgc.movie.movie.service.Membership_levelService;
import com.kgc.movie.movie.service.UserService;
import com.kgc.movie.movie.service.User_MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.naming.Name;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Resource
    Membership_levelService membership_levelService;
    @Resource
    User_MemberService user_memberService;
    @Resource
    UserService userService;
    @Resource
    AdminsService adminsService;
    @RequestMapping("/member-list.html")
    public String memberlist(String pageNumStr, Model model, String uname, HttpSession session) {
        //分页
        int pageSize=5;
        int pageNum=1;
        if(pageNumStr!=null){
            pageNum=Integer.parseInt(pageNumStr);
        }
        PageHelper.startPage(pageNum,pageSize);
       //通过uname模糊查询
       UserExample userExample=new UserExample();
        UserExample.Criteria criteria2 = userExample.createCriteria();
        List<User> users=new ArrayList<>();
        //判断uname是否等于空
        if(uname!=null&&uname.isEmpty()==false){
            criteria2.andUnameLike("%"+uname+"%");
            users = userService.selectByExample(userExample);
        }else{
            users = userService.selectByExample(userExample);
        }
            //查询User用户表
        for (User user : users) {
            User_MemberExample userMemberExample=new User_MemberExample();
            User_MemberExample.Criteria criteria = userMemberExample.createCriteria();
            criteria.andUserIdEqualTo(user.getId());
            //查询User_Meber循环查询连接表
            List<User_Member> user_members = user_memberService.selectByExample(userMemberExample);
            for (User_Member user_member : user_members) {
                Membership_levelExample membership_levelExample=new Membership_levelExample();
                Membership_levelExample.Criteria criteria1 = membership_levelExample.createCriteria();
                criteria1.andLevelIdEqualTo(user_member.getMemberId());
                //查询循环Membership_level等级表
                List<Membership_level> membership_levels = membership_levelService.selectByExample(membership_levelExample);
                for (Membership_level membership_level : membership_levels) {
                    user.setType(membership_level.getType());
                }
            }
        }
        PageInfo<User>PageInfo=new PageInfo<>(users);
        model.addAttribute("userPageInfo",PageInfo);
        session.setAttribute("uname",uname);
        return "member-list";
    }
    //会员等级查询    @GetMapping("/emp/{id}")
    @RequestMapping("/member-level.html")
    public String memberlevel(Model model,String type,HttpSession session){
        List<Membership_level> membership_levels = membership_levelService.select(type);
        PageInfo<Membership_level> membership_levelPageInfo=new PageInfo<>(membership_levels);
        model.addAttribute("membership_levelPageInfo", membership_levelPageInfo);
        session.setAttribute("type",type);
        return "member-level";
    }

}
