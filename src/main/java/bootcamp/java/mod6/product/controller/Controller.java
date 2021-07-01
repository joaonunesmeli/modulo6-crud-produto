package bootcamp.java.mod6.product.controller;

import bootcamp.java.mod6.product.dto.ProductDTO;
import bootcamp.java.mod6.product.fakedb.Products;
import bootcamp.java.mod6.product.validator.dto.ProductValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class Controller {
    @PostMapping("/")
    public ResponseEntity<Response<Map<String, Object>>> createProduct(@RequestBody ProductDTO dto, UriComponentsBuilder uriBuilder) {
        MapResponse resp = new MapResponse(HttpStatus.CREATED);
        resp.setError(ProductValidator.validate(dto));
        if (resp.hasError()) {
            return resp.createResponseEntity();
        }

        int id = Products.save(ProductDTO.convert(dto));
        URI uri = uriBuilder.path("/products/{id}").buildAndExpand(id).toUri();
        resp.put("id", id);
        return resp.createResponseEntity(uri);
    }

    @GetMapping("/{id}")
    public Response<ProductDTO> getProduct(@PathVariable int id) {
        return new Response<>(ProductDTO.from(Products.byId(id)));
    }

    @GetMapping("/")
    public Response<List<ProductDTO>> getAllProducts() {
        return new Response<>(ProductDTO.from(Products.all()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<Map<String, Object>>> updateProduct(@PathVariable int id, @RequestBody ProductDTO dto) {
        MapResponse resp = new MapResponse();
        resp.setError(ProductValidator.validate(dto));
        if (resp.hasError()) {
            return resp.createResponseEntity();
        }

        dto.setId(id);
        Products.update(ProductDTO.convert(dto));
        resp.put("id", id);
        return resp.createResponseEntity();
    }

    @DeleteMapping("/{id}")
    public MapResponse deleteProduct(@PathVariable int id) {
        MapResponse resp = new MapResponse();
        Products.remove(id);
        resp.put("id", id);
        return resp;
    }
}
