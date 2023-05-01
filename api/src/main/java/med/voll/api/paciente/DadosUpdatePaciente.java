package med.voll.api.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEndereco;

public record DadosUpdatePaciente(@NotNull Long id, String nome, String telefone, DadosEndereco endereco) {
}
