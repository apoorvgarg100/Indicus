import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Date;

public class BookServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/library?user=root&password=");
			String qry="select b.bookId,b.bookName,b.publishDate,b.genre,b.bookRating,a.authorName,a.birthDate,a.birthPlace,a.emailId from books b inner join author a on b.authorId=a.id;";
			PreparedStatement ps=con.prepareStatement(qry);
			ResultSet rs=ps.executeQuery();
			
			int a=1;
			String json = "[\n";
			while(rs.next())
			{				
				int bid=rs.getInt(1);
				String bname=rs.getString(2);
				Date pdate=rs.getDate(3);
				String genre=rs.getString(4);
				float rating=rs.getFloat(5);
				//int authid=rs.getInt(6);
				String authName=rs.getString(6);
				Date bdate=rs.getDate(7);
				String bplace=rs.getString(8);
				String emailId=rs.getString(9);

				if(a>1){
					json += ",\n";
				}
				json += "{\n";
				json += "\"bid\": " +bid + ",\n";
				json += "\"bname\": \"" + bname + "\",\n";
				json += "\"pdate\": \"" + pdate + "\",\n";
				json += "\"genre\": \"" + genre + "\",\n";
				json += "\"rating\": " + rating + ",\n";
				//json += "\"authid\": " + authid + "\n";
				json += "\"authName\": \"" + authName + "\",\n";
				json += "\"bdate\": \"" + bdate + "\",\n";
				json += "\"bplace\": \"" + bplace + "\",\n";
				json += "\"emailId\": \"" + emailId + "\"\n";
				json += "}";
			 a++;
			}
			json += "\n]";
			res.getOutputStream().println(json);
			
		   }
		 catch(Exception e)
		 {
		 }
		 finally{
			 try{
				 con.close();
			 }
			 catch(Exception e)
			 {
			 }
		 }		
	}
}