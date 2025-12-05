package com.fisioclick.api.controller;

import com.fisioclick.api.dto.RequestAgendamentoDto;
import com.fisioclick.api.dto.ResponseAgendamentoDto;
import com.fisioclick.api.dto.UsuarioDTO;
import com.fisioclick.api.service.AgendamentoService;
import com.fisioclick.api.service.FisioterapeutaService;
import com.fisioclick.api.service.PacienteService;
import com.fisioclick.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/agendamento")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private FisioterapeutaService fisioterapeutaService;

    @PostMapping("agendar")
    public ResponseEntity<Boolean> agendar(@RequestBody RequestAgendamentoDto requestAgendamentoDto) {

        this.agendamentoService.agendar(requestAgendamentoDto);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    @GetMapping("agenda-paciente/{idUsuario}")
    public ResponseEntity<List<ResponseAgendamentoDto>> agendaPaciente(@PathVariable("idUsuario") Long idUsuario) {

        Long idPaciente = this.pacienteService.buscarPorIdUsuario(idUsuario).getIdPaciente();

        List<ResponseAgendamentoDto> responseAgendamentoDtos = this.agendamentoService.agendaPaciente(idPaciente);

        return new ResponseEntity<>(responseAgendamentoDtos, HttpStatus.OK);
    }

    @GetMapping("agenda-fisioterapeuta/{idUsuario}")
    public ResponseEntity<List<ResponseAgendamentoDto>> agendaFisioterapeuta(@PathVariable("idUsuario") Long idUsuario) {

        UsuarioDTO usuarioDTO = this.usuarioService.usuarioById(idUsuario);

        Long idFisioterapeuta = this.fisioterapeutaService.buscarPorIdUsuario(Long.valueOf(usuarioDTO.getId())).getIdFisioterapeuta();

        List<ResponseAgendamentoDto> responseAgendamentoDtos = this.agendamentoService.agendaFisioterapeuta(idFisioterapeuta);

        return new ResponseEntity<>(responseAgendamentoDtos, HttpStatus.OK);
    }

    @GetMapping("cancelar/{idAgendamento}")
    public ResponseEntity<Boolean> cancelar(@PathVariable("idAgendamento") Long idAgendamento) {

        boolean resultado = this.agendamentoService.cancelar(idAgendamento);

        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }
}
