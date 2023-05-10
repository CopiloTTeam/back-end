// package com.fatec.pro4tech.controllers.Titulo;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// import com.fatec.pro4tech.entities.Titulo;
// import com.fatec.pro4tech.services.responseentities.tituloapp.TituloAppWriterService;

// import jakarta.annotation.security.PermitAll;

// @CrossOrigin
// @RestController
// public class UpdateTitulo {
//     @Autowired
// 	private TituloAppWriterService userWriter;

// 	@PostMapping("/cadastrar/titulo")
// 	@PermitAll
// 	public ResponseEntity<?> saveUser(@RequestBody Titulo user) {
// 		return userWriter.save(user);
// 	}
// }
