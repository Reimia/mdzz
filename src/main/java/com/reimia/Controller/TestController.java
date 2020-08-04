package com.reimia.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


public interface TestController {

    @PostMapping("/test")
    MdzzDTO test();
}
