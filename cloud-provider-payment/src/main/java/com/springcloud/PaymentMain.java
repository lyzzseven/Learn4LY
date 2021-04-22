package com.springcloud;

import com.springcloud.entities.Eknown;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author liuyang
 * @version 1.0
 * @date 2020/8/2 10:01 上午
 */
@SpringBootApplication
@EnableConfigurationProperties({Eknown.class})
public class PaymentMain {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain.class,args);
    }
}
