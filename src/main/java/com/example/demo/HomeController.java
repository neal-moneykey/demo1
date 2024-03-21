package com.example.demo;

import com.abc.foo.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    // inject value from property file
    @Value("${valueFromPropertiesFile}")
    private String msgFromProperties;

    // inject a value from YAML
    @Value("${valueFromYAMLFile.msg}")
    private String msgFromYAMLFile;

    // get value from e
    @Value("${spring.profiles.active}")
    private String txtFromProfile;

    @Value("${profileProperty}")
    private String profileProperty;

    // inject instance into property
    //@Autowired
    private NotificationService notificationService;

    // better than autowiring variable directly for testing purposes?
    @Autowired
    public HomeController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RequestMapping("/")
    public String home() {

        //return("<H1>Hello Neal - NGU</H1>");
        String msg = notificationService.toString() +
                msgFromProperties +
                msgFromYAMLFile +
                "<br>" + txtFromProfile +
                "<br>" + profileProperty;

        return (msg);
    }
}
