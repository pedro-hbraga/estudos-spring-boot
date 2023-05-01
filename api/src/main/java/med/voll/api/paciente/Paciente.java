package med.voll.api.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name = "pacientes" ) //MAPEAMENTO da entidade Medico na Tabela Medicos
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    @Embedded
    private Endereco endereco;
    private Boolean status;

    public Paciente(DadosCadastroPaciente dados){
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
        this.status = true;
    }

    public void atualizarInformacoesPaciente(DadosUpdatePaciente updatePaciente) {
        this.id = updatePaciente.id();
        if(updatePaciente.nome() != null){
            this.nome = updatePaciente.nome();
        }
        if(updatePaciente.telefone() != null){
            this.telefone = updatePaciente.telefone();
        }
        if(updatePaciente.endereco() != null){
            this.endereco.atualizarEndereco(updatePaciente.endereco());
        }
    }

    public void excluir() {
        status = true;
    }
}
