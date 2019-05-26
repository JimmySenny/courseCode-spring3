package struts;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.Action;

public class TestFilter implements Filter {

    @Override
    public void destroy() {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        System.out.println("=============before filter");
        ((HttpServletResponse)response).sendRedirect("/struts2/t2.jsp");
//        chain.doFilter(request, response);
        System.out.println("=============after filter");
        ((HttpServletRequest)request).getHeader("Host");
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("=================init");
    }

    
}
