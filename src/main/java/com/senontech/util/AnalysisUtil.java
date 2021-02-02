package com.senontech.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class AnalysisUtil {

    public static final JSONArray getObjListByUrl(String url) {
        String getConnect= HttpUtil.requestGetConnect(url);
        JSONObject jsonObject = JSONObject.parseObject(getConnect);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        return jsonArray;
        //List<User> userList=JSONArray.parseArray(jsonArray.toJSONString(), User.class);转换方式
    }

    public static final JSONObject getObjByUrl(String url) {
        String getConnect= HttpUtil.requestGetConnect(url);
        JSONObject ret = JSONObject.parseObject(getConnect);
        JSONObject obj =(JSONObject) ret.get("data");
        return obj;
        // User user= JSONObject.toJavaObject(obj,User.class);转换方式
    }

    public static final JSONArray getObjList(String res) {
        JSONObject jsonObject = JSONObject.parseObject(res);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        return jsonArray;
        //List<User> userList=JSONArray.parseArray(jsonArray.toJSONString(), User.class);转换方式
    }

    public static final JSONObject getObj(String res) {
        JSONObject ret = JSONObject.parseObject(res);
        JSONObject obj =(JSONObject) ret.get("data");
        return obj;
        // User user= JSONObject.toJavaObject(obj,User.class);转换方式
    }

    public static final Integer getId(String res) {
        JSONObject ret = JSONObject.parseObject(res);
        Integer id =(Integer) ret.get("data");
        return id;
        // User user= JSONObject.toJavaObject(obj,User.class);转换方式
    }


    public static final Integer getCode(String res) {
        JSONObject ret = JSONObject.parseObject(res);
        Integer code =(Integer) ret.get("code");
        return code;
    }


}
