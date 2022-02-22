
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
	private String jdbcURL = "jdbc:mysql://localhost:3306/account";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";

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
			case "/ServiceServlet/delete":
				deleteService(request, response);
				break;
			case "/ServiceServlet/edit":
				showEditForm(request, response);
				break;
			case "/ServiceServlet/update":
				updateService(request, response);
				break;
			case "/ServiceServlet/dashboard":
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
			throws SQLException, IOException, ServletException {
		List<service> services = new ArrayList<>();
		try (Connection connection = getConnection();
				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICES);) {
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
		// Step 5.4: Set the users list into the listUsers attribute to be pass to the
		// serviceManagement.jsp
		request.setAttribute("listServices", services);
		request.getRequestDispatcher("/serviceManagement.jsp").forward(request, response);
	}

	// method to get parameter, query database for existing user data and redirect
	// to user edit page
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// get parameter passed in the URL
		String serviceName = request.getParameter("serviceName");
		service existingService = new service("", "", "", "");

		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE_BY_ID);) {
			preparedStatement.setString(1, serviceName);
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				serviceName = rs.getString("serviceName");
				String serviceImage = rs.getString("serviceImage");
				String servicePrice = rs.getString("servicePrice");
				String serviceDescription = rs.getString("serviceDescription");
				existingService = new service(serviceName, serviceImage, servicePrice, serviceDescription);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5: Set existingUser to request and serve up the userEdit form
		request.setAttribute("service", existingService);
		request.getRequestDispatcher("/serviceEdit.jsp").forward(request, response);
	}

	// method to update the user table base on the form data
	private void updateService(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		String oriName = request.getParameter("oriName");
		String serviceName = request.getParameter("serviceName");
		String serviceImage = request.getParameter("serviceImage");
		String servicePrice = request.getParameter("servicePrice");
		String serviceDescription = request.getParameter("serviceDescription");

		// Step 2: Attempt connection with database and execute update user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_SERVICES_SQL);) {
			statement.setString(1, serviceName);
			statement.setString(2, serviceImage);
			statement.setString(3, servicePrice);
			statement.setString(4, serviceDescription);
			statement.setString(5, oriName);
			int i = statement.executeUpdate();
		}
		// Step 3: redirect back to UserServlet (note: remember to change the url to
		// your project
		// name)
		response.sendRedirect("http://localhost:8090/jcommerce/ServiceServlet/dashboard");
	}

	// method to delete user
	private void deleteService(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		String serviceName = request.getParameter("serviceName");// Step 2: Attempt connection with database and execute
																// delete user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_SERVICES_SQL);) {
			statement.setString(1, serviceName);
			int i = statement.executeUpdate();
		}
		// Step 3: redirect back to UserServlet dashboard (note: remember to change the
		// url to
		// your project name)
		response.sendRedirect("http://localhost:8090/jcommerce/ServiceServlet/dashboard");
	}

}
