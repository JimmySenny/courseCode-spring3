package xwork;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction2 extends ActionSupport {

    @Override
    public String execute() throws Exception {
        System.out.println("ÄãºÃ");
        return SUCCESS;
    }
    
    public static void main(String[] args) throws Exception {
        new UserAction2().execute();
    }

}
