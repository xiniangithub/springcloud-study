package com.wez.ribbon.rule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

/**
 * 自定义负载均衡配置类
 * 注意：该负载均衡配置类不能放在@ComponentScan所扫描的当前包下以及子包下，否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享
 * @author Admin
 *
 */
@Configuration
public class CustomLoadBalancedRuleConfig {
	
	@Bean
	public IRule getCustomLoadBalancedRule() {
		return new RoundFiveRule();
	}

}
