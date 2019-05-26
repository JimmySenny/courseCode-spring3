package xwork;

import java.util.HashMap;
import java.util.Map;

import javax.el.ELContext;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.TextProvider;
import com.opensymphony.xwork2.config.ConfigurationManager;
import com.opensymphony.xwork2.conversion.impl.XWorkConverter;
import com.opensymphony.xwork2.inject.Container;
import com.opensymphony.xwork2.ognl.OgnlTypeConverterWrapper;
import com.opensymphony.xwork2.ognl.OgnlUtil;
import com.opensymphony.xwork2.ognl.OgnlValueStackFactory;
import com.opensymphony.xwork2.util.CompoundRoot;
import com.opensymphony.xwork2.util.ValueStack;

public class OgnlTest {
    
    /**
     * @throws OgnlException
     * @throws ClassNotFoundException
     */
    /**
     * @throws OgnlException
     * @throws ClassNotFoundException
     */
    /**
     * @throws OgnlException
     * @throws ClassNotFoundException
     */
    public static void test1() throws OgnlException, ClassNotFoundException {
        UserAction3 ua = new UserAction3();
        ua.setName("test");
        System.out.println(getValue("name", ua, null));
        System.out.println(getValue("toString()", ua, null));
        Map<String, Object> context = new OgnlContext();
        context.put("hello", "ÄãºÃ");
        System.out.println(getValue("#hello", ua, context));
        
        setValue("name", ua, null, "ÄãºÃ°¡");
        System.out.println(getValue("name", ua, null));
        
        setValue("bean.name", ua, null, "ÄãºÃ¹þ");
        System.out.println(getValue("bean.name", ua, null));
        
        context.put("newName","ttttttt"); 
        getValue("name=#newName",ua, context); 
        System.out.println("--------==="); 
        System.out.println(getValue("#newName='Äã¹þ°¡'",ua, context)); 
        System.out.println(getValue("name", ua, null));
        System.out.println(getValue("#newName", ua, context));
        
        System.out.println("----------------");
        setValue("#hello", ua, context, "ÄãºÃ°¡");
        System.out.println(getValue("#hello", ua, context));
        System.out.println(context.get("hello"));
        System.out.println("======================");
        
        OgnlValueStackFactory vsFactory = new OgnlValueStackFactory();
        ConfigurationManager manager = new ConfigurationManager();
        Container container = manager.getConfiguration().getContainer();
        vsFactory.setContainer(container);
        vsFactory.setTextProvider(container.getInstance(TextProvider.class));
        vsFactory.setXWorkConverter(container.getInstance(XWorkConverter.class));
        ValueStack vs = vsFactory.createValueStack();
        vs.push(ua);
        dumpStack(vs.getRoot());
        System.out.println(vs.findValue("name"));
        
        
        vs.getContext().put("hello", "Hi! ");
        System.out.println(vs.findValue("#hello"));
        vs.push(new UserAction3());
        System.out.println(vs.findValue("name"));
        System.out.println(vs.findValue("[1].name"));
        dumpStack(vs.getRoot());
        
        vs.setValue("#hello", "-------------ÄãºÃ°¡");
        System.out.println(vs.findValue("#hello"));
        
        
        
    }
    
    private static void dumpStack(CompoundRoot root) { 
        System.out.println("---stack top---"); 
        for(int i=0;i<root.size();i++) { 
            System.out.println(root.get(i).toString()); 
        } 
        System.out.println("---stack bottom---"); 
    } 
    
    public static void main(String[] args) throws OgnlException, ClassNotFoundException {
        test1();
    }
    
    public static Object getValue(String expression, Object rootObject, Map context) throws OgnlException {
        if(context == null) {
            return Ognl.getValue(Ognl.parseExpression(expression), rootObject);
        }
        return Ognl.getValue(Ognl.parseExpression(expression), context, rootObject);
    }

    public static void setValue(String expression, Object rootObject, Map context, Object value) throws OgnlException {
        if(context == null) {
            Ognl.setValue(Ognl.parseExpression(expression), rootObject, value);
            return;
        }
        Ognl.setValue(Ognl.parseExpression(expression), context, rootObject, value);
    }
}
