package com.senontech.config;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SystemConfig {

    //配置文件参数key
    public static final String SERVICE_IOT_KEY = "iotServiceIpPort"; // 物联网服务
    public static final String SERVICE_EQUIPMENT_KEY = "equipmentServiceIpPort";
    public static final String SERVICE_ORGANIZATION_KEY = "organizationServiceIpPort";//组织服务


    public static final String SYS_TAG_KEY = "sysTag"; // 系统标识
    public static final String SYS_NAME_KEY = "sysName"; // 系统名称


    static SystemConfig single = new SystemConfig();
    private Properties properties;

    private SystemConfig(){}

    public static void init(InputStream config) throws IOException {
        single.properties = new Properties();
        single.properties.load(config);
    }

    public static String getParam(String key){
        return single.properties.getProperty(key);
    }

    public static String getSysTag() {
        return single.properties.getProperty(SYS_TAG_KEY);
    }

    public static String getSysName(){
        return single.properties.getProperty(SYS_NAME_KEY);
    }


    public static String getRtuConfigKey(){
        String ipPort = single.properties.getProperty(SERVICE_IOT_KEY);
        if(StringUtils.isNotBlank(ipPort)) {
            return "http://"+ipPort+"/rtuConfigService";
        }
        throw new IllegalArgumentException();
    }

    public static String getRtuParamKey(){
        String ipPort = single.properties.getProperty(SERVICE_IOT_KEY);
        if(StringUtils.isNotBlank(ipPort)) {
            return "http://"+ipPort+"/rtuParamService";
        }
        throw new IllegalArgumentException();
    }

    public static String getDataItemConfigKey(){
        String ipPort = single.properties.getProperty(SERVICE_IOT_KEY);
        if(StringUtils.isNotBlank(ipPort)) {
            return "http://"+ipPort+"/dataItemConfigService";
        }
        throw new IllegalArgumentException();
    }

    public static String getEquimentService(){
        String ipPort = single.properties.getProperty(SERVICE_EQUIPMENT_KEY);
        if(StringUtils.isNotBlank(ipPort)) {
            return "http://"+ipPort+"/api";
        }
        throw new IllegalArgumentException();
    }


    public static String getOrganizationService(){
        String ipPort = single.properties.getProperty(SERVICE_ORGANIZATION_KEY);
        if(StringUtils.isNotBlank(ipPort)) {
            return "http://"+ipPort+"/organizationService20001";
        }
        throw new IllegalArgumentException();
    }
}
