package basico;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Consultar")
public class Consultar extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private final String URL = "jdbc:mysql://localhost:3306/periodico";
	private final String USER = "root";
	private final String PASS = "";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Servlet Levantado");
		
		
		try {
			PrintWriter out = response.getWriter();
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			
			Statement stmt = conn.createStatement();
			ResultSet rs  = stmt.executeQuery("Select * from noticias");
			
			String resultado = "";
			
			while(rs.next()) {
				resultado += "<tbody><tr><td>" + rs.getString(2) + "</td>";				
				resultado += "<td>" + rs.getString(4) + "</td>";
				resultado += "<td>" + rs.getString(5) + "</td>";
				resultado += "<td>" + rs.getString(6) + "</td></tr><tbody>";
			}
			
			request.getSession().setAttribute("resultado", resultado);
			
			//request.getRequestDispatcher("leer.jsp").forward(request, response);
			response.sendRedirect("leer.jsp");
			
		
		} catch (ClassNotFoundException e) {
			System.out.println("Fallo al cargar el driver");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
