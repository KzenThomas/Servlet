package servletTest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class MyServlet extends HttpServlet{
	
	static int counter = 0;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		counter++;
		resp.setContentType("text/html");
		resp.getWriter().println("<html><head>title>Hello World! " + counter + "</title><head>");
		resp.getWriter().println("<body><h1>hallo mitch lukt het ook bij jou refresh deze pagina danku! " + counter + "</h1></body></html>");
		resp.getWriter().println();
		resp.getWriter().close();
 	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}