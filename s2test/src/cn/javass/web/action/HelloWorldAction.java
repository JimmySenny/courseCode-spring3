package cn.javass.web.action;

import cn.javass.model.JSONModel;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class HelloWorldAction implements Action {

    //1.�ռ�����,Struts2�������ռ�����(request.getParameter())
    public int uuid;
    public String name;
    private int age = 111111;
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public int getAge() {
        return age;
    }
    
    
    @Override
    public String execute() throws Exception {
        System.out.println("==========" + this);
        //2.��֯����
        //3.����ҵ���߼���API
        System.out.println("====================uuid==" + uuid + ",name==" + name);
        //4.1 ׼��Ҫ��ʾ�����ݣ�(request.setAttribute())   �����ǰ�Action�µ�ʵ�������ӵ�request����
        //4.2 ѡ����һ��ҳ��
        return "toList";
    }
    
    
    public String json() {
        JSONModel jm = new JSONModel();
        jm.getMap().put("aaa", "bbb");
        jm.getMap().put("bbb", "bbb");
        jm.getMap().put("ccc", "bbb");
        jm.getMap().put("ddd", "bbb");
        ActionContext.getContext().put("json", jm);
        System.out.println("===================");
        return "json";
    }

}
