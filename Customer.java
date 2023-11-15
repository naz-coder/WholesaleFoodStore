public class Customer {
    int customerID;
    String businessName;
    Address address;
    String telephoneNumber;

    // Constructor
    public Customer(int id, String bizName, Address ad, String phone){
        this.customerID = id;
        this.businessName = bizName;
        this.address = ad;
        this.telephoneNumber = phone;
    }

    // Getters
    public int getCustomerID(){
        return customerID;
    }
    public String getBusinessName(){
        return businessName;
    }
    public Address getAddress(){
        return address;
    }
    public String getTelephone(){
        return telephoneNumber;
    }

    // Setters
    public void setBusinessName(String value){
        this.businessName = value;
    }
    public void setAddress(Address value){
        this.address = value;
    }
    public void setTelephoneNumber(String value){
        this.telephoneNumber = value;
    }
    


}