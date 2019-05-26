package cn.javass.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginFilter implements Filter {
    
    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("=================myFilter init" + this);
    }

    @Override
    public void destroy() {
        System.out.println("=================myFilter destroy" + this);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
            FilterChain chain) throws IOException, ServletException {
        
        //1.预处理
        HttpServletRequest request = (HttpServletRequest) req;
        //2.调用链中的下一个对象（Filter、Servlet）
        //2.1前置条件判断（登录检查）
        boolean ok = true;
        Object o = request.getSession().getAttribute("user");
        if(o == null) {
            ok=false;
        }
        
        String path = request.getServletPath();
        System.out.println("===============" + path);
        if("/admin/login.jsp".equals(path)) {
            ok=true;
        }
        if("/admin/nologin.jsp".equals(path)) {
            ok=true;
        }
        if(!ok) {
            //出错处理
            request.getRequestDispatcher("/admin/nologin.jsp").forward(req, resp);
            //因为出错了，无需再进行后处理
            return;
        }
        else {
            chain.doFilter(req, resp);    
        }
        //3.后处理
        
    }

}
