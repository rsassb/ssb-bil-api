package no.ssb.api.ssbbilapi.repository;

import no.ssb.api.ssbbilapi.domain.Sete;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "sete", path="sete")
public interface SeteRepository extends CrudRepository<Sete, Long> {

    @RestResource(path = "byFomAndTom", rel = "customFindMethod")
    List<Sete> findAllByFomDatoAfterAndTomDatoBefore(@Param("fomDato") LocalDate fomDato, @Param("tomDato") LocalDate tomDato);

    @Query("SELECT s FROM Sete s WHERE s.fomDato <= :dato AND s.tomDato >= :dato")
    List<Sete> findForDato(@Param("dato") LocalDate dato);
}
