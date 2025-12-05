package com.fisioclick.api.controller;

import com.fisioclick.api.dto.FisioterapeutaDTO;
import com.fisioclick.api.dto.ResponseDTO;
import com.fisioclick.api.dto.UsuarioDTO;
import com.fisioclick.api.model.Fisioterapeuta;
import com.fisioclick.api.service.FisioterapeutaService;
import com.fisioclick.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/fisioterapeuta")
public class FisioterapeutaController {

    @Autowired
    private FisioterapeutaService fisioterapeutaService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("salvar")
    public ResponseEntity<ResponseDTO> cadastrar(@RequestBody FisioterapeutaDTO fisioterapeutaDTO) {

        ResponseDTO responseDTO = new ResponseDTO();

        UsuarioDTO usuarioDTO = this.usuarioService.usuarioPorCpf(fisioterapeutaDTO.getUsuarioDTO().getCpf());

        if(usuarioDTO != null) {
            responseDTO.setMensagem("Já existe um usuário cadastrado com o mesmo CPF");
            responseDTO.setStatus("400");
        }else {

            Fisioterapeuta fisioterapeuta = this.fisioterapeutaService.salvar(fisioterapeutaDTO);


            if (fisioterapeuta != null) {
                responseDTO.setMensagem("Operação realizada com sucesso.");
                responseDTO.setStatus("200");
                responseDTO.setObject(fisioterapeuta);

            } else {
                responseDTO.setMensagem("Erro ao grava Fisioterapeuta;");
                responseDTO.setStatus("400");
            }
        }

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("buscar")
    public ResponseEntity<List<FisioterapeutaDTO>> buscarListaFisioterapeuta() {

        List<FisioterapeutaDTO> fisioterapeuta = this.fisioterapeutaService.buscarListaFisioterapeuta();

        return new ResponseEntity<>(fisioterapeuta, HttpStatus.OK);
    }
}
