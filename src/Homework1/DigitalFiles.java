package Homework1;
import java.util.*;
import java.io.*;

abstract class DigitalFiles {
    protected String name;
    protected String producer;
    protected int size;
    protected String type;

    public DigitalFiles(String type, String name, String producer, int size) {
        this.name = name;
        this.producer = producer;
        this.size = size;
        this.type = type;

        if (size < 5 || size > 10_000_000) {
            throw new IllegalArgumentException("Size must be between 5 and 10,000,000.");
        }
    }
    public abstract void displayDetails();
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getProducer() {
        return producer;
    }

    public int getSize() {
        return size;
    }

}


