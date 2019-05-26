package cn.javass.spring.chapter3;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.javass.spring.chapter2.helloworld.HelloApi;


public class DependencyInjectTest {
    
    @Test
    public void ConstructorDependencyInjectTest() {
        
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter3/constructorDependencyInject.xml");
        
        //获取根据参数索引依赖注入的Bean
        HelloApi byIndex = beanFactory.getBean("byIndex", HelloApi.class);
        byIndex.sayHello();

        //获取根据参数类型依赖注入的Bean
        HelloApi byType = beanFactory.getBean("byType", HelloApi.class);
        byType.sayHello();

        //获取根据参数名字依赖注入的Bean
        HelloApi byName = beanFactory.getBean("byName", HelloApi.class);
        byName.sayHello();
        
    }

    @Test
    public void staticFactoryDependencyInjectTest() {
        
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter3/staticFactoryDependencyInject.xml");
        
        //获取根据参数索引依赖注入的Bean
        HelloApi byIndex = beanFactory.getBean("byIndex", HelloApi.class);
        byIndex.sayHello();
        
        //获取根据参数类型依赖注入的Bean
        HelloApi byType = beanFactory.getBean("byType", HelloApi.class);
        byType.sayHello();
        
        //获取根据参数名字依赖注入的Bean
        HelloApi byName = beanFactory.getBean("byName", HelloApi.class);
        byName.sayHello();
        
    }

    @Test
    public void instanceFactoryDependencyInjectTest() {
        
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter3/instanceFactoryDependencyInject.xml");
        
        //获取根据参数索引依赖注入的Bean
        HelloApi byIndex = beanFactory.getBean("byIndex", HelloApi.class);
        byIndex.sayHello();
        
        //获取根据参数类型依赖注入的Bean
        HelloApi byType = beanFactory.getBean("byType", HelloApi.class);
        byType.sayHello();
        
        //获取根据参数名字依赖注入的Bean
        HelloApi byName = beanFactory.getBean("byName", HelloApi.class);
        byName.sayHello();
        
    }
    
    @Test
    public void setterDependencyInjectTest() {
        
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter3/setterDependencyInject.xml");
        
        HelloApi bean = beanFactory.getBean("bean", HelloApi.class);
        bean.sayHello();
    }
//=====================依赖注入扩展部分=================================
    
    //注入Boolean值
    @Test
    public void booleanInjectTest() {
        
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter3/booleanInject.xml");
        
        BooleanTestBean bean1 = beanFactory.getBean("bean1", BooleanTestBean.class);
        System.out.println(bean1.isSuccess());

        BooleanTestBean bean2 = beanFactory.getBean("bean2", BooleanTestBean.class);
        System.out.println(bean2.isSuccess());

        BooleanTestBean bean3 = beanFactory.getBean("bean3", BooleanTestBean.class);
        System.out.println(bean3.isSuccess());

        BooleanTestBean bean4 = beanFactory.getBean("bean4", BooleanTestBean.class);
        System.out.println(bean4.isSuccess());
    }
    
    
}
