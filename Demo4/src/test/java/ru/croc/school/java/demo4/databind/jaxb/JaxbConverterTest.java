package ru.croc.school.java.demo4.databind.jaxb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JaxbConverterTest {

    @Test
    public void testConvertBook() throws Exception {
        JaxbConverter jacksonConverter = new JaxbConverter();

        Book book = new Book("Дорофеев Максим", "Джедайские техники", "#34");
        String xml = jacksonConverter.toXml(book);
        Assertions.assertEquals(
                "<Book number=\"#34\">\n" +
                        "  <author>Дорофеев Максим</author>\n" +
                        "  <title>Джедайские техники</title>\n" +
                        "</Book>\n",
                xml
        );
    }

}
