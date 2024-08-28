package Homework1;
import java.util.*;
public class Audio extends DigitalFiles {
    String format;

    public Audio(String name, String producer, int size, String format) {
        super("Audio", name, producer, size);

        this.format = format;
    }

        @Override
        public void displayDetails () {
            System.out.println("Audio Name: " + name + ", Producer: " + producer + ", Size: " + size + " Format: " + format);
        }

    }

