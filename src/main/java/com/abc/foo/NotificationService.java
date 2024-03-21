package com.abc.foo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

// 4 types of bean you can ask SpringBoot to manage for you
//@Component
//@Service
//@Repository
//@Controller
//@RestController

//@Service // usually do this but can give our own name as below to avaoid possible collision
@Service("zzneal sService")
public class NotificationService {

    public NotificationService() {

    }

    public void send() {
    }

    public void sendSync() {
    }

    @Override
    public String toString() {
        return ("<H1>Msg from Notification Instance</H1>");
    }
}

