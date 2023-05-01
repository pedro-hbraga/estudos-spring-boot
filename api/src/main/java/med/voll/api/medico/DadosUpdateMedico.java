package med.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEndereco;

// DTO para atualizar os dados do Medico
// Apenas o ID é obrigatório
// É possível manter o DTO DandosEndereco pois para atualizar o ENDERECO precisamos das mesmas informações
public record DadosUpdateMedico(@NotNull Long id, String nome, String telefone, DadosEndereco endereco) {

}
