package com.sistema.examen.sistemaexamenesbackend.exeptions;

public class UsuarioFoundExeption extends Exception{
    public UsuarioFoundExeption (){
        super("El usuario con ese nombre de usuario ya existe en la base de datos");
    }

    public UsuarioFoundExeption(String msg){
        super(msg);
    }
}
