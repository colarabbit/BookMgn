/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @author Derrick
 *  Edited by: Kira
 */

package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Book;
import utils.Response;
import dao.DBConnector;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

  
    private Statement statement;
    
    public BookDao(Connection conn) throws ClassNotFoundException, SQLException {
        statement = conn.createStatement();
    }
    
    public BookDao() throws SQLException, ClassNotFoundException{
        statement = DBConnector.getConnector().openConnection().createStatement();
    }
    
   
    
    public Response addBook(Book book) throws SQLException {
        
        if((book.getAuthor().trim().length()==0 )|| (book.getPublisher().trim().length()==0) ||( book.getTitle().trim().length()==0)){
            return new Response(false,"FIELDS CAN NOT BE EMPTY");
        }
        
        ResultSet result = statement.executeQuery("SELECT * from TBL_BOOK WHERE BOOKID="+book.getBookId());
        if (result.next()) {
             return new Response(false,"BOOKID: {"+book.getBookId()+"}  Already Exist");
        }
       
     
        String sql = "INSERT INTO TBL_BOOK (BOOKID, TITLE, AUTHOR, PUBLISHER) ";
        sql += "VALUES (" + book.getBookId() + ", '" + book.getTitle() + "', '" + book.getAuthor() + "', '" + book.getPublisher()+"' )";
        if(statement.executeUpdate(sql)>0){
            return new Response(true,"SUCCESS");
        }
        return new Response(false,"INSERT ERROR");
       
    }
    
    /**
     * get all orders of user
     * */
    public List<Book> selectAllBooks() throws SQLException {
        List<Book> res = new ArrayList<>();
        PreparedStatement ps;
        String sql = "SELECT * FROM TBL_BOOK ";
        
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()){
            Book tmp = new Book();
            tmp.setAuthor(rs.getString("AUTHOR"));
            tmp.setBookId(rs.getInt("BOOKID"));
            tmp.setPublisher(rs.getString("PUBLISHER"));
            tmp.setTitle(rs.getString("TITLE"));
            res.add(tmp);
        }
        return res;
    }
   
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
    
        DBConnector db = new DBConnector();
        BookDao dao = new BookDao(db.openConnection());
        Book book = new Book();
        book.setAuthor("");
        book.setBookId(1);
        book.setPublisher("abc");
        book.setTitle("abc");
        for(Book tmp:dao.selectAllBooks())
            System.out.println(tmp.toString());
    }

}
