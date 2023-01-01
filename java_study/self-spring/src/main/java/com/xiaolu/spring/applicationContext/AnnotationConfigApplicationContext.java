package com.xiaolu.spring.applicationContext;

import com.xiaolu.spring.beanDefinition.AnnotateBeanDefinitionReader;
import com.xiaolu.spring.beanDefinition.BeanDefinitionRegistry;

/**
 * @author xiaolu
 * @since 2023/1/1
 */
public class AnnotationConfigApplicationContext extends GenericApplicationContext
        // 作为bean工厂读父类
        implements BeanDefinitionRegistry {

    private AnnotateBeanDefinitionReader reader;

    /**
     * 如果有人调用这个无参构造，那么他会隐式调用父类的无参构造
     */
    public AnnotationConfigApplicationContext() {
        this.reader = new AnnotateBeanDefinitionReader(this);
    }

    public AnnotationConfigApplicationContext(Class<?> componentClass) {
        // 1、读 componentClass 也就是我门的扫描路径 所在类的AppConfig
        this();
        // 2、先把这个类AppConfig 注册到bean工厂（BeanDefinition +registerBeanDefinition +FactoryBean)
        register(componentClass);
        // 3、扫描这个路径，然后提取出这个路径下所有的bean，然后注册到工厂（单例bean的初始化）
        // refresh 方法作为核心方法，需要用在父类中，让所有的子类都能使用
        refresh();

    }

    private void register(Class<?> componentClass) {
        this.reader.register(componentClass);
    }

}
