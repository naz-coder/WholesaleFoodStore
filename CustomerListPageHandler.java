package StoreInventory;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class CustomerListPageHandler implements HttpHandler {
    public void handle(HttpExchange he) throws IOException{
        String response = "Welcome to our Store Inventory";
        he.sendResponseHeaders(200, 0);
        BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(he.getResponseBody()));
        CustomerDAO customerDAOServer = new CustomerDAO();
        List<Customer> allCustomers = customerDAOServer.findAllCustomers();

        out.write(
                "<html>" +
                        "<style>" +
                        "body {" +
                        "  font-family: 'Helvetica', sans-serif;" +
                        "  background-color: #f4f4f4;" +
                        "  margin: 0px;" +
                        "}" +
                        "h1, h3 {" +
                        "  color: #333;" +
                        "}" +
                        "button{"+
                        "background-color: #004A2F;"+
                        "padding: 1rem;"+
                        "margin: 2rem;"+
                        "border-radius: 0.5rem;"+
                        "border: 1px solid #004A2F;"+
                        "font-size: 1rem;"+
                        "color: #ffffff;"+
                        "}"+
                        "button:hover{"+
                        "background-color: #002F35;"+
                        "border: 1px solid #002F35;"+
                        "color: #ffffff;"+
                        "cursor: pointer;"+
                        "}"+
                        "a{"+
                        "text-decoration: none;"+
                        "}"+
                        "a, a.menu_item, .menu_item{" +
                        "  text-decoration: none;" +
                        "}" +
                        ".header_container{" +
                        "  display: flex;" +
                        "  flex-direction: row;" +
                        "  justify-content: space-between;" +
                        "  align-items: center;" +
                        "  padding: 10px 40px;" +
                        "  box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);" +
                        "}" +
                        ".menu_items_container{" +
                        "  display: flex;" +
                        "  flex-direction: row;" +
                        "  justify-content: space-between;" +
                        "}" +
                        ".menu_items_container p{" +
                        "  margin-left: 2rem;" +
                        "}" +
                        ".home_route_btn{" +
                        "  margin: 0rem 0rem 0rem 2rem;" +
                        "  padding: 0.7rem 1.2rem;" +
                        "}" +
                        ".customer_hero{"+
                        "text-align: center;"+
                        "margin-left: 5vw;"+
                        "margin-right: 5vw;"+
                        "}"+
                        ".section_title{" +
                        "  font-size: 3rem;" +
                        "  color: #0F3238;" +
                        "  text-transform: capitalize;" +
                        "  font-weight: 900;" +
                        "  margin-bottom: -1rem;" +
                        "}" +
                        ".title_span{" +
                        "  color: #F86532;" +
                        "}" +
                        ".section_subtitle{" +
                        "  font-size: 2rem;" +
                        "  color: #0F3238;" +
                        "  margin-bottom: -0.5rem;" +
                        "}" +
                        ".section_description{" +
                        "  margin-bottom: 0.5rem;" +
                        "  color: #333333;" +
                        "}" +
                        ".table_container {" +
                        "  width: 96%;" +
                        "  border-collapse: collapse;" +
                        "  margin-top: 20px;" +
                        "margin-left: 2%;"+
                        "margin-right: 2%;"+
                        "}" +
                        ".table_container th{" +
                        "background-color: #c5c5c5;"+
                        "}"+
                        ".table_container th, .table_container td {" +
                        "  border: 1px solid #ddd;" +
                        "  padding: 8px;" +
                        "  text-align: left;" +
                        "}" +

                        ".table_container th{" +
                        "  color: #0F3238;" +
                        "}" +

                        //                        FOOTER SECTION
                        "footer{"+
                        "background-color: #0F3238;"+
                        "color: #ffffff;"+
                        "display: flex;" +
                        "justify-content: center;" +
                        "align-items: center;" +
                        "text-align: center;"+
                        "margin: 15vh 0 0 0;"+
                        "padding: 3rem;"+
                        "}"+
                        ".copyright, .website_link{"+
                        "color: #DCDBD7;"+
                        "}"+
                        "</style>" +

//                        WEB CONTENT
                        "<head><title>Food Store Inventory App</title></head>"+
                        "<body>"+
                        "<header class=\"header_container\">" +
                        "<div>" +
                        "<a href=\"/\"><img src=\"https://previews.dropbox.com/p/thumb/ACI7SjvD_4PPADFAYzZUOTrctQEvVZtGAJhMs3xw0qqQ1CMFbAYZWt6Fga0h4tiwCDuYeuYriFtB-pKkzq4MbGH-PpkTDTtCFqVvZ62r40Lhn0FPUGG8tpAuYWpkmbVYuHto43K62vaoea3Rs_19yKxKk8lhmfO9W4hnPDFSCkKEybp9u19vbBpt-J8NosQIORM6DW3YpIRCXJKAsp3n3-CXqUaYSVxkkbTO-IVIWp-gt_JE3iOi9Rb3MEBQya0zdDf0xnOaFHPWMW2SQeAC-1AI9fYuTYqk58KD-aL6Rw1SoPq7xnZ1zFjyHTnMcyhVQ492O8p-FC0Pg_94A-RuL-tK/p.png\" alt=\"FoodTruck Logo\" style=\"max-width: 20%; height: auto;\"></img></a>" +
                        "</div>" +
                        "<div class=\"menu_items_container\">" +
                        "<a href=\"foodStore\" style=\"color: #333333;\"><p>Products</p></a>" +
                        "<a href=\"customerList\" style=\"color: #F86532; font-weight: 900;\"><p>Customers</p></a>" +
                        "<a href=\"adminLogin\" style=\"color: #333333;\"><p>Admin Login</p></a>"+
                        "<a href=\"/\"><button class=\"home_route_btn\">Go Home</button></a>" +
                        "</div>" +
                        "</header>" +

                        "<section class=\"customer_hero\">" +
                        "<div class=\"hero_content\">" +
                        "<h1 class=\"section_title\">FoodTruck <span class=\"title_span\">Esteemed Customers</h1>" +
                        "<h3 class=\"section_subtitle\">This is a list of our customers</h3>" +
                        "<p class=\"section_description\">Embark on a gastronomic journey with Epicurean Haven, your go-to hub for the finest and freshest wholesale food products. Elevate your culinary creations with our high-quality ingredients, meticulously curated to meet the demands of your discerning customers. Discover the secret ingredient to success, where passion meets premium. Welcome to a world of unparalleled taste and quality!</p>" +
                        "</div>" +
                        "</section>" +

                        "<table class=\"table_container\">"+
                        "<thead>"+
                        "<tr>"+
                        "<th>S/NO</th>"+"<th>Business Name</th>"+"<th>Address</th>"+"<th>Country</th>"+"<th>Postcode</th>"+"<th>Phone Contact</th>"+
                        "</tr>"
        );


//        Display the Customer info values
        for(Customer d: allCustomers){
            out.write(d.toHTMLString());
        }

        out.write(
                "</tbody>"+
                        "</table>"+
                        "<footer>" +
                        "<div class=\"footer_content\">" +
                        "<img src=\"https://previews.dropbox.com/p/thumb/ACK5oqvf-LSqrUXXTApiiC3RhRZhjoluA03pmWduVPGiBDWnmSvzgKNZnmmmwdOUwHQ5tM87y1mwro4yCDyGfwg2B-jUGcbWXLGGR7vrdFhCJnWtheJtZdTz0cWAddyG5aDwDF9K8UMI9MFnkEMeB4tN79bLXdzmADO2iZkelLUn5P4jmJA4lCr08K8Sk0dFh2X6Mn_zqdN9_qx-dX4Xn52MkvryG0b92Zo-U5F3makhPXBY5nhrMwt75fHprmZvX3_oeEyVASWxSTTNddapouJx7UX-6MWfWRPB7gGGBqOS3642_NRHrB8vYm0R44aKgO2beRq0EfT3_2lrK1KSPfRw/p.png\" alt=\"FoodTruck Logo\" style=\"max-width: 5rem; height: auto;\"></img>"+
                        "<a target=\"blank\" href=\"https://www.nazanajemba.com/\"><p class=\"website_link\">Visit our website</p></a>"+
                        "<p class=\"copyright\">Favour Chinaza Anajemba &copy; 2024</p>"+
                        "</footer>"+
                        "</body>"+
                        "</html>");
        out.close();
    }
}
