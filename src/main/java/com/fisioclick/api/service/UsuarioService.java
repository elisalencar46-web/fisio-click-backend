package com.fisioclick.api.service;

import com.fisioclick.api.dto.ResponseUsuarioDTO;
import com.fisioclick.api.dto.UsuarioDTO;
import com.fisioclick.api.model.Usuario;
import com.fisioclick.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseUsuarioDTO cadastrar(UsuarioDTO usuarioDTO) {

        ResponseUsuarioDTO responseUsuarioDTO = new ResponseUsuarioDTO();

        if(this.usuarioRepository.findUsuarioByCpf(usuarioDTO.getCpf()) != null) {

            responseUsuarioDTO.setStatus("400");
            responseUsuarioDTO.setMessageErro("Usuário já cadastrad0.");

        }

        Usuario usuario = new Usuario();
        usuario.setCpf(usuarioDTO.getCpf());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setTipoUsuario(usuarioDTO.getTipoUsuario());


        this.usuarioRepository.save(usuario);

        return responseUsuarioDTO;
    }

    public List<UsuarioDTO> usuarios() {

        List<Usuario> usuarios = this.usuarioRepository.findAll();
        List<UsuarioDTO> usuarioDTOS = new ArrayList<>();

        for (Usuario usuario: usuarios) {
            UsuarioDTO usuarioDTO = new UsuarioDTO(String.valueOf(usuario.getIdUsuario()), usuario.getCpf(), usuario.getSenha(), usuario.getTipoUsuario());

            usuarioDTOS.add(usuarioDTO);

        }

        return usuarioDTOS;
    }

    public UsuarioDTO usuarioPorCpf(String cpf) {

        Usuario usuario = this.usuarioRepository.findUsuarioByCpf(cpf);

        if(usuario != null) {
            return new UsuarioDTO(String.valueOf(usuario.getIdUsuario()), usuario.getCpf(),usuario.getSenha(), usuario.getTipoUsuario());
        }

        return null;
    }

    public UsuarioDTO usuarioById(Long idUsuario) {

        Optional<Usuario> usuario = this.usuarioRepository.findById(idUsuario);

        return usuario.map(value -> new UsuarioDTO(String.valueOf(value.getIdUsuario()), value.getCpf(), value.getSenha(),
                value.getTipoUsuario())).orElse(null);


    }

    public UsuarioDTO logar(UsuarioDTO usuarioDTO) {

        Usuario usuario = this.usuarioRepository.
                findUsuarioByCpfAndSenhaAndTipoUsuario(usuarioDTO.getCpf(), usuarioDTO.getSenha(),
                        usuarioDTO.getTipoUsuario());

        if(usuario != null) {
            return new UsuarioDTO(String.valueOf(usuario.getIdUsuario()), usuario.getCpf(), usuario.getTipoUsuario(), Boolean.TRUE);

        }
        return null;
    }

    public Usuario usuarioDtoToUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();

        usuario.setCpf(usuarioDTO.getCpf());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setTipoUsuario(usuarioDTO.getTipoUsuario());

        return usuario;
    }
}
