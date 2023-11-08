package com.sistema.examen.sistemaexamenesbackend.repositorios;

import com.sistema.examen.sistemaexamenesbackend.modelo.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    public Usuario findByUsername(String username);

}
