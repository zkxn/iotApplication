package com.senontech.controller.rtuConfigService;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.senontech.config.SystemConfig;
import com.senontech.controller.BaseController;
import com.senontech.util.AnalysisUtil;
import com.senontech.util.HttpUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;
import java.util.TreeSet;

/**
 * RtuControlController
 */
@Controller
@RequestMapping(value = "/rtuControl", produces = "application/json;charset=UTF-8")
public class RtuControlController extends BaseController {
    private static Logger log= Logger.getLogger(RtuControlController.class);


    /**
     * 手动模式的开与关
     * {"dataItemId":"a","operation":"0/1"}
     *
     * @param param
     * @return {"successful":1,"returnCode":0} returnCode : 0:操作正常，1：集中器不在线  2：集中器锁闭，无法控制 3：集中器设备运行异常
     * 4： 集中器基础参数版本更新异常 5：集中器运行参数版本更新异常 6：固件版本更新异常,7:设备版本错误，需要升级
     */
    @ResponseBody
    @RequestMapping(value = "/remoteControl", method = RequestMethod.POST)
    public String remoteControl(@RequestBody String param) {
        JSONObject returnCode = new JSONObject();
        returnCode.put("code", 1);
        try {
            JSONObject jsonParam = JSONObject.parseObject(param);
            Long dataItemId=jsonParam.getLong("dataItemId");
            JSONObject dataItem=AnalysisUtil.getObj(HttpUtil.requestGetConnect(SystemConfig.getDataItemConfigKey()+"/dataItem/query?dataItemId="+dataItemId));
            if(dataItem==null){
                returnCode.put("data", 8);
                returnCode.put("msg","该数据项不存在！");
                return returnCode.toJSONString();
            }
            JSONObject dataType=dataItem.getJSONObject("dataType");
            if(dataType==null){
                returnCode.put("data", 9);
                returnCode.put("msg","该数据项未配置数据类型！");
                return returnCode.toJSONString();
            }
            if(dataType.getString("mainingControlType").equals("采集")){
                returnCode.put("data", 10);
                returnCode.put("msg","该数据项不是可控数据项！");
                return returnCode.toJSONString();
            }
            JSONObject rtu=AnalysisUtil.getObjByUrl(SystemConfig.getRtuConfigKey()+"/rtu/queryBySensorId?sensorId="+dataItem.getLong("sensorId"));
            if(rtu==null){
                returnCode.put("data", 11);
                returnCode.put("msg","该数据项没有可控集中器！");
                return returnCode.toJSONString();
            }

            JSONObject rtuStatus=AnalysisUtil.getObjByUrl(SystemConfig.getRtuConfigKey()+"/rtuInfoStatus/queryNewByRtuId?rtuId="+rtu.getLong("rtuId"));
            if (rtuStatus==null){
                returnCode.put("data", 12);
                returnCode.put("msg","该集中器未上报过状态无法控制！");
                return returnCode.toJSONString();
            }
            if(rtuStatus.getBoolean("onlineStatus")==null||!rtuStatus.getBoolean("onlineStatus")){
                returnCode.put("data", 1);
                returnCode.put("msg","集中器不在线！");
                return returnCode.toJSONString();
            }
            if (rtuStatus.getBoolean("lockMode")!=null&&!rtuStatus.getBoolean("lockMode")){
                returnCode.put("data", 2);
                returnCode.put("msg","集中器锁闭，无法控制！");
                return returnCode.toJSONString();
            }
            if(rtuStatus.getBoolean("runStatus")==null||rtuStatus.getBoolean("runStatus")){
                returnCode.put("data", 3);
                returnCode.put("msg","集中器设备运行异常！");
                return returnCode.toJSONString();
            }
            if(rtuStatus.getBoolean("baseParamStatus")==null||!rtuStatus.getBoolean("baseParamStatus")){
                returnCode.put("data", 4);
                returnCode.put("msg","集中器基础参数版本更新异常！");
                return returnCode.toJSONString();
            }
            if(rtuStatus.getBoolean("workParamStatus")==null||!rtuStatus.getBoolean("workParamStatus")){
                returnCode.put("data", 5);
                returnCode.put("msg","集中器运行参数版本更新异常！");
                return returnCode.toJSONString();
            }
            if(rtuStatus.getBoolean("firmwareStatus")==null||!rtuStatus.getBoolean("firmwareStatus")){
                returnCode.put("data", 6);
                returnCode.put("msg","固件版本更新异常！");
                return returnCode.toJSONString();
            }


            //封装处理对象
            JSONObject jsonResult = new JSONObject();
            jsonResult.put("rtuId",rtu.getLong("rtuId"));
            JSONArray dataItemArray = new JSONArray();
            JSONObject addOperation = new JSONObject();
            addOperation.put("dataItemId", dataItemId);
            addOperation.put("Operation", jsonParam.getString("operation"));
            dataItemArray.add(addOperation);
            jsonResult.put("devOperationsList", dataItemArray);
            String query = HttpUtil.requestShortConnect(SystemConfig.getEquimentService(), "/RemoteControl/ControlPointOperation", jsonResult.toJSONString());
            JSONObject returnCodeObject = JSONObject.parseObject(query);
            if (returnCodeObject.getIntValue("returnCode") == 0 && returnCodeObject.getBoolean("ExecuteSuccess")) {
                returnCode.put("data", 0);
                returnCode.put("msg", "设备开关切换成功。");
            } else {
                returnCode.put("data", returnCodeObject.getIntValue("returnCode"));
                returnCode.put("msg", "设备开关切换失败。");
            }
            return returnCode.toJSONString();
        } catch (Exception e) {
            log.error("接口名:remoteControl\n 错误内容:"+e);
            return returnError();
        }
    }


    /*
  重启设备
  *{"rtuId":164}
   */
    @ResponseBody
    @RequestMapping(value = "/reboot", method = RequestMethod.POST)
    public String reboot(@RequestBody String param) {
        JSONObject returnCode = new JSONObject();
        returnCode.put("code", 1);
        try {
            String returnValue = HttpUtil.requestShortConnect(SystemConfig.getEquimentService(), "/RemoteControl/Restart", param);
            JSONObject returnCodeObject = JSONObject.parseObject(returnValue);
            if (returnCodeObject.getIntValue("returnCode") == 0 && returnCodeObject.getBoolean("ExecuteSuccess")) {
                returnCode.put("msg", "设备重启成功。");
            } else {
                returnCode.put("returnCode", returnCodeObject.getIntValue("returnCode"));
                returnCode.put("msg", "设备重启失败。");
                returnCode.put("code", 0);
            }
            return returnCode.toJSONString();
        }catch (Exception e) {
            log.error("接口名:reboot\n 错误内容:"+e);
            return returnError();
        }
    }



}
