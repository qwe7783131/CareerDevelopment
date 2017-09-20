package com.bugmaker.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bugmaker.bean.User;

public class RequestUtil {

	public static String USER = "user";

	// 获取请求
	public static HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		return request;
	}

	// 获取当前session
	public static HttpSession getSession() {
		return getRequest().getSession(true);
	}

	// 保存用户登录信息
	public static void loginUserInfo(User user) {
		getSession().setAttribute(RequestUtil.USER, user);
	}

	// 清除用户登录信息
	public static void clearUserInfo() {
		getSession().removeAttribute(RequestUtil.USER);
	}

	// 获取当前登录用户，账户信息
	public static User getCurrentUser() {
		return (User) getSession().getAttribute(RequestUtil.USER);
	}
}
