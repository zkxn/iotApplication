package com.senontech.controller.rtuConfigService;

import com.senontech.config.SystemConfig;
import com.senontech.controller.BaseController;
import com.senontech.util.HttpUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;

/**
 * 集中器信息状态Controller
 */
@Controller
@RequestMapping(value = "/rtuInfoStatus", produces = "application/json;charset=UTF-8")
public class RtuInfoStatusController extends BaseController {
    private static Logger log= Logger.getLogger(RtuInfoStatusController.class);


    /**
     *  根据集中器Id查询
     * {"rtuId":"3"}
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/queryByRtuId", method = RequestMethod.GET)
    public String queryByRtuId(@RequestParam Integer rtuId) {
        try {
            String str = SystemConfig.getRtuConfigKey() + "/rtuInfoStatus/queryByRtuId?rtuId=" +rtuId;
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:queryByRtuId \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *分页查询集中器信息状态数据列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryNewPageList", method = RequestMethod.GET)
    public String queryNewPageList(Integer page,Integer size,String condition) {
        try {
            String str="";
            if(condition!=null&&condition!=""){
                str = SystemConfig.getRtuConfigKey() + "/rtuInfoStatus/queryNewPageList?page="+page+"&size="+size+"&condition="+ URLEncoder.encode(condition,"UTF-8");
            }else {
                str = SystemConfig.getRtuConfigKey() + "/rtuInfoStatus/queryNewPageList?page="+page+"&size="+size;
            }
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:queryNewPageList \n 错误内容:"+e);
            return returnError();
        }
    }
    /**
     *分页查询集中器信息状态数据列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryHistoryPageList", method = RequestMethod.GET)
    public String queryHistoryPageList(Integer page,Integer size,String condition) {
        try {
            String str="";
            if(condition!=null&&condition!=""){
                str = SystemConfig.getRtuConfigKey() + "/rtuInfoStatus/queryHistoryPageList?page="+page+"&size="+size+"&condition="+ URLEncoder.encode(condition,"UTF-8");
            }else {
                str = SystemConfig.getRtuConfigKey() + "/rtuInfoStatus/queryHistoryPageList?page="+page+"&size="+size;
            }
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:queryHistoryPageList \n 错误内容:"+e);
            return returnError();
        }
    }


    /**
     *  根据集中器Id查询最新的集中器状态
     * {"rtuId":"3"}
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/queryNewByRtuId", method = RequestMethod.GET)
    public String queryNewByRtuId(@RequestParam Integer rtuId) {
        try {
            String str = SystemConfig.getRtuConfigKey() + "/rtuInfoStatus/queryNewByRtuId?rtuId=" +rtuId;
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:queryNewByRtuId \n 错误内容:"+e);
            return returnError();
        }
    }
}
