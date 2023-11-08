package com.sistema.examen.sistemaexamenesbackend.servicios.impl;

import com.sistema.examen.sistemaexamenesbackend.exeptions.UsuarioFoundExeption;
import com.sistema.examen.sistemaexamenesbackend.modelo.Usuario;
import com.sistema.examen.sistemaexamenesbackend.modelo.UsuarioRol;
import com.sistema.examen.sistemaexamenesbackend.repositorios.RolRepository;
import com.sistema.examen.sistemaexamenesbackend.repositorios.UsuarioRepository;
import com.sistema.examen.sistemaexamenesbackend.servicios.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
        if(usuarioLocal != null){
            System.out.println("El usuario ya existe");
            throw new UsuarioFoundExeption("El usuario ya esta presente");
        }
        else{
            for(UsuarioRol usuarioRol:usuarioRoles){
                rolRepository.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            usuarioLocal = usuarioRepository.save(usuario);
        }
        return usuarioLocal;
    }

    @Override
    public Usuario obtenerUsuario(String username) {

        return usuarioRepository.findByUsername(username);
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    @Override
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }

}