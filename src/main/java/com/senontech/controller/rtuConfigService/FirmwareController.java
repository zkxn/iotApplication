package com.senontech.controller.rtuConfigService;

import com.alibaba.fastjson.JSONObject;
import com.senontech.config.SystemConfig;
import com.senontech.controller.BaseController;
import com.senontech.util.AnalysisUtil;
import com.senontech.util.FileDownloadUtils;
import com.senontech.util.HttpUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

/**
 * 固件Controller
 */
@Controller
@RequestMapping(value = "/firmware", produces = "application/json;charset=UTF-8")
public class FirmwareController extends BaseController {
    private static Logger log= Logger.getLogger(FirmwareController.class);

    /**
     * 添加固件
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestBody String param) {
        try {
            return HttpUtil.requestShortConnect(SystemConfig.getRtuConfigKey(), "/firmware/add", param);
        } catch (Exception e) {
            log.error("接口名:add \n 错误内容:"+e);
            return returnError();
        }
    }


    /**
     * 修改固件
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestBody String param) {
        try {
            return HttpUtil.requestShortConnect(SystemConfig.getRtuConfigKey(), "/firmware/edit", param);
        } catch (Exception e) {
            log.error("接口名:edit \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *删除固件
     * {"areaId":"3"}
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public String del(@RequestBody String param) {
        try {
            return HttpUtil.requestShortConnect(SystemConfig.getRtuConfigKey(), "/firmware/del", param);
        } catch (Exception e) {
            log.error("接口名:edit \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *批量删除固件
     * {"areaIdList":[1,2,3]}
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/delList", method = RequestMethod.POST)
    public String delList(@RequestBody String param) {
        try {
            return HttpUtil.requestShortConnect(SystemConfig.getRtuConfigKey(), "/firmware/delList", param);
        } catch (Exception e) {
            log.error("接口名:delList \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *  单个查询固件数据
     * {""areaId":"3"}
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String query(@RequestParam Integer firmwareId) {
        try {
            String str = SystemConfig.getRtuConfigKey() + "/firmware/query?firmwareId=" +firmwareId;
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:query \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *  单个查询固件数据
     * {""firmwareId":"1,2,3"}
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/queryByIdList", method = RequestMethod.GET)
    public String queryByIdList(@RequestParam("firmwareId") List<Long> firmwareIdList) {
        try {
            String str="";
            if(firmwareIdList!=null&&firmwareIdList.size()>0){
                String param = null;
                int i=0;
                for (Long firmwareId : firmwareIdList) {
                    i++;
                    if(i==firmwareIdList.size()){
                        param+=firmwareId;
                    }else {
                        param+=firmwareId+",";
                    }
                }
                str = SystemConfig.getRtuConfigKey() + "/firmware/queryByIdList?"+param;
            }else {
                str = SystemConfig.getRtuConfigKey() + "/firmware/queryByIdList";
            }

            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:query \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *查询固件数据列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryList", method = RequestMethod.GET)
    public String queryList() {
        try {
            String str = SystemConfig.getRtuConfigKey() + "/firmware/queryList";
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:queryList \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *分页查询固件数据列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryPageList", method = RequestMethod.GET)
    public String queryPageList(Integer page,Integer size,String condition) {
        try {
            String str="";
            if(condition!=null&&condition!=""){
                str = SystemConfig.getRtuConfigKey() + "/firmware/queryPageList?page="+page+"&size="+size+"&condition="+ URLEncoder.encode(condition,"UTF-8");
            }else {
                str = SystemConfig.getRtuConfigKey() + "/firmware/queryPageList?page="+page+"&size="+size;
            }
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:queryPageList \n 错误内容:"+e);
            return returnError();
        }
    }


    /**
     *查询固件数据列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryByRtuTypeId", method = RequestMethod.GET)
    public String queryByRtuTypeId(@RequestParam Integer rtuTypeId) {
        try {
            String str = SystemConfig.getRtuConfigKey() + "/firmware/queryByRtuTypeId?rtuTypeId="+rtuTypeId;
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:queryList \n 错误内容:"+e);
            return returnError();
        }
    }


    /**
     *  下载固件
     * {"firmwareId":"3"}
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/downloadFirmware", method = RequestMethod.GET)
    public void downloadFirmware(@RequestParam Integer firmwareId, HttpServletResponse reps, HttpServletRequest request) {
        try {
            String str=HttpUtil.requestGetConnect(SystemConfig.getRtuConfigKey() + "/firmware/query?firmwareId=" +firmwareId);
            JSONObject firmwareObj= AnalysisUtil.getObj(str);
            if(firmwareObj!=null){
                FileDownloadUtils.downFirmware(firmwareObj.getString("version")+".bin",firmwareObj.getBytes("firmware"),request,reps);
            }else {
                FileDownloadUtils.downFirmware("没有该固件哦!"+".bin",null,request,reps);
            }
        } catch (Exception e) {
            log.error("接口名:downloadFirmware \n 错误内容:"+e);
        }
    }

}
