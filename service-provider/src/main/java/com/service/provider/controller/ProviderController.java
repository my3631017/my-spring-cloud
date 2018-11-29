package com.service.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2018-11-21 16:16
 */
@RestController
public class ProviderController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(String name) {
        return "Hello " + name + "! I'm Spring Cloud";
    }
}
