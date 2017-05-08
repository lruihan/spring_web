package com.fdu.rissy.annotations;

import org.jetbrains.annotations.NotNull;

/**
 * Created by lins13 on 5/8/17.
 */
public class AnnotationRunner {

    public void method1() {
        System.out.println("method1");
    }

    @CanRun
    public void method2() {
        System.out.println("method2");
    }

    public void method3(@NotNull String aa) {
        System.out.println(aa);
    }
}
