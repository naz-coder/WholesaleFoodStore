package StoreInventory;

import java.util.HashMap;
import java.util.Map;

public class UserAuthManager {
    private static final Map<String, User> userDatabase = new HashMap<>();
    static {
        userDatabase.put("admin", new User("admin", "adminPassword", true));
        userDatabase.put("user1", new User("user1", "user1Password", false));
        userDatabase.put("user2", new User("user2", "user2Password", false));
    }
    public static  User authenticate(String username, String password){
        User user = userDatabase.get(username);
        if(user != null && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }
}
