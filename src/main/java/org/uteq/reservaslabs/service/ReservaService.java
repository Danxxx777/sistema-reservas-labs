package org.uteq.reservaslabs.service;

import org.uteq.reservaslabs.entity.Reserva;
import org.uteq.reservaslabs.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
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

        if (reserva.getHoraInicio().isAfter(reserva.getHoraFin())) {
            throw new RuntimeException("La hora de inicio no puede ser mayor que la hora fin");
        }

        return reservaRepository.save(reserva);
    }

    public void cancelar(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        reserva.setEstado("Cancelada");
        reservaRepository.save(reserva);
    }
}
