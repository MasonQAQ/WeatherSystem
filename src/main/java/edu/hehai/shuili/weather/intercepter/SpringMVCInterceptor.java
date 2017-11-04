package edu.hehai.shuili.weather.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import edu.hehai.shuili.weather.util.IntercepterUtil;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Enumeration;

public class SpringMVCInterceptor implements HandlerInterceptor {


	private Logger logger = Logger.getLogger(SpringMVCInterceptor.class);

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String url = request.getRequestURL().toString();
		Enumeration paraKeys = request.getParameterNames();
		JSONObject params = new JSONObject();
		while (paraKeys.hasMoreElements()) {
			String paraKey = (String) paraKeys.nextElement();
			params.put(paraKey,request.getParameter(paraKey));
		}
		logger.warn("用户访问: "+url +" 用户IP:"+ IntercepterUtil.getIpAddr(request)+" 参数列表: "+params.toJSONString());
		return true;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
	throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
