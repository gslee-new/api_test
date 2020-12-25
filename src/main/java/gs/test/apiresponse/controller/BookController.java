package gs.test.apiresponse.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BookController {

    @GetMapping("/{id}")
    public Map<Integer, String> findById(@PathVariable String id) {
        Map<Integer, String> map = new HashMap<>();


        if ("ddd".equals(id)) {
            map.put(404, new BookNotFoundException(id).toString());
        } else {
            try {
                map.put(Integer.parseInt(id), id);
            } catch (Exception e) {
                map.put(500, e.getMessage());
            }

        }
        return map;
    }

    @RequestMapping("/errorCode")
    public ResponseEntity<String> errorCodeData() {

        return new ResponseEntity<>("hello", HttpStatus.BAD_REQUEST);
    }
}
