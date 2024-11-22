package Backend.notification.controller;

import Backend.notification.Service.PushNotificationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PushNotificationController {


    private final PushNotificationService pushNotificationService;

    public PushNotificationController(PushNotificationService pushNotificationService) {
        this.pushNotificationService = pushNotificationService;
    }

    @RequestMapping(value = "/sendNotification", method = RequestMethod.POST)
    public String senNotification(String token, String title, String message){
        System.out.println("Recibido token: " + token);
        System.out.println("Título: " + title);
        System.out.println("Mensaje: " + message);
        pushNotificationService.sendPushNotification(token, title, message);
        return "Notificación enviada";
    }

}
