package com.module.zy.moduleproject.testAnnotation;

import org.junit.Test;
@TestAnno(hello = "hahah")
public class TestAnnotationA {


    public static void main(String[] args) {

        boolean hasAnnotation = TestAnnotationA.class.isAnnotationPresent(TestAnno.class);
        if (hasAnnotation) {
            TestAnno testAnnotation = TestAnnotationA.class.getAnnotation(TestAnno.class);
            System.out.println("id:" + testAnnotation.id());
            System.out.println("msg:" + testAnnotation.hello());
        }

    }
}
