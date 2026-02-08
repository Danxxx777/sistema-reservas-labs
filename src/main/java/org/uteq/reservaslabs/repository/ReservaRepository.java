package org.uteq.reservaslabs.repository;

import org.uteq.reservaslabs.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findByFecha(LocalDate fecha);

    List<Reserva> findByLaboratorioId(Long laboratorioId);
}
