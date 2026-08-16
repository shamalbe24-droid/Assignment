package library.model;

public class DigitalResource extends LibraryResource implements Printable {

    public DigitalResource(int resourceId, String title, String author) {
        super(resourceId, title, author);
    }

    @Override
    public double calculateFine(int overdueDays) {

        if (overdueDays < 0) {
            return 0;
        }

        return overdueDays * 2.0;
    }

    @Override
    public void printDetails() {

        displayLibraryName();

        System.out.println("Resource Type : Digital Resource");
        System.out.println("Resource ID   : " + getResourceId());
        System.out.println("Title         : " + getTitle());
        System.out.println("Author        : " + getAuthor());
    }
}