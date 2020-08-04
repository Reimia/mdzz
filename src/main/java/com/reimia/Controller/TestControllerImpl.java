package com.reimia.Controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControllerImpl implements TestController {

    @Override
    public MdzzDTO test() {
        MdzzDTO mdzzDTO= new MdzzDTO();
        mdzzDTO.setParam1("11111111");
        mdzzDTO.setParam2("222222222");
        mdzzDTO.setParam3("3333333333");
        System.out.println(mdzzDTO.toString());
        return mdzzDTO;
    }
}
