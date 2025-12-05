package com.fisioclick.api.controller;

import com.fisioclick.api.dto.ResponseDTO;
import com.fisioclick.api.dto.UsuarioDTO;
import com.fisioclick.api.model.Usuario;
import com.fisioclick.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("logar")
    public ResponseEntity<ResponseDTO> logar(@RequestBody UsuarioDTO usuarioDTO) {

        UsuarioDTO resultado = this.usuarioService.logar(usuarioDTO);
        ResponseDTO responseDTO = new ResponseDTO();

        if(resultado != null) {
            responseDTO.setMensagem("Login efetuado com sucesso.");
            responseDTO.setStatus("200");
            responseDTO.setObject(resultado);

        }else {
            responseDTO.setMensagem("Cpf ou senha inválido");
            responseDTO.setStatus("400");
        }

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
