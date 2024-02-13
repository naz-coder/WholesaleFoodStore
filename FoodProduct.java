package StoreInventory;

public class FoodProduct {

 private int id;
 private String name;
 private String SKU; //stock keeping unit (a unique code for each product)
 private String desc;
 private String cat;
 private int price;

    public FoodProduct(int id, String name, String SKU, String desc, String cat, int price) {
        this.id = id;
        this.name = name;
        this.SKU = SKU;
        this.desc = desc;
        this.cat = cat;
        this.price = price;
    }

  public FoodProduct( String name, String SKU, String desc, String cat, int price) {
        this.name = name;
        this.SKU = SKU;
        this.desc = desc;
        this.cat = cat;
        this.price = price;
    }    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toHTMLString(){
        return "<tr><td>" + id + "</td><td> " + name + "</td><td> " + SKU + "</td><td> " + desc + "</td><td> " + cat + "</td><td> " + price +
                "</td></tr>";
    }

}
