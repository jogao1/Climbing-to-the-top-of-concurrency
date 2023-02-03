package org.task01;

public class UnsafeSequence {
    private int value;

    public int getValue() {
        return value;
    }

    public int getNext() {
        return value++;
    }
}

