package com.xiaolu.spring.beanFactory;

/**
 * BeanFactory
 *
 * @author xiaolu
 * @since 2023/1/1
 */
public interface BeanFactory {
    /**
     * getBean
     *
     * @param beanName beanName
     * @return Object
     */
    Object getBean(String beanName);
}
