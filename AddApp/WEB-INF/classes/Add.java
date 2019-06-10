import javax.servlet.*;
import java.io.*;
 public class Add implements Servlet
{
public void init(ServletConfig con)
{
}
public void service(ServletRequest req,ServletResponse res)
{
	PrintWriter out=null;
	try
	{
		out=res.getWriter();
		res.setContentType("text/html");
		String s1=req.getParameter("num1");
		String s2=req.getParameter("num2");
		int n1=Integer.parseInt(s1);
		int n2=Integer.parseInt(s2);
		int n=n1+n2;
		out.println("<html><body>");
		out.println("<h1>My first add app</h1>");
		out.println("hello servlet<br>");
		out.println("Sum of <b>"+n1+"</b> and <b>"+n2+"</b>=<b>"+n+"</b>");
		out.println("</body></htlm>");
		out.close();
	}
	catch(Exception e)
	{
		out.close();
		out.println(e);
	}
	
}
public void destroy()
{
	
}
public ServletConfig getServletConfig()
{
	return null;
}
public String getServletInfo()
{
	return null;
}
}	