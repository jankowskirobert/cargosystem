package eu.jankowskirobert.cargosystem.composite.location;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface LocationQueryRepository extends ElasticsearchRepository<LocationProjection, String> {
}
