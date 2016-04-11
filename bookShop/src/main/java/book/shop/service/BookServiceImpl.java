package book.shop.service;

import book.shop.dao.BookDao;
import book.shop.model.Author;
import book.shop.model.Book;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by виталий on 01.11.2015.
 */
@Transactional
public class BookServiceImpl implements BookService {

    private static final Logger log = Logger.getLogger(BookServiceImpl.class);

    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @Transactional
    public long createNewBook(long isbn, Author author, String name) {
       return bookDao.createNewBook(isbn, author, name);
    }

    @Override
    @Transactional
    public void updateBook(long isbn, Book book) {
        bookDao.updateBook(isbn, book);
    }

    @Override
    @Transactional
    public void deleteBook(long isbn) {
        bookDao.deleteBook(isbn);
    }

    @Override
    public Book getBookByIsbn(int isbn) {
        System.out.println("isbn = "+isbn);
        log.info("isbn = "+isbn);
        return bookDao.getBookByIsbn(isbn);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }
}
