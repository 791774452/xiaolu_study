package cn.bugstack.middleware.db.router.annotation;

import java.lang.annotation.*;

/**
 * 路由策略，分表标记
 *
 * @author xiaolu
 * @since 2022-12-17
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface DBRouterStrategy {

    boolean splitTable() default false;
}
