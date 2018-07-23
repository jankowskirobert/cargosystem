package eu.jankowskirobert.cargosystem.infrastructure.converters.cargo;

import com.mongodb.DBObject;
import eu.jankowskirobert.cargosystem.domain.cargo.Cargo;
import org.springframework.core.convert.converter.Converter;
/*
https://stackoverflow.com/questions/13780692/set-mongodb-converter-programmatically
 */
public class CargoConverter implements Converter<Cargo, DBObject> {

    @Override
    public DBObject convert(Cargo cargo) {
//        DBObject dbObject = new BasicDBObject();
//        dbObject.put("_id", cargo.getCargoId().getId());
//        dbObject.put("transportNumber", cargo.getTransportNumber().getNumber());
//        dbObject.put("routeSpecification",cargo.getRouteSpecification());
//        if (user.getEmailAddress() != null) {
//            DBObject emailDbObject = new BasicDBObject();
//            emailDbObject.put("value", user.getEmailAddress().getValue());
//            dbObject.put("email", emailDbObject);
//        }
//        dbObject.removeField("_class");
//        return dbObject;
        return null;
    }


}
