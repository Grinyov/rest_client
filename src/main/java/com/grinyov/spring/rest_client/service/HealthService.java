package com.grinyov.spring.rest_client.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by vgrinyov.
 */
@Service
public class HealthService {

    @Value("${app.health.healthCheckAddress}")
    private String healthCheckAddress;

    private RestTemplate restTemplate = new RestTemplate();

    public String getHealth() {
        return restTemplate.getForObject(healthCheckAddress, String.class);
    }
}
