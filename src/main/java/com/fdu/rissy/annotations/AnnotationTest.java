package com.fdu.rissy.annotations;

import java.lang.reflect.Method;

/**
 * Created by lins13 on 5/8/17.
 */
public class AnnotationTest {

    public static void main(String[] args) {
        AnnotationRunner runner = new AnnotationRunner();

        Method[] methods = runner.getClass().getMethods();

        for (Method method : methods) {
            CanRun annotation = method.getAnnotation(CanRun.class);
            if (annotation != null) {
                try {
                    method.invoke(runner);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        //idea will show this as error
        //runner.method3(null);
    }
}
