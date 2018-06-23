package eu.jankowskirobert.cargosystem.composite.location;

import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.location.LocationId;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface LocationQueryRepository extends ElasticsearchRepository<LocationProjection, String> {
}
