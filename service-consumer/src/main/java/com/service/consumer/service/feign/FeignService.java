package com.service.consumer.service.feign;

import com.service.consumer.service.feign.impl.FeignServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2018-11-22 10:59
 */
@Service
@FeignClient(value = "service-provider" ,fallback = FeignServiceHystrix.class)
public interface FeignService {
    @GetMapping("hello")
    String hello(@RequestParam("name") String name);
}
