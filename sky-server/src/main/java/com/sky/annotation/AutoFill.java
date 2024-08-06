package com.sky.annotation;

import com.sky.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: Y-peak
 * @Date: 2024/8/6 20:22 星期二
 * @ProductName: IntelliJ IDEA
 * @ProjectName: sky-take-out
 * @ClassName: AutoFill
 * @Description: 自定义注解，用于标识某个方法需要添加aop
 */
@Target(ElementType.METHOD)  //注明只能添加在方法上
@Retention(RetentionPolicy.RUNTIME) //表示注解将保留在运行时
public @interface AutoFill {
    //数据库操作类型：UPEATE INSERT
    OperationType value();

}
