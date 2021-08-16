package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
/**
 * Servlet Filter implementation class MyFilter
 */
@WebFilter("/*")
public class MyFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MyFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpServletRequest  requ = (HttpServletRequest) request;
		request.setCharacterEncoding("utf-8");  
		response.setContentType("text/html;charset=utf-8");
		//System.out.println("1111111111111111111111111");
		//在跨域时cookie被丢弃。允许传递cookie
		resp.setHeader("Access-Control-Allow-Credentials","true");
		//解决跨域访问报错,Credentials为true不能用*
		String origin = requ.getHeader("Origin");
		resp.setHeader("Access-Control-Allow-Origin",origin);
		resp.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
		resp.setHeader("Access-Control-Max-Age", "3600"); //设置过期时间
		resp.setHeader("Access-Control-Allow-Headers", "Origin, token, X-Requested-With, Content-Type, Accept, client_id, uuid, Authorization");
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 支持HTTP 1.1.
		resp.setHeader("Pragma", "no-cache"); // 支持HTTP 1.0.
		resp.setHeader("Expires", "0");	
		resp.setHeader("XDomainRequestAllowed","1");
		chain.doFilter(request, resp);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
