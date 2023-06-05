package com.fatec.pro4tech.controllers.Funcionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.pro4tech.entities.Funcionario;
import com.fatec.pro4tech.security.roles.roles;
import com.fatec.pro4tech.services.responseentities.Email.EmailSenderService;
// import com.fatec.pro4tech.entities.titulos;
import com.fatec.pro4tech.services.responseentities.userapp.UserAppWriterService;
import jakarta.mail.MessagingException;
import jakarta.annotation.security.PermitAll;

@CrossOrigin
@RestController
public class CreateFuncionario {
    @Autowired
	private UserAppWriterService userWriter;
	@Autowired
	private EmailSenderService emailSenderService;

	@PostMapping("/funcionarios/cadastrar")
	@PermitAll
	public ResponseEntity<?> saveUser( @RequestBody Funcionario user) {
		user.getCredential().setRole(roles.Sem_Cargo);
		return userWriter.save(user);
	}

	@PostMapping("/email")
    @PermitAll
    public ResponseEntity<?> sendEmail() {
        try {
            String toEmail = "lucasviniciuswinner2012@gmail.com";
            String subject = "Teste de Email";
            String body = "Este é um teste de envio de email.";

            // Caminho completo do arquivo a ser anexado
            String filePath = "C:/Users/lucas/OneDrive/Área de Trabalho/aaa/teste.pdf";

            emailSenderService.sendEmailWithAttachment(toEmail, subject, body, filePath);

            return ResponseEntity.ok("Email sent successfully.");
        } catch (MessagingException e) {
            return ResponseEntity.status(500).body("Failed to send email: " + e.getMessage());
        }
    }
}
