package sv.com.webster;

import java.util.concurrent.CompletableFuture;
import sv.com.webster.service.EmailService;
import sv.com.webster.service.SmsService;

public class MainFuture {
  public static void main(String[] args) {
    SmsService smsService = new SmsService();
    EmailService emailService = new EmailService();

    CompletableFuture.supplyAsync(smsService::sendSms)
      .thenCombine(CompletableFuture.supplyAsync(emailService::sendEmail), (smsRsp, emailRsp) -> smsRsp.booleanValue() && emailRsp.booleanValue())
      .thenAccept(rst -> {
        if (rst.booleanValue()) {
          System.out.println("El proceso finalizo con exito");
        } else {
          System.out.println("El proceso fallo en algun punto");
        }
      });

    System.out.println("Presione una tecla para finalizar la ejecucion...");
    try {
      System.in.read();
    } catch (Exception e) {

    }
  }
}
