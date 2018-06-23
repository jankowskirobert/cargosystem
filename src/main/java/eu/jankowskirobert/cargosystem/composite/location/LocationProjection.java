package eu.jankowskirobert.cargosystem.composite.location;

import eu.jankowskirobert.cargosystem.shared.Address;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
@Document(indexName = "locationprojection", createIndex = true)
@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocationProjection {

    @Id
    private String id;
    @Field(type = FieldType.Nested)
    private Address address;
    private String companyId;
    private String companyName;
    private LocalDate availability;

}
