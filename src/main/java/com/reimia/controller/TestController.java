package com.reimia.controller;

import org.springframework.web.bind.annotation.PostMapping;


public interface TestController {

    @PostMapping("/test")
    MdzzDTO test();
}
