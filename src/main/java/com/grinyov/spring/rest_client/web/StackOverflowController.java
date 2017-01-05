package com.grinyov.spring.rest_client.web;

import com.grinyov.spring.rest_client.model.StackOverflowWebsite;
import com.grinyov.spring.rest_client.service.StackoverflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Created by vgrinyov.
 */
@RestController
@RequestMapping("/api/stackoverflow")
public class StackOverflowController {

    @Autowired
    private StackoverflowService stackoverflowService;

    @RequestMapping
    public List<StackOverflowWebsite> getListOfProviders(){
        return stackoverflowService.findAll();
    }
}
