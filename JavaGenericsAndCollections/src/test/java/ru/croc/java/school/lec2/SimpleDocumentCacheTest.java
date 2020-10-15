package ru.croc.java.school.lec2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleDocumentCacheTest {

    @Test
    public void testPutAndGet() {
        Document docA = new Document("A");
        Document docB = new Document("B");
        Cache<Document> cache = new Cache<>();
        cache.put(docA);
        cache.put(docB);

        Assertions.assertEquals(docA, cache.get("A"));
        Assertions.assertEquals(docB, cache.get("B"));
    }
}
