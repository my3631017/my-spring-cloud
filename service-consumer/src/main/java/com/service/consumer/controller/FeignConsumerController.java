package com.service.consumer.controller;

import com.service.consumer.service.feign.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class FeignConsumerController {
    private final FeignService feignService;

    @Autowired
    public FeignConsumerController(FeignService feignService) {
        this.feignService = feignService;
    }

    @RequestMapping(value = "/hello/feign", method = RequestMethod.GET)
    public String indexFeign(String name) {
        return feignService.hello(name+"66666");
    }
}
