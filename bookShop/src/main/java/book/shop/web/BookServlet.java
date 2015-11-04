package book.shop.web;


import book.shop.model.Book;
import book.shop.service.BookService;
import book.shop.service.BookServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by виталий on 04.11.2015.
 */
public class BookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String isbn = req.getParameter("isbn");
        PrintWriter out = resp.getWriter();

        try {
            WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
            BookService bookService = (BookService) ctx.getBean("bookService");
            Book book = bookService.getBookByIsbn(Integer.parseInt(isbn));

            book.getName().toLowerCase();

            out.write("<html><head><title>My First Servlet Response</title></head><body><h1>Book is  " + book.getName() + "</h1></body></html>");

        } finally {
            out.close();
        }
    }
}
