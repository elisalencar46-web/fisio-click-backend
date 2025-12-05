package com.fisioclick.api.service;

import com.fisioclick.api.dto.RequestAgendamentoDto;
import com.fisioclick.api.dto.ResponseAgendamentoDto;
import com.fisioclick.api.dto.UsuarioDTO;
import com.fisioclick.api.model.Agendamento;
import com.fisioclick.api.model.Fisioterapeuta;
import com.fisioclick.api.model.Paciente;
import com.fisioclick.api.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private FisioterapeutaService fisioterapeutaService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private UsuarioService usuarioService;


    public boolean agendar(RequestAgendamentoDto requestAgendamentoDto) {

        UsuarioDTO usuarioDTO = this.usuarioService.usuarioById(Long.valueOf(requestAgendamentoDto.getIdUsuario()));

        Long idPaciente = this.pacienteService.buscarPorIdUsuario(Long.valueOf(usuarioDTO.getId())).getIdPaciente();

        Agendamento agendamento = new Agendamento();

        Paciente paciente = this.pacienteService.buscar(String.valueOf(idPaciente));

        Fisioterapeuta fisioterapeuta = this.fisioterapeutaService.buscar(requestAgendamentoDto.getIdFisioterapeuta());

        agendamento.setDataAgendamento(this.converterStringToLocalDate(requestAgendamentoDto.getDataAgendamento()));
        agendamento.setHora(requestAgendamentoDto.getHoraAgendamento());
        agendamento.setStatus('A');
        agendamento.setPaciente(paciente);
        agendamento.setFisioterapeuta(fisioterapeuta);

        this.agendamentoRepository.save(agendamento);

        return true;

    }

    public boolean cancelar(Long idAgendamento) {

        Optional<Agendamento> agendamento = this.agendamentoRepository.findById(idAgendamento);

        if(agendamento.isPresent()) {
            agendamento.get().setStatus('C');
            this.agendamentoRepository.save(agendamento.get());

            return true;
        }

        return false;

    }

    private LocalDate converterStringToLocalDate(String data) {
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(data, parser);
    }

    private String converterLocalDateToString(LocalDate localDate) {
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return localDate.format(parser);
    }

    public List<ResponseAgendamentoDto> agendaPaciente(Long idPaciente) {

        List<ResponseAgendamentoDto> responseAgendamentoDtos = new ArrayList<>();

        List<Agendamento> agendamentoList = this.agendamentoRepository.findAllByPacienteIdPaciente(idPaciente);

        for (Agendamento agendamento: agendamentoList) {

            ResponseAgendamentoDto responseAgendamentoDto = new ResponseAgendamentoDto();

            responseAgendamentoDto.setIdAgendamento(String.valueOf(agendamento.getIdAgendamento()));
            responseAgendamentoDto.setHoraAgendamento(agendamento.getHora());
            responseAgendamentoDto.setDataAgendamento(converterLocalDateToString(agendamento.getDataAgendamento()));
            responseAgendamentoDto.setNomePaciente(agendamento.getPaciente().getNome());
            responseAgendamentoDto.setNomeFisioterapeuta(agendamento.getFisioterapeuta().getNome());
            responseAgendamentoDto.setStatus(String.valueOf(agendamento.getStatus()));

            responseAgendamentoDtos.add(responseAgendamentoDto);


        }


        return responseAgendamentoDtos;
    }

    public List<ResponseAgendamentoDto> agendaFisioterapeuta(Long idFisioterapeuta) {

        List<ResponseAgendamentoDto> responseAgendamentoDtos = new ArrayList<>();

        List<Agendamento> agendamentoList = this.agendamentoRepository.findAllByFisioterapeutaIdFisioterapeuta(idFisioterapeuta);

        for (Agendamento agendamento: agendamentoList) {

            ResponseAgendamentoDto responseAgendamentoDto = new ResponseAgendamentoDto();

            responseAgendamentoDto.setIdAgendamento(String.valueOf(agendamento.getIdAgendamento()));
            responseAgendamentoDto.setHoraAgendamento(agendamento.getHora());
            responseAgendamentoDto.setDataAgendamento(converterLocalDateToString(agendamento.getDataAgendamento()));
            responseAgendamentoDto.setNomePaciente(agendamento.getPaciente().getNome());
            responseAgendamentoDto.setNomeFisioterapeuta(agendamento.getFisioterapeuta().getNome());
            responseAgendamentoDto.setStatus(String.valueOf(agendamento.getStatus()));
            responseAgendamentoDto.setInscricao(agendamento.getFisioterapeuta().getInscricao());

            responseAgendamentoDtos.add(responseAgendamentoDto);


        }


        return responseAgendamentoDtos;
    }

}
