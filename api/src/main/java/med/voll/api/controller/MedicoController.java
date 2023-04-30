package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.endereco.Endereco;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    //INJECAO DE DEPENDENCIA - SPRING ira inicializar esse atributo
    @Autowired //INJETANDO
    private MedicoRepository repository;

    //METODO POST  - Captando dados do Body em JSON
    @PostMapping
    @Transactional // do pack Spring, precisa de transacao ativa com BD -> TRANSACAO COM BANCO
    public void cadastrarMedico(@RequestBody @Valid DadosCadastroMedico dados){ //VEM DA REQUISICAO

        //conversao de DTO para Medico
        repository.save(new Medico(dados)); // INSERT NO BANCO
    }

    //METODO GET
    // LEITURA NAO PRECISA DE TRANSACAO ATIVA
    @GetMapping
    public Page<DadosListagemMedico> listarMedicos(Pageable paginacao){

        // OBJETO PAGINACAO COMO PARAMETRO, DIRETO DO SPRING, ASSIM DEFINIMOS A QUANTIDADE DESEJADA
        // A quantidade desejada deve ser passada no /medicos?size=QTDDESEJADA
        //&page=PAGEDESEJADA concatenada a anterior, tras a pagina seguinte
        return repository.findAll(paginacao).map(DadosListagemMedico :: new);

        //var x = repository.findAll().stream().map(DadosListagemMedico :: new); // .map é uma transformacao, diferente do Dict


        //return repository.findAll().stream()
        //  .map(DadosListagemMedico :: new) // CONVERSAO DE Medico PARA DadosListagemMedico, Necessario criar CONSTRUTOR que recebe Medico
        //  .toList();

    }

}
