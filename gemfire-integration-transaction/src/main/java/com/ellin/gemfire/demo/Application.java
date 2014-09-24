package com.ellin.gemfire.demo;
import com.ellin.gemfire.demo.service.HelloService;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.text.SimpleDateFormat;

@Configuration
@ComponentScan
@ImportResource("Integration.xml")
@EnableTransactionManagement
public class Application {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        HelloService c =    context.getBean(HelloService.class);
        c.doSomeStuff();


    }



}
