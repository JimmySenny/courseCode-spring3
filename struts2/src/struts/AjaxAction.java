package struts;

import java.util.ArrayList;
import java.util.List;

import struts.model.JSONModel;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AjaxAction extends ActionSupport {
    private String province;
    public void setProvince(String province) {
        this.province = province;
    }
    
    @Override
    public String execute() throws Exception {
        JSONModel jsonModel = new JSONModel();
        jsonModel.getMap().put("key1", "value1");
        jsonModel.getMap().put("key2", "value2");
        jsonModel.getSm().setSname("aaaa");
        
        ActionContext.getContext().getValueStack().getContext().put("json", jsonModel);
        
        return super.execute();
    }
    

    public String city() throws Exception {
        
        List<String[]> list = new ArrayList<String[]>();
        if("beijing".equals(province)) {
            list.add(new String[]{"haidian", "������"});
            list.add(new String[]{"chaoyang", "������"});
            
        } else {
            list.add(new String[]{"rizhao", "������"});
            list.add(new String[]{"jinan", "������"});
        }
        
        ActionContext.getContext().getValueStack().getContext().put("json", list);
        return SUCCESS;
    }
    
    
    
}
