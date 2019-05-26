package struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;


public class StudentAction extends ActionSupport {
    
    @Override
    public String execute() throws Exception {
        
        ValueStack vs = ActionContext.getContext().getValueStack();
        vs.getContext().put("gmList", GradeEbo.list());
        return this.SUCCESS;
    }
    
    
}
