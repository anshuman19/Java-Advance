import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;
 public class Profile extends HttpServlet
{

public void service(HttpServletRequest req,HttpServletResponse res)
{
	PrintWriter out=null;
	try
	{
		out=res.getWriter();
		res.setContentType("text/html");
		String e=req.getParameter("email");
		out.println("<html><body>");
		out.println("<h1>Login Logout App</h1>");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","incapp");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from user_id where email='"+e+"'");
		if(rs.next())
		{
		String n=rs.getString(3);
		String ph=rs.getString(4);
		int a=rs.getInt(5);
		out.println("Welcome"+n);
		out.println("Email_Id:<b>"+e+"</b><br>");
		out.println("Name:<b>"+n+"</b><br>");
		out.println("Phone:<b>"+ph+"</b><br>");
		out.println("Age:<b>"+a+"</b><br>");
		out.println("<a href='index.html'>Logout</a>");
		}
		
		out.println("</body></htlm>");
		con.close();
		out.close();
	}
	catch(Exception e)
	{
		out.close();
		out.println(e);
	}
	
}
}

