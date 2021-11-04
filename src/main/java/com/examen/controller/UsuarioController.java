package com.examen.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.examen.entity.Usuario;
import com.examen.service.UsuarioServiceImpl;

@RestController
@RequestMapping("/rest/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Usuario>> listar(){
		List<Usuario> lista = usuarioService.listaUsuario();
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/consulta/{email}")
	@ResponseBody
	public ResponseEntity<List<Usuario>> consulta(@PathVariable("email") String email){
		List<Usuario> listaporemail = usuarioService.listaUsuarioporEmail(email);
		return ResponseEntity.ok(listaporemail);
	}

	@PostMapping("/registrar")
	@ResponseBody
	public ResponseEntity<Usuario> registrar(@RequestBody Usuario bean) {
		return ResponseEntity.ok(usuarioService.insertaActualizaUsuario(bean));
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseBody
	public ResponseEntity<Usuario> eliminar(@PathVariable("id") int id) {
		Optional<Usuario> optAlumno = usuarioService.obtienePorId(id);
		if(optAlumno.isPresent()) {
			usuarioService.eliminaUsuario(id);
			return ResponseEntity.ok(optAlumno.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}

}
