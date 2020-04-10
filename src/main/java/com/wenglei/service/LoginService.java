package com.wenglei.service;


import java.util.Map;

public interface LoginService {

    Map<String,Object> ToLogin(String loginname, String password);
}
