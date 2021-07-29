package cn.rocker.ioc.overview.dependency.container;

import cn.rocker.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class AnnotationApplicationContextIocContainerDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationApplicationContextIocContainerDemo.class);
        applicationContext.refresh();

        lookupCollectionByType(applicationContext);
    }

    @Bean
    public User user(){
        User user = new User();
        user.setId(1L);
        user.setName("哈哈");
        return user;
    }

    private static void lookupCollectionByType(BeanFactory context){
        if(context instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) context;
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println(userMap);
        }
    }

}
