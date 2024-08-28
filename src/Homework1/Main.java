package Homework1;
import java.util.*;

/**
 * Ian Webb
 * August 28th
 * ITEC
 */
public class Main {
    public static void main(String[] args) {

        FileHandling manager = new FileHandling();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("What do you want to do?");
            System.out.println("1. List all items");
            System.out.println("2. Find an item by name");
            System.out.println("3. Delete an item");
            System.out.println("4. Add a new item");
            System.out.println("5. Write list to a file");
            System.out.println("6. Exit");
            System.out.println();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manager.listItems();

                    break;
                case 2:
                    System.out.println("What is the name of the item you would like to find?");
                    String findName = scanner.nextLine();
                    manager.findItem(findName);

                    break;
                case 3:
                    System.out.println("What is the name of the item you would like to delete?");
                    String deleteName = scanner.nextLine();
                    manager.deleteItem(deleteName);

                    break;
                case 4:
                    System.out.println("Enter type (audio/video):");
                    String type = scanner.nextLine();
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter producer:");
                    String producer = scanner.nextLine();
                    System.out.println("Enter size:");

                    int size = scanner.nextInt();
                    scanner.nextLine();

                    if (type.equalsIgnoreCase("audio")) {
                        System.out.println("Enter (MP3/Other):");
                        String format = scanner.nextLine();
                        manager.addItem(new Audio(name, producer, size, format));

                    } else if (type.equalsIgnoreCase("video")) {
                        System.out.println("Enter length:");
                        int length = scanner.nextInt();
                        scanner.nextLine();
                        manager.addItem(new Video(name, producer, size, length));
                    }

                    break;

                case 5:
                    manager.saveFile();

                    break;

                case 6:
                    System.out.println("Exiting.");

                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

