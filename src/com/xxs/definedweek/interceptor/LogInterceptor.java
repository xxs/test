package com.xxs.definedweek.interceptor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.xxs.definedweek.action.admin.BaseAdminAction;
import com.xxs.definedweek.bean.LogConfig;
import com.xxs.definedweek.entity.Log;
import com.xxs.definedweek.service.AdminService;
import com.xxs.definedweek.service.LogService;
import com.xxs.definedweek.util.LogConfigUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 拦截器 - 管理日志

 * KEY: DEFINEDWEEK8EF2677C515B19AF3363B817A1842E24

 */

public class LogInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 276741467699160227L;

	@Resource(name = "logServiceImpl")
	private LogService logService;
	@Resource(name = "adminServiceImpl")
	private AdminService adminService;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String result = invocation.invoke();
		
		Object action = invocation.getAction();
		String actionClass = action.getClass().getName();
		String actionMethod = invocation.getProxy().getMethod();
		
		if (action instanceof BaseAdminAction) {
			if (!StringUtils.equals(result, BaseAdminAction.ERROR)) {
				List<LogConfig> allLogConfigList = LogConfigUtil.getAllLogConfigList();
				if (allLogConfigList != null) {
					for (LogConfig logConfig : allLogConfigList) {
						if (StringUtils.equals(logConfig.getActionClass(), actionClass) && StringUtils.equals(logConfig.getActionMethod(), actionMethod)) {
							BaseAdminAction baseAdminAction = (BaseAdminAction) action;
							HttpServletRequest request= ServletActionContext.getRequest();
							
							String logInfo = baseAdminAction.getLogInfo();
							String operator = adminService.getLoginAdmin().getUsername();
							if(operator == null) {
								operator = "未知";
							}
							String ip = request.getRemoteAddr();
							String operation = logConfig.getOperation();
							
							Log log = new Log();
							log.setOperation(operation);
							log.setOperator(operator);
							log.setActionClass(actionClass);
							log.setActionMethod(actionMethod);
							log.setIp(ip);
							log.setInfo(logInfo);
							logService.save(log);
							break;
						}
					}
				}
			}
		}
		return null;
	}

}