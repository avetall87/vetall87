package book.shop.service;

import book.shop.dao.BookDao;
import book.shop.model.Author;
import book.shop.model.Book;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by виталий on 01.11.2015.
 */
public class BookServiceImpl implements BookService {

    private static final Logger log = Logger.getLogger(BookServiceImpl.class);

    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        log.info("Book dao was init !!!");
        this.bookDao = bookDao;
    }

    @Override
    public long createNewBook(long isbn, Author author, String name) {
       return bookDao.createNewBook(isbn, author, name);
    }

    @Override
    public void updateBook(long isbn, Book book) {
        bookDao.updateBook(isbn, book);
    }

    @Override
    public void deleteBook(long isbn) {
        bookDao.deleteBook(isbn);
    }

    @Override
    public Book getBookByIsbn(long isbn) {
        return bookDao.getBookByIsbn(isbn);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }
}
