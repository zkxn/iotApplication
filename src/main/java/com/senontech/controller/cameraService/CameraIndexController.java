package com.senontech.controller.cameraService;

import com.senontech.exceptions.ErrorCodeException;
import com.senontech.pojo.bo.cameraService.Camera;
import com.senontech.pojo.bo.cameraService.CameraIndex;
import com.senontech.pojo.page.Page;
import com.senontech.pojo.vo.BaseResponseVo;
import com.senontech.util.RestTemplateUtil;
import org.springframework.web.bind.annotation.*;


import java.net.URLEncoder;

import static com.senontech.constant.ExceptionCode.FAULT_CODE;
import static com.senontech.constant.GlobalString.*;

/**
 * @description: 摄像头预设点表接口层
 * @author: gyk
 * @date: 2020-11-17 13:13:35
 */
@RestController
@RequestMapping(value = "/cameraIndex", produces = "application/json;charset=UTF-8")
public class CameraIndexController {

    //private static Logger log = (Logger) LoggerFactory.getLogger(CameraIndexController.class);

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestBody Camera param) throws ErrorCodeException {
        try {
            String json = RestTemplateUtil
                    .create() 
                    .setContentType("application/json")
                    .addObjectBody(param)
                    .postForObj(RestTemplateUtil.getProp("cameraService20003") + "/cameraIndex/add", String.class);
            return json;
        } catch (Exception e) {
            return new BaseResponseVo(FAULT_CODE, ADD_FAIL).toJSONString();
        }
    }

    @RequestMapping(value = "/clear", method = RequestMethod.POST)
    public String clear(@RequestBody Camera param) {
        try {
            String json = RestTemplateUtil
                    .create() 
                    .setContentType("application/json")
                    .addObjectBody(param)
                    .postForObj(RestTemplateUtil.getProp("cameraService20003") + "/cameraIndex/clear", String.class);
            return json;
        } catch (Exception e) {
            return new BaseResponseVo(FAULT_CODE, EDIT_FAIL).toJSONString();
        }
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestBody CameraIndex cameraIndex) {
        try {
            String json = RestTemplateUtil
                    .create() 
                    .setContentType("application/json")
                    .addObjectBody(cameraIndex)
                    .postForObj(RestTemplateUtil.getProp("cameraService20003") + "/cameraIndex/edit", String.class);
            return json;
        } catch (Exception e) {
            return new BaseResponseVo(FAULT_CODE, EDIT_FAIL).toJSONString();
        }
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String query(@RequestParam("cameraIndexId") Integer cameraIndexId) {
        try {
            String json = RestTemplateUtil
                    .create() 
                    .setContentType("application/json")
                    .getForObj(RestTemplateUtil.getProp("cameraService20003") + "/cameraIndex/query?cameraIndexId=" + cameraIndexId, String.class);
            return json;
        } catch (Exception e) {
            return new BaseResponseVo(FAULT_CODE, QUERY_FAIL).toJSONString();
        }
    }

    @RequestMapping(value = "/queryList", method = RequestMethod.GET)
    public String queryList() {
        try {
            String json = RestTemplateUtil
                    .create() 
                    .setContentType("application/json")
                    .getForObj(RestTemplateUtil.getProp("cameraService20003") + "/cameraIndex/queryList", String.class);
            return json;
        } catch (Exception e) {
            return new BaseResponseVo(FAULT_CODE, QUERY_FAIL).toJSONString();
        }
    }

    @RequestMapping(value = "/queryPageList", method = RequestMethod.GET)
    public String queryPageList(Page<CameraIndex> page) {
        try {
            String json = RestTemplateUtil
                    .create() 
                    .setContentType("application/json")
                    .getForObj(RestTemplateUtil.getProp("cameraService20003") + "/cameraIndex/queryPageList?page="
                            + page.getPage() + "&size="
                            + page.getSize() + "&condition="
                            + URLEncoder.encode(page.getCondition().toString(), "UTF-8"), String.class);
            return json;
        } catch (Exception e) {
            return new BaseResponseVo(FAULT_CODE, QUERY_FAIL).toJSONString();
        }
    }

    @RequestMapping(value = "/queryListByCameraId", method = RequestMethod.GET)
    public String queryListByCameraId(@RequestParam("cameraId") Integer cameraId) {
        try {
            String json = RestTemplateUtil
                    .create() 
                    .setContentType("application/json")
                    .getForObj(RestTemplateUtil.getProp("cameraService20003") + "/cameraIndex/queryListByCameraId?cameraId=" + cameraId, String.class);
            return json;
        } catch (Exception e) {
            return new BaseResponseVo(FAULT_CODE, QUERY_FAIL).toJSONString();
        }
    }
}