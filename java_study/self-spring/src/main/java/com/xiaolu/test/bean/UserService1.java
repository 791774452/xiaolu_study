package com.xiaolu.test.bean;

import com.xiaolu.spring.annotation.Scope;
import com.xiaolu.spring.annotation.Service;

/**
 * userService
 *
 * @author xiaolu
 * @since 2023/1/1
 */
@Service("UserService1")
@Scope("singleton")
public class UserService1 {
}
