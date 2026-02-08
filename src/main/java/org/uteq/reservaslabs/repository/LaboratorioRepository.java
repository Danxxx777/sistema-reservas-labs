package org.uteq.reservaslabs.repository;

import org.uteq.reservaslabs.entity.Laboratorio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LaboratorioRepository extends JpaRepository<Laboratorio, Long> {

    List<Laboratorio> findByEstado(String estado);
}
