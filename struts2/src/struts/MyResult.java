package struts;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;

public class MyResult implements Result {
    
    @Override
    public void execute(ActionInvocation invocation) throws Exception {
        System.out.println("=============" + invocation.getResultCode());
    }
}
