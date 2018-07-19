package eu.jankowskirobert.cargosystem.composite.cargo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Document(createIndex = true, indexName = "cargo")
public class CargoProjection {
    @Id
    private String trackingNumber;
    private String name;
}
