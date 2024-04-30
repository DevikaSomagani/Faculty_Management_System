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
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Register")
public class Register extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// get print writer
		PrintWriter pw=res.getWriter();
		//set res type
		res.setContentType("text/html");
		//read from data
		String facId =req.getParameter("id");
		String name =req.getParameter("name");
		String gender =req.getParameter("gender");
		String desi =req.getParameter("desi");
		String dob =req.getParameter("dob");
		String phno=req.getParameter("phno");
		String email=req.getParameter("email");
		String add=req.getParameter("add");
		String edu=req.getParameter("edu");
		String we=req.getParameter("we");
		try {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/faculty","root","Devika@16");
			  Statement st=con.createStatement();
			  int p=0;
			  ResultSet rs = st.executeQuery("select * from facultydata where facId="+facId);
			  pw.println("<html><body background='register.jpg' style='background-repeat:no-repeat;background-size:cover'>");
			  if(rs.next())
				 p=1;
			  if(p==1)
				  pw.println("<div style='color:white;font-size:50px;margin-left:360px;margin-top:300px'><b>faculty details with id "+facId+" already exist</b></div>");  
			  else
			  {
			  PreparedStatement pst=con.prepareStatement("insert into facultydata values(?,?,?,?,?,?,?,?,?,?)");
			  pst.setString(1,facId);
			  pst.setString(2,name);
			  pst.setString(3,gender);
			  pst.setString(4,desi);
			  pst.setString(5,dob);
			  pst.setString(6,phno);
			  pst.setString(7,email);
			  pst.setString(8,add);
			  pst.setString(9,edu);
			  pst.setString(10,we);
			 pst.executeUpdate();
			  pw.println("<div style='color:white;font-size:50px;margin-left:380px;margin-top:300px'><b>faculty details are added</b></div>");
			  }
			  pw.println("<br><div style='padding-left:550px;color:white'>back to home page<a href='home.html' style='color:#F06292'>clickhere</a></div><br>");
			  pw.println("</html></body>");
		
		}
		catch(Exception e)	
		{
			e.printStackTrace();
		}
		pw.close();
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
