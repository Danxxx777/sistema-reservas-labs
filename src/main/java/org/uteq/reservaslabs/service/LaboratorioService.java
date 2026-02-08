package org.uteq.reservaslabs.service;

import org.uteq.reservaslabs.entity.Laboratorio;
import org.uteq.reservaslabs.repository.LaboratorioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratorioService {

    private final LaboratorioRepository laboratorioRepository;

    public LaboratorioService(LaboratorioRepository laboratorioRepository) {
        this.laboratorioRepository = laboratorioRepository;
    }

    public List<Laboratorio> listarTodos() {
        return laboratorioRepository.findAll();
    }

    public List<Laboratorio> listarDisponibles() {
        return laboratorioRepository.findByEstado("Disponible");
    }

    public Laboratorio guardar(Laboratorio laboratorio) {
        if (laboratorio.getNombre() == null || laboratorio.getNombre().isBlank()) {
            throw new RuntimeException("El nombre del laboratorio es obligatorio");
        }
        return laboratorioRepository.save(laboratorio);
    }

    public void eliminar(Long id) {
        laboratorioRepository.deleteById(id);
    }
}
