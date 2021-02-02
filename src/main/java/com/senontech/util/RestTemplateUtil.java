package com.senontech.util;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author gyk
 * @description RestTemplateUtil工具类
 * @date 2020/10/23 15:41
 */
public class RestTemplateUtil {
    /*
    使用示例:
    JSONObject json = RestTemplateUtils
            .create() //创建一个实例
            .setContentType("xxx") //设置Content-Type,不设置默认为：application/json,多次设置，以最后一次为准
            .addHeader("headerKey","headerVal") //添加header，可以多次添加
            .addBody("bodyKey","bodyVal") //添加body，可以多次添加
            .addObjectBody(object) //添加实体类封装的参数,添加一次
            .postForObj("url",JSONObject.class); //发送post请求
    */

    static SimpleClientHttpRequestFactory factory = null;

    static {
        factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(10 * 1000);
        factory.setConnectTimeout(10 * 1000);
    }

    private static final Logger log = (Logger) LoggerFactory.getLogger(RestTemplateUtil.class);

    private static final RestTemplate REST_TEMPLATE = new RestTemplate(factory);

    /**
     * httpEntity
     */
    private HttpEntity httpEntity;

    /**
     * header
     */
    private HttpHeaders httpHeaders;

    /**
     * contentType
     */
    private String contentType;

    /**
     * body
     */
    private HashMap<String, Object> params;

    /**
     * cookies
     */
    private List<String> cookieList;

    /**
     * 配置文件类
     */
    private static Properties properties;

    static {
        InputStream in = null;
        try {
            properties = new Properties();
            in = RestTemplateUtil.class.getResourceAsStream("/httpIpPort.properties");
            properties.load(in);
        } catch (IOException e) {
            log.error("读取conditionParam.properties文件出错", e);
        }
    }

    /**
     * 获取配置文件中的值
     *
     * @param key 键
     * @return java.lang.String
     * @author gyk
     * @date 2021/1/21 12:54
     */
    public static String getProp(String key) {
        return properties.getProperty(key);
    }

    private RestTemplateUtil() {
    }

    /**
     * 构造函数已经私有化，只能通过create方法构造HttpContent
     *
     * @return com.gyk.util.RestTemplateUtil
     * @author gyk
     * @date 2021/1/21 12:54
     */
    public static RestTemplateUtil create() {
        return new RestTemplateUtil();
    }

    /**
     * 普通get请求
     *
     * @param url   请求地址
     * @param clazz 返回的类型
     * @param <T>   类类型
     * @return T
     * @author gyk
     * @date 2021/1/21 12:55
     */
    public <T> T getForObj(String url, Class<T> clazz) {
        return RestTemplateUtil.REST_TEMPLATE.getForObject(url, clazz);
    }

    /**
     * 普通post请求
     *
     * @param url   请求地址
     * @param clazz 返回的类型
     * @param <T>   类类型
     * @return T
     * @author gyk
     * @date 2021/1/21 12:55
     */
    public <T> T postForObj(String url, Class<T> clazz) {
        this.build();
        return REST_TEMPLATE.postForObject(url, this.httpEntity, clazz);
    }

    /**
     * 可设置的get请求
     *
     * @param url   访问地址
     * @param clazz 返回的类型
     * @param <T>   类类型
     * @return org.springframework.http.ResponseEntity<T>
     * @author gyk
     * @date 2021/1/21 12:57
     */
    public <T> ResponseEntity<T> exchangeGet(String url, Class<T> clazz) {
        this.build();
        return RestTemplateUtil.REST_TEMPLATE.exchange(url, HttpMethod.GET, this.httpEntity, clazz);
    }

    /**
     * 可设置的post请求
     *
     * @param url   访问地址
     * @param clazz 返回的类型
     * @param <T>   类类型
     * @return org.springframework.http.ResponseEntity<T>
     * @author gyk
     * @date 2021/1/21 12:58
     */
    public <T> ResponseEntity<T> exchangePost(String url, Class<T> clazz) {
        this.build();
        return RestTemplateUtil.REST_TEMPLATE.exchange(url, HttpMethod.POST, this.httpEntity, clazz);
    }

    /**
     * 设置请求体
     *
     * @param key   键
     * @param value 值
     * @return com.gyk.util.RestTemplateUtil
     * @author gyk
     * @date 2021/1/21 12:59
     */
    public RestTemplateUtil addBody(String key, Object value) {
        if (Objects.isNull(params)) {
            params = new HashMap<>();
        }
        params.put(key, value);
        return this;
    }

