package Homework1;
import java.util.*;
class Video extends DigitalFiles {
    int length;

    public Video(String name, String producer, int size, int length) {
        super("Video", name, producer, size);
        if (length < 10 || length > 180) {
            throw new IllegalArgumentException("Length needs to be between" +
                    " 10 and 180 minutes.");
        }
            this.length = length;
        }

        @Override
        public void displayDetails () {
            System.out.println("Video: " + name + ", Producer: " + producer +
                    " Size: " + size + " Length: " + length + " minutes");
        }
    }

