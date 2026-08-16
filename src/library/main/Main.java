package library.main;

import library.model.LibraryResource;
import library.model.Book;
import library.model.DigitalResource;
import library.service.LibraryService;

public class Main {

    public static void main(String[] args) {

        LibraryResource[] resources = new LibraryResource[5];

        resources[0] = new Book(
                101,
                "Java Programming",
                "Herbert Schildt"
        );

        resources[1] = new DigitalResource(
                102,
                "Artificial Intelligence",
                "Stuart Russell"
        );

        resources[2] = new Book(
                103,
                "Database Management Systems",
                "Raghu Ramakrishnan"
        );

        resources[3] = new DigitalResource(
                104,
                "Computer Networks",
                "Andrew S. Tanenbaum"
        );

        resources[4] = new Book(
                105,
                "Operating System Concepts",
                "Silberschatz"
        );

        int[] overdueDays = {
                5,
                10,
                3,
                7,
                4
        };

        System.out.println("===== SMART LIBRARY RESOURCE MANAGEMENT SYSTEM =====");
        System.out.println();

        LibraryService.displayResources(resources);

        double totalFine =
                LibraryService.calculateTotalFine(resources, overdueDays);

        System.out.printf("Total Fine of All Resources: Rs. %.2f%n",
                totalFine);

        System.out.println();

        LibraryResource.displayTotalResources();
    }
}