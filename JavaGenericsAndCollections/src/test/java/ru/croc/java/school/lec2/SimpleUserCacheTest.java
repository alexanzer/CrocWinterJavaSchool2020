package ru.croc.java.school.lec2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleUserCacheTest {


    @Test
    public void testPutAndGet() {
        User alex = new User("alex", "Александр");
        User peter = new User("peter", "Пётр");
        SimpleUserCache cache = new SimpleUserCache();
        cache.put(alex);
        cache.put(peter);

        Assertions.assertEquals(alex, cache.get("alex"));
        Assertions.assertEquals(peter, cache.get("peter"));
    }

    @Test
    public void testPutAndGetGeneric() {
        User alex = new User("alex", "Александр");
        User peter = new User("peter", "Пётр");
        Cache<User> cache = new Cache<>();

        cache.put(alex);
        cache.put(peter);

        Assertions.assertEquals(alex, cache.get("alex"));
        Assertions.assertEquals(peter, cache.get("peter"));
    }
}