    /**
     * 设置参数为 实体类/JSONObject的请求体
     *
     * @param objectBody param
     * @return com.gyk.util.RestTemplateUtil
     * @author gyk
     * @date 2021/1/21 13:00
     */
    public RestTemplateUtil addObjectBody(Object objectBody) {
        if (objectBody instanceof JSONObject) {
            if (Objects.isNull(params)) {
                params = (HashMap<String, Object>) ((JSONObject) objectBody).getInnerMap();
            }
            return this;
        }
        if (Objects.isNull(params)) {
            params = new HashMap<>();
            Field[] fields = objectBody.getClass().getDeclaredFields();
            for (Field field : fields) {
                if ("serialVersionUID".equals(field.getName())) {
                    continue;
                }
                String getMethod = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                Method get = null;
                Object invoke = null;
                try {
                    get = objectBody.getClass().getDeclaredMethod(getMethod);
                    invoke = get.invoke(objectBody);
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    log.error("RestTemplateUtil addObjectBody() error");
                }
                if (invoke != null) {
                    params.put(field.getName(), invoke.toString());
                }
            }
        }
        return this;
    }

    /**
     * 设置content-Type
     *
     * @param contentType contentType
     * @return com.gyk.util.RestTemplateUtil
     * @author gyk
     * @date 2021/1/21 13:00
     */
    public RestTemplateUtil setContentType(String contentType) {
        if (StringUtils.isBlank(contentType)) {
            log.error("content-Type can not be empty,please check your mediaType and try again ~");
            throw new RuntimeException("content-Type can not be empty,please check your mediaType and try again ~");
        }
        this.contentType = contentType;
        if (Objects.isNull(httpHeaders)) {
            httpHeaders = new HttpHeaders();
        }
        httpHeaders.setContentType(MediaType.parseMediaType(contentType));
        return this;
    }

    public RestTemplateUtil addCookies(Cookie[] cookies) {
        List<String> newCookies = null;
        if (Objects.nonNull(cookies)) {
            newCookies = new CopyOnWriteArrayList<>();
            for (Cookie cookie : cookies) {
                newCookies.add(cookie.getName() + "=" + cookie.getValue());
            }
        } else {
            return this;
        }
        if (Objects.isNull(cookieList)) {
            cookieList = new CopyOnWriteArrayList<>(newCookies);
        } else {
            cookieList.addAll(newCookies);
        }
        if (Objects.isNull(httpHeaders)) {
            httpHeaders = new HttpHeaders();
        }
        httpHeaders.put("Cookie", cookieList);
        return this;
    }

    /**
     * 添加Header内容
     *
     * @param key   键
     * @param value 值
     * @return com.gyk.util.RestTemplateUtil
     * @author gyk
     * @date 2021/1/21 13:01
     */
    public RestTemplateUtil addHeader(String key, String value) {
        if (Objects.isNull(httpHeaders)) {
            httpHeaders = new HttpHeaders();
        }
        httpHeaders.add(key, value);
        return this;
    }

    /**
     * 构建HttpEntity对象
     *
     * @return void
     * @author gyk
     * @date 2021/1/21 13:02
     */
    private void build() {
        if (Objects.isNull(this.contentType) || ContentType.APPLICATION_JSON.getMimeType().equals(this.contentType)) {
            this.setContentType(ContentType.APPLICATION_JSON.getMimeType());
        }
        try {
            this.setContentType(ContentType.getByMimeType(this.contentType).getMimeType());
        } catch (Exception e) {
            log.error("设置content-Type出错");
            this.setContentType(ContentType.APPLICATION_JSON.getMimeType());
        }
        if (this.contentType.equals(ContentType.APPLICATION_FORM_URLENCODED.getMimeType())) {
            if (Objects.nonNull(params)) {
                MultiValueMap<String, Object> formData = new LinkedMultiValueMap<>();
                for (String s : params.keySet()) {
                    formData.add(s, params.get(s));
                }
                this.httpEntity = new HttpEntity<>(formData, httpHeaders);
            } else {
                this.httpEntity = new HttpEntity<>(httpHeaders);
            }
            return;
        }
        if (Optional.ofNullable(params).isPresent()) {
            JSONObject jsonObject = new JSONObject();
            for (String s : params.keySet()) {
                try {
                    jsonObject.put(s, params.get(s));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            String body = jsonObject.toString();
            this.httpEntity = new HttpEntity<>(body, httpHeaders);
        } else {
            this.httpEntity = new HttpEntity<>(null, httpHeaders);
        }
    }
}