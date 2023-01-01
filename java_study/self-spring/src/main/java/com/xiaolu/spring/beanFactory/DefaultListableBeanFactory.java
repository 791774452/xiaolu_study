package com.xiaolu.spring.beanFactory;

import com.xiaolu.spring.annotation.ComponentScan;
import com.xiaolu.spring.annotation.Scope;
import com.xiaolu.spring.annotation.Service;
import com.xiaolu.spring.beanDefinition.AnnotationBeanDefinition;
import com.xiaolu.spring.beanDefinition.AnnotationGenericBeanDefinition;
import com.xiaolu.spring.beanDefinition.BeanDefinitionRegistry;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * bean
 *
 * @author xiaolu
 * @since 2023/1/1
 */
public class DefaultListableBeanFactory implements BeanDefinitionRegistry, BeanFactory {

    private final Map<String, AnnotationBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);
    private final Map<String, Object> singletonObject = new ConcurrentHashMap<>(256);

    private List<String> beanDefinitionNames = new ArrayList<>();

    /**
     * bean注册
     *
     * @param beanName       beanName
     * @param beanDefinition beanDefinition
     * @return void
     */
    @Override
    public void registryBeanDefinition(String beanName, AnnotationBeanDefinition beanDefinition) {
        this.beanDefinitionMap.put(beanName, beanDefinition);
    }

    /**
     * doScan
     *
     * @return void
     */
    public void doScan() {
        for (String beanName : beanDefinitionMap.keySet()) {
            AnnotationGenericBeanDefinition bd = (AnnotationGenericBeanDefinition) beanDefinitionMap.get(beanName);
            if (bd.getClazz().isAnnotationPresent(ComponentScan.class)) {
                ComponentScan componentScan = (ComponentScan) bd.getClazz().getAnnotation(ComponentScan.class);
                // 获取注解value
                String basePackage = componentScan.value();
                URL resource = this.getClass().getClassLoader().getResource(basePackage.replace(".", "/"));
                File file = new File(resource.getFile());
                if (file.isDirectory()) {
                    for (File listFile : file.listFiles()) {
                        try {
                            Class clazz =
                                    this.getClass().getClassLoader().loadClass(basePackage.concat(".".concat(listFile.getName().split("\\.")[0])));
                            if (clazz.isAnnotationPresent(Service.class)) {
                                String name = ((Service) clazz.getAnnotation(Service.class)).value();
                                AnnotationGenericBeanDefinition add = new AnnotationGenericBeanDefinition();
                                add.setClazz(clazz);
                                if (clazz.isAnnotationPresent(Scope.class)) {
                                    add.setScope(((Scope) clazz.getAnnotation(Scope.class)).value());
                                } else {
                                    add.setScope("singleton");
                                }
                                beanDefinitionMap.put(name, add);
                                // 需要有一个地方，记录真正定义的bean
                                beanDefinitionNames.add(name);
                            }
                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
        System.out.println();
    }

    /**
     * 单例bean初始化
     *
     * @return void
     */
    public void preInstantiateSingleton() {
        // 初始化定义的bean，需要找到所有的自定义的的beanName
        // 为什么不直接使用beanDefinitionNames？ 因为beanDefinitionNames处于一个并发环境，如果出现其他线程访问，就会出现for循环失败。备份
        List<String> beanNames = new ArrayList<>(beanDefinitionNames);
        for (String beanName : beanNames) {
            AnnotationGenericBeanDefinition beanDefinition =
                    (AnnotationGenericBeanDefinition) beanDefinitionMap.get(beanName);
            if ("singleton".equals(beanDefinition.getScope())) {
                // 创建单例对象，然后把这个单例对象保存到单例池
                // getBean方法中包含创建对象，然后放到singletonObject
                getBean(beanName);
            }
        }
    }

    /**
     * 只有bean都注册上以后才能有getBean
     *
     * @param beanName beanName
     * @return Object
     */
    @Override
    public Object getBean(String beanName) {
        return doGetBean(beanName);
    }

    private Object doGetBean(String beanName) {
        Object bean = singletonObject.get(beanName);
        if (bean != null) {
            return bean;
        }
        // 需要根据beanDefinition创建bean
        AnnotationGenericBeanDefinition beanDefinition =
                (AnnotationGenericBeanDefinition) beanDefinitionMap.get(beanName);
        Object cBean = createBean(beanName, beanDefinition);
        if ("singleton".equals(beanDefinition.getScope())) {
            // createBean方法其实是为了完成bean definition转真正实体对象的地方
            singletonObject.put(beanName, cBean);
        }
        return cBean;

    }

    private Object createBean(String beanName, AnnotationGenericBeanDefinition beanDefinition) {
        try {
            return beanDefinition.getClazz().getConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }


}
