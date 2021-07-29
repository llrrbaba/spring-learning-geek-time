package cn.rocker.ioc.overview.dependency.inject;

import cn.rocker.ioc.overview.dependency.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * 依赖注入
 */
public class DependencyInjectDemo {

    public static void main(String[] args) {
        BeanFactory context = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-inject-context.xml");

        UserRepository userRepository = context.getBean(UserRepository.class);
        System.out.println(userRepository);

        // 这里能获取到一个 beanFactory ，但是这个获取到的 beanFactory 又不是一个 bean，那他是怎么被依赖注入到 userRepository 里的
        // 依赖注入 userRepository#beanFactory (内建依赖)
        BeanFactory beanFactory = userRepository.getBeanFactory();
        System.out.println(beanFactory);
        Environment environment1 = beanFactory.getBean(Environment.class);
        System.out.println(environment1);

        // 依赖查找 (报错)，容器里没有 beanFactory 这个bean
//        System.out.println(context.getBean(BeanFactory.class));

        // 容器内建 bean
        Environment environment = context.getBean(Environment.class);
        System.out.println(environment);



    }



}
