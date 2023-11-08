package com.sistema.examen.sistemaexamenesbackend.servicios;

import com.sistema.examen.sistemaexamenesbackend.modelo.Usuario;
import com.sistema.examen.sistemaexamenesbackend.modelo.UsuarioRol;


import java.util.Set;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    public Usuario obtenerUsuario(String username);

    public void eliminarUsuario(Long usuarioId);
}
