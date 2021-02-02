package com.senontech.controller.rtuParamService;

import com.senontech.config.SystemConfig;
import com.senontech.controller.BaseController;
import com.senontech.util.HttpUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 运行参数Controller
 */
@Controller
@RequestMapping(value = "/rtuRunParam", produces = "application/json;charset=UTF-8")
public class RtuRunParamController extends BaseController {
    private static Logger log= Logger.getLogger(RtuRunParamController.class);

    /**
     * 添加运行参数
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestBody String param) {
        try {
            return HttpUtil.requestShortConnect(SystemConfig.getRtuParamKey(), "/rtuRunParam/add", param);
        } catch (Exception e) {
            log.error("接口名:add \n 错误内容:"+e);
            return returnError();
        }
    }


    /**
     *删除运行参数
     * {"rtuRunParamId":"3"}
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public String del(@RequestBody String param) {
        try {
            return HttpUtil.requestShortConnect(SystemConfig.getRtuParamKey(), "/rtuRunParam/del", param);
        } catch (Exception e) {
            log.error("接口名:edit \n 错误内容:"+e);
            return returnError();
        }
    }



    /**
     *  根据集中器查询最新参数列表
     * {"rtuId":"3"}
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/queryNewByRtuId", method = RequestMethod.GET)
    public String queryNewByRtuId(@RequestParam Integer rtuId) {
        try {
            String str = SystemConfig.getRtuParamKey() + "/rtuRunParam/queryNewByRtuId?rtuId=" +rtuId;
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:query \n 错误内容:"+e);
            return returnError();
        }
    }

}
