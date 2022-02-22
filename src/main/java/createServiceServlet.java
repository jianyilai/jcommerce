

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/createServiceServlet")
public class createServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createServiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		//Step 1: Initialize a PrintWriter object to return the html values via the response
		PrintWriter out = response.getWriter();
		String n = request.getParameter("serviceName");
		String p = request.getParameter("serviceImage");
		String e = request.getParameter("servicePrice");
		String c = request.getParameter("serviceDescription");
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection(
			 "jdbc:mysql://localhost:3306/account", "root", "password");
			 PreparedStatement ps = con.prepareStatement("insert into services values(?,?,?,?)");
			 ps.setString(1, n);
			 ps.setString(2, p);
			 ps.setString(3, e);
			 ps.setString(4, c);
			//Step 6: perform the query on the database using the prepared statement
			 int i = ps.executeUpdate();
			//Step 7: check if the query had been successfully execute, return “You are successfully
			//registered” via the response,
			 if (i > 0){
				 PrintWriter writer = response.getWriter();
				 writer.println("<h1>" + "You have successfully created a service!" +
				 "</h1>");
				 writer.close();
				 }
				 }
				 //Step 8: catch and print out any exception
				 catch (Exception exception) {
				  System.out.println(exception);
				  out.close();
				 }
				 doGet(request, response);
			 }
	}
	


