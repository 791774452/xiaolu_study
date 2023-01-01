package com.xiaolu.spring.beanDefinition;

/**
 * 1
 *
 * @author xiaolu
 * @since 2023/1/1
 */
public class AnnotationGenericBeanDefinition implements AnnotationBeanDefinition{
    private Class clazz;

    private String scope;

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
