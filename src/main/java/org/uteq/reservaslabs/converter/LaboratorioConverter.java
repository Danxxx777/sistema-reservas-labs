package org.uteq.reservaslabs.converter;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

import org.uteq.reservaslabs.entity.Laboratorio;
import org.uteq.reservaslabs.service.LaboratorioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@FacesConverter(value = "laboratorioConverter", managed = true)
@Component
public class LaboratorioConverter implements Converter<Laboratorio> {

    @Autowired
    private LaboratorioService laboratorioService;

    @Override
    public Laboratorio getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        return laboratorioService.buscarPorId(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Laboratorio laboratorio) {
        if (laboratorio == null || laboratorio.getId() == null) {
            return "";
        }
        return laboratorio.getId().toString();
    }
}
