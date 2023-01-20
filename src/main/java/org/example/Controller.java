package org.example;

import org.example.service.EmailNotificationService;
import org.example.service.NotificationService;
import org.example.service.SmsNotificationService;

import java.util.HashMap;
import java.util.Map;

public class Controller {

   static Map<DELIVERY_CHANNEL, NotificationService> lookup = new HashMap<>();

    public static void init(String[] args) {
        String emailName = "53ffc361c9d9692e9060ef89c18f1c11"; //check  in group
        String emailPassword = "47db15682b550bdf44e2609e94c0dd4a"; //check  in group
        NotificationService emailService =  new EmailNotificationService(emailName, emailPassword);

        String name = "isicju@gmail.com"; //check  in group
        String password = "MjHqfCWBKh63W12Ognw5aM4XzR"; //check in group

        NotificationService smsService = new SmsNotificationService(name, password);

        lookup.put(DELIVERY_CHANNEL.SMS, emailService);
        lookup.put(DELIVERY_CHANNEL.EMAIL, smsService);
    }

//    public void sendMessage(DELIVERY_CHANNEL deliveryChannel, String recipient, String content) {
//        lookup.get(DELIVERY_CHANNEL.SMS).sendMessage(recipient, content);
//    }

    enum DELIVERY_CHANNEL {
        SMS, EMAIL, TELEGRAM
    }
}