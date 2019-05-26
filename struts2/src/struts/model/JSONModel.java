package struts.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONModel {
    private int i = 1;
    private String str = "haha";
    private List list = Arrays.asList("aaa", "bbb");
    private String[] array = {"ccc", "ddd"};
    private Map<String, String> map = new HashMap<String, String>();
    private StudentModel sm = new StudentModel();
    
    public int getI() {
        return i;
    }
    public void setI(int i) {
        this.i = i;
    }
    public String getStr() {
        return str;
    }
    public void setStr(String str) {
        this.str = str;
    }
    public List getList() {
        return list;
    }
    public void setList(List list) {
        this.list = list;
    }
    public String[] getArray() {
        return array;
    }
    public void setArray(String[] array) {
        this.array = array;
    }
    public Map<String, String> getMap() {
        return map;
    }
    public void setMap(Map<String, String> map) {
        this.map = map;
    }
    public StudentModel getSm() {
        return sm;
    }
    public void setSm(StudentModel sm) {
        this.sm = sm;
    }
    
    
    
}
