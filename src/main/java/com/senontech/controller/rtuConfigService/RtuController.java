package com.senontech.controller.rtuConfigService;

import com.senontech.config.SystemConfig;
import com.senontech.controller.BaseController;
import com.senontech.util.HttpUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;

/**
 * 集中器Controller
 */
@Controller
@RequestMapping(value = "/rtu", produces = "application/json;charset=UTF-8")
public class RtuController extends BaseController {
    private static Logger log= Logger.getLogger(RtuController.class);

    /**
     * 添加集中器
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestBody String param) {
        try {
            return HttpUtil.requestShortConnect(SystemConfig.getRtuConfigKey(), "/rtu/add", param);
        } catch (Exception e) {
            log.error("接口名:add \n 错误内容:"+e);
            return returnError();
        }
    }


    /**
     * 给集中器绑定传感器
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/addSensor", method = RequestMethod.POST)
    public String addSensor(@RequestBody String param) {
        try {
            return HttpUtil.requestShortConnect(SystemConfig.getRtuConfigKey(), "/rtu/addSensor", param);
        } catch (Exception e) {
            log.error("接口名:addSensor \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     * 修改集中器
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestBody String param) {
        try {
            return HttpUtil.requestShortConnect(SystemConfig.getRtuConfigKey(), "/rtu/edit", param);
        } catch (Exception e) {
            log.error("接口名:edit \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *删除集中器
     * {"rtuId":"3"}
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public String del(@RequestBody String param) {
        try {
            return HttpUtil.requestShortConnect(SystemConfig.getRtuConfigKey(), "/rtu/del", param);
        } catch (Exception e) {
            log.error("接口名:edit \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *批量删除集中器
     * {"rtuIdList":[1,2,3]}
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/delList", method = RequestMethod.POST)
    public String delList(@RequestBody String param) {
        try {
            return HttpUtil.requestShortConnect(SystemConfig.getRtuConfigKey(), "/rtu/delList", param);
        } catch (Exception e) {
            log.error("接口名:delList \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *  单个查询集中器数据
     * {""rtuId":"3"}
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String query(@RequestParam Integer rtuId) {
        try {
            String str = SystemConfig.getRtuConfigKey() + "/rtu/query?rtuId=" +rtuId;
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:query \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *查询集中器数据列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryList", method = RequestMethod.GET)
    public String queryList() {
        try {
            String str = SystemConfig.getRtuConfigKey() + "/rtu/queryList";
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:queryList \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *分页查询集中器数据列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryPageList", method = RequestMethod.GET)
    public String queryPageList(Integer page,Integer size,String condition) {
        try {
            String str="";
            if(condition!=null&&condition!=""){
                str = SystemConfig.getRtuConfigKey() + "/rtu/queryPageList?page="+page+"&size="+size+"&condition="+ URLEncoder.encode(condition,"UTF-8");
            }else {
                str = SystemConfig.getRtuConfigKey() + "/rtu/queryPageList?page="+page+"&size="+size;
            }
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:queryPageList \n 错误内容:"+e);
            return returnError();
        }
    }


    /**
     *  根据传感器查询集中器
     * {"sensorId":"3"}
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/queryBySensorId", method = RequestMethod.GET)
    public String queryBySensorId(@RequestParam Integer sensorId) {
        try {
            String str = SystemConfig.getRtuConfigKey() + "/rtu/queryBySensorId?sensorId=" +sensorId;
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:queryBySensorId \n 错误内容:"+e);
            return returnError();
        }
    }
}
