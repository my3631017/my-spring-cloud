package com.service.consumer.service.feign.impl;

import com.service.consumer.service.feign.FeignService;
import org.springframework.stereotype.Component;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2018-11-22 15:11
 */
@Component
public class FeignServiceHystrix implements FeignService {
    @Override
    public String hello(String name) {
        return "远程调用失败 " + name + "，service has fail!";
    }
}
