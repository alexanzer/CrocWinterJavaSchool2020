package ru.croc.school.java.demo4.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunPrivateMethod {
    public Object run(Object obj, String methodName) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        final Method method = obj.getClass().getDeclaredMethod(methodName);
        method.setAccessible(true);
        return method.invoke(obj);
    }
}
