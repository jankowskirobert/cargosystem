package eu.jankowskirobert.cargosystem.composite.cargo;

import eu.jankowskirobert.cargosystem.composite.location.LocationProjection;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@Document(createIndex = true, indexName = "cargo")
public class CargoProjection {
    @Id
    private String trackingNumber;
    private String name;
}
