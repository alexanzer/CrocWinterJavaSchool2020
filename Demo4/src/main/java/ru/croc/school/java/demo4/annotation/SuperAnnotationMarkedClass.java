package ru.croc.school.java.demo4.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.List;

@Target(ElementType.TYPE) @interface MarkedType {}
@Target(ElementType.FIELD) @interface MarkedField {}
@Target(ElementType.METHOD) @interface MarkedMethod {}
@Target(ElementType.PARAMETER) @interface MarkedParameter {}
@Target(ElementType.CONSTRUCTOR) @interface MarkedConstructor {}
@Target(ElementType.LOCAL_VARIABLE) @interface MarkedLocalVariable {}
@Target(ElementType.ANNOTATION_TYPE) @interface MarkedAnnotationType {}
@Target(ElementType.PACKAGE) @interface MarkedPackage {}
@Target(ElementType.TYPE_PARAMETER) @interface MarkedTypeParameter {}
@Target(ElementType.TYPE_USE) @interface MarkedTypeUse {}
//@Target(ElementType.RECORD_COMPONENT) @interface MarkedRecordComponent {}

@MarkedType
public class SuperAnnotationMarkedClass<@MarkedTypeParameter T> {
    @MarkedField
    private int count = 0;

    @MarkedConstructor
    public SuperAnnotationMarkedClass( @MarkedParameter int  count) {
        this.count = count;
    }

    @MarkedMethod
    public @MarkedTypeUse List<String> f(
            @MarkedParameter String param) {
        @MarkedLocalVariable String value = "" + count;
        return Collections.singletonList(value);
    }
}

