package ru.croc.school.java.demo4.reflection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.croc.school.java.demo4.databind.jaxb.Book;

public class ExampleTest {

    @Test
    public void testClass() {
        Class<Book> clazz = Book.class;

        Book book = new Book(null, "2", "3");
        Assertions.assertEquals(clazz, book.getClass());
    }
}
