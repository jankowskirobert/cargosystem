package eu.jankowskirobert.cargosystem.infrastructure.converters.cargo;

import com.mongodb.DBObject;
import eu.jankowskirobert.cargosystem.domain.cargo.CargoId;
import org.springframework.core.convert.converter.Converter;

public class CargoIdToDbConverter implements Converter<CargoId, DBObject> {
    @Override
    public DBObject convert(CargoId cargoId) {
        return null;
    }
}
