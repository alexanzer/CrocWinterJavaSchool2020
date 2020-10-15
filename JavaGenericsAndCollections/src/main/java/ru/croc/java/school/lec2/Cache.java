package ru.croc.java.school.lec2;

import java.util.HashMap;
import java.util.Map;

public class Cache<T extends CacheId> {
    private Map<String, T> cache = new HashMap<>();

    public void put(T value) {
        cache.put(value.getId(), value);
    }

    public T get(String key) {
        return cache.get(key);
    }
}
