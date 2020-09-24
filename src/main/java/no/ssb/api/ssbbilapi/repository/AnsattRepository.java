package no.ssb.api.ssbbilapi.repository;

import no.ssb.api.ssbbilapi.domain.Ansatt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "ansatt", path="ansatt")
public interface AnsattRepository extends CrudRepository<Ansatt, String> {
}
