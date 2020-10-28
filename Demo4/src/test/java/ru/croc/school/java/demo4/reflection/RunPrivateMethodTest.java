package ru.croc.school.java.demo4.reflection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

public class RunPrivateMethodTest {

    class A {
        private String f() {
            return "777";
        }
    }

    @Test
    public void test() throws Exception {
        A a = new A();
        RunPrivateMethod runner = new RunPrivateMethod();
        Assertions.assertEquals(a.f(), runner.run(a, "f"));
    }
}
