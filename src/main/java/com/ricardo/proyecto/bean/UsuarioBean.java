/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricardo.proyecto.bean;

import com.ricardo.proyecto.model.Usuario;
import com.ricardo.proyecto.service.UsuarioService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
/**
 *
 * @author ricardotoledo
 */
@Named(value = "usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable {
    @Inject
    UsuarioService uService;
    List<Usuario> usuarios;
    Usuario usuario;
    public UsuarioBean() {
        usuario=new Usuario();
    }

    public List<Usuario> getUsuarios() {
        return uService.list();
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public void save(){
        uService.save(this.usuario);
    }
    
}
