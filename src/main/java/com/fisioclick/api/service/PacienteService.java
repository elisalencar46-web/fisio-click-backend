package com.fisioclick.api.service;

import com.fisioclick.api.dto.PacienteDTO;
import com.fisioclick.api.model.Paciente;
import com.fisioclick.api.model.Usuario;
import com.fisioclick.api.repository.PacienteRepository;
import com.fisioclick.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    public Paciente salvar(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente();

        paciente.setNome(pacienteDTO.getNome());
        paciente.setIdade(pacienteDTO.getIdade());

        Usuario usuario = this.usuarioRepository.save(this.usuarioService.usuarioDtoToUsuario(pacienteDTO.getUsuarioDTO()));

        paciente.setUsuario(usuario);

        return this.pacienteRepository.save(paciente);


    }

    public Paciente buscar(String idPaciente) {
       Optional<Paciente> paciente = this.pacienteRepository.findById(Long.valueOf(idPaciente));

        return paciente.orElse(null);

    }

    public Paciente buscarPorIdUsuario(Long idUsuario) {
        Paciente paciente = this.pacienteRepository.findPacienteByUsuarioIdUsuario(idUsuario);

        return paciente;

    }

//    public boolean cadastrar(UsuarioDTO usuarioDTO) {
//
//        Usuario usuario = new Usuario();
//        usuario.setCpf(usuarioDTO.getCpf());
//        usuario.setSenha(usuarioDTO.getSenha());
//        usuario.setTipoUsuario(usuarioDTO.getTipoUsuario());
//
//
//        this.usuarioRepository.save(usuario);
//
//        return Boolean.TRUE;
//    }
//
//    public List<UsuarioDTO> usuarios() {
//
//        List<Usuario> usuarios = this.usuarioRepository.findAll();
//        List<UsuarioDTO> usuarioDTOS = new ArrayList<>();
//
//        for (Usuario usuario: usuarios) {
//            UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getCpf(), usuario.getSenha(), usuario.getTipoUsuario());
//
//            usuarioDTOS.add(usuarioDTO);
//
//        }
//
//        return usuarioDTOS;
//    }
//
//    public UsuarioDTO usuario(String cpf) {
//
//        Usuario usuario = this.usuarioRepository.findUsuarioByCpf(cpf);
//
//        if(usuario != null) {
//            return new UsuarioDTO(usuario.getCpf(),usuario.getSenha(), usuario.getTipoUsuario());
//        }
//
//        return null;
//    }
//
//    public UsuarioDTO usuarioById(Long idUsuario) {
//
//        Optional<Usuario> usuario = this.usuarioRepository.findById(idUsuario);
//
//        return usuario.map(value -> new UsuarioDTO(value.getCpf(), value.getSenha(),
//                value.getTipoUsuario())).orElse(null);
//
//
//    }


}
