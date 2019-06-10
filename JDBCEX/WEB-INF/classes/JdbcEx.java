import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;
 public class JdbcEx extends HttpServlet
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
		out.println("<h1>JDBC Example</h1>");
		out.println("hello servlet<br>");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","incapp");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from user_id where email='"+e"'");
		if(rs.next())
		{
		String s1=rs.getString(3);
		String s2=rs.getString(4);
		int a1=rs.getInt(5);
		out.println("Email_Id:<b>"+e+"</b><br>");
		out.println("Name:<b>"+s1+"</b><br>");
		out.println("Phone:<b>"+s2+"</b><br>");
		out.println("Age:<b>"+a1+"</b><br>");
		}
		else
		{
		out.println("Wrong id");
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
