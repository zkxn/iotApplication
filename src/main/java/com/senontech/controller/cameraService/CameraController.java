package com.senontech.controller.cameraService;

import com.senontech.pojo.bo.cameraService.Camera;
import com.senontech.pojo.page.Page;
import com.senontech.pojo.vo.BaseResponseVo;
import com.senontech.util.RestTemplateUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;

import static com.senontech.constant.ExceptionCode.FAULT_CODE;
import static com.senontech.constant.GlobalString.*;

/**
 * @description: 摄像头接口层
 * @author: gyk
 * @date: 2020-11-17 12:59:41
 */
@RestController
@RequestMapping(value = "/camera", produces = "application/json;charset=UTF-8")
public class CameraController {

    //private static Logger log = (Logger) LoggerFactory.getLogger(CameraController.class);

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestBody Camera param) {
        try {
            String json = RestTemplateUtil
                    .create()
                    .setContentType("application/json")
                    .addObjectBody(param)
                    .postForObj(RestTemplateUtil.getProp("cameraService20003") + "/camera/add", String.class);
            return json;
        } catch (Exception e) {
            return new BaseResponseVo(FAULT_CODE, ADD_FAIL).toJSONString();
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody Camera param) {
        try {
            String json = RestTemplateUtil
                    .create()
                    .setContentType("application/json")
                    .addObjectBody(param)
                    .postForObj(RestTemplateUtil.getProp("cameraService20003") + "/camera/delete", String.class);
            return json;
        } catch (Exception e) {
            return new BaseResponseVo(FAULT_CODE, DEL_FAIL).toJSONString();
        }
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestBody Camera param) {
        try {
            String json = RestTemplateUtil
                    .create()
                    .setContentType("application/json")
                    .addObjectBody(param)
                    .postForObj(RestTemplateUtil.getProp("cameraService20003") + "/camera/edit", String.class);
            return json;
        } catch (Exception e) {
            return new BaseResponseVo(FAULT_CODE, EDIT_FAIL).toJSONString();
        }
    }

    @RequestMapping(value = "/queryCameraAllInfo", method = RequestMethod.POST)
    public String queryCameraAllInfo(@RequestBody Camera param) {
        try {
            String json = RestTemplateUtil
                    .create()
                    .setContentType("application/json")
                    .addObjectBody(param)
                    .postForObj(RestTemplateUtil.getProp("cameraService20003") + "/camera/queryCameraAllInfo", String.class);
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
                    .getForObj(RestTemplateUtil.getProp("cameraService20003") + "/camera/queryList", String.class);
            return json;
        } catch (Exception e) {
            return new BaseResponseVo(FAULT_CODE, QUERY_FAIL).toJSONString();
        }
    }

    @RequestMapping(value = "/queryPageList", method = RequestMethod.GET)
    public String queryPageList(Page<Camera> page) {
        try {
            String json = RestTemplateUtil
                    .create()
                    .setContentType("application/json")
                    .getForObj(RestTemplateUtil.getProp("cameraService20003") + "/camera/queryPageList?page=" + page.getPage() + "&size=" + page.getSize() + "&condition=" + URLEncoder.encode(page.getCondition().toString(), "UTF-8"), String.class);
            return json;
        } catch (Exception e) {
            return new BaseResponseVo(FAULT_CODE, QUERY_FAIL).toJSONString();
        }
    }

    @RequestMapping(value = "/cameraList", method = RequestMethod.POST)
    public String cameraList(@RequestBody Camera param) {
        try {
            String json = RestTemplateUtil
                    .create()
                    .setContentType("application/json")
                    .addObjectBody(param)
                    .postForObj(RestTemplateUtil.getProp("cameraService20003") + "/camera/cameraList", String.class);
            return json;
        } catch (Exception e) {
            return new BaseResponseVo(FAULT_CODE, QUERY_FAIL).toJSONString();
        }
    }
}