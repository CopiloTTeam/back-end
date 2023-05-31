// package com.fatec.pro4tech.services.responseentities.Email;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.context.event.ApplicationReadyEvent;
// import org.springframework.context.event.EventListener;

// import jakarta.mail.MessagingException;

// @SpringBootApplication
// public class SpringEmailDemoApplication {

//     @Autowired
//     private EmailSenderService senderService;

//     public static void main(String[] args) {
//         SpringApplication.run(SpringEmailDemoApplication.class, args);
//     }

//     @EventListener(ApplicationReadyEvent.class)
//     public void triggerMail() throws MessagingException {
//         String toEmail = "lucasviniciuswinner2012@gmail.com";
//         String subject = "Email with Attachment";
//         String body = "Please find the attached file.";

//         // Caminho completo do arquivo a ser anexado
//         String filePath = "C:/Users/lucas/OneDrive/Área de Trabalho/aaa/teste.pdf";

//         senderService.sendEmailWithAttachment(toEmail, subject, body, filePath);
//     }
// }