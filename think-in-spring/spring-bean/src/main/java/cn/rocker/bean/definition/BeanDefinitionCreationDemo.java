package cn.rocker.bean.definition;

import cn.rocker.ioc.overview.dependency.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {
        // 1.通过 BeanDefinitionBuilder 构建一个 beanDefinition
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder
                .addPropertyValue("age", 29)
                .addPropertyValue("name", "梅西");
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();


        // 2.通过 AbstractBeanDefinition 及其派生类构建一个 beanDefinition
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues propertyValues = new MutablePropertyValues();
//        propertyValues.addPropertyValue("age", 32);
//        propertyValues.addPropertyValue("name", "C罗");
        propertyValues
                .add("age", 32)
                .add("name", "C罗");
        genericBeanDefinition.setPropertyValues(propertyValues);
    }

}
