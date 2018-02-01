package com.dawn.interceptor;

import com.dawn.util.JwtHelper;
import com.dawn.util.ResourcesUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class LoginInterceptor implements HandlerInterceptor {


	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}


	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}


	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// 1.获取到请求的url
		String url = request.getRequestURI();
		// 获取到session
		// 2.判断, 公共的 资源如果user/login 给放行 否则的话进行拦截
		// 连接器优化
		List<String> open_url = ResourcesUtil.gekeyList("annotionURL");
		for (String open_urls : open_url) {
			// 判断是否包含
			if (url.indexOf(open_urls) >= 0) {
				return true;
			}
		}

		/*HttpSession session = request.getSession();
		ActiveUser activeUser = (ActiveUser) session.getAttribute("activeUser");
		if (activeUser == null) {
			return true;
		}*/

		// 判断session中有数据
		/*if (activeUser == null) {
			return false;
		}*/
		//获取请求头的jwt token
		String auth = request.getHeader("Authorization");
		if(auth!=null &&( auth.length()>6)){
			String headStr = auth.substring(0,6).toLowerCase();
			if(headStr.compareTo("bearer")==0){
				auth = auth.substring(6,auth.length());
				if(JwtHelper.parseJWT(auth)!=null){
					return true;
				}
			}
		}

		// 转发
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		return false;
	}

}
