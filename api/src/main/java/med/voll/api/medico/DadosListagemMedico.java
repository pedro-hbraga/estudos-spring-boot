package med.voll.api.medico;

// DTO
public record DadosListagemMedico(String nome, String email, String crm, Especialidade especialidade) {

    public DadosListagemMedico(Medico medico){
        // Chama o proprio construtor do DTO DadosListagemMedico e passa os parametros recebidos
        // Nos RECORDS podemos ter mais de um CONSTRUTOR, mas precisa chamar o CONSTRUTOR PRINCIPAL
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}
