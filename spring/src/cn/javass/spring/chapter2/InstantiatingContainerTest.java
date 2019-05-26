package cn.javass.spring.chapter2;

import java.io.File;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import cn.javass.spring.chapter2.helloworld.HelloApi;

public class InstantiatingContainerTest {
    
    @Test
    public void testXmlBeanFactoryBaseOnFileSystem() {
        //1.准备配置文件，从文件系统获取配置文件，默认是相对路径，可以指定绝对路径
        File file = new File("fileSystemConfig.xml");
        Resource resource = new FileSystemResource(file);
        //2.初始化容器
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        //2、从容器中获取Bean
        HelloApi helloApi = beanFactory.getBean("hello", HelloApi.class);
        //3、执行业务逻辑
        helloApi.sayHello();
    }
    
    @Test
    public void testXmlBeanFactoryBaseOnClassPath() {
        //1.准备配置文件，从当前类加载路径中获取配置文件
        Resource resource = new ClassPathResource("chapter2/classpath.xml");
        //2.初始化容器
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        //2、从容器中获取Bean
        HelloApi helloApi = beanFactory.getBean("hello", HelloApi.class);
        //3、执行业务逻辑
        helloApi.sayHello();
    }
    
    @Test
    public void testClassPathXmlApplicationContext() {
        //1.准备配置文件，从当前类加载路径中获取配置文件
        //2.初始化容器
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter2/classpath.xml");
        //2、从容器中获取Bean
        HelloApi helloApi = beanFactory.getBean("hello", HelloApi.class);
        //3、执行业务逻辑
        helloApi.sayHello();
    }
    
    @Test
    public void testFileSystemApplicationContext() {
        //1.准备配置文件，从文件系统获取配置文件，默认是相对路径，可以指定绝对路径
        //2.初始化容器
        BeanFactory beanFactory = new FileSystemXmlApplicationContext("fileSystemConfig.xml");
        //2、从容器中获取Bean
        HelloApi helloApi = beanFactory.getBean("hello", HelloApi.class);
        //3、执行业务逻辑
        helloApi.sayHello();
    }
}
