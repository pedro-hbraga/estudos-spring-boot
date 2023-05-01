package med.voll.api.medico;


import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    // GERANDO CONSULTA AOS STATUS NA BASE
    Page<Medico> findAllByStatusTrue(Pageable paginacao);
}
