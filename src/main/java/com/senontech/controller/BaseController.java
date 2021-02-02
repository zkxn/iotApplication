package com.senontech.controller;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseController {

    protected final static String CODE = "code";
    protected final static String MSG = "msg";
    protected final static String DATA = "data";

    /**
     * 返回{"code",1}
     * @return
     */
    public String returnError(){
        return returnJson(CODE,1);
    }

    /**
     * 返回{tag:code}
     * @param tag
     * @param code
     * @return
     */
    public String returnJson(String tag,Object code){
        Map<String, Object> responseBody = new HashMap<String, Object>();
        responseBody.put(tag,code);
        responseBody.put("msg","系统异常,请重新操作");
        return JSON.toJSONString(responseBody);
    }

//    public Boolean veriftyUser(User user){
//        if (user.getUserName().equals(SystemConfig.getParam("userName"))||user.getUserName().equals("yxadmin")) {
//            return true;
//        }else {
//            return false;
//        }
//    }

    /**
     * 返回{tag:code}
     * @return
     */
    public String returnSession(){
        //已经登录，无需再次请求，直接跳转主界面
        Map<String, Object> responseBody = new HashMap<String, Object>();
        responseBody.put("sessionStatus", 0);//0表示未登录
        responseBody.put("msg", "session已过期,请重新登录。");//0表示未登录
        return JSON.toJSONString(responseBody);
    }


}
