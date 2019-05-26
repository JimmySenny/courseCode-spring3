package struts;

public enum TestEnum {
    ADMIN("管理员"),USER("普通用户");
    
    private String desc;
    
    private TestEnum(String desc) {
        this.desc = desc;
    }
    
    public String getDesc() {
        return desc;
    }
    
    
}
