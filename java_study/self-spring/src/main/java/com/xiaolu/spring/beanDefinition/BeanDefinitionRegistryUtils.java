package com.xiaolu.spring.beanDefinition;

/**
 * @author xiaolu
 * @since 2023/1/1
 */
public class BeanDefinitionRegistryUtils {
    /**
     * re
     *
     * @param beanDefinition beanDefinition
     * @param registry       registry
     */
    public static void registerBeanDefinition(AnnotationBeanDefinition beanDefinition,
                                              BeanDefinitionRegistry registry) {
        String beanName = ((AnnotationGenericBeanDefinition) beanDefinition).getClazz().getSimpleName();
        registry.registryBeanDefinition(beanName, beanDefinition);
    }
}
