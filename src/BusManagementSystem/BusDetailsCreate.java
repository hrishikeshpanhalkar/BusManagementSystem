package BusManagementSystem;



import java.sql.*;


public class BusDetailsCreate {
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
            String sql="Create table bus_details"+
                    "(id integer not null AUTO_INCREMENT,"+
                    "Bus_no varchar(50),"+
                    "Movement varchar(50),"+
                    "Bus_Source varchar(50),"+
                    "Bus_dest varchar(50),"+ 
                    "Depart_Date date,"+
                    "Depart_time varchar(50),"+
                    "price integer,"+ 
                    "Total_seat integer,"+ 
                    "Primary key(id))";
            
            st.executeUpdate(sql);
            System.out.println("successfully created table!");
            con.close();
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        };
    }
}