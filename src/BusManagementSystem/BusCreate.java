package BusManagementSystem;



import java.sql.*;


public class BusCreate {
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
            String sql="Create table bus"+
                    "(id integer not null AUTO_INCREMENT,"+
                    "first_name varchar(50),"+
                    "last_name varchar(50),"+
                    "user_name varchar(50),"+
                    "password varchar(50),"+ 
                    "email varchar(50),"+
                    "contact integer,"+ 
                    "Primary key(id))";
            
            st.executeUpdate(sql);
            System.out.println("successfully created table!");
            con.close();
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        };
    }
}