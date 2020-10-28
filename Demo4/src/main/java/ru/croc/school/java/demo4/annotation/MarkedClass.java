package ru.croc.school.java.demo4.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface MarkedClass {
    // nothing
}

@MarkedClass
class MyClass {
    void method() {

    }

}
