package ru.croc.school.java.demo4.databind.jackson;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JacksonConverterTest {

    @Test
    public void testConvertBook() throws Exception {
        JacksonConverter jacksonConverter = new JacksonConverter();

        Book book = new Book("Дорофеев Максим", "Джедайские техники");
        String xml = jacksonConverter.toXml(book);
        Assertions.assertEquals(
                "<Book>\n" +
                        "  <author>Дорофеев Максим</author>\n" +
                        "  <title>Джедайские техники</title>\n" +
                        "</Book>\n",
                xml
        );
    }

}
