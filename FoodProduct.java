public class FoodProduct {

 int foodID;
 String productSKU; //stock keeping unit (a unique code for each product)
 String description;
 String productCategory;
 int price;

// Constructors
 public FoodProduct(int id, String prdtSKU, String desc, String category, int prdtPrice) {
// insert code here to assign attributes.
  this.foodID = id;
  this.productSKU = prdtSKU;
  this.description = desc;
  this.productCategory = category;
  this.price = prdtPrice;
}

// Product Getters
 public int getFoodID(){
  return foodID;
}
 public String getProductSKU(){
  return productSKU;
 }
 public String getDescription(){
  return description;
 }
 public String getProductCategory(){
  return productCategory;
 }
 public int getPrice(){
  return  price;
 }

// Product Setters
 public void setProductSKU(String value){
  this.productSKU = value;
 }
 public void setDescription(String value){
  this.description = value;
 }
 public void setProductCategory(String value){
  this.productCategory = value;
 }
 public void setPrice(int value){
  this.price = value;
 }

}
