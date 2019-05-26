package struts;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.CompoundRoot;

public class HelloAction extends ActionSupport implements ModelDriven<UserModel> {

    public String uuid;
    public String name;
    public UserModel um = new UserModel();
    
    private UserModel um2 = new UserModel();
    
    @Override
    public UserModel getModel() {
        return um;
    }
    public UserModel getUm() {
        return um;
    }
    
//    @Override
//    public void validate() {
//        if(uuid == null || "".equals(uuid)) {
//            this.addFieldError("id", getText("aa") + getText("null", new String[]{"sssssssdd    ", "sss"}));
//        }
//    }
//    
    public void setUm2(UserModel um2) {
        this.um2 = um2;
    }
    public UserModel getUm2() {
        return um2;
    }
    private String[] roles;
    private List<String> roleList;
    
    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }
    
    public List<String> getRoleList() {
        return roleList;
    }
    public void setRoles(String[] roles) {
        this.roles = roles;
    }
    public String[] getRoles() {
        return roles;
    }
    private static void dumpStack(CompoundRoot root) { 
        System.out.println("---stack top---"); 
        for(int i=0;i<root.size();i++) { 
            System.out.println(root.get(i).toString()); 
        } 
        System.out.println("---stack bottom---"); 
    } 
    @Override
    public String execute() throws Exception {
        dumpStack(ActionContext.getContext().getValueStack().getRoot());
        System.out.println(ActionContext.getContext().getValueStack().getContext());
        new UserEbo().process(uuid, name);
        new UserEbo().process(um);
        new UserEbo().process(um2);
        for(String role:roles) {
            System.out.println(role);
        }
        for(String role:roleList) {
            System.out.println(role);
        }
        return this.SUCCESS;
    }
}
