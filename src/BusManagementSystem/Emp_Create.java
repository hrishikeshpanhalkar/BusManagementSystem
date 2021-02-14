package BusManagementSystem;



import java.sql.*;


public class Emp_Create {
    public static void main(String args[])
    {
        Connection con=null;
        Statement st=null;
    
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bus","root","root");
            System.out.println("Connection to database successfully!");
            System.out.println("Creating table in database.....");
            st=con.createStatement();
            String sql="Create table Emp_details"+
                    "(id integer not null AUTO_INCREMENT,"+
                    "first_name varchar(50),"+
                    "last_name varchar(50),"+
                    "mob1 integer,"+
                    "mob2 integer,"+
                    "bus_no varchar(50),"+                                     
                    "Primary key(id))";
            
            st.executeUpdate(sql);
            System.out.println("successfully created table!");
            con.close();
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        };
    }
}