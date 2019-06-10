import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;
 public class Register extends HttpServlet
{

public void service(HttpServletRequest req,HttpServletResponse res)
{
	PrintWriter out=null;
	try
	{
		out=res.getWriter();
		res.setContentType("text/html");
		String e=req.getParameter("email");
		String n=req.getParameter("name");
		String ph=req.getParameter("phone");
		int a=Integer.parseInt(req.getParameter("age"));
		String p=req.getParameter("pass");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","incapp");
		Statement st=con.createStatement();
		int x=st.executeUpdate("insert into user_id values('"+e+"','"+p+"','"+n+"','"+ph+"','"+a+"')");
		if(x==1)
		{
		//	con.close();
			RequestDispatcher rd=req.getRequestDispatcher("Profile");
			rd.forward(req,res);
		}
		else
		{
		//con.close();
		res.sendRedirect("RegisterError.html");
		}
		
		//out.close();
	}catch(SQLIntegrityConstraintViolationException ex)
	{
	 try{
	     res.sendRedirect("RegisterError2.html");
		}
	 catch(Exception e){
	    out.close();
		out.println(e);
		}
	}
	catch(Exception e)
	{
		out.close();
		out.println(e);
	}
	
}
}
