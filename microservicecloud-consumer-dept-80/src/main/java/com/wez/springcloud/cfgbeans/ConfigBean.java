package com.wez.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class ConfigBean {

	@Bean
	@LoadBalanced // Ribbon负载均衡，默认是轮询
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	// 设置负载均衡策略。（使用Ribbon提供的负载均衡策略）
	/*@Bean
	public IRule loadRalancedRule() {
//		return new RoundRobinRule(); // 轮询策略，默认的。
		return new RandomRule(); // 随机策略
	}*/
	
}
