package com.xiaolu.spring.beanDefinition;

/**
 * @author xiaolu
 * @since 2023/1/1
 */
public interface BeanDefinitionRegistry {
    /**
     * 1
     *
     * @param beanName beanName
     * @param beanDefinition beanDefinition
     * @return void
     */
    void registryBeanDefinition(String beanName, AnnotationBeanDefinition beanDefinition);
}
