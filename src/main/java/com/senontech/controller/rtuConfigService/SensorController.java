package com.senontech.controller.rtuConfigService;

import com.senontech.config.SystemConfig;
import com.senontech.controller.BaseController;
import com.senontech.util.HttpUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;

/**
 * 传感器Controller
 */
@Controller
@RequestMapping(value = "/sensor", produces = "application/json;charset=UTF-8")
public class SensorController extends BaseController {
    private static Logger log= Logger.getLogger(SensorController.class);

    /**
     * 添加传感器
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestBody String param) {
        try {
            return HttpUtil.requestShortConnect(SystemConfig.getRtuConfigKey(), "/sensor/add", param);
        } catch (Exception e) {
            log.error("接口名:add \n 错误内容:"+e);
            return returnError();
        }
    }


    /**
     * 修改传感器
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestBody String param) {
        try {
            return HttpUtil.requestShortConnect(SystemConfig.getRtuConfigKey(), "/sensor/edit", param);
        } catch (Exception e) {
            log.error("接口名:edit \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *删除传感器
     * {"sensorId":"3"}
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public String del(@RequestBody String param) {
        try {
            return HttpUtil.requestShortConnect(SystemConfig.getRtuConfigKey(), "/sensor/del", param);
        } catch (Exception e) {
            log.error("接口名:edit \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *批量删除传感器
     * {"sensorIdList":[1,2,3]}
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/delList", method = RequestMethod.POST)
    public String delList(@RequestBody String param) {
        try {
            return HttpUtil.requestShortConnect(SystemConfig.getRtuConfigKey(), "/sensor/delList", param);
        } catch (Exception e) {
            log.error("接口名:delList \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *  单个查询传感器数据
     * {""sensorId":"3"}
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String query(@RequestParam Integer sensorId) {
        try {
            String str = SystemConfig.getRtuConfigKey() + "/sensor/query?sensorId=" +sensorId;
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:query \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *查询传感器数据列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryList", method = RequestMethod.GET)
    public String queryList() {
        try {
            String str = SystemConfig.getRtuConfigKey() + "/sensor/queryList";
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:queryList \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *分页查询传感器数据列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryPageList", method = RequestMethod.GET)
    public String queryPageList(Integer page,Integer size,String condition) {
        try {
            String str="";
            if(condition!=null&&condition!=""){
                str = SystemConfig.getRtuConfigKey() + "/sensor/queryPageList?page="+page+"&size="+size+"&condition="+ URLEncoder.encode(condition,"UTF-8");
            }else {
                str = SystemConfig.getRtuConfigKey() + "/sensor/queryPageList?page="+page+"&size="+size;
            }
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:queryPageList \n 错误内容:"+e);
            return returnError();
        }
    }


    /**
     *  根据集中器查询分配的传感器
     * {""rtuId":"3"}
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/querySensorByRtuId", method = RequestMethod.GET)
    public String querySensorByRtuId(@RequestParam Integer rtuId) {
        try {
            String str = SystemConfig.getRtuConfigKey() + "/sensor/querySensorByRtuId?rtuId=" +rtuId;
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:querySensorByRtuId \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *  根据集中器查询分配的传感器
     */
    @ResponseBody
    @RequestMapping(value = "/queryUnallocated", method = RequestMethod.GET)
    public String queryUnallocated() {
        try {
            String str = SystemConfig.getRtuConfigKey() + "/sensor/queryUnallocated";
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:queryUnallocated \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *  根据业主查询未分配的传感器
     * {""rtuId":"3"}
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/queryUnallocatedByOwnership", method = RequestMethod.GET)
    public String queryUnallocatedByOwnership(@RequestParam Integer ownershipId) {
        try {
            String str = SystemConfig.getRtuConfigKey() + "/sensor/queryUnallocatedByOwnership?ownershipId=" +ownershipId;
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:queryUnallocatedByOwnership \n 错误内容:"+e);
            return returnError();
        }
    }
}
