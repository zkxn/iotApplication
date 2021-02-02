package com.senontech.controller.rtuConfigService;

import com.senontech.config.SystemConfig;
import com.senontech.controller.BaseController;
import com.senontech.util.HttpUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;

/**
 * 集中器自动运行模式Controller
 */
@Controller
@RequestMapping(value = "/rtuAutoRunModeHistory", produces = "application/json;charset=UTF-8")
public class RtuAutoRunModeHistoryController extends BaseController {
    private static Logger log= Logger.getLogger(RtuAutoRunModeHistoryController.class);

    /**
     *分页查询集中器自动运行模式数据列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryPageList", method = RequestMethod.GET)
    public String queryPageList(Integer page,Integer size,String condition) {
        try {
            String str="";
            if(condition!=null&&condition!=""){
                str = SystemConfig.getRtuConfigKey() + "/rtuAutoRunModeHistory/queryPageList?page="+page+"&size="+size+"&condition="+ URLEncoder.encode(condition,"UTF-8");
            }else {
                str = SystemConfig.getRtuConfigKey() + "/rtuAutoRunModeHistory/queryPageList?page="+page+"&size="+size;
            }
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:queryPageList \n 错误内容:"+e);
            return returnError();
        }
    }

}
