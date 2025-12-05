package com.fisioclick.api.repository;

import com.fisioclick.api.model.Fisioterapeuta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FisioterapeutaRepository extends JpaRepository<Fisioterapeuta, Long> {

    Fisioterapeuta findFisioterapeutaByUsuarioIdUsuario(Long idUsuario);
}
