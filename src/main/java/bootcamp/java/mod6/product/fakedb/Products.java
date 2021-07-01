package bootcamp.java.mod6.product.fakedb;

import bootcamp.java.mod6.product.entity.Product;

import java.util.*;

public final class Products {
    private static Map<Integer, Product> products = new HashMap<>();
    private static int nextId = 1;

    private Products() {}

    public static Product byId(int id) {
        return products.get(id);
    }

    public static List<Product> all() {
        return new ArrayList<>(products.values());
    }

    public static int save(Product p) {
        int id = nextId++;
        p.setId(id);
        products.put(id, p);
        return id;
    }

    public static void update(Product p) {
        products.put(p.getId(), p);
    }

    public static void remove(int id) {
        products.remove(id);
    }
}
