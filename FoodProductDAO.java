import java.util.*;
import java.sql.*;

public class FoodProductDAO {
    private static final String databaseURL = "jdbc:sqlite:foodStore.sqlite";

    public static Connection createLink(){
        try{
            return DriverManager.getConnection(databaseURL);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<FoodProduct> findAllProducts(){
        ArrayList<FoodProduct> foodArray = new ArrayList();
        Connection link = createLink();
        if(link == null){
            return foodArray;
        }
        try{
            PreparedStatement statement = link.prepareStatement("SELECT * FROM product");
            ResultSet output = statement.executeQuery();
            while(output.next()){
                int id = output.getInt("id");
                String product_name = output.getString("product_name");
                String product_SKU = output.getString("product_SKU");
                String product_desc = output.getString("product_desc");
                String product_category = output.getString("product_price");
            }
            return foodArray;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static FoodProduct findProduct(int id){
        return null;
    }
    public static boolean deleteProducts(int id){
        return false;
    }
    public static boolean updateProducts(FoodProduct Product){
        return false;
    }
    public static boolean createProducts(FoodProduct Product){
        return false;
    }


}

