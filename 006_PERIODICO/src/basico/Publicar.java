package basico;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Publicar
 */
@WebServlet("/Publicar")
public class Publicar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final String URL = "jdbc:mysql://localhost:3306/periodico";
	private final String USER = "root";
	private final String PASS = "";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		int categoria = Integer.parseInt(request.getParameter("categoria"));
		String titulo = request.getParameter("titulo");
		String contenido = request.getParameter("contenido");
		
		
			
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection(URL, USER, PASS);
				PrintWriter out = response.getWriter();
				
				String query = "insert into noticias (mail,idcategoria,titulo,contenido) values (?,?,?,?)";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, email);
				ps.setInt(2, categoria);
				ps.setString(3, titulo);
				ps.setString(4, contenido);
				
				out.println("Se ha insertado tu noticia correctamente<br/>");
				out.println("<a href='leer.jsp'>Volver a las noticias</a>");
				System.out.println("Registros insertados ----> " + ps.executeUpdate());
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
	}

}
