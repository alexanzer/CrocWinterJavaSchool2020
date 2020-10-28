package ru.croc.school.java.demo4.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Inherited
@Retention(RUNTIME)
@Target({TYPE, FIELD, METHOD})
public @interface SuperAnnotation {
    int number() default 0;
    boolean is() default false;
    String value();
    Class<? extends CharSequence> strings() default String.class;
    E enumm() default E.B;
    double[] array() default {1.0, 2.6, 3.9};
    String object() default " " + 74;
}

enum E { A, B, C }

@SuperAnnotation("ss")
class ClassWithSuperAnnotationA {}

@SuperAnnotation(value = "ss")
class ClassWithSuperAnnotationB {}

@SuperAnnotation(
        value = "ss",
        array = {5.5},
        strings = CharSequence.class,
        number = 9,
        object = "text"
)
class ClassWithSuperAnnotationC {}
