package library.service;

import library.model.LibraryResource;
import library.model.Printable;
import library.util.InputValidator;

public class LibraryService {

    public static void displayResources(LibraryResource[] resources) {

        for (LibraryResource resource : resources) {

            if (resource != null) {

                if (InputValidator.validateResourceId(
                        resource.getResourceId())) {

                    if (resource instanceof Printable) {
                        ((Printable) resource).printDetails();
                    }

                    System.out.println("----------------------------------------");
                }
            }
        }
    }

    public static double calculateTotalFine(
            LibraryResource[] resources, int[] overdueDays) {

        double totalFine = 0;

        for (int i = 0; i < resources.length; i++) {

            if (resources[i] != null
                    && InputValidator.validateFineDays(overdueDays[i])) {

                totalFine += resources[i]
                        .calculateFine(overdueDays[i]);
            }
        }

        return totalFine;
    }
}