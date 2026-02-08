package org.uteq.reservaslabs.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import org.uteq.reservaslabs.entity.Usuario;
import org.uteq.reservaslabs.service.UsuarioService;

import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class UsuarioBean implements Serializable {

    @Autowired
    private UsuarioService usuarioService;

    private Usuario usuario;
    private List<Usuario> usuarios;

    // Constructor vacío obligatorio para JSF
    public UsuarioBean() {
    }

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        usuarios = usuarioService.listarTodos();
    }

    public void guardar() {
        usuarioService.guardar(usuario);
        usuario = new Usuario();
        usuarios = usuarioService.listarTodos();
    }

    public void eliminar(Long id) {
        usuarioService.eliminar(id);
        usuarios = usuarioService.listarTodos();
    }

    // ===============================
    // GETTERS
    // ===============================

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
