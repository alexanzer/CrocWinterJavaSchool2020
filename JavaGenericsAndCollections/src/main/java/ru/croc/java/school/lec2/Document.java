package ru.croc.java.school.lec2;

public class Document implements CacheId {
    private final String name;

    public Document(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return getName();
    }
}
