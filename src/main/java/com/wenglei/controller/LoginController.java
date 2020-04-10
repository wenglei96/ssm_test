package com.wenglei.controller;

import com.wenglei.pojo.User;
import com.wenglei.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("login")
public class LoginController {

    @RequestMapping("toLogin")
    public String ToLogin(){
        return "login.jsp";
    }


    @Autowired
    private LoginService loginService;


    @RequestMapping("logins")
    public String login(User user, Model model){
        /*获取前端传送的用户信息*/
        String loginname = user.getLoginname();
        String password = user.getPassword();

        System.out.println("账户："+ loginname);
        System.out.println("密码："+ password );

        Map<String, Object> map = loginService.ToLogin(loginname, password);


            if (map.get("status").equals("200")) {
                return  "system/index.jsp";
            }else {
                model.addAttribute("error", map.get("msg"));
                return  "login.jsp";
            }


    }



}
