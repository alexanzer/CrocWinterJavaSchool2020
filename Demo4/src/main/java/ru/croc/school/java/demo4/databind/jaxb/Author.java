package ru.croc.school.java.demo4.databind.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Author {
    @XmlAttribute(name = "ФИО", required = true)
    private String name;
    @XmlAttribute(name = "Возраст")
    private int age;
    @XmlElement(name = "Биография")
    private String biography;

    public Author() {
    }

    public Author(String name, int age, String biography) {
        this.name = name;
        this.age = age;
        this.biography = biography;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBiography() {
        return biography;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", biography='" + biography + '\'' +
                '}';
    }
}
