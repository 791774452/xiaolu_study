package cn.bugstack.middleware.db.router.annotation;

import java.lang.annotation.*;


/**
 * 路由注解
 *
 * @author xiaolu
 * @since 2022-12-15
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface DBRouter {

    /** 分库分表字段 */
    String key() default "";

}
