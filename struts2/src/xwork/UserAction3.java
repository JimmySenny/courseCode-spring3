package xwork;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class UserAction3 implements Action {
    
    private String name;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    
    private TestBean bean = new TestBean();
    public void setBean(TestBean bean) {
        this.bean = bean;
    }
    public TestBean getBean() {
        return bean;
    }
    
    
    @Override
    public String execute() throws Exception {
        String name = (String) ActionContext.getContext().getParameters().get("name");
        System.out.println("ÄãºÃ" + name + this.name);
        return SUCCESS;
    }

    public static void main(String[] args) throws Exception {
         new UserAction3().execute();
    }
}
