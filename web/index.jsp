<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String resp = (String) session.getAttribute("resp"); %>
<%@page import="dao.*"%>
<%@page import="model.Book"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; carset=UTF-8">
                <link rel="stylesheet" href="stylesheet.css">
		<title>Login Page</title>
	</head>
	<body>
            <div class="header">
                <a href="#default" class="logo">&#10070 &#8464BookMgn</a>
            </div>
            <div class="container">
		<h1>Insert Book Info</h1>
		<form method="post" action="BookServlet">
			<table>
				<tr><td>Book ID</td><td><input type="text" placeholder="Enter bookid" name="bookid"></td></tr>
				<tr><td>Title</td><td><input type="text" placeholder="Enter title" name="title"></td></tr>
                                <tr><td>Author</td><td><input type="text" placeholder="Enter author" name="author"></td></tr>
                                <tr><td>Publisher</td><td><input type="text" placeholder="Enter publisher" name="publisher"></td></tr>
                                <tr><td><input class="button" type="submit" value="Submit"></td></tr>
                                <tr><td><font color="red"><% if (resp != null) { %> <%=resp%> <%}%></font> <td></tr>
                        </table>
                      
		</form>
            </div>
                        
                          <!-- Order Dashboard -->
        <!-- Includes: 1. show user's order info; 2. cancel user's order order -->
        <div class="container">
            <h1>Books Dashboard</h1>
            <table class="table">
                <thead>
                <th>Book ID</th>
                <th>Book Author</th>
                <th>Book Title</th>
                <th>Book Publisher</th>
               
                </thead>
                <tbody>
                    <%
                        BookDao bookdao = new BookDao();
                        List<Book> res = bookdao.selectAllBooks();

                    %>
                    <%   for (Book o : res) {
                    %>
                    <tr>
                        <td><%=o.getBookId()%></td>
                        <td><%=o.getAuthor()%></td>
                        <td><%=o.getTitle()%></td>
                        <td><%=o.getPublisher()%></td>
                       
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
       
        </div>
	</body>
</html>