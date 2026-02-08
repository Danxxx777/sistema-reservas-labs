package org.uteq.reservaslabs.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import org.uteq.reservaslabs.entity.Laboratorio;
import org.uteq.reservaslabs.entity.Reserva;
import org.uteq.reservaslabs.entity.Usuario;
import org.uteq.reservaslabs.service.LaboratorioService;
import org.uteq.reservaslabs.service.ReservaService;
import org.uteq.reservaslabs.service.UsuarioService;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Component
@ViewScoped
public class ReservaBean implements Serializable {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private LaboratorioService laboratorioService;

    private Reserva reserva;
    private List<Reserva> reservas;
    private List<Usuario> usuarios;
    private List<Laboratorio> laboratorios;

    // Constructor vacío (necesario)
    public ReservaBean() {
    }

    @PostConstruct
    public void init() {
        reserva = new Reserva();
        reserva.setFecha(LocalDate.now());
        reserva.setEstado("Activa");

        reservas = reservaService.listarTodas();
        usuarios = usuarioService.listarTodos();
        laboratorios = laboratorioService.listarDisponibles();
    }

    public void guardar() {
        reservaService.guardar(reserva);

        reserva = new Reserva();
        reserva.setFecha(LocalDate.now());
        reserva.setEstado("Activa");

        reservas = reservaService.listarTodas();
    }

    public void cancelar(Long id) {
        reservaService.cancelar(id);
        reservas = reservaService.listarTodas();
    }

    // ===============================
    // GETTERS
    // ===============================

    public Reserva getReserva() {
        return reserva;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Laboratorio> getLaboratorios() {
        return laboratorios;
    }
}
