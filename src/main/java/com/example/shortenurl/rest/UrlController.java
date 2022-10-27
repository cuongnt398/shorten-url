package com.example.shortenurl.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/url")
public class UrlController {

    @GetMapping
    public String index() {
        return "index";
    }
}
