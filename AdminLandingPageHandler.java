package StoreInventory;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class AdminLandingPageHandler implements HttpHandler {
    public void handle(HttpExchange he) throws IOException {
        he.sendResponseHeaders(200, 0);
        BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(he.getResponseBody()));
        out.write(
                "<html>" +
                        "<head><title>Food Store Inventory App</title></head>" +
                        "<body>" +
                        "<style>" +
                        "body {" +
                        "  font-family: 'Helvetica', sans-serif;" +
                        "  background-color: #ffffff;" +
                        "  margin: 0px;" +
                        "}" +
                        "h1, h3 {" +
                        "  color: #333;" +
                        "}" +
                        "button{" +
                        "  background-color: #004A2F;" +
                        "  padding: 1rem;" +
                        "  margin: 2rem;" +
                        "  border-radius: 0.5rem;" +
                        "  border: 1px solid #004A2F;" +
                        "  font-size: 1rem;" +
                        "  color: #ffffff;" +
                        "}" +
                        "button:hover{" +
                        "  background-color: #002F35;" +
                        "  border: 1px solid #002F35;" +
                        "  color: #ffffff;" +
                        "  cursor: pointer;" +
                        "}" +
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
                        ".register_btn{" +
                        "  margin: 0rem 0rem 0rem 2rem;" +
                        "  padding: 0.7rem 1.2rem;" +
                        "}" +
                        ".home_hero{" +
                        "  margin: 0.2rem 5rem;" +
                        "  display: flex;" +
                        "  flex-direction: row;" +
                        "  justify-content: space-between;" +
                        "}" +
                        ".hero_content_container{" +
                        "  display: flex;" +
                        "  justify-content: center;" +
                        "  align-items: center;" +
                        "}" +
                        ".section_title{" +
                        "  font-size: 4rem;" +
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
                        "  margin-bottom: -0.5rem;" +
                        "  color: #333333;" +
                        "}" +
                        ".store_btn, .customer_btn{" +
                        "  margin-left: 0rem;" +
                        "  margin-bottom: 0rem;" +
                        "padding-bottom: 0.7rem"+
                        "padding-top: 0.7rem"+
                        "}" +
                        ".hero_img{" +
                        "  max-width: 50vw;" +
                        "  height: auto;" +
                        "}" +
                        ".hero_image_mobile_container{" +
                        "  display: none;" +
                        "}" +
                        ".hero_image_mobile{" +
                        "  display: none;" +
                        "}" +

//                        ABOUT US SECTION
                        ".about_us{"+
                        "display: flex;" +
                        "justify-content: center;" +
                        "align-items: center;" +
                        "margin: 5vh 5vw;"+
                        "padding: 4rem;"+
                        "border-radius: 0.5rem;"+
                        "border: 1px solid rgb(236, 225, 225);"+
                        "box-shadow: rgba(0, 0, 0, 0.2) 0px 4px 8px 0px, rgba(0, 0, 0, 0.19) 0px 6px 20px 0px;"+
                        "}"+
                        ".about_us.section_subtitle{" +
                        "  text-align: center;" +
                        "}"+
//                        ".about_us_description{"+
//                        "text-align: justify;"+
//                        "}"+

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


                        // MEDIA QUERY FOR RESPONSIVE MOBILE VIEW
                        "@media only screen and (max-width: 900px) {" +
                        "body {" +
//                        "background-color: pink;" +
                        "}" +
                        ".header_container, .menu_items_container {" +
                        "margin: 2rem 2%;" +
                        "}" +
                        ".home_hero{" +
                        "  display: flex;" +
                        "  flex-direction: column;" +
                        "  align-items: center;" +
                        "  margin: 2rem 2%;" +
                        "  width: 100%;" +
                        "}" +
                        ".section_title{" +
                        "  font-size: 1.5rem;" +
                        "}" +
                        ".section_subtitle{" +
                        "  font-size: 1rem;" +
                        "text-transform: uppercase;"+
                        "}" +
                        ".hero_img{" +
                        "display: none;" +
                        "visibility: hidden;"+
                        "height: 0;"+
                        "width: 0;"+
                        "clip-path: polygon(0 0, 0 0, 0 0, 0 0);"+
                        "position: absolute;"+
                        "top: -9999px;"+
                        "left: -9999px;"+
                        "}" +
                        ".hero_image_container{" +
                        "  display: none;" +
                        "}" +
                        ".hero_image_mobile_container{" +
                        "  display: block;" +
                        "}" +
                        ".hero_img_mobile{" +
                        "  display: block;" +
                        "  max-width: 100vw;" +
                        "  height: auto;" +
                        "}" +
                        "}" +
                        "</style>" +

//                        APP CONTENT
                        "<header class=\"header_container\">" +
                        "<div>" +
                        "<a href=\"/\"><img src=\"https://previews.dropbox.com/p/thumb/ACI7SjvD_4PPADFAYzZUOTrctQEvVZtGAJhMs3xw0qqQ1CMFbAYZWt6Fga0h4tiwCDuYeuYriFtB-pKkzq4MbGH-PpkTDTtCFqVvZ62r40Lhn0FPUGG8tpAuYWpkmbVYuHto43K62vaoea3Rs_19yKxKk8lhmfO9W4hnPDFSCkKEybp9u19vbBpt-J8NosQIORM6DW3YpIRCXJKAsp3n3-CXqUaYSVxkkbTO-IVIWp-gt_JE3iOi9Rb3MEBQya0zdDf0xnOaFHPWMW2SQeAC-1AI9fYuTYqk58KD-aL6Rw1SoPq7xnZ1zFjyHTnMcyhVQ492O8p-FC0Pg_94A-RuL-tK/p.png\" alt=\"FoodTruck Logo\" style=\"max-width: 20%; height: auto;\"></img></a>" +
                        "</div>" +
                        "<div class=\"menu_items_container\">" +
                        "<a class=\"menu_item\" href=\"#AboutUs\" style=\"color: #333333;\"><p>About</p></a>" +
                        "<a href=\"foodStore\" style=\"color: #333333;\"><p>Products</p></a>" +
                        "<a href=\"customerList\" style=\"color: #333333;\"><p>Customers</p></a>" +
                        "<a href=\"adminLogin\" style=\"color: #333333;\"><p>Admin Login</p></a>"+
                        "<button class=\"register_btn\">Register</button>" +
                        "</div>" +
                        "</header>" +

                        "<section class=\"home_hero\">" +
                        "<div class=\"hero_content_container\">" +
                        "<div class=\"hero_content\">" +
                        "<h1 class=\"section_title\">Welcome onboard, <span class=\"title_span\">FoodTruck</span> Admin</h1>" +
                        "<h3 class=\"section_subtitle\">Fueling culinary excellence with premium ingredients</h3>" +
                        "<p class=\"section_description\">Embark on a gastronomic journey with Epicurean Haven, your go-to hub for the finest and freshest wholesale food products. Elevate your culinary creations with our high-quality ingredients, meticulously curated to meet the demands of your discerning customers. Discover the secret ingredient to success, where passion meets premium. Welcome to a world of unparalleled taste and quality!</p>" +
                        "<a href=\"/foodStore\"><button class=\"store_btn\">View FoodStore</button></a>" +
                        "<a href=\"/customerList\"><button class=\"customer_btn\">View Customers</button></a>" +
                        "</div>" +
                        "</div>" +
                        "<div class=\"hero_image_container\">" +
                        "<img class=\"hero_img\" src=\"https://previews.dropbox.com/p/thumb/ACLULmoDhCYa9znDIO0lLpjVsMA8m64nAlHaOj1yq4M4rSZQ42Y4g6fCNOcGyCu3wIw6YsK_TFRocoSlxjo2y3UoN8bUv4OlpS4cjjJ8PIPo5e0uteAcYouAyb8CBMGiyr6S9gzrKrcFpqqc6c7_Xs_aKmnO0Y6aTsYk4Ap0XLLVxi1Csw3k1gbcUC8bwcndYyRdIzoU5tJ_FMjqJ4OnoQQTlrZkr5y7G2jJdUQFltI2M6-Mg2WrTuf8k4JzFSSN53DK-HYYO-lBlHqFs2tmrldeTDV0RMqfNvf1h8pfL-vyuAAoWe0sb3mXx0kDYf6Mks4YWNp-2kOlOdUlb-V8n04w/p.jpeg\" alt=\"FoodTruck hero\"></img>" +
                        "</div>" +
                        "</section>" +

                        "<section class=\"about_us\" id=\"AboutUs\">" +
                        "<div>" +
                        "<h3 class=\"section_subtitle\" style=\"text-align: center;\">About us</h3>" +
                        "<p class=\"about_us_description\">At FoodTruck, we are on a mission to fuel culinary excellence with premium ingredients. We believe that every dish has the potential to be extraordinary, and it all starts with the quality of the ingredients. Our commitment is to provide you with the finest and freshest wholesale food products that will elevate your culinary creations to new heights.</p>"+
//                        "<br>"+
                        "<p class=\"about_us_description\">Embark on a gastronomic journey with us! As your go-to hub for premium ingredients, we understand the importance of sourcing only the best for your discerning customers. Our product selection is meticulously curated, ensuring that every item meets the highest standards of quality.</p>"+
                        "<p class=\"about_us_description\">We invite you to explore our extensive range of high-quality ingredients. From fresh produce to specialty items, we have everything you need to add that extra touch of perfection to your dishes. Elevate your culinary creations and delight your customers with flavors that stand out. Discover a world where passion meets premium. Whether you're a seasoned chef or a food enthusiast, FoodTruck is your partner in culinary excellence. Join us on this delicious journey, and let's create extraordinary flavors together!</p>"+
                        "</div>" +
                        "</div>" +
                        "</section>"+

                        "<footer>" +
                        "<div class=\"footer_content\">" +
                        "<img src=\"https://previews.dropbox.com/p/thumb/ACK5oqvf-LSqrUXXTApiiC3RhRZhjoluA03pmWduVPGiBDWnmSvzgKNZnmmmwdOUwHQ5tM87y1mwro4yCDyGfwg2B-jUGcbWXLGGR7vrdFhCJnWtheJtZdTz0cWAddyG5aDwDF9K8UMI9MFnkEMeB4tN79bLXdzmADO2iZkelLUn5P4jmJA4lCr08K8Sk0dFh2X6Mn_zqdN9_qx-dX4Xn52MkvryG0b92Zo-U5F3makhPXBY5nhrMwt75fHprmZvX3_oeEyVASWxSTTNddapouJx7UX-6MWfWRPB7gGGBqOS3642_NRHrB8vYm0R44aKgO2beRq0EfT3_2lrK1KSPfRw/p.png\" alt=\"FoodTruck Logo\" style=\"max-width: 5rem; height: auto;\"></img>"+
                        "<a target=\"blank\" href=\"https://www.nazanajemba.com/\"><p class=\"website_link\">Visit our website</p></a>"+
                        "<p class=\"copyright\">Favour Chinaza Anajemba &copy; 2024</p>"+
                        "</footer>"+
                        "</body>" +
                        "</html>"
        );
        out.close();
    }
}


