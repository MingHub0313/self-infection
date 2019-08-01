package com.zmm.framework.web;

import com.zmm.framework.model.SysDic;
import com.zmm.framework.service.SysDicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.ibase4j.core.base.AppBaseController;
import top.ibase4j.core.support.Assert;
import top.ibase4j.core.util.WebUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 字典管理
 * @Name SysDicController
 * @Author 900045
 * @Created by 2019/8/1 0001
 */
@Controller
@Api(value = "字典管理", description = "APP-字典接口")
@RequestMapping(value = "/app/dic/")
public class SysDicController extends AppBaseController<SysDic, SysDicService> {

	@ApiOperation(value = "查询字典项", produces = MediaType.APPLICATION_JSON_VALUE, response = SysDic.class)
	@RequestMapping(value = "query", method = {RequestMethod.GET, RequestMethod.POST})
	public Object queryList(HttpServletRequest request, String type) {
		Map<String, Object> param = WebUtil.getParameter(request);
		Assert.notNull(param.get("type"), "类型type不能为空.");
		param.put("orderBy", "type_,sort_no");
		ModelMap modelMap = new ModelMap();
		modelMap.put("listKey", "dicLlist");
		return super.queryList(modelMap, param);
	}
}
