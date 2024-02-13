/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StoreInventory;

import java.util.ArrayList;

/**
 *
 * @author EM DREAMS
 */
public class CustomerRepo {

    private void displayCustomer(Customer c) {

        if(c == null){
            System.out.println("Customer Does Not Exist");
        }else{
            System.out.println("Customer = {ID: " + c.getCustomerID() + ","
                    + " Name: " + c.getBusinessName() + ", Phone: " + c.getTelephoneNumber() +", "
                    + "Address1: " + c.getAddress().getAddressLine1() + ", Address2: " + c.getAddress().getAddressLine2() + ""
                    + "address3: " + c.getAddress().getAddressLine3() + ", Postal code: " + c.getAddress().getPostCode() + ", Country: " + c.getAddress().getCountry() + "}");
        }
    }

    public void allCustomers() {

        System.out.println("Retriving All Customers");
        ArrayList<Customer> cList = (ArrayList<Customer>) CustomerDAO.findAllCustomers();

        for (int i = 0; i < cList.size(); i++) {

            Customer c = cList.get(i);

            displayCustomer(c);

        }
    }

    public void createCustomer(String name, String phone, String add1, String add2, String add3, String country, String post_code) {
        Address address = new Address(
                            add1,
                            add2,
                            add3,
                            country,
                            post_code
                    );
Customer c=new Customer(name, address, phone);
        if (CustomerDAO.createCustomer(c)) {
            System.out.println("Created Successfully ");
            displayCustomer(c);
        } else {
            System.out.println("Error Creating Customer ");
        }
    }

    public void readCustomer(int id) {
        displayCustomer(CustomerDAO.findCustomer(id));
    }

    public void updateCustomer(int id, String name, String phone, String add1, String add2, String add3, String country, String post_code) {
        readCustomer(id);
        Address address = new Address(
                            add1,
                            add2,
                            add3,
                            country,
                            post_code
                    );
        Customer c=new Customer(id, name, address, phone);
        if (CustomerDAO.updateCustomer(c)) {
            System.out.println("Updated Successfully ");
            displayCustomer(c);
        } else {
            System.out.println("Error Updating Customer ");
        }

    }

    public void deleteCustomer(int id) {

        String output = CustomerDAO.deleteCustomer(id) ? "Deleted Successfully " : " Error Deleting Customer id " + id;

        System.out.println(output);
    }

}
