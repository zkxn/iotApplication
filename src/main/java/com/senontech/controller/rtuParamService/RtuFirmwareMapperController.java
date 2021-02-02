package com.senontech.controller.rtuParamService;

import com.senontech.config.SystemConfig;
import com.senontech.controller.BaseController;
import com.senontech.util.HttpUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 基础参数Controller
 */
@Controller
@RequestMapping(value = "/rtuFirmwareMapper", produces = "application/json;charset=UTF-8")
public class RtuFirmwareMapperController extends BaseController {
    private static Logger log= Logger.getLogger(RtuFirmwareMapperController.class);

    /**
     * 添加基础参数
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestBody String param) {
        try {
            return HttpUtil.requestShortConnect(SystemConfig.getRtuParamKey(), "/rtuFirmwareMapper/add", param);
        } catch (Exception e) {
            log.error("接口名:add \n 错误内容:"+e);
            return returnError();
        }
    }


    /**
     *  根据集中器查询最新参数列表
     * {""rtuId":"3"}
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/queryFirmwareByRtuId", method = RequestMethod.GET)
    public String queryFirmwareByRtuId(@RequestParam Integer rtuId) {
        try {
            String str = SystemConfig.getRtuParamKey() + "/rtuFirmwareMapper/queryFirmwareByRtuId?rtuId=" +rtuId;
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:query \n 错误内容:"+e);
            return returnError();
        }
    }

}
