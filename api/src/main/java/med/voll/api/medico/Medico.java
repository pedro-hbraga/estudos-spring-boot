package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

//ENTIDADE JPA
@Table(name = "medicos" ) //MAPEAMENTO da entidade Medico na Tabela Medicos
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;

    private Boolean status;

    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
        this.status = true;
    }

    public void atualizarInformacoes(DadosUpdateMedico updateMedico) {

        this.id = updateMedico.id();
        if(updateMedico.nome() != null){
            this.nome = updateMedico.nome();
        }
        if(updateMedico.telefone() != null){
            this.telefone = updateMedico.telefone();
        }
        if(updateMedico.endereco() != null){
            this.endereco.atualizarEndereco(updateMedico.endereco());
        }
    }

    public void excluir() {
        this.status = false;
    }
}
