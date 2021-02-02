package com.senontech.controller.rtuConfigService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.senontech.config.SystemConfig;
import com.senontech.controller.BaseController;
import com.senontech.util.AnalysisUtil;
import com.senontech.util.HttpUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;

/**
 * 组织机构Controller
 */
@Controller
@RequestMapping(value = "/company", produces = "application/json;charset=UTF-8")
public class CompanyController extends BaseController {
    private static Logger log= Logger.getLogger(CompanyController.class);

    /**
     * 添加组织机构
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestBody String param) {
        try {
            String str =HttpUtil.requestShortConnect(SystemConfig.getOrganizationService(), "/company/addWithOutCheck", param);
            Integer code = AnalysisUtil.getCode(str);
            if (code==1) {
                JSONObject paramJson =JSONObject.parseObject(param);
                JSONObject data = AnalysisUtil.getObj(str);
                JSONObject company = data.getJSONObject("company");
                JSONObject ownershipRtuTypeMapper=new JSONObject();
                ownershipRtuTypeMapper.put("ownershipId",company.getLong("companyId"));
                ownershipRtuTypeMapper.put("rtuTypeIdList",paramJson.getJSONArray("rtuTypeIdList"));
                HttpUtil.requestShortConnect(SystemConfig.getRtuConfigKey(), "/ownershipRtuTypeMapper/add", ownershipRtuTypeMapper.toString());
            }
            return str;
        } catch (Exception e) {
            log.error("接口名:add \n 错误内容:"+e);
            return returnError();
        }
    }


    /**
     * 修改组织机构
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestBody String param) {
        try {
            String str = HttpUtil.requestShortConnect(SystemConfig.getOrganizationService(), "/company/edit", param);
            Integer code = AnalysisUtil.getCode(str);
            if (code==1){
                JSONObject paramJson =JSONObject.parseObject(param);
                JSONArray rtuTypeIdList = paramJson.getJSONArray("rtuTypeIdList");
                if(rtuTypeIdList!=null&&rtuTypeIdList.size()>0){
                    JSONObject ownershipRtuTypeMapper=new JSONObject();
                    ownershipRtuTypeMapper.put("ownershipId",paramJson.getLong("companyId"));
                    ownershipRtuTypeMapper.put("rtuTypeIdList",rtuTypeIdList);
                    HttpUtil.requestShortConnect(SystemConfig.getRtuConfigKey(), "/ownershipRtuTypeMapper/add", ownershipRtuTypeMapper.toString());
                }
            }
            return str;
        } catch (Exception e) {
            log.error("接口名:edit \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *删除组织机构
     * {"companyId":"3"}
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public String del(@RequestBody String param) {
        try {
            String str=HttpUtil.requestShortConnect(SystemConfig.getOrganizationService(), "/company/del", param);
            Integer code = AnalysisUtil.getCode(str);
            if (code==1){
                JSONObject paramJson =JSONObject.parseObject(param);
                JSONObject ownershipRtuTypeMapper=new JSONObject();
                ownershipRtuTypeMapper.put("ownershipId",paramJson.getLong("companyId"));
                HttpUtil.requestShortConnect(SystemConfig.getRtuConfigKey(), "/ownershipRtuTypeMapper/delByOwnershipId", ownershipRtuTypeMapper.toString());
            }
            return str;
        } catch (Exception e) {
            log.error("接口名:edit \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *  单个查询组织机构数据
     * {""companyId":"3"}
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String query(@RequestParam Integer companyId) {
        try {
            String str = HttpUtil.requestGetConnect(SystemConfig.getOrganizationService() + "/company/query?companyId=" +companyId);
            JSONObject ret = JSONObject.parseObject(str);
            Integer code = ret.getInteger("code");
            JSONObject data = ret.getJSONObject("data");
            if (code==1){
                String url=SystemConfig.getRtuConfigKey()+"/ownershipRtuTypeMapper/queryByOwnershipId?ownershipId="+companyId;
                String str2 = HttpUtil.requestGetConnect(url);
                JSONObject ret2 = JSONObject.parseObject(str2);
                JSONArray rtuTypeIdList = ret2.getJSONArray("data");
                data.put("rtuTypeIdList",rtuTypeIdList);
                ret.put("data",data);
            }
            return JSON.toJSONString(ret);
        } catch (Exception e) {
            log.error("接口名:query \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *查询组织机构数据列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryList", method = RequestMethod.GET)
    public String queryList() {
        try {
            String str = SystemConfig.getOrganizationService() + "/company/queryList";
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:queryList \n 错误内容:"+e);
            return returnError();
        }
    }
    /**
     *查询最上层组织列表接口
     */
    @ResponseBody
    @RequestMapping(value = "/queryParentList", method = RequestMethod.GET)
    public String queryParentList() {
        try {
            String str = SystemConfig.getOrganizationService() + "/company/queryParentList";
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:queryParentList \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *分页查询组织机构数据列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryPageList", method = RequestMethod.GET)
    public String queryPageList(Integer page,Integer size,String condition) {
        try {
            String str="";
            if(condition!=null&&condition!=""){
                str = SystemConfig.getOrganizationService() + "/company/queryPageList?page="+page+"&size="+size+"&condition="+ URLEncoder.encode(condition,"UTF-8");
            }else {
                str = SystemConfig.getOrganizationService() + "/company/queryPageList?page="+page+"&size="+size;
            }
            return HttpUtil.requestGetConnect(str);
        } catch (Exception e) {
            log.error("接口名:queryPageList \n 错误内容:"+e);
            return returnError();
        }
    }

    /**
     *通过集中器Id查询
     */
    @ResponseBody
    @RequestMapping(value = "/queryByRtuTypeId", method = RequestMethod.GET)
    public String queryByRtuTypeId(@RequestParam Integer rtuTypeId) {
        try {
            String url=SystemConfig.getRtuConfigKey()+"/ownershipRtuTypeMapper/queryByRtuTypeId?rtuTypeId="+rtuTypeId;
            String str = HttpUtil.requestGetConnect(url);
            JSONArray ownershipIdList = AnalysisUtil.getObjList(str);
            if(ownershipIdList!=null&&ownershipIdList.size()>0){
                String strParam="";
                for (int i = 0; i < ownershipIdList.size() ; i++) {
                    Integer ownershipId= (Integer) ownershipIdList.get(i);
                    if(i==0){
                        strParam+=ownershipId;
                    }else {
                        strParam+=","+ownershipId;
                    }
                }
                return HttpUtil.requestGetConnect(SystemConfig.getOrganizationService()+"/company/queryListById?companyIdList="+strParam);
            }
            return str;
        } catch (Exception e) {
            log.error("接口名:queryByRtuTypeId \n 错误内容:"+e);
            return returnError();
        }
    }
}
