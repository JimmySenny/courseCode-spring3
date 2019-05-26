package struts;

import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.CompoundRoot;

public class HelloAction2 {
    
    public String uuid;
    public String name;
    private UserModel um = new UserModel();
    
    private Date date;
    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }
    
    private UserModel um2 = new UserModel();
//    
//    public UserModel getUm() {
//        return um;
//    }
//    
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
    private List<TestEnum> roleList;
    
    public void setRoleList(List<TestEnum> roleList) {
        this.roleList = roleList;
    }
    
    public List<TestEnum> getRoleList() {
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
    
    
    public String toAdd() throws Exception {
        return "toAdd";
    }
    public String execute() throws Exception {
        dumpStack(ActionContext.getContext().getValueStack().getRoot());
        System.out.println("---context start---"); 
        for(Entry e : ActionContext.getContext().getValueStack().getContext().entrySet()) { 
            System.out.println(e.getKey() + ":" + e.getValue()); 
        } 
        System.out.println("---context end---");

        ((HttpServletRequest)ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST)).setAttribute("uuid", "aaaaaaaaaaaaaa");
        System.out.println("============" + ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST));
        System.out.println("============" + ActionContext.getContext().get("action"));
        System.out.println("============" + ActionContext.getContext().get("action"));
        System.out.println("============" + ActionContext.getContext().getValueStack().findValue("uuid"));
        System.out.println("============" + date);
        
        new UserEbo().process(uuid, name);
        new UserEbo().process(um);
        new UserEbo().process(um2);
        for(String role:roles) {
            System.out.println(role);
        }
        for(TestEnum role:roleList) {
            System.out.println(role);
        }
        return "haha";
    }
}
