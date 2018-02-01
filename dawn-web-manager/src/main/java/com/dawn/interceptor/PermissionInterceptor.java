package com.dawn.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dawn.pojo.ActiveUser;
import com.dawn.pojo.SysPermission;
import com.dawn.util.ResourcesUtil;

public class PermissionInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
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

		// 读取公用的URL
		List<String> opencommon_url = ResourcesUtil.gekeyList("commonURL");
		for (String opencomm_urls : opencommon_url) {
			// 判断是否包含这个URL
			if (url.indexOf(opencomm_urls) >= 0) {
				return true;
			}
		}

		HttpSession session = request.getSession();
		ActiveUser activeUser = (ActiveUser) session.getAttribute("activeUser");
		// 1.从session中取permisson 的url
		// 2.把url进行查询遍历, 进行放行
		List<SysPermission> listPserssion = activeUser.getPermissions();
		for (SysPermission sysPermission_url : listPserssion) {
			// 取出URL字段 只要是数据库里有的就放行
			String open_perssionURL = sysPermission_url.getUrl();
			if (url.indexOf(open_perssionURL) >= 0) {
				return true;
			}
		}
		// 转发
		request.getRequestDispatcher("/WEB-INF/jsp/refuse.jsp").forward(request, response);
		return false;
	}

}
