package com.senontech.controller.rtuParamService;

import com.senontech.config.SystemConfig;
import com.senontech.controller.BaseController;
import com.senontech.util.HttpUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;

/**
 * 基础参数Controller
 */
@Controller
@RequestMapping(value = "/rtuBaseParam", produces = "application/json;charset=UTF-8")
public class RtuBaseParamController extends BaseController {
    private static Logger log= Logger.getLogger(RtuBaseParamController.class);

    /**
     * 添加基础参数
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestBody String param) {
        try {
            return HttpUtil.requestShortConnect(SystemConfig.getRtuParamKey(), "/rtuBaseParam/add", param);
        } catch (Exception e) {
            log.error("接口名:add \n 错误内容:"+e);
            return returnError();
        }
    }


    /**
     *删除基础参数
     * {"rtuBaseParamId":"3"}
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public String del(@RequestBody String param) {
        try {
            return HttpUtil.requestShortConnect(SystemConfig.getRtuParamKey(), "/rtuBaseParam/del", param);
        } catch (Exception e) {
            log.error("接口名:edit \n 错误内容:"+e);
            return returnError();
        }
    }



    /**
     *  根据集中器查询最新参数列表
     * {""rtuId":"3"}
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/queryNewByRtuId", method = RequestMethod.GET)
    public String queryNewByRtuId(@RequestParam Integer rtuId) {
        try {
            String str = SystemConfig.getRtuParamKey() + "/rtuBaseParam/queryNewByRtuId?rtuId=" +rtuId;
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:query \n 错误内容:"+e);
            return returnError();
        }
    }

}
