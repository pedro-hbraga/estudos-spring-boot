package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

//record -> seria o equivalente as Props do .NET, assim nao precisamos digitar Getters
// record contem apenas atributos, construtor e metodos de leitura (GETTERS), ou seja, SEM COMPORTAMENTO
// Um DTO ajuda a prevenir Mass Assignment Attack, sendo equivalente ao SQLParameters, onde so expoe os dados que fazem sentido
// a FUNCIONALIDADE do DTO
public record DadosCadastroMedico(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull
        @Valid
        DadosEndereco endereco) {
}
