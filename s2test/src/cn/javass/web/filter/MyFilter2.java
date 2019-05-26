package cn.javass.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MyFilter2 implements Filter {
    
    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("=================myFilter init2" + this);
    }

    @Override
    public void destroy() {
        System.out.println("=================myFilter destroy2" + this);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
            FilterChain chain) throws IOException, ServletException {
        
        //1.预处理
        System.out.println("===================预处理开始2");
        System.out.println("===================预处理结束2");
        HttpServletRequest request = (HttpServletRequest) req;
        //2.调用链中的下一个对象（Filter、Servlet）
        //2.1前置条件判断（登录检查）
        boolean ok = true;
        if(!ok) {
            //出错处理
//            request.getRequestDispatcher("/helloworld.jsp").forward(req, resp);
            //因为出错了，无需再进行后处理
            return;
        }
        else {
            chain.doFilter(req, resp);    
        }
        //3.后处理
        System.out.println("===================后处理开始2");
        System.out.println("===================后处理结束2");
        
    }

}
