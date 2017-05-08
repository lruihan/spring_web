package com.fdu.rissy.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Annotation1Parser {

    public static void main(String[] args) {
        Annotation1Usage annotation1Usage = new Annotation1Usage();
        Method[] methods = annotation1Usage.getClass().getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Annotation1.class)) {
                try {
                    for (Annotation annotation : method.getDeclaredAnnotations()) {
                        System.out.println(method + ": " + annotation);
                    }
                    Annotation1 annotation1 = method.getAnnotation(Annotation1.class);
                    if (annotation1.version() == 1) {
                        System.out.println("Method with version = 1: " + method);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
