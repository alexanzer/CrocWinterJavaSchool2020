package ru.croc.school.java.demo4.databind.jaxb;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Книга")
public class Book {
    @XmlElementWrapper(name = "Авторы")
    @XmlElement(name = "Автор")
    private List<Author> authors;
    @XmlElement(name = "Название")
    private String title;
    @XmlAttribute(name = "Номер")
    private String number;

    public Book() {
    }

    public Book(List<Author> authors, String title, String number) {
        this.authors = authors;
        this.title = title;
        this.number = number;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Book{" +
                "authors=" + authors +
                ", title='" + title + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
