package com.grinyov.spring.rest_client.web;

import com.grinyov.spring.rest_client.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vgrinyov.
 */
@RestController
public class HealthCheckController {

    @Autowired
    private HealthService healthService;

    @RequestMapping("/check")
    public String checkStatus(){
        healthService.clearNumberOfAttempts();
        return healthService.getHealth();
    }
}
