package com.songjing.sbsd.annotation.run.limit;

import java.lang.annotation.*;

@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AccessLimit {

    int limit() default 5;

    int seconds();
}
