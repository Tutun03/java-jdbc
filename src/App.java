import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception { 
        // String name;
        // String password;
        // String email;
        // String gender;
        // String city;
        // Scanner scanner = new Scanner(System.in);
        // System.out.println("PROVIDE NAME");
        // name=scanner.nextLine();
        // System.out.println("PROVIDE PASSWORD");
        // password=scanner.nextLine();
        // System.out.println("PROVIDE EMAIL");
        // email=scanner.nextLine();
        // System.out.println("PROVIDE GENDER");
        // gender=scanner.nextLine();
        // System.out.println("updated  CITY");
        // city=scanner.nextLine();
        // String email;
        // String city;
        // Scanner scanner = new Scanner(System.in);
        // System.out.println("enter the updated city");
        // city=scanner.nextLine();
        // System.out.println("enter the  email where city need to  updated");
        // email=scanner.nextLine();
        // String email;
        // Scanner scanner = new Scanner(System.in);
        // System.out.println("enter the  email please");
        // email=scanner.nextLine();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// JDBC IS MANINLY AN API WHICH CREATES A CONNECTIVITY WITH THE DATABASE AND HELP TO EXECUTE THE ACTIONS PERFORMED BY THE JAVA APP. IT HAS SEVERAL STEPS -1. TRANSLATOR(DRIVER LOADING),2- IS THE CREATE CONNECTION ,THAT MEANS TO ESTABLISHING THE CONNECTION. , create statement ---compare it as vehicle which can transfer query to the database,4th step execute the statement(we have statement interface, callable,prepare statement but we will use prepare statement), 5 process it and 6. close the statement and close the connection. 
        } catch (ClassNotFoundException e) {
           
            e.printStackTrace();
        }
        // DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","");// connection establish and return the value in connection .
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","");
        // PreparedStatement ps= con.prepareStatement(" INSERT INTO register (name,password,email,gender,city) VALUES(?,?,?,?,?)");//// it returns the value into prepared statement.
    //    PreparedStatement ps= con.prepareStatement("UPDATE register SET city=? where email=?");
    // PreparedStatement ps= con.prepareStatement("delete from register where email=?");
    PreparedStatement ps= con.prepareStatement("SELECT * FROM register ");

        // ps.setString(1, name);
        // ps.setString(2, password);
        // ps.setString(3, email);
        // ps.setString(4, gender);
        // ps.setString(5, city);
        // ps.setString(1,city);
        // ps.setString(2, email);
// ps.setString(1, email);
        // int i=ps.executeUpdate();
        // if(i>0) {
        // System.out.println("success");
        // }
        // else{
        //     System.out.println("failure");
        // }

        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));// we can also write column instead of no
        }
        con.close();
        rs.close();
        ps.close();
     
    }
}
