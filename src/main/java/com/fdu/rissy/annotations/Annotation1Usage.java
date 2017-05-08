package com.fdu.rissy.annotations;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Annotation1Usage {

    @Override
    @Annotation1(author = "Rissy1", date = "2017.05.08", version = 1)
    public String toString() {
        return "Overriden toString method";
    }

    @Deprecated
    @Annotation1(date = "2017.05.06")
    public static void deprecatedMethod() {
        System.out.println("Deprecated Method");
    }

    @SuppressWarnings({ "unchecked", "deprecation"})
    @Annotation1(author = "Rissy2", date = "2017.05.07", version = 10)
    public static void suppressMethod() throws FileNotFoundException {
        List list = new ArrayList();
        list.add("new");
        deprecatedMethod();
    }
}
