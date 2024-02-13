package StoreInventory;


    
 import java.sql.*;
import java.util.ArrayList;

import java.util.ArrayList;

public class FoodProductDAO {

   public static void createProductTable() throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS product (" +
                "id INTEGER PRIMARY KEY," +
                "product_name TEXT," +
                "product_SKU TEXT," +
                "product_desc TEXT," +
                "product_category TEXT," +
                "product_price INTEGER)";
        try (PreparedStatement statement = DatabaseConnection.createLink().prepareStatement(createTableSQL)) {
            statement.execute();
        }
    }
      
    public static ArrayList<FoodProduct> findAllProducts() {
        ArrayList<FoodProduct> foodArray = new ArrayList<>();
        Connection link = DatabaseConnection.createLink();
        
        if (link == null) {
            return foodArray;
        }
        try {
            PreparedStatement statement = link.prepareStatement("SELECT * FROM product");
            ResultSet output = statement.executeQuery();
            while (output.next()) {
                int id = output.getInt("id");
                String productName = output.getString("product_name");
                String productSKU = output.getString("product_SKU");
                String productDesc = output.getString("product_desc");
                String productCategory = output.getString("product_category");
               int productPrice = output.getInt("product_price");
  
                FoodProduct foodProduct = new FoodProduct(id, productName, productSKU, productDesc, productCategory, productPrice);
                
                foodArray.add(foodProduct);
            }
            return foodArray;
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

    public static FoodProduct findProduct(int id) {
        Connection link = DatabaseConnection.createLink();
        if (link == null) {
            return null;
        }
        try {
            PreparedStatement statement = link.prepareStatement("SELECT * FROM product WHERE id = ?");
            statement.setInt(1, id);
            ResultSet output = statement.executeQuery();
            if (output.next()) {
                String productName = output.getString("product_name");
                String productSKU = output.getString("product_SKU");
                String productDesc = output.getString("product_desc");
                String productCategory = output.getString("product_category");
                int productPrice = output.getInt("product_price");
  
                return new FoodProduct(id, productName, productSKU, productDesc, productCategory, productPrice);
                
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

    public static boolean deleteProduct(int id) {
        Connection link = DatabaseConnection.createLink();
        if (link == null) {
            return false;
        }
        try {
            PreparedStatement statement = link.prepareStatement("DELETE FROM product WHERE id = ?");
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

    public static boolean updateProduct(FoodProduct product) {
        Connection link = DatabaseConnection.createLink();
        if (link == null) {
            return false;
        }
        try {
            PreparedStatement statement = link.prepareStatement("UPDATE product SET product_name = ?, product_price = ?, " +
                    "product_SKU = ?, product_desc = ?, product_category = ? WHERE id = ?");
            statement.setString(1, product.getName());
            statement.setInt(2, product.getPrice());
            statement.setString(3, product.getSKU());
            statement.setString(4, product.getDesc());
            statement.setString(5, product.getCat());
           statement.setInt(6, product.getId());

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

    public static boolean createProduct(FoodProduct product) {
        Connection link = DatabaseConnection.createLink();
        if (link == null) {
            return false;
        }
        try {
            PreparedStatement statement = link.prepareStatement("INSERT INTO product (product_name, product_SKU, product_desc, " +
                    " product_category, product_price) VALUES (?, ?, ?, ?, ?)");
           
         statement.setString(1, product.getName());
            statement.setString(2, product.getSKU());
            statement.setString(3, product.getDesc());
            statement.setString(4, product.getCat());
            statement.setInt(5, product.getPrice());
   
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




