package ru.croc.java.school.lec2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class CollectionTest {

    @Test
    public void testIterable() {
        Iterable<String> iterable = Arrays.asList("Java", "C++");

        Iterator<String> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (String str : iterable) {
            System.out.println(str);
        }
    }

    @Test
    public void testMap() {
    }
}
