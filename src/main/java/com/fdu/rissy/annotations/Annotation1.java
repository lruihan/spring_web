package com.fdu.rissy.annotations;

import java.lang.annotation.*;
import java.util.Date;

@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Annotation1 {
    String author() default "Rissy";
    String date();
    int version() default 1;
}
