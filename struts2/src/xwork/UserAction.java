package xwork;

import com.opensymphony.xwork2.Action;

public class UserAction implements Action {

    @Override
    public String execute() throws Exception {
        System.out.println("���");
        return SUCCESS;
    }

    public static void main(String[] args) throws Exception {
         new UserAction().execute();
    }
}
