package com.wez.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

	@Bean
	@LoadBalanced // Ribbon负载均衡，默认是轮询
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
}
