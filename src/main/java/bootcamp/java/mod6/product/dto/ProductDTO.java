package bootcamp.java.mod6.product.dto;

import bootcamp.java.mod6.product.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {
    private int id;
    private String name;
    private double price;

    public ProductDTO() {}

    public ProductDTO(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static Product convert(ProductDTO dto) {
        Product p = new Product(dto.name, dto.price);
        p.setId(dto.id);
        return p;
    }

    public static ProductDTO from(Product p) {
        if (p == null) {
            return null;
        }
        ProductDTO dto = new ProductDTO();
        dto.id = p.getId();
        dto.price = p.getPrice();
        dto.name = p.getName();
        return dto;
    }

    public static List<ProductDTO> from(List<Product> ps) {
        List<ProductDTO> res = new ArrayList<>();
        for (Product p : ps) {
            if (p != null) {
                res.add(new ProductDTO(p.getId(), p.getName(), p.getPrice()));
            }
        }
        return res;
    }
}
