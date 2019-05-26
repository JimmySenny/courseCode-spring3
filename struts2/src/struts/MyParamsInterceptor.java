package struts;

import java.util.Map;
import java.util.Map.Entry;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyParamsInterceptor extends AbstractInterceptor {

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
        Map<String, Object> params = ActionContext.getContext().getParameters();
        
        for(Entry entry : params.entrySet()) {
            ActionContext.getContext().getValueStack().setValue((String) entry.getKey(), entry.getValue());
        }
        return invocation.invoke();
    }


    
}
