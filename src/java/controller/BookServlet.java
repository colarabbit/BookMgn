package controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Book;
import dao.*;
import utils.Response;


public class BookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
       
        String bookid = request.getParameter("bookid");
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String publisher = request.getParameter("publisher");
        session.setAttribute("resp", null);
        //generate book 
        Book book = new Book();
        book.setAuthor(author);
        book.setBookId(Integer.parseInt(bookid));
        book.setPublisher(publisher);
        book.setTitle(title);
        try {
            //dao
            BookDao dao = new BookDao(DBConnector.getConnector().openConnection());
            Response resp = dao.addBook(book);
            session.setAttribute("resp", resp.getMsg());
            request.getRequestDispatcher("index.jsp").include(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
