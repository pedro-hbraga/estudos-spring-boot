package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    //POST
    @PostMapping
    @Transactional
    public void cadastrarPaciente(@RequestBody @Valid DadosCadastroPaciente dados){
        pacienteRepository.save(new Paciente(dados));
    }

    //GET
    @GetMapping
    public Page<DadosListagemPaciente> listarPacientes(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){

        //return pacienteRepository.findAll(paginacao).map(DadosListagemPaciente::new);
        //Paginacao removendo status INATIVOS
        return pacienteRepository.findAllByStatusTrue(paginacao).map(DadosListagemPaciente::new);

    }

    //PUT
    @PutMapping
    @Transactional
    public void atualizarPaciente(@RequestBody @Valid DadosUpdatePaciente updatePaciente){
        var paciente = pacienteRepository.getReferenceById(updatePaciente.id());
        paciente.atualizarInformacoesPaciente(updatePaciente);
    }

    // DELETE
    @DeleteMapping("/{id}")
    @Transactional
    public void deletarPaciente(@PathVariable Long id){

        var paciente = pacienteRepository.getReferenceById(id);
        paciente.excluir();
    }
}
