

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read from data
		String facId =req.getParameter("facId");
		try {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/faculty","root","Devika@16");
			  Statement st =con.createStatement();
			  int n=0;
			  n= st.executeUpdate("delete from facultydata where facId="+facId);
			  pw.println("<html><body>");
			  if(n>=1)
				  pw.println("<html><body background='home.jpg' style='background-repeat:no-repeat;background-size:cover'><div style='color:white;font-size:50px;margin-left:300px;margin-top:300px'><b>details of faculty whose id is "+facId+ " are deleted</b></div>");
				 
				
			  else
				  pw.println("<html><body background='home.jpg' style='background-repeat:no-repeat;background-size:cover'><div style='color:white;font-size:50px;margin-left:380px;margin-top:300px'><b>faculty details are not found</b></div>");
			  pw.println("<br><div style='padding-left:550px;color:white'>back to home page<a href='home.html' style='color:#7FE9DE'>clickhere</a></div><br>");
			  pw.println("</html></body>");
		
			  st.close();
			  con.close();
		}
		catch(Exception e)	
		{
			e.printStackTrace();
		}
		pw.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
