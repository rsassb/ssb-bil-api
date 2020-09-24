package no.ssb.api.ssbbilapi.repository;

import no.ssb.api.ssbbilapi.domain.Parameter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "parameter", path="parameter")
public interface ParameterRepository extends CrudRepository<Parameter, String> {

}
