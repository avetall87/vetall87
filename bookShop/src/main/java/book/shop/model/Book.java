package book.shop.model;

/**
 * Created by виталий on 01.11.2015.
 */
public class Book {
    private long isbn;
    private Author autor;
    private String name;

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public Author getAutor() {
        return autor;
    }

    public void setAutor(Author autor) {
        this.autor = autor;
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
     * @param autor author who write this book
     * @param name name of book
     */
    public Book(long isbn, Author autor, String name) {
        this.isbn = isbn;
        this.autor = autor;
        this.name = name;
    }
}
