package edu.hehai.shuili.weather.intercepter;

import edu.hehai.shuili.weather.pojo.Privilege;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 权限有三类0,1,2
 * Created by yangyue on 21/02/2017.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {
    Privilege[] value();
}