package com.spbt.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.spbt.entity.common.Result;


public class ResponseUtils {

	private ResponseUtils() {

	}

	// 发送内容 "application/json;charset=UTF-8"
	public static void render(HttpServletResponse response, String contentType, String text) {
		response.setContentType(contentType);
		try {
			response.getWriter().write(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 发送的是JSON
	public static void renderJSON(HttpServletResponse response, String text) {
		render(response, "application/json;charset=UTF-8", text);
	}

	// 发送xml
	public static void renderXml(HttpServletResponse response, String text) {
		render(response, "application/xml;charset=UTF-8", text);
	}

	// 发送text
	public static void renderText(HttpServletResponse response, String text) {
		render(response, "application/plain;charset=UTF-8", text);
	}

	// 根据status返回相关查询结果
	public static void returnCommon(HttpServletResponse response, int checkStatus) {
		Result result = new Result();
		if (checkStatus == 0) {
			result.setMessage("0");
			result.setStatus(false);
			renderJSON(response, GsonUtil.gsonString(result));
		}
		if (checkStatus == 1) {
			result.setMessage("1");
			result.setStatus(true);
			renderJSON(response, GsonUtil.gsonString(result));
		}
		if (checkStatus == 2) {
			result.setMessage("2");
			result.setStatus(false);
			renderJSON(response, GsonUtil.gsonString(result));
		}
		if (checkStatus == 3) {
			result.setMessage("3");
			result.setStatus(false);
			renderJSON(response, GsonUtil.gsonString(result));
		}
	}

	// 根据status返回相关查询结果
	public static void loginReturnCommon(HttpServletResponse response, boolean checkStatus, String msg) {
		Result result = new Result();
		result.setMessage(msg);
		if (!checkStatus) {
			result.setStatus(false);
			renderJSON(response, GsonUtil.gsonString(result));
		}
		if (checkStatus) {
			result.setStatus(true);
			renderJSON(response, GsonUtil.gsonString(result));
		}
	}
}
