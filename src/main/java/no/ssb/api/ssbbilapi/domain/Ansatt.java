package no.ssb.api.ssbbilapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Ansatt {
    @NonNull private @Id
    String initialer;
    private String navn;
    private String telefonnummer;
}
