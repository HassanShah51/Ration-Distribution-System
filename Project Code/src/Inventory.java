import java.util.HashMap;

public class Inventory {
    public static HashMap<String, Integer> stock = new HashMap<>();

    static {
        stock.put("Lahore", 200);
        stock.put("Karachi", 200);
        stock.put("Islamabad", 200);
    }

    public static void updateStock(String city, int qty) {
        stock.put(city, stock.getOrDefault(city, 0) + qty);
    }

    public static void reduceStock(String city, int qty) {
        stock.put(city, Math.max(0, stock.getOrDefault(city, 0) - qty));
    }

    public static int getStock(String city) {
        return stock.getOrDefault(city, 0);
    }
}


