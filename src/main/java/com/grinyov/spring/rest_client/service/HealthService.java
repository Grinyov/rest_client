package com.grinyov.spring.rest_client.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by vgrinyov.
 */
@Service
public class HealthService {

    @Value("${app.health.healthCheckAddress}")
    private String healthCheckAddress;

    private int attempt;

    private RestTemplate restTemplate = new RestTemplate();

    // annotation set value and period attempts
    @Retryable(maxAttempts = 10, value = RuntimeException.class, backoff = @Backoff(delay = 500, multiplier = 2))
    public String getHealth() {
        attempt++;
        return restTemplate.getForObject(healthCheckAddress, String.class) + " - " + attempt + " attempt(s)";
    }

    @Recover
    public String recoverService(){
        return "service unavailable";
    }

    public void clearNumberOfAttempts(){
        attempt = 0;
    }
}
