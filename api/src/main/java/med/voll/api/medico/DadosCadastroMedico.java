package med.voll.api.medico;

import med.voll.api.endereco.DadosEndereco;

//record -> seria o equivalente as Props do .NET, assim nao precisamos digitar Getters e Setters
public record DadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade, DadosEndereco endereco) {
}
