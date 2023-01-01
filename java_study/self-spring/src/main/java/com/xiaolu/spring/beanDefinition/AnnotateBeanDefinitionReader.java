package com.xiaolu.spring.beanDefinition;

import com.xiaolu.spring.annotation.Scope;

/**
 * 1
 *
 * @author xiaolu
 * @since 2023/1/1
 */
public class AnnotateBeanDefinitionReader {
    private BeanDefinitionRegistry registry;

    public AnnotateBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    /**
     * 注册路径扫描Bean到Bean工厂
     *
     * @param componentClass componentClass
     * @return void
     */
    public void register(Class<?> componentClass) {
        registerBean(componentClass);
    }

    private void registerBean(Class<?> componentClass) {
        doRegisterBean(componentClass);
    }

    private void doRegisterBean(Class<?> componentClass) {
        // 把appConfig读成一个BeanDefinition定义
        AnnotationGenericBeanDefinition beanDefinition = new AnnotationGenericBeanDefinition();
        beanDefinition.setClazz(componentClass);
        if (componentClass.isAnnotationPresent(Scope.class)) {
            String scope = componentClass.getAnnotation(Scope.class).value();
            beanDefinition.setScope(scope);
        }else {
            beanDefinition.setScope("singleton");
        }

        // beanDefinition 创建完成后给beanFactory进行Bean注册
        BeanDefinitionRegistryUtils.registerBeanDefinition(beanDefinition,this.registry);
    }
}
