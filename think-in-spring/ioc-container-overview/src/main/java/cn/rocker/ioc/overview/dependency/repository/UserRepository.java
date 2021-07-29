package cn.rocker.ioc.overview.dependency.repository;

import cn.rocker.ioc.overview.dependency.domain.User;
import lombok.Data;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.core.env.Environment;

import java.util.Collection;

@Data
public class UserRepository {
    /**
     * 我们自定义的 bean 对象
     */
    private Collection<User> users;

    /**
     * spring 内嵌的 非bean 对象
     */
    private BeanFactory beanFactory;

    private Environment environment;

}
