package com.example.demo;

import com.abc.foo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

// add the following otherwise @SpringBooApplication only looks in current package
@ComponentScan(basePackages = "com.example.demo, com.abc.foo")
@SpringBootApplication  // convenience method for the following 3
//@Configuration  // says this class is a source of bean definitions from the application context
//@EnableAutoConfiguration  // scan for components, services in this PACKAGE
@EnableConfigurationProperties
public class Demo1Application {

    // one method to add a bean into application context
    // name of the method becomes the name of the bea but we can override
    // or can override name here
    @Bean
    public User zzUser() {
        return new User("ajay", "weinstein", "a@gmail.com");
    }

    public static void main(String[] args) {

        // list all the beans that the ApplicationContext is monitoring
        // notice how we were able to add NotificationServices from other package
        ApplicationContext ctx = SpringApplication.run(Demo1Application.class, args);


        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String name : beanNames) {
            System.out.println("name = " + name);
        }

        System.out.println(ctx.getBean("zzUser").toString());
        System.out.println(ctx.getBean("myAppConfig").toString());
        System.out.println("===========================");

        MyAppConfig myAppConfig = (MyAppConfig) ctx.getBean("myAppConfig");
        System.out.println("MyAppConfig=" + myAppConfig.toString());

        // if not obtaining context can do
        //SpringApplication.run(Dem1Application.class, args);
    }
}
