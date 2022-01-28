package io.github.lsj8367.web;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<Map<String, String>> hello() {
        return ResponseEntity.ok(Map.of("key", "hello"));
    }

}
