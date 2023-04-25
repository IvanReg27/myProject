package org.example;

import org.example.service.EmailNotificationService;
import org.example.service.NotificationService;
import org.example.service.SmsNotificationService;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Controller {

   static Map<DELIVERY_CHANNEL, NotificationService> lookup = new HashMap<>();

    public static void init(String[] args) {
        String emailName = "xxx";
        String emailPassword = "xxx";
        NotificationService emailService =  new EmailNotificationService(emailName, emailPassword);

        String name = "xxx@gmail.com";
        String password = "xxx";

        NotificationService smsService = new SmsNotificationService(name, password);

        lookup.put(DELIVERY_CHANNEL.SMS, emailService);
        lookup.put(DELIVERY_CHANNEL.EMAIL, smsService);
    }
    enum DELIVERY_CHANNEL {
        SMS, EMAIL, TELEGRAM
    }
}