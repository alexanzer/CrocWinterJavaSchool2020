package ru.croc.java.school.thread;

public class Holder {
    public int value;
}
/** Потокобезопасный вариант
public class Holder {
    private int value;

    public synchronized int getValue() {
        return value;
    }

    public synchronized void setValue(int value) {
        this.value = value;
    }
}
 */
