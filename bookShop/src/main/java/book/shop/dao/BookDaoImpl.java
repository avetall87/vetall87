package book.shop.dao;

import book.shop.model.Author;
import book.shop.model.Book;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by виталий on 01.11.2015.
 */
public class BookDaoImpl implements BookDao {

    private static final Logger log = Logger.getLogger(BookDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public long createNewBook(long isbn, Author author, String name) {
        return 0;
    }

    public void updateBook(long isbn, Book book) {

    }

    public void deleteBook(long isbn) {

    }

    public Book getBookByIsbn(long isbn) {
        return null;
    }

    public List<Book> getAllBooks() {
        return null;
    }
}
