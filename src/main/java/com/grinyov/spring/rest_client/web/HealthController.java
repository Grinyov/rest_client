package com.grinyov.spring.rest_client.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vgrinyov.
 */
@RestController
public class HealthController {
    @RequestMapping("/health")
    public String getStatus(){
        return "Ok";
    }
}
