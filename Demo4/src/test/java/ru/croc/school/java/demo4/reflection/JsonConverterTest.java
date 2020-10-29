package ru.croc.school.java.demo4.reflection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JsonConverterTest {




    @Test
    public void testBookToJson() throws IllegalAccessException {
        String template = "{\n" +
                "  name: \"%s\",\n" +
                "  author: \"%s\",\n" +
                "  genre: \"%s\",\n" +
                "}";
        Book book = new Book("А", "Б", "Ц");

        JsonConverter converter = new JsonConverter();
        String json = converter.toJson(book);
        String expectedJson = String.format(template,  book.name, book.author, book.genre);
        Assertions.assertEquals(expectedJson, json);
    }

    @Test
    public void testMovieToJson() throws IllegalAccessException {
        String template = "{\n" +
                "  title: \"%s\",\n" +
                "  country: \"%s\",\n" +
                "  year: \"%d\",\n" +
                "}";
        Movie movie = new Movie("А", "Б", 2020);

        JsonConverter converter = new JsonConverter();
        String json = converter.toJson(movie);
        String expectedJson = String.format(template,  movie.title, movie.country, movie.year);
        Assertions.assertEquals(expectedJson, json);
    }
}
