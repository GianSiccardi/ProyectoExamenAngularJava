package com.sistema.examen.sistemaexamenesbackend.exeptions;

public class UsuarioNotFoundExeption extends Exception{

    public UsuarioNotFoundExeption (){
        super("El usuario con ese nombre de usuario no existe en la base de datos");
    }

    public UsuarioNotFoundExeption(String msg){
        super(msg);
    }
}
