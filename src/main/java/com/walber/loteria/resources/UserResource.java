package com.walber.loteria.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walber.loteria.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	/*endpoint para acesso de usuários */
	
	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "maria", "walberfellipe@gmail.com", "zezinho");
		return ResponseEntity.ok().body(u);
	}
}
