package struts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

public class HelloAction2DateConvertor extends StrutsTypeConverter {

    
    @Override
    public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
//        try {
        System.out.println("converter==================");
        return new Date();//SimpleDateFormat("yyyy-mm-dd").parse((String) o);
//        } catch (ParseException e) {
//            return super.convertValue(context, o, toClass);
//        }
    }
    
    @Override
    public String convertToString(Map arg0, Object arg1) {
        if(arg1 == null) {
            return "www";
        }
        return new SimpleDateFormat("yyyy-dd-MM").format(arg1);
    }
}
