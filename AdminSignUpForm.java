package StoreInventory;

import java.util.Scanner;

public class AdminSignUpForm {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Admin Sign-Up Form");
        System.out.println("Enter admin username:");
        String username = scanner.nextLine();

        System.out.println("Enter admin password:");
        String password = scanner.nextLine();

        User adminUser = new User(username, password, true);
        System.out.println("Admin Sign-Up Successful!");
        System.out.println("Username: " + adminUser.getUsername());
        System.out.println("Password: **********");
    }
}
