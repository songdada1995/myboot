package com.spbt.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * session
 * 
 */
public class SpringWebUtil {
	
	/**存储登录人session*/
	public static Map<String,HttpSession> sessionMap = new HashMap<String, HttpSession>();
	
	/**存储登录人sessionKey,sessionId*/
	public static Map<String,String> sessionKeyMap = new HashMap<String, String>();

    public static Map<String, HttpSession> getSessionMap() {
		return sessionMap;
	}

	public static void setSessionMap(Map<String, HttpSession> sessionMap) {
		SpringWebUtil.sessionMap = sessionMap;
	}

	public static String GLOB_DELETE_ID_VAL = "globDeleteIdVal";  
    public static HttpServletRequest getRequest(){  
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();  
        return requestAttributes==null? null : requestAttributes.getRequest();  
    }  
      
    public static HttpSession getSession(){  
        return getRequest().getSession(false);  
    }  
      
    public static String getRealRootPath(){  
        return getRequest().getServletContext().getRealPath("/");  
    }  
      
    public static String getIp() {  
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder  
                .getRequestAttributes();  
        if(servletRequestAttributes!=null){  
            HttpServletRequest request = servletRequestAttributes.getRequest();  
            return request.getRemoteAddr();  
        }  
        return null;  
    }  
      
    public static Object getSessionAttribute(String name){  
        HttpServletRequest request = getRequest();  
        return request == null?null:request.getSession().getAttribute(name);  
    }  
      
    public static void setSessionAttribute(String name,Object value){  
        HttpServletRequest request = getRequest();  
        if(request!=null){  
            request.getSession().setAttribute(name, value);   
        }  
    }  
      
    public static Object getRequestAttribute(String name){  
        HttpServletRequest request = getRequest();  
        return request == null?null:request.getAttribute(name);  
    }  
    public static void setRequestAttribute(String name,Object value){  
        HttpServletRequest request = getRequest();  
        if(request!=null){  
            request.setAttribute(name, value);    
        }  
    }  
  
    public static String getContextPath() {  
        return getRequest().getContextPath();  
    }  
  
    public static void removeSessionAttribute(String name) {  
        getRequest().getSession().removeAttribute(name);  
    }
    
    public static String getIpAddr(HttpServletRequest request) {  
       String ip = request.getHeader("x-forwarded-for");  
       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
           ip = request.getHeader("Proxy-Client-IP");  
       }  
       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
           ip = request.getHeader("WL-Proxy-Client-IP");  
       }  
       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        }  
        return ip;  
    }
    
    public static String getPageInfo(String path,String pathName,String mainPath){
    	String page = "";
		String pjax = SpringWebUtil.getRequest().getHeader("X-PJAX");
		// pjax请求、直接跳转请求页面
		if (StringUtils.isNotEmpty(pjax) && pjax.equals("true")) {
			page = path;
		} else {
			// 非pjax请求、先跳转主页面、再将子页面嵌入主页面
			SpringWebUtil.setRequestAttribute("include",
					pathName);

			page = mainPath;
		}
		return page;
    }
    
}  
