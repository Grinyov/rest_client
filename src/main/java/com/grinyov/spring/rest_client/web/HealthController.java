package com.grinyov.spring.rest_client.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by vgrinyov.
 */
@RestController
public class HealthController {
    @RequestMapping("/health")
    public ResponseEntity<String> getStatus(){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(2);
        if ((randomInt == 1)) {
            return new ResponseEntity<>("INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
