import java.sql.*;
import java.io.*;

public class jdbcdelete 
{
    
    public static void main(String[] args) 
    {
    String dno,dname,loc;
    BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
    try
    {
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         String url="jdbc:odbc:mydept";
        Connection con=DriverManager.getConnection(url);
        Statement s=con.createStatement();
        System.out.println("Enter Deptno :");
        dno=in.readLine();
        ResultSet rs=s.executeQuery("Select * from dept where dno='"+dno+"'");
	if(rs.next())
	{
	
	s.executeUpdate("delete from dept where dno='"+dno+"'");
        System.out.println("Record Deleted");
        
        ResultSet rs1=s.executeQuery("Select * from dept");
        System.out.println("DeptNo\tDeptName\tLocation");
        while(rs1.next())
        {
            System.out.print(rs1.getString(1)+"   ");
            System.out.print(rs1.getString(2)+"\t\t");
            System.out.println(rs1.getString(3));
            
        }

	}
	else
	{
	System.out.println("Record not found");
	}
        
        
        con.close();
    }
    catch(Exception e)
    {
        System.out.println(e);
        
    }

    }
    
}
