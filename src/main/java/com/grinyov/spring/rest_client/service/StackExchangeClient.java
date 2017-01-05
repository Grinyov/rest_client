package com.grinyov.spring.rest_client.service;

import com.grinyov.spring.rest_client.service.dto.SiteDto;
import com.grinyov.spring.rest_client.service.dto.SitesDto;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by grinyov
 */
@Component
public class StackExchangeClient {

    HttpClient httpClient = HttpClientBuilder.create().build();
    ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);

    private RestTemplate restTemplate = new RestTemplate(requestFactory);

    public List<SiteDto> getSites() {
        String url = "https://api.stackexchange.com/2.2/sites?page=1&pagesize=99999&filter=!Fn4IB7S7T4v-QOAVmFyqlc(HdV";

        try {
            SitesDto responce = null;
            responce = restTemplate.getForObject(new URI(url), SitesDto.class);
            return responce.getItems();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }
}
