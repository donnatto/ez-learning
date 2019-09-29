package com.ezlearning.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * MVC Index Controller
 */
@Controller
public class Index {
    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }
}
