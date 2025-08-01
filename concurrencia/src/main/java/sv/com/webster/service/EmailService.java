package sv.com.webster.service;

public class EmailService {
  public boolean sendEmail() {
    System.out.println("Se genero el email");

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Se ha enviado el SMS");
    return true;
  }
}
