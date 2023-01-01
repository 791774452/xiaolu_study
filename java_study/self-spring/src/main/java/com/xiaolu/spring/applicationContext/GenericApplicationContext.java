package com.xiaolu.spring.applicationContext;

import com.xiaolu.spring.beanDefinition.AnnotationBeanDefinition;
import com.xiaolu.spring.beanDefinition.BeanDefinitionRegistry;
import com.xiaolu.spring.beanFactory.DefaultListableBeanFactory;

/**
 * sd
 *
 * @author xiaolu
 * @since 2023/1/1
 */
public class GenericApplicationContext implements BeanDefinitionRegistry {
    private DefaultListableBeanFactory factory;

    public GenericApplicationContext() {
        this.factory = new DefaultListableBeanFactory();
    }

    /**
     * 1
     *
     * @param beanName       beanName
     * @param beanDefinition beanDefinition
     * @return void
     */
    @Override
    public void registryBeanDefinition(String beanName, AnnotationBeanDefinition beanDefinition) {
        this.factory.registryBeanDefinition(beanName, beanDefinition);
    }

    protected void refresh() {
        // 获取bean工厂
        DefaultListableBeanFactory beanFactory = obtainBeanFatory();
        // 把appConfig路径下的所有bean进行扫描，注册到bean工厂 beanDefinitionMap（UserService and UserService1）
        invokeBeanFactoryPostProcessors(beanFactory);
        // 初始化beanDefinition说代表的单例bean，放到单例bean的容器里
        finishBeanFactoryInitialization(beanFactory);
    }

    /**
     * Bean初始化
     *
     * @param beanFactory beanFactory
     * @return void
     */
    private void finishBeanFactoryInitialization(DefaultListableBeanFactory beanFactory) {
        beanFactory.preInstantiateSingleton();
    }

    /**
     * 调用 Bean Factory 后处理器
     *
     * @param beanFactory beanFactory
     * @return void
     */
    private void invokeBeanFactoryPostProcessors(DefaultListableBeanFactory beanFactory) {
        // 只进行简化处理,doScan方法并没有在beanFactory里
        beanFactory.doScan();
    }

    private DefaultListableBeanFactory obtainBeanFatory() {
        return this.factory;
    }

    public Object getBean(String beanName) {
       return this.factory.getBean(beanName);
    }
}
