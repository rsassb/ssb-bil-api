package no.ssb.api.ssbbilapi.configuration;

// Created to expose ids to json
import no.ssb.api.ssbbilapi.domain.Ansatt;
import no.ssb.api.ssbbilapi.domain.Bestilling;
import no.ssb.api.ssbbilapi.domain.Parameter;
import no.ssb.api.ssbbilapi.domain.Sete;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class ExposeEntityIdRestMvcConfiguration extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Ansatt.class);
        config.exposeIdsFor(Bestilling.class);
        config.exposeIdsFor(Parameter.class);
        config.exposeIdsFor(Sete.class);
    }
}
