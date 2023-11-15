import java.util.Scanner;

public class MenuConsole {
    void displayMenu() {
        // The Sanner would let us choose one of the options
        Scanner in = new Scanner(System.in);
        FoodStore foodStore = new FoodStore();
        int selected;
        do{
        System.out.println("--------------------");
        System.out.println("The Food Store");
        System.out.println("Choose from these options");
        System.out.println("--------------------");
        System.out.println("[1] List all products");
        System.out.println("[2] Search for products by ID");
        System.out.println("[3] Add a new product");
        System.out.println("[4] Update a product by ID");
        System.out.println("[5] Delete a product by ID");
        System.out.println("[6] Exit");
        
        selected = in.nextInt();
        switch (selected) {
            case 1:
                System.out.println("List products");
                break;
            case 2:
                System.out.println("Searching products");
                break;
            case 3:
                System.out.println("Adding a new product");
                break;
            case 4:
                System.out.println("Updating a product");
                break;
            case 5:
            System.out.println("Enter ID");
            int id = in.nextInt();
                foodStore.deleteProduct(id);
                break;
            default:
                System.out.println("Exit console");
                break;
        }
        }
        while (selected != 6);
    }
}
