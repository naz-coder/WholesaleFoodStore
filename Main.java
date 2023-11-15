public class Main {
    public static void main(String[] args){
        System.out.println("Hello world");
        MenuConsole menuc = new MenuConsole();
        menuc.displayMenu();
        CustomerDAO cust1 = new CustomerDAO(1, "Ingressive Business Ltd.", "Bolton City Centre", "United Kingdom", "BL4 4BT", "0776528796");
        System.out.println(CustomerDAO.findAllCustomers());
    }
    
}