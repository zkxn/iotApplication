package com.senontech.controller.rtuConfigService;

import com.senontech.config.SystemConfig;
import com.senontech.controller.BaseController;
import com.senontech.util.HttpUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 集中器数据Controller
 */
@Controller
@RequestMapping(value = "/rtuData", produces = "application/json;charset=UTF-8")
public class RtuDataController extends BaseController {
    private static Logger log= Logger.getLogger(RtuDataController.class);

    /**
     *  查询rtu的数据
     * {"rtuTypeId":"3"}
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/queryRtuDataByTypeId", method = RequestMethod.GET)
    public String queryRtuDataByTypeId(@RequestParam Integer rtuTypeId) {
        try {
            String str = SystemConfig.getRtuConfigKey() + "/rtuData/queryRtuDataByTypeId?rtuTypeId=" +rtuTypeId;
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:queryRtuDataByTypeId \n 错误内容:"+e);
            return returnError();
        }
    }
}
