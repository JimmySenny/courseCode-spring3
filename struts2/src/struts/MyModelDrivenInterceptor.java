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
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyModelDrivenInterceptor implements Interceptor {

    private String name;
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public void init() {
    }
    

    @Override
    public void destroy() {
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Object action = invocation.getAction();
        Object model = null;
        if(action instanceof ModelDriven) {
            model = ((ModelDriven)action).getModel();
        }
        if(model != null) {
            ActionContext.getContext().getValueStack().push(model);
        }
        
        return invocation.invoke();
    }


    
}
