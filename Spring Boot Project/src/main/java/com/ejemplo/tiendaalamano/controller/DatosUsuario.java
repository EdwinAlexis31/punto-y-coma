package com.ejemplo.tiendaalamano.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ejemplo.tiendaalamano.model.Usuario;
import com.ejemplo.tiendaalamano.repository.UsuarioRepository;


@RequestMapping("/usuario")
public class DatosUsuario {
	
UsuarioRepository user;

	@GetMapping("/all")
	public ResponseEntity <List <Usuario>> importarCursos(@RequestParam(required=false) String nombre) {
		try {
			
			List <Usuario> cursos = new ArrayList<Usuario>();
			user.findAll().forEach(cursos::add);
			
			if(cursos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(cursos,HttpStatus.OK);
			}			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
