package com.service.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//向服务中心注册发现
@EnableDiscoveryClient
//表明为Eureka客户端
@EnableEurekaClient
//启用feign进行远程调用
@EnableFeignClients
public class ServiceConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceConsumerApplication.class, args);
	}

	@Bean
	//表明restTemplate使用LoadBalancerClient执行请求
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
