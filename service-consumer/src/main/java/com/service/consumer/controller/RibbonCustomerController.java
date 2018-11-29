package com.service.consumer.controller;

import com.service.consumer.service.ribbon.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2018-11-22 17:00
 */
@RestController
public class RibbonCustomerController {
    private final ExampleService exampleService;

    @Autowired
    public RibbonCustomerController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @RequestMapping(value = "/hello/ribbon", method = RequestMethod.GET)
    public String indexRibbon(String name) {
        return exampleService.hello(name+"88888");
    }
}
