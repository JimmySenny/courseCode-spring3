package xwork;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class ActionContextTest {
    
    
    public static void main(String[] args) {
        Map context = new HashMap();
        ActionContext.setContext(new ActionContext(context));
        ActionContext.getContext().put("test", "ÄãºÃ");
        System.out.println(ActionContext.getContext().get("test"));
        
        System.out.println( true && false);
        System.out.println( true & false);
    }
}
