package com.senontech.controller.rtuConfigService;

import com.senontech.config.SystemConfig;
import com.senontech.controller.BaseController;
import com.senontech.util.HttpUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;

/**
 * 集中器更换Controller
 */
@Controller
@RequestMapping(value = "/rtuReplace", produces = "application/json;charset=UTF-8")
public class RtuReplaceController extends BaseController {
    private static Logger log= Logger.getLogger(RtuReplaceController.class);

    /**
     * 添加集中器更换
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestBody String param) {
        try {
            return HttpUtil.requestShortConnect(SystemConfig.getRtuConfigKey(), "/rtuReplace/add", param);
        } catch (Exception e) {
            log.error("接口名:add \n 错误内容:"+e);
            return returnError();
        }
    }


    /**
     * 修改集中器更换
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestBody String param) {
        try {
            return HttpUtil.requestShortConnect(SystemConfig.getRtuConfigKey(), "/rtuReplace/edit", param);
        } catch (Exception e) {
            log.error("接口名:edit \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *删除集中器更换
     * {"rtuReplaceId":"3"}
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public String del(@RequestBody String param) {
        try {
            return HttpUtil.requestShortConnect(SystemConfig.getRtuConfigKey(), "/rtuReplace/del", param);
        } catch (Exception e) {
            log.error("接口名:edit \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *批量删除集中器更换
     * {"rtuReplaceIdList":[1,2,3]}
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/delList", method = RequestMethod.POST)
    public String delList(@RequestBody String param) {
        try {
            return HttpUtil.requestShortConnect(SystemConfig.getRtuConfigKey(), "/rtuReplace/delList", param);
        } catch (Exception e) {
            log.error("接口名:delList \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *  单个查询集中器更换数据
     * {""rtuReplaceId":"3"}
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String query(@RequestParam Integer rtuReplaceId) {
        try {
            String str = SystemConfig.getRtuConfigKey() + "/rtuReplace/query?rtuReplaceId=" +rtuReplaceId;
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:query \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *查询集中器更换数据列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryList", method = RequestMethod.GET)
    public String queryList() {
        try {
            String str = SystemConfig.getRtuConfigKey() + "/rtuReplace/queryList";
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:queryList \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *分页查询集中器更换数据列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryPageList", method = RequestMethod.GET)
    public String queryPageList(Integer page,Integer size,String condition) {
        try {
            String str="";
            if(condition!=null&&condition!=""){
                str = SystemConfig.getRtuConfigKey() + "/rtuReplace/queryPageList?page="+page+"&size="+size+"&condition="+ URLEncoder.encode(condition,"UTF-8");
            }else {
                str = SystemConfig.getRtuConfigKey() + "/rtuReplace/queryPageList?page="+page+"&size="+size;
            }
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:queryPageList \n 错误内容:"+e);
            return returnError();
        }
    }


    /**
     *根据类型分页查询接口
     */
    @ResponseBody
    @RequestMapping(value = "/queryTypePageList", method = RequestMethod.GET)
    public String queryTypePageList(Integer page,Integer size,Long rtuTypeId,String rtuName) {
        try {
               String str = SystemConfig.getRtuConfigKey() + "/rtuReplace/queryTypePageList?page="+page+"&size="+size+"&rtuTypeId="+rtuTypeId+"&rtuName="+rtuName;
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:queryTypePageList \n 错误内容:"+e);
            return returnError();
        }
    }
}
