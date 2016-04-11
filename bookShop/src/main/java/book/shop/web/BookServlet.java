package book.shop.web;

import book.shop.model.Book;
import book.shop.service.BookService;
import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BookServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(BookServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        PrintWriter out = resp.getWriter();
        log.info("before context");
//        try {
//            WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
//
//            BookService bookService = (BookService) ctx.getBean("bookService");
//
//            List<Book> books = bookService.getAllBooks();
//
//            out.write("Length list = "+books.size());
//
//            for (Book book:books) {
//                out.write("<html><head><title>My First Servlet Response</title></head><body><h1>Book is  " + book.getName() + "</h1></body></html>");
//            }
//        } finally {
//            out.close();
//        }
    }
}
