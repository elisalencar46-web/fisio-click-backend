package com.fisioclick.api.repository;

import com.fisioclick.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findUsuarioByCpf(String cpf);

    Usuario findUsuarioByCpfAndSenha(String cpf, String senha);

    Usuario findUsuarioByCpfAndSenhaAndTipoUsuario(String cpf, String senha, String tipoUsuario);
}
