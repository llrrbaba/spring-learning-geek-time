package cn.rocker.ioc.overview.dependency.lookup;

import cn.rocker.ioc.overview.dependency.annotation.Super;
import cn.rocker.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {
        BeanFactory context = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");
//        lookupInRealTime(context);
//        lookupInLazily(context);
        lookupByType(context);
//        lookupCollectionByType(context);
//        lookupByAnnotation(context);
    }

    private static void lookupByAnnotation(BeanFactory context) {
        if(context instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) context;
            Map<String, User> beansWithAnnotation = (Map)listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println(beansWithAnnotation);
        }
    }

    private static void lookupCollectionByType(BeanFactory context){
        if(context instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) context;
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println(userMap);
        }
    }

    private static void lookupByType(BeanFactory context){
        User user = context.getBean(User.class);
        System.out.println(user);
    }

    private static void lookupInRealTime(BeanFactory context){
        User user = (User) context.getBean("user");
        System.out.println(user);
    }

    private static void lookupInLazily(BeanFactory context){
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) context.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println(user);
    }

}
