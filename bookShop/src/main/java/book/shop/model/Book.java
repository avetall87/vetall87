package book.shop.model;

/**
 * Created by виталий on 01.11.2015.
 */
public class Book {
    private int isbn;
    private int autorId;
    private String name;

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public long getAutor() {
        return autorId;
    }

    public void setAutor(int autorId) {
        this.autorId = autorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Default constructor
     * @param isbn new isbn
     * @param autorId author who write this book
     * @param name name of book
     */
    public Book(int isbn, int autorId, String name) {
        this.isbn = isbn;
        this.autorId = autorId;
        this.name = name;
    }
}
