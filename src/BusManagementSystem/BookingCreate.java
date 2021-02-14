package BusManagementSystem;



import java.sql.*;


public class BookingCreate {
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
            String sql="Create table booking_details"+
                    "(booking_id integer not null AUTO_INCREMENT,"+
                    "first_name varchar(50),"+
                    "last_name varchar(50),"+
                    "journey_date date,"+
                    "busno varchar(50),"+
                    "seat integer,"+
                    "paid integer,"+
                    "id_no integer,"+                                        
                    "Primary key(booking_id))";
            
            st.executeUpdate(sql);
            System.out.println("successfully created table!");
            con.close();
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        };
    }
}