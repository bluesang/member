package spms.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(
	urlPatterns="/*",
	initParams={
		@WebInitParam(name="encoding",value="UTF-8")
	})

public class CharacterEncodingFilter implements Filter{
	FilterConfig config;
	
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}
	
	public void doFilter(
			ServletRequest request, ServletResponse response,
			FilterChain nextFilter) throws IOException, ServletException {
		request.setCharacterEncoding(config.getInitParameter("encoding"));
		System.out.println(this.getClass()+"����"+ config.getInitParameter("encoding") +" ���ڵ� ����");
		nextFilter.doFilter(request, response);
	}

	public void destroy() {}
}