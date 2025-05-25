import java.util.ArrayList;
import java.util.HashMap;

public class DataStore {
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Admin> admins = new ArrayList<>();
    public static HashMap<String, Request> requests = new HashMap<>();

    static {
        admins.add(new Admin("nayab", "nayabADMIN123"));
    }

    public static User findUser(String email, String password) {
        for (User u : users)
            if (u.email.equals(email) && u.password.equals(password))
                return u;
        return null;
    }

    public static Admin findAdmin(String username, String password) {
        for (Admin a : admins)
            if (a.username.equals(username) && a.password.equals(password) && a.isValidAdmin())
                return a;
        return null;
    }

    public static void addUser(User user) {
        users.add(user);
    }

    public static void addRequest(Request request) {
        requests.put(request.email, request);
    }

    public static Request getRequest(String email) {
        return requests.get(email);
    }
}
