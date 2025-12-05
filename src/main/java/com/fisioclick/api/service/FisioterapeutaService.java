package com.fisioclick.api.service;

import com.fisioclick.api.dto.FisioterapeutaDTO;
import com.fisioclick.api.model.Fisioterapeuta;
import com.fisioclick.api.model.Usuario;
import com.fisioclick.api.repository.FisioterapeutaRepository;
import com.fisioclick.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FisioterapeutaService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private FisioterapeutaRepository fisioterapeutaRepository;

    @Autowired
    private UsuarioService usuarioService;

    public Fisioterapeuta salvar(FisioterapeutaDTO fisioterapeutaDTO) {

        Fisioterapeuta fisioterapeuta = new Fisioterapeuta();

        fisioterapeuta.setNome(fisioterapeutaDTO.getNome());
        fisioterapeuta.setInscricao(fisioterapeutaDTO.getInscricao());

        Usuario usuario = this.usuarioRepository.save(this.usuarioService.usuarioDtoToUsuario(fisioterapeutaDTO.getUsuarioDTO()));

        fisioterapeuta.setUsuario(usuario);

        return this.fisioterapeutaRepository.save(fisioterapeuta);

    }

    public List<FisioterapeutaDTO> buscarListaFisioterapeuta() {

        List<FisioterapeutaDTO> list = new ArrayList<>();

        List<Fisioterapeuta> fisioterapeutas = this.fisioterapeutaRepository.findAll();

        for (Fisioterapeuta fisio: fisioterapeutas) {
            FisioterapeutaDTO fisioterapeutaDTO = new FisioterapeutaDTO();

            fisioterapeutaDTO.setId(String.valueOf(fisio.getIdFisioterapeuta()));
            fisioterapeutaDTO.setNome(fisio.getNome());
            fisioterapeutaDTO.setInscricao(fisio.getInscricao());

            list.add(fisioterapeutaDTO);
        }

        return list;

    }

    public Fisioterapeuta buscar(String idFisioterapeuta) {
        Optional<Fisioterapeuta> fisioterapeuta = this.fisioterapeutaRepository.findById(Long.valueOf(idFisioterapeuta));

        return fisioterapeuta.orElse(null);
    }

    public Fisioterapeuta buscarPorIdUsuario(Long idUsuario) {
        Fisioterapeuta fisioterapeuta = this.fisioterapeutaRepository.findFisioterapeutaByUsuarioIdUsuario(idUsuario);

        return fisioterapeuta;

    }
}
