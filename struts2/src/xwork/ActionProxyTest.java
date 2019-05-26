package xwork;

import java.util.HashMap;
import java.util.Map;

import ognl.PropertyAccessor;

import org.apache.struts2.util.RegexPatternMatcher;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.DefaultActionProxyFactory;
import com.opensymphony.xwork2.DefaultTextProvider;
import com.opensymphony.xwork2.DefaultUnknownHandlerManager;
import com.opensymphony.xwork2.ObjectFactory;
import com.opensymphony.xwork2.TextProvider;
import com.opensymphony.xwork2.UnknownHandlerManager;
import com.opensymphony.xwork2.config.Configuration;
import com.opensymphony.xwork2.config.ConfigurationManager;
import com.opensymphony.xwork2.config.impl.DefaultConfiguration;
import com.opensymphony.xwork2.conversion.ObjectTypeDeterminer;
import com.opensymphony.xwork2.conversion.impl.DefaultObjectTypeDeterminer;
import com.opensymphony.xwork2.conversion.impl.XWorkBasicConverter;
import com.opensymphony.xwork2.conversion.impl.XWorkConverter;
import com.opensymphony.xwork2.inject.Container;
import com.opensymphony.xwork2.inject.ContainerBuilder;
import com.opensymphony.xwork2.inject.Scope;
import com.opensymphony.xwork2.ognl.OgnlReflectionProvider;
import com.opensymphony.xwork2.ognl.OgnlUtil;
import com.opensymphony.xwork2.ognl.OgnlValueStackFactory;
import com.opensymphony.xwork2.ognl.accessor.CompoundRootAccessor;
import com.opensymphony.xwork2.util.CompoundRoot;
import com.opensymphony.xwork2.util.PatternMatcher;
import com.opensymphony.xwork2.util.ValueStackFactory;
import com.opensymphony.xwork2.util.reflection.ReflectionProvider;


public class ActionProxyTest {
    
    
    public static void main(String[] args) throws Exception {
        Map context = new HashMap();
        context.put("test", "ÄãºÃ");
        Map params = new HashMap(); 
        params.put("name", "test");
        context.put(ActionContext.PARAMETERS, params); 
        ConfigurationManager manager = new ConfigurationManager();
        Container container = manager.getConfiguration().getContainer();
        DefaultActionProxyFactory actionProxyFactory = new DefaultActionProxyFactory();
        actionProxyFactory.setContainer(container);
        ActionProxy actionProxy = actionProxyFactory.createActionProxy("default", "userAction", context);
        actionProxy.execute();
        
    }
}
