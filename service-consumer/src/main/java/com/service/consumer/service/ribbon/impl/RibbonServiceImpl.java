package com.service.consumer.service.ribbon.impl;

import com.service.consumer.service.ribbon.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2018-11-21 16:08
 */
@Service
public class RibbonServiceImpl implements ExampleService {
    private final RestTemplate restTemplate;

    @Autowired
    public RibbonServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String hello(String name) {
        return restTemplate.getForObject("http://service-provider/hello?name="+name, String.class);
    }
}
