package Homework1;
import java.util.*;
import java.io.*;
public class FileHandling {
    private static final String FILE_NAME = "/Users/a16782/IdeaProjects/AdvancedPrograming/src/Homework1/MyTextFile";
    private List<DigitalFiles> files;

    public FileHandling() {
        files = new ArrayList<>();
        loadFromFile();
    }

    public void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Read line: " + line);
                String[] parts = line.split(", ");

                String type = parts[0];
                String name = parts[1];
                String producer = parts[2];
                int size = Integer.parseInt(parts[3]);

                if (type.equalsIgnoreCase("audio")) {
                    String format = parts[4];
                    files.add(new Audio(name, producer, size, format));
                } else if (type.equalsIgnoreCase("video")) {
                    int length = Integer.parseInt(parts[4]);
                    files.add(new Video(name, producer, size, length));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number: " + e.getMessage());
        }
    }


    public void saveFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (DigitalFiles file : files) {
                if (file instanceof Audio) {
                    Audio audio = (Audio) file;
                    writer.write(String.format("audio, %s, %s, %d, %s%n", audio.getName(), audio.getProducer(), audio.getSize(), audio.format));
                } else if (file instanceof Video) {
                    Video video = (Video) file;
                    writer.write(String.format("video, %s, %s, %d, %d%n", video.getName(), video.getProducer(), video.getSize(), video.length));
                }
            }
        } catch (IOException e) {
            System.out.println("Error writing file.");
        }
    }

    public void listItems() {

        if (files.isEmpty()) {
            System.out.println("No items to display.");
            return;
        }
        for (DigitalFiles file : files) {
            file.displayDetails();
        }
    }

    public void findItem(String name) {
        for (DigitalFiles file : files) {
            if (file.getName().equalsIgnoreCase(name)) {
                file.displayDetails();
                return;
            }
        }
        System.out.println(name + " was not found in the list.");
    }

    public void deleteItem(String name) {
        Iterator<DigitalFiles> iterator = files.iterator();
        while (iterator.hasNext()) {
            DigitalFiles file = iterator.next();
            if (file.getName().equalsIgnoreCase(name)) {
                file.displayDetails();
                System.out.println("Do you want to delete this item? (y/n)");
                Scanner scanner = new Scanner(System.in);
                if (scanner.nextLine().equalsIgnoreCase("y")) {
                    iterator.remove();
                    System.out.println("Item deleted.");
                }
                return;
            }
        }
        System.out.println(name + " was not found in the list.");
    }

    public void addItem(DigitalFiles file) {
        files.add(file);
    }
}
