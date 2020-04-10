package com.wenglei.service.serviceimpl;

import com.wenglei.mapper.UserMapper;
import com.wenglei.pojo.User;
import com.wenglei.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginServiceimpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    public Map<String, Object> ToLogin(String loginname, String password) {

        //获取数据库获取到用户信息
        List<User> login = userMapper.login(loginname,password);
        /*如果等于零，说明没有数据*/

        HashMap<String, Object> m = new HashMap<String, Object>();
        if ((login.size()) ==0){
                m.put("error","500");
                m.put("msg","账号或密码输入错误，请重新输入!!!");
        }else {
            m.put("status", "200");
            m.put("msg", "登陆成功!");


            /*            User user = login.get(0);//取集合里第一个
            if (!password.equals(user.getPassword())) {
                //如果密码不相等，密码错误
                m.put("status", "401");
                m.put(msg, "密码错误！");
            } else {
                m.put("status", "200");
                m.put(msg, "登陆成功!");
            }*/
        }

//把map集合里的状态码和信息提示返回给controller
        return m;
    }
}
