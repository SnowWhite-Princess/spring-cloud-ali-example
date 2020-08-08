package com.smart.order.config;

import com.netflix.loadbalancer.IRule;

import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 65%  spring  boot
 * 30   spring  cloud
 * 5    ssm  + jsp
 */
@Configuration
public class RibbonConfiguration {
    /**
     * 响应时间越长  权重就越小
     *
     * @return
     */
    @Bean
    public IRule iRule() {
//        return  new RoundRobinRule()
        return new WeightedResponseTimeRule();
    }

}
