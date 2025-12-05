package com.fisioclick.api.repository;

import com.fisioclick.api.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Paciente findPacienteByUsuarioIdUsuario(Long idUduario);
}
