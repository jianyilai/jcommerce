package jcommerce;
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
 * Servlet implementation class locationServlet
 */
@WebServlet("/locationServlet")
public class locationServlet extends HttpServlet {

	// Step 1: Prepare list of variables used for database connections
	private String jdbcURL = "jdbc:mysql://localhost:3306/jcommerce";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	// Step 2: Prepare list of SQL prepared statements to perform CRUD to our
	// database
	private static final String INSERT_LOCATION_SQL = "INSERT INTO shop_location"
			+ " (shopName, shopImage, shopLocation, shopDescription) VALUES " + " (?, ?, ?);";
	private static final String SELECT_LOCATION_BY_ID = "select shopName,shopImage,shopLocation,shopDescription from shop_location where shopName =?";
	private static final String SELECT_ALL_LOCATION = "select * from shop_location ";
	private static final String DELETE_LOCATION_SQL = "delete from shop_location where shopName = ?;";
	private static final String UPDATE_LOCATION_SQL = "update shop_location set shopName = ?,shopImage= ?, shopLocation =?,shopDescription =? where shopName = ?;";

	// Step 3: Implement the getConnection method which facilitates connection to
	// the database via JDBC
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

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public locationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
				listLocations(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

		// TODO Auto-generated method stub
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

	private void listLocations(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<location> locations = new ArrayList<>();
		try (Connection connection = getConnection();
				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LOCATION);) {
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				String shopName = rs.getString("shopName");
				String shopImage = rs.getString("shopImage");
				String shopLocation = rs.getString("shopLocation");
				String shopDescription = rs.getString("shopDescription");
				locations.add(new location(shopName, shopImage, shopLocation, shopDescription));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5.4: Set the users list into the listUsers attribute to be pass to the
		// userManagement.jsp
		request.setAttribute("listLocations", locations);
		request.getRequestDispatcher("/view_all_shops.jsp").forward(request, response);
	}

}
