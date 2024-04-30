

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=res.getWriter();
		//set res type
		res.setContentType("text/html");
		//read from data
		String id=req.getParameter("id");
		//String id=req.getParameter("id");
		String name = null;
		String gender =null;
		String desi=null;
		String dob=null;
		String phno=null;
		String email=null;
		String address=null;
		String edu=null;
		String we=null;
		try {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/faculty","root","Devika@16");
			  Statement st=con.createStatement();
			  ResultSet rs = st.executeQuery("select * from facultydata where facId="+id);
			  while(rs.next()){
				id=rs.getString(1);
				name =rs.getString(2);
				gender=rs.getString(3);
				desi=rs.getString(4);
				dob=rs.getString(5);
				phno=rs.getString(6);
				email=rs.getString(7);
				address=rs.getString(8);
				edu=rs.getString(9);
				we=rs.getString(10);
			  }
			pw.println("<html><body background='register.jpg' style='background-repeat:no-repeat;background-size:cover;color:white;'>");
			pw.println("<h1 align='center'>Update Faculty Details</h1><br>");
			pw.println("<form action='UpdateDemo' method='post' style='padding-left:300px;color:white'>");
			//pw.println("<h1 style='margin-left:40px'>Update Faculty Details</h1><br>");
			//pw.println("Faculty Id<br><input id='id' <table border=1 cellspacing=0 style='width:200px' name='id'><tr><td>"+id+"</td></tr></table>><br>");
			pw.println("<table cellpadding=15 style='font-size:20px'><tr><td>");
			pw.println("Faculty Id<br><input type='text' name='id' value="+id+" style='border-radius:6px;height:35px;width:300px'><br><br></td>");
			pw.println("<td>Faculty Name<br><input type='text' name='name' value="+name+" style='border-radius:6px;height:35px;width:300px'><br><br></td></tr>");
			pw.println("<tr><td>Gender<br><input type='text' name='gender' value="+gender+" style='border-radius:6px;height:35px;width:300px'><br><br></td>");
			pw.println("<td>Designation<br><input type='text' name='desi' value="+desi+" style='border-radius:6px;height:35px;width:300px'><br><br></td></tr>");
			pw.println("<tr><td>DOB<br><input type='text' name='dob' value="+dob+" style='border-radius:6px;height:35px;width:300px'><br><br></td>");
			pw.println("<td>Phno<br><input type='text' name='phno' value="+phno+" style='border-radius:6px;height:35px;width:300px'><br><br></td></tr>");
			pw.println("<tr><td>Email<br><input type='text' name='email' value="+email+" style='border-radius:6px;height:35px;width:300px'></br><br></td>");
			pw.println("<td>Address<br><input type='text' name='add' value="+address+" style='border-radius:6px;height:35px;width:300px'><br><br></td></tr>");
			pw.println("<tr><td>Education Qualification<br><input type='text' name='edu' value="+edu+" style='border-radius:6px;height:35px;width:300px'><br><br></td>");
			pw.println("<td>Work Experience<br><input type='text' name='we' value="+we+" style='border-radius:6px;height:35px;width:300px'><br><br></td></tr></table>");
			pw.println("<input type='submit' style='margin-left:320px;border-radius:6px;height:30px;background-color:rgb(0, 255, 64)'>");
			pw.println("</form>");
			pw.println("<br><div style='padding-left:550px;color:white'>back to home page<a href='home.html' style='color:#F06292'>clickhere</a></div><br>");		
			pw.println("</body></html>");
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
