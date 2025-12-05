package com.fisioclick.api.controller;

import com.fisioclick.api.dto.PacienteDTO;
import com.fisioclick.api.dto.ResponseDTO;
import com.fisioclick.api.dto.UsuarioDTO;
import com.fisioclick.api.model.Paciente;
import com.fisioclick.api.service.PacienteService;
import com.fisioclick.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("salvar")
    public ResponseEntity<ResponseDTO> cadastrar(@RequestBody PacienteDTO pacienteDTO) {

        ResponseDTO responseDTO = new ResponseDTO();

        UsuarioDTO usuarioDTO = this.usuarioService.usuarioPorCpf(pacienteDTO.getUsuarioDTO().getCpf());

        if(usuarioDTO != null) {
            responseDTO.setMensagem("Já existe um usuário cadastrado com o mesmo CPF");
            responseDTO.setStatus("400");

        }else {

            Paciente paciente = this.pacienteService.salvar(pacienteDTO);


            if (paciente != null) {
                responseDTO.setMensagem("Operação realizada com sucesso.");
                responseDTO.setStatus("200");
                responseDTO.setObject(paciente);

            } else {
                responseDTO.setMensagem("Erro ao gravar Paciente.");
                responseDTO.setStatus("400");
            }
        }

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
