package org.uteq.reservaslabs.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import org.uteq.reservaslabs.entity.Laboratorio;
import org.uteq.reservaslabs.service.LaboratorioService;

import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class LaboratorioBean implements Serializable {

    @Autowired
    private LaboratorioService laboratorioService;

    private Laboratorio laboratorio;
    private List<Laboratorio> laboratorios;

    // Constructor vacío obligatorio
    public LaboratorioBean() {
    }

    @PostConstruct
    public void init() {
        laboratorio = new Laboratorio();
        laboratorio.setEstado("Disponible");
        laboratorios = laboratorioService.listarTodos();
    }

    public void guardar() {
        laboratorioService.guardar(laboratorio);

        laboratorio = new Laboratorio();
        laboratorio.setEstado("Disponible");

        laboratorios = laboratorioService.listarTodos();
    }

    public void eliminar(Long id) {
        laboratorioService.eliminar(id);
        laboratorios = laboratorioService.listarTodos();
    }

    // ===============================
    // GETTERS
    // ===============================

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public List<Laboratorio> getLaboratorios() {
        return laboratorios;
    }
}
