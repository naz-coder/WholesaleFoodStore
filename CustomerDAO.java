package StoreInventory;


import java.util.*;
import java.sql.*;

public class CustomerDAO {

    public static void createCustomerTable() throws SQLException {

        String createTableSQL = "CREATE TABLE IF NOT EXISTS customer ("
                + "id INTEGER PRIMARY KEY,"
                + "business_name TEXT,"
                + "phone TEXT,"
                + "address_line1 TEXT,"
                + "address_line2 TEXT,"
                + "address_line3 TEXT,"
                  + "post_code TEXT)";
        try (PreparedStatement statement = DatabaseConnection.createLink().prepareStatement(createTableSQL)) {
            statement.execute();
        }
    }

    public static ArrayList<Customer> findAllCustomers() {
        ArrayList<Customer> customerList = new ArrayList<>();
        try (Connection connection = DatabaseConnection.createLink()) {
            if (connection == null) {
                return customerList;
            }

            String query = "SELECT * FROM customer";
            try (PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String customerName = resultSet.getString("business_name");
                    String phone = resultSet.getString("phone");
                    Address address = new Address(
                            resultSet.getString("address_line1"),
                            resultSet.getString("address_line2"),
                            resultSet.getString("address_line3"),
                            resultSet.getString("country"),
                            resultSet.getString("post_code")
                    );
                  
                    customerList.add(new Customer(id, customerName, address, phone));
                
                
                }
                return customerList;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Handle the exception appropriately.
        }
        return null;
    }

    public static Customer findCustomer(int id) {
          Connection link = DatabaseConnection.createLink();
        if (link == null) {
            return null;
        }
        try {
            PreparedStatement statement = link.prepareStatement("SELECT * FROM customer WHERE id = ?");
            statement.setInt(1, id);
            ResultSet output = statement.executeQuery();
            if (output.next()) {
                    String customerName = output.getString("business_name");
                    String phone = output.getString("phone");
                    Address address = new Address(
                            output.getString("address_line1"),
                            output.getString("address_line2"),
                            output.getString("address_line3"),
                            output.getString("country"),
                            output.getString("post_code")
                    );
                  return  new Customer(id, customerName, address, phone);
           }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                link.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static boolean deleteCustomer(int id) {
        Connection link = DatabaseConnection.createLink();
        if (link == null) {
            return false;
        }
        try {
            PreparedStatement statement = link.prepareStatement("DELETE FROM customer WHERE id = ?");
            statement.setInt(1, id);
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                link.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean updateCustomer(Customer customer) {
    Connection link = DatabaseConnection.createLink();
        if (link == null) {
            return false;
        }
        try {
            PreparedStatement statement = link.prepareStatement("UPDATE customer SET business_name = ?, phone = ?, " +
                    "address_line1 = ?, address_line2 = ?, address_line3 = ?, country = ?, post_code = ? WHERE id = ?");
            statement.setString(1, customer.getBusinessName());
            statement.setString(2, customer.getTelephoneNumber());
            statement.setString(3, customer.getAddress().getAddressLine1());
            statement.setString(4, customer.getAddress().getAddressLine2());
            statement.setString(5, customer.getAddress().getAddressLine3());
            statement.setString(6, customer.getAddress().getCountry());
            statement.setString(7, customer.getAddress().getPostCode());
           statement.setInt(8, customer.getCustomerID());
           int affectedRows = statement.executeUpdate();
           return affectedRows > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                link.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean createCustomer(Customer customer) {
        Connection link = DatabaseConnection.createLink();
        if (link == null) {
            return false;
        }
        try {
            PreparedStatement statement = link.prepareStatement("INSERT INTO customer (business_name, phone, address_line1, " +
                    "address_line2, address_line3, country, post_code) VALUES (?, ?, ?, ?, ?, ?, ?)");
           
            statement.setString(1, customer.getBusinessName());
            statement.setString(2, customer.getTelephoneNumber());
            statement.setString(3, customer.getAddress().getAddressLine1());
            statement.setString(4, customer.getAddress().getAddressLine2());
            statement.setString(5, customer.getAddress().getAddressLine3());
            statement.setString(6, customer.getAddress().getCountry());
            statement.setString(7, customer.getAddress().getPostCode()); 
   
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                link.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
