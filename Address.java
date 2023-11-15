public class Address {
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String country;
    private String postCode;

    // Why use Getters and Setters
        // Using getters and setters bcs we have the data as private above
// Setters
    public void setAddressLine1(String value){
        this.addressLine1 = value;
    }
    public void setAddressLine2(String value){
        this.addressLine2 = value;
    }
    public void setAddressLine3(String value){
        this.addressLine3 = value;
    }
    public void setPostCode(String value){
        this.postCode = value;
    }
    public void setCountry(String value){
        this.country = value;
    }
    
// Getters
    public String getAddressLine1(){
        return addressLine1;
    }
    public String getAddressLine2(){
        return addressLine2;
    }
    public String getAddressLine3(){
        return addressLine3;
    }
    public String getCountry(){
        return country;
    }
    public String getPostCode(){
        return postCode;
    }




    // Constructors - we are using polymorphism for this contructor
    // Considering that we need the three addresses to be optional with one address line compulsory, then we can use Polymorphism here to achieve that
    public Address(String add1, String country, String post_code){
        this.addressLine1 = add1;
        this.country = country;
        this.postCode = post_code;
    }

    public Address(String add1, String add2, String country, String post_code){
        this.addressLine1 = add1;
        this.addressLine2= add2;
        this.country = country;
        this.postCode = post_code;
    }

    public Address(String add1, String add2, String add3, String country, String post_code){
        this.addressLine1 = add1;
        this.addressLine2= add2;
        this.addressLine3= add3;
        this.country = country;
        this.postCode = post_code;
    }

}
