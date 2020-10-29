package ru.croc.school.java.demo4.databind.jaxb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class JaxbConverterTest {

    @Test
    public void testConvertBook() throws Exception {
        JaxbConverter jacksonConverter = new JaxbConverter();
        List<Author> authors = Arrays.asList(
                new Author("Автор 1", 34, "text1 ..."),
                new Author("Автор 2", 90, "text2 ..."),
                new Author("Автор 3", 45, "text3 ...")
        );
        Book book = new Book(authors, "Джедайские техники", "#0000");
        String xml = jacksonConverter.toXml(book);
        Assertions.assertEquals(
                "<Book number=\"#34\">\n" +
                        "  <author>Дорофеев Максим</author>\n" +
                        "  <title>Джедайские техники</title>\n" +
                        "</Book>\n",
                xml
        );
    }

    @Test
    public void testConvertXml() throws Exception {
        JaxbConverter jacksonConverter = new JaxbConverter();
        Path path = Paths.get("src/main/resources", "book_ex_2.xml");
        String xml = Files.readString(path);
        Book book = jacksonConverter.fromXml(xml, Book.class);
        System.out.println(book);
    }

}
