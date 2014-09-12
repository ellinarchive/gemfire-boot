package com.ellin.gf8.demo;
import com.ellin.gf8.demo.controller.HelloController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.gemfire.RegionFactoryBean;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
@ComponentScan
@ImportResource("gemfire-context.xml")
@EnableGemfireRepositories()
@EnableTransactionManagement

public class Application {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext xtx = SpringApplication.run(Application.class, args);

        HelloController c =    xtx.getBean(HelloController.class);

        c.doSomeStuff();

        xtx.stop();

    }



}
