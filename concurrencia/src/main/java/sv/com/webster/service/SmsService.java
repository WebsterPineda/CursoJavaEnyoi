package sv.com.webster.service;

public class SmsService {
  public boolean sendSms() {
    System.out.println("Se enviara el SMS");

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Se ha enviado el SMS");
    return true;
  }
}
