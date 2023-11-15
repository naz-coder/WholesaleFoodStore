import java.util.*;
import java.sql.*;

public class CustomerDAO {
    private static final String dataBaseURL = "jdbc:sqlite:foodStore.sqlite";
    public static Connection createLink(){
        try{
            return DriverManager.getConnection(dataBaseURL);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public static ArrayList<Customer> findAllCustomers(){
        ArrayList<Customer> customerArray = new ArrayList<Customer>();
        Connection link = createLink();
        if(link == null){
            return customerArray;
        }
        try{
            PreparedStatement statement = link.prepareStatement("SELECT * FROM customer");
            ResultSet output = statement.executeQuery();
            while(output.next()){
                int id = output.getInt("id");
                String customer_name = output.getString("customer_name");
                Address address = new Address(output.getString("address_line1"), output.getString("address_line2"), output.getString("address_line3"), output.getString("country"), output.getString("post_code"));
                customerArray.add(new Customer(output.getInt("id"), output.getString("customer_name"), address, output.getString("phone")));
            }
            return customerArray;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public static Customer findCustomer(int id){
        return null;
    }
    public static boolean deleteCustomers(int id){
        return false;
    }
    public static boolean updateCustomers(Customer customer){
        return false;
    }
    public static boolean createCustomers(Customer customer){
        return false;
    }
}
