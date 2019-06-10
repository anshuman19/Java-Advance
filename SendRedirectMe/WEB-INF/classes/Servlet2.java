import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;
 public class Servlet2 extends HttpServlet
{

public void service(HttpServletRequest req,HttpServletResponse res)
{
	PrintWriter out=null;
	try
	{
		out=res.getWriter();
		res.setContentType("text/html");
		String n=req.getParameter("name");
		out.println("<html><body>");
		out.println("<h1>My Web app</h1>");
		out.println("hello servlet2<br>");
		out.println("Name="+n);
		out.println("Bye Servlet2");
		out.println("</body></html>");
		out.close();
	}
	catch(Exception e)
	{
		out.close();
		out.println(e);
	}
	
}
}
