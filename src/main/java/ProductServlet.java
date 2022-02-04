import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jcommerce.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Step 1: Prepare list of variables used for database connections
	private String jdbcURL = "jdbc:mysql://localhost:3306/products";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";

	// Step 2: Prepare list of SQL prepared statements to perform CRUD
	private static final String INSERT_PRODUCTS_SQL = "INSERT INTO PRODUCTS"
			+ " (productName, productImage, productPrice, productDescription) VALUES " + " (?, ?, ?);";
	private static final String SELECT_PRODUCT_BY_ID = "select productName, productImage, productPrice, productDescription from PRODUCTS where productName =?";
	private static final String SELECT_ALL_PRODUCTS = "select * from products";
	private static final String DELETE_PRODUCTS_SQL = "delete from PRODUCTS where productName = ?;";
	private static final String UPDATE_PRODUCTS_SQL = "update PRODUCTS set productName = ?,productImage= ?, productPrice =?, productDescription =? where productName = ?;";

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

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		// Step 4: Depending on the request servlet path, determine the function to
		// invoke using the follow switch statement.
		String action1 = request.getServletPath();
		try {
			switch (action1) {
			case "/ProductServlet/delete":
			deleteProduct(request, response);
			break;
			case "/ProductServlet/edit":
			showEditForm(request, response);
			break;
			case "/ProductServlet/update":
			updateProduct(request, response);
			break;
			case "/ProductServlet/dashboard":
			listProducts(request, response);
			break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	// method to update the user table base on the form data
	private void updateProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		// Step 1: Retrieve value from the request
		String oriProduct = request.getParameter("oriProduct");
		String productName = request.getParameter("productName");
		String productImage = request.getParameter("productImage");
		String productPrice = request.getParameter("productPrice");
		String productDescription = request.getParameter("productDescription");

		// Step 2: Attempt connection with database and execute update user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCTS_SQL);) {
			statement.setString(1, productName);
			statement.setString(2, productImage);
			statement.setString(3, productPrice);
			statement.setString(4, productDescription);
			statement.setString(5, oriProduct);
			int i = statement.executeUpdate();
		}

		// Step 3: redirect back to ProductServlet
		response.sendRedirect("http://localhost:8090/jcommerce/ProductServlet/dashboard");
	}

	// Step 5: listProducts function to connect to the database and retrieve all
	// product records

	private void listProducts(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Product> products = new ArrayList<>();
		try (Connection connection = getConnection();

				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);) {
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				String productName = rs.getString("productName");
				String productImage = rs.getString("productImage");
				String productPrice = rs.getString("productPrice");
				String productDescription = rs.getString("productDescription");
				products.add(new Product(productName, productImage, productPrice, productDescription));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}

		// Step 5.4: Set the users list into the listUsers attribute to be pass to the
		// userManagement.jsp
		request.setAttribute("listProducts", products);
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

	// method to get parameter, query database for existing user data and redirect
	// to product edit page
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// get parameter passed in the URL
		String productName = request.getParameter("productName");
		Product existingProduct = new Product("", "", "", "");

		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
			preparedStatement.setString(1, productName);

			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object
			while (rs.next()) {
				productName = rs.getString("productName");
				String productImage = rs.getString("productImage");
				String productPrice = rs.getString("productPrice");
				String productDescription = rs.getString("productDescription");
				existingProduct = new Product(productName, productImage, productPrice, productDescription);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5: Set exisitngProduct to request and serve up the productEdit form
		request.setAttribute("product", existingProduct);
		request.getRequestDispatcher("/productEdit.jsp").forward(request, response);
	}

	// method to delete product
	private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		// Step 1: Retrieve value from the request
		String productName = request.getParameter("productName");

		// Step 2: Attempt connection with database and execute delete user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCTS_SQL);) {
			statement.setString(1, productName);
			int i = statement.executeUpdate();
		}

		// Step 3: redirect back to UserServlet dashboard (note: remember to change the
		// url to your project name)
		response.sendRedirect("http://localhost:8090/jcommerce/ProductServlet/dashboard");
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

}
