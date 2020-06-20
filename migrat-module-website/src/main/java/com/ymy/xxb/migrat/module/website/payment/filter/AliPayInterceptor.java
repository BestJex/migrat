package com.ymy.xxb.migrat.module.website.payment.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.ymy.xxb.migrat.module.website.controller.auth.AliPayController;
import com.ymy.xxb.migrat.module.website.controller.ext.AliPayApiController;
import com.ymy.xxb.migrat.module.website.payment.alipay.AliPayApiConfigKit;

public class AliPayInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (HandlerMethod.class.equals(handler.getClass())) {
			HandlerMethod method = (HandlerMethod) handler;
			Object controller  = method.getBean();
			if (controller instanceof AliPayApiController == false) {
				throw new RuntimeException("current controller must extends AliPayApiController");
			}
			
			try {
				AliPayApiConfigKit.setThreadLocalAliPayApiConfig(((AliPayController)controller).getApiConfig());
				return true;
			}
			finally {
			}
		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}