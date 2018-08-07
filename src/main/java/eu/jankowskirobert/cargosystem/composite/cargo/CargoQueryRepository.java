package eu.jankowskirobert.cargosystem.composite.cargo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CargoQueryRepository extends ElasticsearchRepository<CargoProjection, String> {
}
