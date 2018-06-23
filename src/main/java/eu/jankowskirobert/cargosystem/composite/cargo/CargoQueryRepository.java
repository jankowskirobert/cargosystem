package eu.jankowskirobert.cargosystem.composite.cargo;

import eu.jankowskirobert.cargosystem.domain.cargo.TransportNumber;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CargoQueryRepository extends ElasticsearchRepository<CargoProjection, String> {
}
