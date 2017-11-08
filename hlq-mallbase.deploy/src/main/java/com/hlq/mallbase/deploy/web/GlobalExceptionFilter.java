package com.hlq.mallbase.deploy.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.hlq.mallbase.deploy.common.BizException;
import com.hlq.mallbase.deploy.common.HttpResponse;
import com.hlq.mallbase.deploy.common.ResponseCode;

/**
 * 
 * @时间:2017年10月31日
 * @作者: hukc
 * @Mail:hu1932@163.com
 * @说明:全局异常拦截器，返回JSON异常信息
 */
public class GlobalExceptionFilter implements Filter{
	private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionFilter.class);
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		try{
			logger.info("access url:"+req.getRequestURI());
			chain.doFilter(req, resp);
		}catch(Exception e){
			Throwable tx =  e.getCause();
			logger.error(tx.getMessage(), tx);
			resp.setContentType("text/plain;charset=utf-8");
			HttpResponse<?> httpResponse = new HttpResponse<>();
			if((tx instanceof BizException) ){
				BizException be = (BizException) tx;
				ResponseCode responseCode = be.getAccessResponseCode();
				httpResponse.setCode(responseCode.getCode());
				httpResponse.setMsg(responseCode.getMsg());
				httpResponse.setData(null);
			} else if((tx.getCause() != null && (tx.getCause() instanceof BizException))){
				BizException be = (BizException) tx.getCause();
				ResponseCode responseCode = be.getAccessResponseCode();
				httpResponse.setCode(responseCode.getCode());
				httpResponse.setMsg(responseCode.getMsg());
				httpResponse.setData(null);
			}else {
				/**
				 * 默认异常返回异常码为500
				 */
				httpResponse.setCode(500);
				httpResponse.setMsg("系统异常， 请稍后重试...");
			}
			String json = JSON.toJSONString(httpResponse);
			byte[] buf = json.getBytes();
			resp.getOutputStream().write(buf);
		}
		
	}

	@Override
	public void destroy() {
	}

}
