
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServiceServlet
 */
@WebServlet("/ServiceServlet")
public class ServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServiceServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Step 1: Prepare list of variables used for database connections
	private String jdbcURL = "jdbc:mysql://localhost:3306/servicedetails";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	private static final String INSERT_SERVICES_SQL = "INSERT INTO services"
			+ "(serviceName, serviceImage, servicePrice, serviceDescription) VALUES " + " (?, ?, ?);";
	private static final String SELECT_SERVICE_BY_ID = "select serviceName,serviceImage,servicePrice,serviceDescription from services where serviceName =?";
	private static final String SELECT_ALL_SERVICES = "select * from services ";
	private static final String DELETE_SERVICES_SQL = "delete from services where serviceName = ?;";
	private static final String UPDATE_SERVICES_SQL = "update services set serviceName = ?,serviceImage= ?,servicePrice =?,serviceDescription =? where serviceName = ?;";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Step 4: Depending on the request servlet path, determine the function to
		// invoke using the
		// follow switch statement.
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/insert":
				break;
			case "/delete":
				break;
			case "/edit":
				break;
			case "/update":
				break;
			default:
				listServices(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	// Step 5: listUsers function to connect to the database and retrieve all users
	// records
	private void listServices(HttpServletRequest request, HttpServletResponse response)
			   throws SQLException, IOException, ServletException
			   {
			   List <service> services = new ArrayList <>();
			    try (Connection connection = getConnection();
			    		// Step 5.1: Create a statement using connection object
			    		 PreparedStatement preparedStatement =
			    		connection.prepareStatement(SELECT_ALL_SERVICES);) {
			    	// Step 5.2: Execute the query or update query
			    	 ResultSet rs = preparedStatement.executeQuery();
			    	// Step 5.3: Process the ResultSet object.
			    	 while (rs.next()) {
			    	 String serviceName = rs.getString("serviceName");
			    	 String serviceImage = rs.getString("serviceImage");
			    	 String servicePrice = rs.getString("servicePrice");
			    	 String serviceDescription = rs.getString("serviceDescription");
			    	 services.add(new service(serviceName, serviceImage, servicePrice, serviceDescription));
			    	 }
			    	 } catch (SQLException e) {
			    	 System.out.println(e.getMessage());
			    	 }
			 // Step 5.4: Set the users list into the listUsers attribute to be pass to the serviceManagement.jsp
			    request.setAttribute("listServices", services);
			    request.getRequestDispatcher("/serviceManagement.jsp").forward(request, response);
			    }

}
