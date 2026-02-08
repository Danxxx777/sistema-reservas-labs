package org.uteq.reservaslabs.converter;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

import org.uteq.reservaslabs.entity.Usuario;
import org.uteq.reservaslabs.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@FacesConverter(value = "usuarioConverter", managed = true)
@Component
public class UsuarioConverter implements Converter<Usuario> {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public Usuario getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        return usuarioService.buscarPorId(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Usuario usuario) {
        if (usuario == null || usuario.getId() == null) {
            return "";
        }
        return usuario.getId().toString();
    }
}
