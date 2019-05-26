package struts;

public class UserEbo {

    public void process(String id, String name) {
        System.out.println("=============id=" + id + ",name=" + name);
    }

    public void process(UserModel um) {
        System.out.println("=============um.uuid=" + um.getUuid() + ",um.name=" + um.getName());
        
    }

}
