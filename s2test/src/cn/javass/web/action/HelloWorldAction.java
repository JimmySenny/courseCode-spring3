package cn.javass.web.action;

import cn.javass.model.JSONModel;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class HelloWorldAction implements Action {

    //1.收集参数,Struts2帮我们收集参数(request.getParameter())
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
        //2.组织参数
        //3.调用业务逻辑层API
        System.out.println("====================uuid==" + uuid + ",name==" + name);
        //4.1 准备要显示的数据？(request.setAttribute())   帮我们把Action下的实例变量加到request……
        //4.2 选择下一个页面
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
