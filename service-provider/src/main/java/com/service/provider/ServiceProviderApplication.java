package com.service.provider;

import com.service.provider.config.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
//向服务中心注册发现
@EnableDiscoveryClient
@EnableScheduling
public class ServiceProviderApplication {

	@Autowired
	private KafkaSender kafkaSender;

	public static void main(String[] args) {
		SpringApplication.run(ServiceProviderApplication.class, args);
	}

	//然后每隔1分钟执行一次
	@Scheduled(fixedRate = 1000 * 60)
	public void testKafka() throws Exception {
		kafkaSender.sendTest();
	}
}
