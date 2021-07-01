package bootcamp.java.mod6.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class MapResponse extends Response<Map<String, Object>> {
    public MapResponse() {
        super();
        setData(new HashMap<>());
    }

    public MapResponse(HttpStatus status) {
        super(status);
        setData(new HashMap<>());
    }

    public void put(String k, Object v) {
        getData().put(k, v);
    }
}
