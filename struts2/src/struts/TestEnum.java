package struts;

public enum TestEnum {
    ADMIN("����Ա"),USER("��ͨ�û�");
    
    private String desc;
    
    private TestEnum(String desc) {
        this.desc = desc;
    }
    
    public String getDesc() {
        return desc;
    }
    
    
}
