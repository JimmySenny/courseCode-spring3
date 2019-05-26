package struts;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class TestInterceptor implements Interceptor {

    private String name;
    public void setName(String name) {
        this.name = name;
    }
    
    public TestInterceptor() {
        System.out.println("================" + this);
    }
    
    @Override
    public void init() {
        System.out.println("================init");
    }
    

    @Override
    public void destroy() {
        System.out.println("================destroy");
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        //before
        System.out.println("before interceptor:" + name);
        String resultCode = invocation.invoke();
        System.out.println("after interceptor");
        //after
        return resultCode;
    }


    
}
