package com.fisioclick.api.repository;

import com.fisioclick.api.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    List<Agendamento> findAllByPacienteIdPaciente(Long idPaciente);

    List<Agendamento> findAllByFisioterapeutaIdFisioterapeuta(Long idPaciente);
}
