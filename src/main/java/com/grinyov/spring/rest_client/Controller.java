package com.grinyov.spring.rest_client;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by vgrinyov.
 */
@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/hello")
    public String showHello() {
        return "hello";
    }
}
