package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.endereco.Endereco;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    // INSERT
    @PostMapping
    @Transactional // do pack Spring, precisa de transacao ativa com BD -> TRANSACAO COM BANCO
    public void cadastrarMedico(@RequestBody @Valid DadosCadastroMedico dados){ //VEM DA REQUISICAO

        //conversao de DTO para Medico
        repository.save(new Medico(dados)); // INSERT NO BANCO
    }

    //METODO GET - READ
    // LEITURA NAO PRECISA DE TRANSACAO ATIVA
    @GetMapping                                     //PageableDefault -> Sem o GET nao possuir parametros, ira seguir os informados aqui
    public Page<DadosListagemMedico> listarMedicos(@PageableDefault(size =1 , sort = {"nome"}) Pageable paginacao){

        // OBJETO PAGINACAO COMO PARAMETRO, DIRETO DO SPRING, ASSIM DEFINIMOS A QUANTIDADE DESEJADA
        // A quantidade desejada deve ser passada no /medicos?size=QTDDESEJADA
        //&page=PAGEDESEJADA concatenada a anterior, tras a pagina seguinte
        return repository.findAll(paginacao).map(DadosListagemMedico :: new);

        //var x = repository.findAll().stream().map(DadosListagemMedico :: new); // .map é uma transformacao, diferente do Dict


        //return repository.findAll().stream()
        //  .map(DadosListagemMedico :: new) // CONVERSAO DE Medico PARA DadosListagemMedico, Necessario criar CONSTRUTOR que recebe Medico
        //  .toList();
    }

    // METODO PUT - UPDATE
    @PutMapping
    @Transactional
    public void atualizarMedicos(@RequestBody @Valid DadosUpdateMedico updateMedico){

        //Primeiro carregar os dados do medico desejado
        var medico = repository.getReferenceById(updateMedico.id());

        //Entao sobescrever os dados com informações atualizados
        medico.atualizarInformacoes(updateMedico); // JPA ja detecta que ocorreu a mudança e atualiza a Base de Dados
    }

    // Nao deletar, mas tornar INATIVO no Sistema (EXCLUSAO LOGICA)
    // METODO DELETE
    @DeleteMapping("/{id}") // ID vindo da URL, atraves de um parametro dinamico {}
    @Transactional
    public void deletarMedico(@PathVariable Long id){ // Avisando que Long id vem da URL
        repository.deleteById(id); // Apaga da Base
    }

}
