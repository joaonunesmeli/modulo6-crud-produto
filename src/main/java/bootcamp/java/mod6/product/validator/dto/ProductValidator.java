package bootcamp.java.mod6.product.validator.dto;

import bootcamp.java.mod6.product.dto.ProductDTO;

import java.util.HashMap;
import java.util.Map;

public final class ProductValidator {
    private ProductValidator() {}

    public static Map<String, String> validate(ProductDTO dto) {
        Map<String, String> err = new HashMap<>();
        if (dto.getName().length() < 3) {
            err.put("name", "Nome muito curto");
        }
        if (dto.getPrice() < 0.01) {
            err.put("price", "Preço deve ser maior ou igual a R$ 0.01");
        }
        return err.size() > 0 ? err : null;
    }
}
