package StoreInventory;

public class Customer {
  private  int customerID;
   private String businessName;
  private  Address address;
  private  String telephoneNumber;

    public Customer(int customerID, String businessName, Address address, String telephoneNumber) {
        this.customerID = customerID;
        this.businessName = businessName;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
    }

        public Customer(String businessName, Address address, String telephoneNumber) {
        this.businessName = businessName;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
    }
    
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String toHTMLString(){
        return "<tr><td>" + customerID + "</td><td> " + businessName + "</td><td> " + address.getAddressLine1()+", " + address.getAddressLine2()+", " + address.getAddressLine3() + "</td><td> " + address.getCountry() + "</td><td> " + address.getPostCode() +"</td><td>" + telephoneNumber +
                "</td></tr>";
    }

}