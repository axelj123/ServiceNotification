package Backend.notification.controller;

import Backend.notification.Service.PushNotificationService;
import Backend.notification.dto.NotificationRequest;
import org.springframework.web.bind.annotation.RequestBody;
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
    public String senNotification(@RequestBody NotificationRequest request){
        System.out.println("Recibido token: " + request.getToken());
        System.out.println("Título: " + request.getTitle());
        System.out.println("Mensaje: " + request.getMessage());

        // Llamar al servicio para enviar la notificación
        pushNotificationService.sendPushNotification(request.getToken(), request.getTitle(), request.getMessage());
        return "Notificación enviada";
    }

}
