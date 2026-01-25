
// product 
interface Notification {
   void send(String recipient , String message);    
}

// concrete product
class SMSNotification  implements Notification{

    @Override
    public void send(String recipient, String message) {
        System.out.println("SMS send"+ "to" + recipient + "message"+ message );
    }
    
}

// concrete product 
class EmailNotification  implements Notification{

    @Override
    public void send(String recipient, String message) {
        System.out.println("Email send"+ "to" + recipient + "message"+ message );
    }
    
}

// factory 
interface NotificationFactory {
    Notification createNotification();
}

// concrete factory
class SMSNotificationFactory implements NotificationFactory {

    @Override
    public Notification createNotification() {
         return new SMSNotification();
    }
}

// concrete factory
class EmailNotificationFactory implements NotificationFactory {

    @Override
    public Notification createNotification() {
         return new EmailNotification();
    }
}
// Service
class NotificationService {
    private final NotificationFactory factory;
    NotificationService(NotificationFactory factory){
        this.factory= factory;
    }
    public void send(String recipient ,String message){
        Notification notification = factory.createNotification();
        notification.send(recipient, message);
    }
}
public class Solution {
    public static void main(String[] args) {
        NotificationFactory factory = new SMSNotificationFactory();
        NotificationService service= new NotificationService(factory);
        service.send("karan4143@gmail.com", "hii there");
    }
}
