package com.zmm.framework.web;

import com.zmm.framework.model.SendMsg;
import com.zmm.framework.service.SendMsgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.ibase4j.core.base.AbstractController;
import top.ibase4j.core.util.WebUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * 短信 前端控制器
 * @Name SysMsgController
 * @Author 900045
 * @Created by 2019/8/1 0001
 */
@Controller
@RequestMapping("/app/")
@Api(value = "APP短信接口", description = "APP-短信接口")
public class SysMsgController extends AbstractController {

	private SendMsgService sendMsgService;

	@PostMapping("msg")
	@ApiOperation(value = "发送短信", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object update(HttpServletRequest request, SendMsg record) {
		record = WebUtil.getParameter(request, SendMsg.class);
		Assert.notNull(record.getMsgType(), "短信类型不能为空.");
		Assert.notNull(record.getPhone(), "手机号不能为空.");
		sendMsgService.sendMsg(record);
		ModelMap modelMap = new ModelMap();
		return setSuccessModelMap(modelMap);
	}
}
