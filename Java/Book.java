public class Book {
    private String title;
    private Author author;
    private String isbn;
    private int pages;
    private boolean isAvailable;

    public Book(String title, Author author, String isbn, int pages) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPages() {
        return pages;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void checkOut() {
        isAvailable = false;
        System.out.println("Book checked out: " + title);
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println("Book returned: " + title);
    }

    public String getBookInfo() {
        return "Title: " + title + " by " + author.getName() + " (" + author.getNationality() + ")";
    }
}