package no.ssb.api.ssbbilapi.repository;


import no.ssb.api.ssbbilapi.domain.Bestilling;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "bestilling", path="bestilling")
public interface BestillingRepository extends CrudRepository<Bestilling, Long> {

    @RestResource(path = "byPassasjer", rel = "customFindMethod")
    List<Bestilling> findAllByPassasjer(@Param("passasjer") String passasjer);

    @RestResource(path = "byDato", rel = "customFindMethod")
    List<Bestilling>  findAllByDato(@Param("dato") LocalDate dato);

//    @RestResource(path = "byDatoAndAnnullert", rel = "customFindMethod")
//    List<Bestilling>  findAllByDatoAndAnnullert(@Param("dato") LocalDate dato, @Param("annullert") char annullert);

}
