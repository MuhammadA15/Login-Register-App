

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher view = req.getRequestDispatcher("/Register.jsp");
		view.forward(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname", "username", "password");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM credentials WHERE email = '" + username + "'");
			ResultSet rs = ps.executeQuery();
			System.out.println("Checking for existing users");
			if(rs.absolute(1)) {
				RequestDispatcher view = req.getRequestDispatcher("/RegistrationError.jsp");
				view.forward(req, res);
			}
			else {
				PreparedStatement ps2 = conn.prepareStatement("INSERT INTO credentials VALUES('" + username + "'" + ", " + "'" + password + "'" + ")");
				ps2.executeUpdate();
				RequestDispatcher view = req.getRequestDispatcher("/HomePage.jsp");
				view.forward(req, res);
				System.out.println("New user registered!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
