package book.shop.dao;

import book.shop.model.Author;
import book.shop.model.Book;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;
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

    public Book getBookByIsbn(int isbn) {
        log.info("find book by isbn"+isbn);
        String sql = "SELECT * FROM book where isbn=?";
        return jdbcTemplate.queryForObject(sql, new BookMapper(), new Integer[]{isbn});
    }

    public List<Book> getAllBooks() {
        return null;
    }

    private static class BookMapper implements RowMapper<Book> {

        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Book book = new Book(rs.getInt("isbn"),rs.getInt("author_id"),rs.getString("name"));
            return book;
        }
    }
}
