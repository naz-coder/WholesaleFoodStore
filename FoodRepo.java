package StoreInventory;

import java.util.ArrayList;

public class FoodRepo {
    private void displayProduct(FoodProduct fp) {
        if(fp == null){
            System.out.println("Product Does Not Exist");
        }else{
            System.out.println("Product = {ID: " + fp.getId() + ", SKU: " + fp.getSKU() + ", Description: " + fp.getDesc() + ", Category: " + fp.getCat() + ", Price: " + fp.getPrice() + "}");
        }
    }

    public void allProducts() {
        System.out.println("Retriving All Products");
        ArrayList<FoodProduct> fpList = FoodProductDAO.findAllProducts();
        for (int i = 0; i < fpList.size(); i++) {
            FoodProduct fp = fpList.get(i);
            displayProduct(fp);
        }
    }

    public void createProduct(String name, String SKU, String desc, String cat, int price) {
        FoodProduct fp = new FoodProduct(name, SKU, desc, cat, price);
        if (FoodProductDAO.createProduct(fp)) {
            System.out.println("Created Successfully ");
            displayProduct(fp);
        } else {
            System.out.println("Error Creating Product ");
        }
    }

    public void readProduct(int id) {
        displayProduct(FoodProductDAO.findProduct(id));
    }

    public void updateProduct(int id, String name, String SKU, String desc, String cat, int price) {
        readProduct(id);
        FoodProduct fp = new FoodProduct(id, name, SKU, desc, cat, price);
        if (FoodProductDAO.updateProduct(fp)) {
            System.out.println("Updated Successfully ");
            displayProduct(fp);
        } else {
            System.out.println("Error Updating Product ");
        }
    }

    public void deleteProduct(int id) {
        String output = FoodProductDAO.deleteProduct(id) ? "Deleted Successfully " : " Error Deleting product id " + id;
        System.out.println(output);
    }
}
