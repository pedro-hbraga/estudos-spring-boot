package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.endereco.Endereco;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    //INJECAO DE DEPENDENCIA - SPRING ira inicializar esse atributo
    @Autowired //INJETANDO
    private MedicoRepository repository;

    //METODO POST  - Captando dados do Body em JSON
    @PostMapping
    @Transactional // do pack Spring, precisa de transacao ativa com BD
    public void cadastrarMedico(@RequestBody @Valid DadosCadastroMedico dados){ //VEM DA REQUISICAO

        //conversao de DTO para Medico
        repository.save(new Medico(dados)); // INSERT NO BANCO
    }

}
