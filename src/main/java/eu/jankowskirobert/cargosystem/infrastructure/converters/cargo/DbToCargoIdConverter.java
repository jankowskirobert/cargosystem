package eu.jankowskirobert.cargosystem.infrastructure.converters.cargo;

import com.mongodb.DBObject;
import eu.jankowskirobert.cargosystem.domain.cargo.CargoId;
import org.springframework.core.convert.converter.Converter;

public class DbToCargoIdConverter implements Converter<DBObject, CargoId> {
    @Override
    public CargoId convert(DBObject dbObject) {
      return null;
    }
}
