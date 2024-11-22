package Backend.notification.Service;


import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PushNotificationService {

    private final String expoPushUrl = "https://exp.host/--/api/v2/push/send"; // URL de Expo



    public void sendPushNotification(String token, String title, String message) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");

        String jsonPayload = String.format(
                "{\"to\": \"%s\", \"title\": \"%s\", \"body\": \"%s\"}",
                token, title, message
        );

        HttpEntity<String> entity = new HttpEntity<>(jsonPayload, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                expoPushUrl, HttpMethod.POST, entity, String.class
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Notificación enviada correctamente");
        } else {
            System.out.println("Error al enviar notificación: " + response.getStatusCode());
        }
    }

}
