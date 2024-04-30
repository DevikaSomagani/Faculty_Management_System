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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pw=res.getWriter();
		//set res type
		res.setContentType("text/html");
		//read from data
		String facId =req.getParameter("facId");
		//pw.println("hi");
		
		
		try {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/faculty","root","Devika@16");
			  Statement st =con.createStatement();
			  int p=0;
			  String id=null;
			  ResultSet rs = st.executeQuery("select * from facultydata where facId="+facId);
			 pw.println("<html><body background='https://img.freepik.com/free-photo/ready-back-school_1134-12.jpg?w=2000' style='color:white;background-repeat:no-repeat;background-size:cover'>");
				  //pw.println("<h1 align='center'>Facutly Details</h1>");
				  //pw.println("<table border=1 width=50% height=50% cellpadding=5 cellspacing=0 align='cent er' style='border-color:white'>");
			  while(rs.next()){
				  p=1;
				  pw.println("<h1 align='center'>Facutly Details</h1>");
				  pw.println("<table border=1 width=50% height=50% cellpadding=15 cellspacing=0 align='center' style='font-size:17px;border-color:white'>");
			     id=rs.getString(1);
				String name=rs.getString(2);
				String gender=rs.getString(3);
				String desi=rs.getString(4);
				String dob=rs.getString(5);
				String phno=rs.getString(6);
				String email=rs.getString(7);
				String address=rs.getString(8);
				String edu=rs.getString(9);
				String we=rs.getString(10);
				pw.println("<tr><th>Faculty ID</th> <td>"+id+"</td></tr>" );
				pw.println("<tr><th>Faculty Name</th> <td>"+name+"</td></tr>" );
				pw.println("<tr><th>Gender</th> <td>"+gender+"</td></tr>" );
				pw.println("<tr><th>Designation</th> <td>"+desi+"</td></tr>" );
				pw.println("<tr><th>DOB</th> <td>"+dob+"</td></tr>" );
				pw.println("<tr><th>PhNo</th> <td>"+phno+"</td></tr>" );
				pw.println("<tr><th>Email</th> <td>"+email+"</td></tr>" );
				pw.println("<tr><th>Address</th> <td>"+address+"</td></tr>" );
				pw.println("<tr><th>Education Qualification</th> <td>"+edu+"</td></tr>" );
				pw.println("<tr><th>Work Experience</th> <td>"+we+"</td></tr>" );
			  }
			  if(p==0)
				  pw.println("<div style='color:white;font-size:50px;margin-left:320px;margin-top:250px'><b>faculty details are not found</b></div>");
			  pw.println("</table><br></br>");
			  st.close();
			  con.close();
			  pw.println("<form action='Update' method='post'>");
				pw.println("<input type='hidden' value="+id+" name='id'>");
				//pw.println("<input type='submit' value='update'></form>");
			// pw.println("<form action='Update' method='post'>");
			  pw.println("<input type='submit' value='update' style='margin-left:600px;border-radius:6px;height:30px;background-color:rgb(0, 255, 64)'>");
			 // pw.println("<br><div style='padding-left:550px;color:white'>edit faculty detail<a href='Update' style='color:#2A3990'> edit</a></div><br>");
			  pw.println("</form><br><div style='padding-left:550px;color:white'>back to home page<a href='home.html' style='color:#2A3990'> clickhere</a></div><br>");
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
