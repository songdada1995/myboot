package com.spbt.controller.db2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spbt.service.db2.IDb2UserService;
import com.spbt.utils.GsonUtil;
import com.spbt.utils.ResponseUtils;

@Controller
@Scope("prototype")
@RequestMapping("/db2")
public class Db2Controller {
	private static final Logger logger = LogManager.getLogger(Db2Controller.class);

	@Autowired
	private IDb2UserService db2UserService;
	
	@RequestMapping("/getUserName")
	public void getUserName(HttpServletResponse response,HttpServletRequest request, Integer id) {
		try {
			String userName = db2UserService.getUserName(id);
			ResponseUtils.renderJSON(response, GsonUtil.gsonString(userName));
		} catch (Exception e) {
			logger.error("Db2Controller.getUserName Error:" + e.getMessage());
		}
	}
}
