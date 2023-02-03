package org.task01;

public class Sequence {
    private int value;

    public int getValue() {
        return value;
    }

    public synchronized int getNext() {
        return value++;
    }
}

