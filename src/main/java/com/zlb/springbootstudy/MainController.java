package com.zlb.springbootstudy;

import com.alibaba.fastjson.JSON;
import com.zlb.springbootstudy.yaml.Config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Bean
    @ConfigurationProperties(prefix="spring.redis")
    public Config getConfig() {
        return new Config();
    }

    @RequestMapping("/")
    String home() {
        System.out.println(JSON.toJSONString(JSON.toJSONString(getConfig())));
        return "Hello World!";
    }
}
