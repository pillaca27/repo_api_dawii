package com.examen.service;

import java.util.List;
import java.util.Optional;

import com.examen.entity.Usuario;

public interface UsuarioService {

	public abstract List<Usuario> listaUsuario();
	public abstract Usuario insertaActualizaUsuario(Usuario obj);
	public abstract Optional<Usuario> obtienePorId(int id);
	public abstract void eliminaUsuario(int id);
	public abstract List<Usuario> listaUsuarioporEmail(String email);
	
	
}
