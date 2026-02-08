package org.uteq.reservaslabs.service;

import org.uteq.reservaslabs.entity.Laboratorio;
import org.uteq.reservaslabs.entity.Reserva;
import org.uteq.reservaslabs.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<Reserva> listarTodas() {
        return reservaRepository.findAll();
    }

    public Reserva guardar(Reserva reserva) {

        // ===============================
        // VALIDACIONES
        // ===============================

        if (reserva.getHoraInicio() == null || reserva.getHoraFin() == null) {
            throw new RuntimeException("Debe ingresar hora de inicio y fin");
        }

        if (reserva.getHoraInicio().isAfter(reserva.getHoraFin())) {
            throw new RuntimeException("La hora de inicio no puede ser mayor que la hora fin");
        }

        Laboratorio laboratorio = reserva.getLaboratorio();

        if (!"Disponible".equals(laboratorio.getEstado())) {
            throw new RuntimeException("El laboratorio no está disponible");
        }

        // ===============================
        // LÓGICA DE NEGOCIO
        // ===============================

        reserva.setEstado("Activa");
        laboratorio.setEstado("Ocupado");

        return reservaRepository.save(reserva);
    }

    public void cancelar(Long id) {

        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        reserva.setEstado("Cancelada");

        // Liberar laboratorio
        reserva.getLaboratorio().setEstado("Disponible");

        reservaRepository.save(reserva);
    }
}
