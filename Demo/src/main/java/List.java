

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
 * Servlet implementation class List
 */
@WebServlet("/List")
public class List extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=res.getWriter();
		//set res type
		res.setContentType("text/html");
		//read from data
		//String facId =req.getParameter("facId");
		//pw.println("hi");
		
		
		try {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/faculty","root","Devika@16");
			  Statement st =con.createStatement();
			  ResultSet rs = st.executeQuery("select * from facultydata");
			 pw.println("<html><body background='https://img.freepik.com/free-photo/ready-back-school_1134-12.jpg?w=2000' style='color:white;background-repeat:no-repeat;background-size:cover'>");
			pw.println("<h1 align='center'>Facutly Details</h1>");
		    pw.println("<table border=1 width=50% height=50% cellpadding=15 cellspacing=0 align='center' style='font-size:17px;border-color:white'>");
			//pw.println("<tr><td>FacId</td><td>Name</td><td>Gender</td><td>Designation</td><td>Date_of_birth</td><td>phno</td><td>Email</td><td>Address</td><td>Education</td><td>WorkExperience</td></tr>");
			pw.println("<tr><td>FacId</td><td>Name</td><td>Gender</td><td>Designation</td><td>view</td><td>update</td><td>delete</td></tr>");
			while(rs.next()){
				 String id=rs.getString(1);
				String name=rs.getString(2);
				String gender=rs.getString(3);
				String desi=rs.getString(4);
				String dob=rs.getString(5);
				String phno=rs.getString(6);
				String email=rs.getString(7);
				String add=rs.getString(8);
				String edu=rs.getString(9);
				String we=rs.getString(10);
				pw.println("<tr><td>"+id+"</td><td>"+name+"</td><td>"+gender+"</td><td>"+desi+"</td>");
				pw.println("<td><form action='Login' method='post'>");
				pw.println("<input type='hidden' value="+id+" name='facId'>");
				pw.println("<input type='submit' value='view'></form>");
				pw.println("</td>");
				pw.println("<td><form action='Update' method='post'>");
				pw.println("<input type='hidden' value="+id+" name='id'>");
				pw.println("<input type='submit' value='update'></form>");
				pw.println("</td>");
				pw.println("<td><form action='Delete' method='post'>");
				pw.println("<input type='hidden' value="+id+" name='facId'>");
				pw.println("<input type='submit' value='delete'></form>");
				pw.println("</td></tr>");
				//pw.println("<tr><td>"+id+"</td><td>"+name+"</td><td>"+gender+"</td><td>"+desi+"</td><td>"+dob+"</td><td>"+phno+"</td><td>"+email+"</td><td>"+add+"</td><td>"+edu+"</td><td>"+we);
				//pw.println("</td><td><a href='login.html'><button>view</button></a></td>");
				//pw.println("<td><a href='update.html'><button>edit</button></a></td>");
				//pw.println("<td><a href='delete.html'><button>delete</button></a></td></tr>");
				 }
			  st.close();
			  con.close();
			  pw.println("</table>");
			  pw.println("<br><div style='padding-left:550px;color:white'>back to home page<a href='home.html' style='color:#2A3990'>clickhere</a></div><br>");
			  pw.println("</html></body>");
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
