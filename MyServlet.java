package servletTest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;	
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class MyServlet extends HttpServlet {
	Connection dbconnection;

	public MyServlet() {
		try {
			dbconnection = DriverManager.getConnection("jdbc:sqlite:C:\\\\Users\\\\tbaselmans\\\\AppData\\\\Roaming\\\\DBeaverData\\\\workspace6\\\\.metadata\\\\sample-database-sqlite-1\\\\Chinook.db");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	static int counter = 0;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		counter++;
		resp.setContentType("text/html");
		resp.getWriter().println("<html><head>title>Hello World! " + counter + "</title><head>");
		resp.getWriter().println("<body><h1>hallo mitch lukt het ook bij jou refresh deze pagina danku! " + counter
				+ "</h1></body></html>");
		resp.getWriter().println();
		resp.getWriter().close();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}