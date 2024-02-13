package StoreInventory;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.sun.net.httpserver.HttpServer;
import java.io.BufferedWriter;
import java.net.InetSocketAddress;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;


public class Main {
    private static final int PORT = 3232;

    private void startServer() {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
            server.createContext("/", new LandingPageHandler());
            server.createContext("/foodStore", new FoodStorePageHandler());
            server.createContext("/customerList", new CustomerListPageHandler());
            server.createContext("/adminLogin", new AdminLoginPageHandler());
            server.createContext("/adminHome", new AdminLandingPageHandler());
            server.setExecutor(null);
            server.start();
            System.out.println("The server is listening on port " + PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            Class.forName("org.sqlite.JDBC");
            FoodProductDAO.createProductTable();
            CustomerDAO.createCustomerTable();
            Main main = new Main();
            main.startServer();

            MenuConsole menuc = new MenuConsole(in);
            int selection;
            do{
                System.out.println("Welcome Wholesale Store");
                System.out.println("[1] Food Products menu");
                System.out.println("[2] Customer menu");
                System.out.println("[3] Exit");

                selection= in.nextInt();

                switch (selection) {
                    case 1:
                        menuc.displayProductMenu();
                        break;
                    case 2:
                        menuc.displayCustomerMenu();
                        break;
                    default:
                        selection=3;
                        break;
                }

            }while(selection!=3);
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println(ex.toString());
        }




    }

}
