package cn.rocker.ioc.overview.dependency.container;

import cn.rocker.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

public class BeanFactoryIocContainerDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory listableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(listableBeanFactory);
        String location = "classpath:/META-INF/dependency-lookup-context.xml";
        int beanDefinitions = xmlBeanDefinitionReader.loadBeanDefinitions(location);
        System.out.println(beanDefinitions);

        lookupCollectionByType(listableBeanFactory);
    }

    private static void lookupCollectionByType(BeanFactory context){
        if(context instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) context;
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println(userMap);
        }
    }

}
