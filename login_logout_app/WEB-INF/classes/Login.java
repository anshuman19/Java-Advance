import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;
 public class Login extends HttpServlet
{

public void service(HttpServletRequest req,HttpServletResponse res)
{
	PrintWriter out=null;
	try
	{
		out=res.getWriter();
		res.setContentType("text/html");
		String e=req.getParameter("email");
		String p=req.getParameter("pass");

		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","incapp");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from user_id where email='"+e+"' and password='"+p+"'");
		if(rs.next())
		{
			con.close();
			RequestDispatcher rd=req.getRequestDispatcher("Profile");
			rd.forward(req,res);
		}
		else
		{
		con.close();
		res.sendRedirect("LoginError.html");
		}
		
		out.close();
	}
	catch(Exception e)
	{
		out.close();
		out.println(e);
	}
	
}
}
