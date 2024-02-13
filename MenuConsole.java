package StoreInventory;


import java.util.Scanner;

public class MenuConsole {
Scanner in ;
public MenuConsole(Scanner in){
    this.in = in;
}    
    
    void displayProductMenu() {
        // The Sanner would let us choose one of the options

        FoodRepo foodStore = new FoodRepo();
        int selected;
        do {
            System.out.println("--------------------");
            System.out.println("Welcome To The Food Store");
            System.out.println("Choose from these options");
            System.out.println("--------------------");
            System.out.println("[1] List all products");
            System.out.println("[2] Search for products by ID");
            System.out.println("[3] Add a new product");
            System.out.println("[4] Update a product by ID");
            System.out.println("[5] Delete a product by ID");
            System.out.println("[6] Exit");

            selected = in.nextInt();
                    String name;
                    String SKU;
                    String desc ;
                    String cat ;
                    int price;
                    int id;
            
            switch (selected) {
                case 1:
                    foodStore.allProducts();
                    break;

                case 2:
                    System.out.println("Enter ID");
                     id = in.nextInt();
                    foodStore.readProduct(id);
                    break;

                case 3:
                    in.nextLine();
                    System.out.println("Enter Name");
                     name = in.nextLine();
                    System.out.println("Enter SKU");
                     SKU = in.nextLine();
                    System.out.println("Enter Description");
                     desc = in.nextLine();
                    System.out.println("Enter Category");
                     cat = in.nextLine();
                    System.out.println("Enter Price");
                     price= in.nextInt();
                    foodStore.createProduct(name, SKU, desc, cat, price);
                    break;

                case 4:
                    System.out.println("Enter ID");
                     id = in.nextInt();
                    foodStore.readProduct(id);
                    in.nextLine();
                    System.out.println("Enter Name");
                     name = in.nextLine();
                    System.out.println("Enter SKU");
                     SKU = in.nextLine();
                    System.out.println("Enter Description");
                     desc = in.nextLine();
                    System.out.println("Enter Category");
                     cat = in.nextLine();
                    System.out.println("Enter Price");
                     price= in.nextInt();
                    foodStore.updateProduct(id, name, SKU, desc, cat, price);
                    break;

                case 5:
                    System.out.println("Enter ID");
                    id = in.nextInt();
                     foodStore.deleteProduct(id);
                    break;

                default:
                    System.out.println("Exiting console");
                    break;
            }
        } while (selected < 6 && selected != 0);

    }

    
    void displayCustomerMenu() {
        // The Sanner would let us choose one of the options
        Scanner in = new Scanner(System.in);

        CustomerRepo cr = new CustomerRepo();

        int selected;

        do {
            System.out.println("--------------------");
            System.out.println("Welcome to the Customer Info. Database");
            System.out.println("Choose from these options");
            System.out.println("--------------------");
            System.out.println("[1] List all customers");
            System.out.println("[2] Search for Customer by ID");
            System.out.println("[3] Add a new Customer");
            System.out.println("[4] Update a customer by ID");
            System.out.println("[5] Delete a customer by ID");
            System.out.println("[6] Exit");

            selected = in.nextInt();
                    String bname;
                    String phone;
                    String add1;
                    String add2;
                    String add3;
                    String country;
                    String post_code;
                    int id;

            switch (selected) {
                case 1:
                    cr.allCustomers();
                    break;
               
                case 2:
                    System.out.println("Enter ID");
                     id = in.nextInt();
                    cr.readCustomer(id);
                    break;
                    
                case 3:
                    in.nextLine();
                    System.out.println("Enter Business Name");
                     bname = in.nextLine();
                    System.out.println("Enter Phone Number");
                     phone = in.nextLine();
                    System.out.println("Enter Address ");
                     add1 = in.nextLine();
                    System.out.println("Enter Address 2 (optional, press s to skip)");
                     add2 = in.nextLine();
                     if(add2.matches("s")){
                         add2= "";
                     }
                    System.out.println("Enter Address 3(optional, press s to skip)");
                     add3= in.nextLine();
                     if(add3.matches("s")){
                         add3="";
                     }
                     System.out.println("Enter Country");
                     country = in.nextLine();
                    System.out.println("Enter Post code");
                     post_code = in.nextLine();
                    cr.createCustomer(bname, phone, add1, add2, add3, country, post_code);
                    break;

                case 4:
                    System.out.println("Enter ID");
                     id = in.nextInt();
                    cr.readCustomer(id);
                    in.nextLine();
                    System.out.println("Enter Business Name");
                     bname = in.nextLine();
                    System.out.println("Enter Phone Number");
                     phone = in.nextLine();
                    System.out.println("Enter Address ");
                     add1 = in.nextLine();
                    System.out.println("Enter Address 2 (optional, press s to skip)");
                     add2 = in.nextLine();
                     if(add2.matches("s")){
                         add2= "";
                     }
                    System.out.println("Enter Address 3(optional, press s to skip)");
                     add3= in.nextLine();
                     if(add3.matches("s")){
                         add3="";
                     }
                     System.out.println("Enter Country");
                     country = in.nextLine();
                    System.out.println("Enter Post code");
                     post_code = in.nextLine();
                    cr.updateCustomer(id,bname, phone, add1, add2, add3, country, post_code);
                    break;
                    
                case 5:
                    System.out.println("Enter ID");
                    id = in.nextInt();
                     cr.deleteCustomer(id);
                    break;

                default:
                    System.out.println("Exiting console");
                    break;
            }
        } while (selected < 6 && selected != 0);
    }
}