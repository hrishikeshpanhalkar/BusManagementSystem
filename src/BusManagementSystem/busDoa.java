package BusManagementSystem;





import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
class busDoa {
    static boolean Login(String name, String password) {
        boolean status=false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bus","root","root");
            PreparedStatement ps=con.prepareStatement("select user_name,password from bus ");
            
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                String sname=rs.getString("user_name");
                String spassword=rs.getString("password");
                
                if(sname.equals(name) && spassword.equals(password) ){
                    status=true;
                }                
            }        
            rs.close();
        }catch(Exception e){
            System.out.println("Error:" +e.getMessage());
        }        
        return status;
    }

    static int add(String fname, String lname, String uname, String password, String email, int contact) {
        int status=0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bus","root","root");           
            PreparedStatement ps=con.prepareStatement("insert into bus(first_name,last_name,user_name,password,email,contact)values(?,?,?,?,?,?)");
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, uname);
            ps.setString(4, password);
            ps.setString(5, email);
            ps.setInt(6, contact);
            status=ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }  
        
        return status;
    }

    static int AddBus(String busno, String movement, String source, String dest, String date,String time, int price, int seat) {
        int status=0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bus","root","root");           
            PreparedStatement ps=con.prepareStatement("insert into bus_details(Bus_no,Movement,Bus_Source,Bus_dest,Depart_Date,Depart_time,price,Total_seat)values(?,?,?,?,?,?,?,?)");
            ps.setString(1, busno);
            ps.setString(2,movement );
            ps.setString(3, source);
            ps.setString(4, dest);
            ps.setString(5, date);
            ps.setString(6, time);
            ps.setInt(7, price);
            ps.setInt(8, seat);
            status=ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        } 
        return status;
    }

    static int booking(String fname, String lname, String date, String bus, int seatno, int paid, int Id) {
        int status=0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bus","root","root");           
            PreparedStatement ps=con.prepareStatement("insert into booking_details(first_name,last_name,journey_date,busno,seat,paid,id_no)values(?,?,?,?,?,?,?)"); 
            PreparedStatement as=con.prepareStatement("update  bus_details set Total_seat=Total_seat-"+seatno+" where Bus_no=?"); 
            ps.setString(1, fname);
            ps.setString(2,lname );
            ps.setString(3, date);
            ps.setString(4, bus);
            ps.setInt(5, seatno);
            ps.setInt(6, paid);
            ps.setInt(7, Id);
            as.setString(1,bus);
            status=ps.executeUpdate();
            status=as.executeUpdate();
            ps.close();
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
        
        return status;
    }

    static int delete(String id) {
        int status=0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bus","root","root");
            PreparedStatement ps=con.prepareStatement("Delete from bus_details where id=?");
            ps.setString(1, id);
            status=ps.executeUpdate();           
            con.close();            
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
        return status;
    } 

    static int empAdd(String fname, String lname, int mob1, int mob2) {
        int status=0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bus","root","root");
            PreparedStatement ps=con.prepareStatement("insert into emp_details(first_name,last_name,mob1,mob2)values(?,?,?,?)");
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setInt(3, mob1);
            ps.setInt(4, mob2);
            status=ps.executeUpdate();           
            con.close();            
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
        return status;
    
    }

    static int assignBus(String empcb, String buscb) {
        int status=0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bus","root","root");
            PreparedStatement ps=con.prepareStatement("update emp_details set bus_no=? where id=?");
            ps.setString(1, buscb);
            ps.setString(2, empcb);
            status=ps.executeUpdate();           
            con.close();            
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
        return status;
    }

    static int deleteEmp(String id) {
        int status=0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bus","root","root");
            PreparedStatement ps=con.prepareStatement("Delete from emp_details where id=?");
            ps.setString(1, id);
            status=ps.executeUpdate();           
            con.close();            
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
        return status;
    }

    static int deleteUsers(String id) {
        int status=0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bus","root","root");
            PreparedStatement ps=con.prepareStatement("Delete from bus where id=?");
            ps.setString(1, id);
            status=ps.executeUpdate();           
            con.close();            
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
        return status;
    }
}
