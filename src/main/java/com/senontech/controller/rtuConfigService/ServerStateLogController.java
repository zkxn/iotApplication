package com.senontech.controller.rtuConfigService;

import com.senontech.config.SystemConfig;
import com.senontech.controller.BaseController;
import com.senontech.util.HttpUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;

/**
 * 服务器状态日志Controller
 */
@Controller
@RequestMapping(value = "/serverStateLog", produces = "application/json;charset=UTF-8")
public class ServerStateLogController extends BaseController {
    private static Logger log= Logger.getLogger(ServerStateLogController.class);

    /**
     * 添加服务器状态日志
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestBody String param) {
        try {
            return HttpUtil.requestShortConnect(SystemConfig.getRtuConfigKey(), "/serverStateLog/add", param);
        } catch (Exception e) {
            log.error("接口名:add \n 错误内容:"+e);
            return returnError();
        }
    }


    /**
     * 修改服务器状态日志
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestBody String param) {
        try {
            return HttpUtil.requestShortConnect(SystemConfig.getRtuConfigKey(), "/serverStateLog/edit", param);
        } catch (Exception e) {
            log.error("接口名:edit \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *删除服务器状态日志
     * {"serverStateLogId":"3"}
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public String del(@RequestBody String param) {
        try {
            return HttpUtil.requestShortConnect(SystemConfig.getRtuConfigKey(), "/serverStateLog/del", param);
        } catch (Exception e) {
            log.error("接口名:edit \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *批量删除服务器状态日志
     * {"serverStateLogIdList":[1,2,3]}
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/delList", method = RequestMethod.POST)
    public String delList(@RequestBody String param) {
        try {
            return HttpUtil.requestShortConnect(SystemConfig.getRtuConfigKey(), "/serverStateLog/delList", param);
        } catch (Exception e) {
            log.error("接口名:delList \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *  单个查询服务器状态日志数据
     * {""serverStateLogId":"3"}
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String query(@RequestParam Integer serverStateLogId) {
        try {
            String str = SystemConfig.getRtuConfigKey() + "/serverStateLog/query?serverStateLogId=" +serverStateLogId;
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:query \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *查询服务器状态日志数据列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryList", method = RequestMethod.GET)
    public String queryList() {
        try {
            String str = SystemConfig.getRtuConfigKey() + "/serverStateLog/queryList";
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:queryList \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *分页查询服务器状态日志数据列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryPageList", method = RequestMethod.GET)
    public String queryPageList(Integer page,Integer size,String condition) {
        try {
            String str="";
            if(condition!=null&&condition!=""){
                str = SystemConfig.getRtuConfigKey() + "/serverStateLog/queryPageList?page="+page+"&size="+size+"&condition="+ URLEncoder.encode(condition,"UTF-8");
            }else {
                str = SystemConfig.getRtuConfigKey() + "/serverStateLog/queryPageList?page="+page+"&size="+size;
            }
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:queryPageList \n 错误内容:"+e);
            return returnError();
        }
    }
}
