public class Library {
    private String libraryName;
    private Book[] books;
    private int bookCount;

    public Library(String libraryName, int capacity) {
        this.libraryName = libraryName;
        this.books = new Book[capacity];
        this.bookCount = 0;
    }

    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount] = book;
            bookCount++;
            System.out.println("Added to " + libraryName + ": " + book.getTitle());
        }
    }

    public void displayAllBooks() {
        System.out.println("=== Books in " + libraryName + " ===");
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            String availability = book.isAvailable() ? "(Available)" : "(Checked Out)";
            System.out.println(book.getBookInfo() + " - " + availability);
        }
    }

    public int getBookCount() {
        return bookCount;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public Book findBookByTitle(String title) {
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            if (book.getTitle().equals(title)) {
                System.out.println("Found: " + book.getTitle());
                return book;
            }
        }
        System.out.println("Book not found: " + title);
        return null;
    }

    public Book[] findBooksByAuthor(String authorName) {
        Book[] temp = new Book[bookCount];
        int count = 0;
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            if (book.getAuthor().getName().equals(authorName)) {
                temp[count] = book;
                count++;
            }
        }
        System.out.println("Found " + count + " book(s) by " + authorName);
        Book[] result = new Book[count];
        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    public Book[] findAvailableBooks() {
        Book[] temp = new Book[bookCount];
        int count = 0;
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            if (book.isAvailable()) {
                temp[count] = book;
                count++;
            }
        }
        System.out.println("Found " + count + " available book(s)");
        Book[] result = new Book[count];
        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    public void displaySearchResults(Book[] results, String searchType) {
        System.out.println("=== Search Results: " + searchType + " ===");
        boolean hasResults = false;
        for (Book book : results) {
            if (book != null) {
                hasResults = true;
                String availability = book.isAvailable() ? "(Available)" : "(Checked Out)";
                System.out.println(book.getBookInfo() + " - " + availability);
            }
        }
        if (!hasResults) {
            System.out.println("No books found");
        }
    }

    public static void main(String[] args) {
        Author orwell = new Author("George Orwell", 1903, "British");
        Author rowling = new Author("J.K. Rowling", 1965, "British");
        Author tolkien = new Author("J.R.R. Tolkien", 1892, "British");
        Author austen = new Author("Jane Austen", 1775, "British");

        Book book1 = new Book("1984", orwell, "978-0451524935", 328);
        Book book2 = new Book("Harry Potter and the Sorcerer's Stone", rowling, "978-0590353427", 309);
        Book book3 = new Book("The Hobbit", tolkien, "978-0547928227", 310);
        Book book4 = new Book("Animal Farm", orwell, "978-0451526342", 112);
        Book book5 = new Book("Pride and Prejudice", austen, "978-0141439518", 279);
        Book book6 = new Book("The Lord of the Rings", tolkien, "978-0544003415", 1178);

        Library library = new Library("City Central Library", 10);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);

        System.out.println();
        library.displayAllBooks();

        System.out.println();
        book1.checkOut();

        System.out.println();
        library.displayAllBooks();

        System.out.println();
        book1.returnBook();

        System.out.println("\n--- Testing Search Functions ---");

        System.out.println();
        Book found = library.findBookByTitle("1984");

        System.out.println();
        Book[] orwellBooks = library.findBooksByAuthor("George Orwell");
        library.displaySearchResults(orwellBooks, "Books by George Orwell");

        System.out.println();
        book2.checkOut();
        Book[] available = library.findAvailableBooks();
        library.displaySearchResults(available, "Available Books");

        System.out.println();
        library.findBookByTitle("Nonexistent Book");
    }
}