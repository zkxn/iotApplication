package com.senontech.controller.dataItemConfigService;

import com.senontech.config.SystemConfig;
import com.senontech.controller.BaseController;
import com.senontech.util.HttpUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;

/**
 * 数据项Controller
 */
@Controller
@RequestMapping(value = "/dataItem", produces = "application/json;charset=UTF-8")
public class DataItemController extends BaseController {
    private static Logger log= Logger.getLogger(DataItemController.class);

    /**
     * 添加数据项
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestBody String param) {
        try {
            return HttpUtil.requestShortConnect(SystemConfig.getDataItemConfigKey(), "/dataItem/add", param);
        } catch (Exception e) {
            log.error("接口名:add \n 错误内容:"+e);
            return returnError();
        }
    }


    /**
     * 修改数据项
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestBody String param) {
        try {
            return HttpUtil.requestShortConnect(SystemConfig.getDataItemConfigKey(), "/dataItem/edit", param);
        } catch (Exception e) {
            log.error("接口名:edit \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *删除数据项
     * {"dataItemId":"3"}
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public String del(@RequestBody String param) {
        try {
            return HttpUtil.requestShortConnect(SystemConfig.getDataItemConfigKey(), "/dataItem/del", param);
        } catch (Exception e) {
            log.error("接口名:edit \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *批量删除数据项
     * {"dataItemIdList":[1,2,3]}
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/delList", method = RequestMethod.POST)
    public String delList(@RequestBody String param) {
        try {
            return HttpUtil.requestShortConnect(SystemConfig.getDataItemConfigKey(), "/dataItem/delList", param);
        } catch (Exception e) {
            log.error("接口名:delList \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *  单个查询数据项数据
     * {""dataItemId":"3"}
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String query(@RequestParam Integer dataItemId) {
        try {
            String str = SystemConfig.getDataItemConfigKey() + "/dataItem/query?dataItemId=" +dataItemId;
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:query \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *查询数据项数据列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryList", method = RequestMethod.GET)
    public String queryList() {
        try {
            String str = SystemConfig.getDataItemConfigKey() + "/dataItem/queryList";
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:queryList \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *分页查询数据项数据列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryPageList", method = RequestMethod.GET)
    public String queryPageList(Integer page,Integer size,String condition) {
        try {
            String str="";
            if(condition!=null&&condition!=""){
                str = SystemConfig.getDataItemConfigKey() + "/dataItem/queryPageList?page="+page+"&size="+size+"&condition="+ URLEncoder.encode(condition,"UTF-8");
            }else {
                str = SystemConfig.getDataItemConfigKey() + "/dataItem/queryPageList?page="+page+"&size="+size;
            }
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:queryPageList \n 错误内容:"+e);
            return returnError();
        }
    }


    /**
     *  单个查询数据项数据
     * {"sensorId":"3"}
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/queryBySensorId", method = RequestMethod.GET)
    public String queryBySensorId(@RequestParam Long sensorId) {
        try {
            String str = SystemConfig.getDataItemConfigKey() + "/dataItem/queryBySensorId?sensorId=" +sensorId;
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:queryBySensorId \n 错误内容:"+e);
            return returnError();
        }
    }


    /**
     *  根据集中器Id查询
     * {"rtuId":"3"}
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/queryByRtuId", method = RequestMethod.GET)
    public String queryByRtuId(@RequestParam Long rtuId) {
        try {
            String str = SystemConfig.getDataItemConfigKey() + "/dataItem/queryByRtuId?rtuId=" +rtuId;
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:queryByRtuId \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *  根据数据项名称查询
     * {"dataItemName":"电压"}
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/queryByName", method = RequestMethod.GET)
    public String queryByName(@RequestParam String dataItemName) {
        try {
            String str = SystemConfig.getDataItemConfigKey() + "/dataItem/queryByName?dataItemName=" +dataItemName;
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:queryByName \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *  根据集中器Id查询并附带最新数据
     * {"rtuId":"1"}
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/queryDataByRtuId", method = RequestMethod.GET)
    public String queryDataByRtuId(@RequestParam Long rtuId) {
        try {
            String str = SystemConfig.getDataItemConfigKey() + "/dataItem/queryDataByRtuId?rtuId=" +rtuId;
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:queryDataByRtuId \n 错误内容:"+e);
            return returnError();
        }
    }



}
