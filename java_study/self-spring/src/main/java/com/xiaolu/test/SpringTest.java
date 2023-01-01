package com.xiaolu.test;

import com.xiaolu.spring.applicationContext.AnnotationConfigApplicationContext;
import com.xiaolu.test.config.AppConfig;

/**
 * spring test
 *
 * @author xiaolu
 * @since 2023/1/1
 */
public class SpringTest {
    public static void main(String[] args) {
        // 创建applicationContext（注解形式）
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // 调用getBean
        System.out.println(applicationContext.getBean("UserService"));
        System.out.println(applicationContext.getBean("UserService"));
        System.out.println(applicationContext.getBean("UserService"));
        System.out.println(applicationContext.getBean("UserService1"));
        System.out.println(applicationContext.getBean("UserService1"));
        System.out.println(applicationContext.getBean("UserService1"));
    }
}
