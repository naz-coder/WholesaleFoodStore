package StoreInventory;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
public class AdminLoginPageHandler implements HttpHandler {
    public void handle(HttpExchange he) throws IOException{
        String response = "Admin Login ";
        he.sendResponseHeaders(200, 0);
        BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(he.getResponseBody()));

        out.write(" "); // Login page and input forms


        String username = "Favour"; //assign username from input form
        String password = "12345"; //assign password from input form
//        String username = "admin"; //assign username from input form
//        String password = "adminPassword"; //assign password from input form
        User authenticatedUser = UserAuthManager.authenticate(username, password);
        if (authenticatedUser != null){
//            // Redirect to admin's home page
            he.getResponseHeaders().set("Location", "/adminHome");
            he.sendResponseHeaders(302, -1);

        }else{
            //Show modal for invalid login credentials
        }
//        LOGIN MODAL HERE
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
                        ".home_route_btn{" +
                        "  margin: 0rem 0rem 0rem 2rem;" +
                        "  padding: 0.7rem 1.2rem;" +
                        "}" +
                        "a, a.menu_item, .menu_item{" +
                        "  text-decoration: none;" +
                        "}" +

//                        MODAL STYLES
                        ".modal {" +
                        "position: fixed;" +
                        "z-index: 1;" +
                        "left: 0;" +
                        "top: 0;" +
                        "bottom: 0;" +
                        "right: 0;" +
                        "width: 100%;" +
                        "height: 100%;" +
                        "overflow: auto;" +
                        "background-color: #888888;" +
                        "background: linear-gradient(rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.7))"+
                        "}" +
                        ".modal-content {" +
                        "  background-position: right bottom;" +
                        "    transition: all 0.5s ease;" +
                        "    padding: 20px;" +
//                        "    width: 100%;" +
//                        "    max-width: 350px;" +
                        "    border-radius: 1rem;" +
                        "    border: 1px solid #ffffff;" +
                        "    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);" +
                        "background-color: #ffffff;" +
                        "  margin: 15% auto;" +
                        "  width: 25%;" +
                        "}" +
                        "span.close {" +
                        "  color: #aaa;" +
                        "  float: right;" +
                        "  font-size: 28px;" +
                        "  font-weight: bold;" +
                        "  cursor: pointer;" +
                        "}" +
                        "span.close:hover, span.close:focus {" +
                        "  color: black;" +
                        "  text-decoration: none;" +
                        "  cursor: pointer;" +
                        "}" +
                        ".modal_title{" +
                        "  color: #F86532;" +
                        "  text-align: center;" +
                        "}" +
                        "label{"+
                        "color: #004A2F;" +
                        "    font-size: 16px;" +
                        "    font-weight: 900;"+
                        "    display: block;"+
                        "padding-bottom: 0.3rem;"+
                        "}"+
                        "input{"+
                        "border: 1px solid #A4A2A7;" +
                        "    border-radius: 0.3rem;" +
                        "    height: 4.6vh;" +
                        "    width: 25vw;" +
                        "    margin-bottom: 0.7rem;" +
                        "    padding-left: 0.5rem;"+
                        "    font-size: 16px;" +
                        "}"+
                        "input:focus{"+
                        "border: 1px solid #A4A2A7;" +
                        "    outline: none;" +
                        "}"+
                        ".login_btn{" +
                        "  background-color: #004A2F;" +
                        "  padding: 1rem;" +
                        "  margin-top: 1rem;" +
                        "  border-radius: 0.5rem;" +
                        "  border: 1px solid #004A2F;" +
                        "  font-size: 1rem;" +
                        "  color: #ffffff;" +
                        "    height: 3rem;" +
                        "    width: 25vw;" +
                        "}" +
                        ".login_btn:hover{" +
                        "  background-color: #002F35;" +
                        "  border: 1px solid #002F35;" +
                        "  color: #ffffff;" +
                        "}" +
                        "}" +
                        "</style>" +

//                        APP CONTENT

//                        FORM  MODAL HERE
                        "<div id=\"loginModal\" class=\"modal\">" +
                        "<div class=\"modal-content\">" +
                        "<a href=\"/\" class=\"home_route_btn\"><span class=\"close\" onclick=\"closeModal()\">&times;</span></a>" +
                        "<h2 class=\"modal_title\">Admin Login</h2>" +
                        "<form id=\"loginForm\">" +
                        "<label for=\"username\">Username:</label>" +
                        "<input type=\"text\" id=\"username\" name=\"username\" required>" +
                        "<br>"+"<br>"+
                        "<label for=\"password\">Password:</label>" +
                        "<input type=\"password\" id=\"password\" name=\"password\" required>" +
                        "<br>"+
                        "<input type=\"submit\" value=\"Login\" class=\"login_btn\">" +
//                        "<button type=\"button\" onclick=\"submitLoginForm()\">Login</button>" +
                        "</form>" +
                        "</div>" +
                        "</div>" +
                        "</body>" +
                        "</html>"
        );
        out.close();
    }

}