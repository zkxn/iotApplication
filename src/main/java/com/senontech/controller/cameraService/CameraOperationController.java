package com.senontech.controller.cameraService;

import com.senontech.exceptions.ErrorCodeException;
import com.senontech.pojo.bo.cameraService.Camera;
import com.senontech.pojo.vo.BaseResponseVo;
import com.senontech.util.RestTemplateUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.senontech.constant.ExceptionCode.FAULT_CODE;
import static com.senontech.constant.GlobalString.*;


/**
 * @description: 萤石云摄像头控制接口
 * @author: gyk
 * @date: 2020/10/11 15:26
 */
@RestController
@RequestMapping(value = "/cameraOperation", produces = "application/json;charset=UTF-8")
public class CameraOperationController {

    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public String start(@RequestBody Camera param) {
        try {
            String json = RestTemplateUtil
                    .create() 
                    .setContentType("application/json") 
                    .addObjectBody(param)
                    .postForObj(RestTemplateUtil.getProp("cameraService20003") + "/cameraOperation/start", String.class);
            return json;
        } catch (Exception e) {
            return new BaseResponseVo(FAULT_CODE, ADD_FAIL).toJSONString();
        }
    }

    @RequestMapping(value = "/stop", method = RequestMethod.POST)
    public String stop(@RequestBody Camera param) {
        try {
            String json = RestTemplateUtil
                    .create() 
                    .setContentType("application/json") 
                    .addObjectBody(param)
                    .postForObj(RestTemplateUtil.getProp("cameraService20003") + "/cameraOperation/stop", String.class); 
            return json;
        } catch (Exception e) {
            return new BaseResponseVo(FAULT_CODE, ADD_FAIL).toJSONString();
        }
    }

    @RequestMapping(value = "/mirror", method = RequestMethod.POST)
    public String mirror(@RequestBody Camera param) {
        try {
            String json = RestTemplateUtil
                    .create() 
                    .setContentType("application/json") 
                    .addObjectBody(param)
                    .postForObj(RestTemplateUtil.getProp("cameraService20003") + "/cameraOperation/mirror", String.class);
            
            return json;
        } catch (Exception e) {
            return new BaseResponseVo(FAULT_CODE, ADD_FAIL).toJSONString();
        }
    }

    @RequestMapping(value = "/move", method = RequestMethod.POST)
    public String move(@RequestBody Camera param) {
        try {
            String json = RestTemplateUtil
                    .create() 
                    .setContentType("application/json") 
                    .addObjectBody(param)
                    .postForObj(RestTemplateUtil.getProp("cameraService20003") + "/cameraOperation/move", String.class); 
            return json;
        } catch (Exception e) {
            return new BaseResponseVo(FAULT_CODE, ADD_FAIL).toJSONString();
        }
    }

    @RequestMapping(value = "/encryptOff", method = RequestMethod.POST)
    public String encryptOff(@RequestBody Camera param) throws ErrorCodeException {
        try {
            String json = RestTemplateUtil
                    .create() 
                    .setContentType("application/json") 
                    .addObjectBody(param)
                    .postForObj(RestTemplateUtil.getProp("cameraService20003") + "/cameraOperation/encryptOff", String.class);
            
            return json;
        } catch (Exception e) {
            return new BaseResponseVo(FAULT_CODE, ADD_FAIL).toJSONString();
        }
    }

    @RequestMapping(value = "/encryptOn", method = RequestMethod.POST)
    public String encryptOn(@RequestBody Camera param) throws ErrorCodeException {
        try {
            String json = RestTemplateUtil
                    .create() 
                    .setContentType("application/json") 
                    .addObjectBody(param)
                    .postForObj(RestTemplateUtil.getProp("cameraService20003") + "/cameraOperation/encryptOn", String.class);
            
            return json;
        } catch (Exception e) {
            return new BaseResponseVo(FAULT_CODE, ADD_FAIL).toJSONString();
        }
    }

    @RequestMapping(value = "/deviceUpgrade", method = RequestMethod.POST)
    public String deviceUpgrade(@RequestBody Camera param) {
        try {
            String json = RestTemplateUtil
                    .create() 
                    .setContentType("application/json") 
                    .addObjectBody(param)
                    .postForObj(RestTemplateUtil.getProp("cameraService20003") + "/cameraOperation/deviceUpgrade",
                            String.class); 
            return json;
        } catch (Exception e) {
            return new BaseResponseVo(FAULT_CODE, ADD_FAIL).toJSONString();
        }
    }

    @RequestMapping(value = "/upgradeStatus", method = RequestMethod.POST)
    public String upgradeStatus(@RequestBody Camera param) {
        try {
            String json = RestTemplateUtil
                    .create() 
                    .setContentType("application/json") 
                    .addObjectBody(param)
                    .postForObj(RestTemplateUtil.getProp("cameraService20003") + "/cameraOperation/upgradeStatus",
                            String.class); 
            return json;
        } catch (Exception e) {
            return new BaseResponseVo(FAULT_CODE, ADD_FAIL).toJSONString();
        }
    }
}
