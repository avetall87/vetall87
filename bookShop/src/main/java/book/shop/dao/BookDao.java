package book.shop.dao;

import book.shop.model.Author;
import book.shop.model.Book;

import java.util.List;

/**
 * Created by виталий on 01.11.2015.
 */
public interface BookDao {

    public long createNewBook(long isbn, Author author,String name);

    public void updateBook (long isbn,Book book);

    public void deleteBook (long isbn);

    public Book getBookByIsbn (int isbn);

    public List<Book> getAllBooks();

}
