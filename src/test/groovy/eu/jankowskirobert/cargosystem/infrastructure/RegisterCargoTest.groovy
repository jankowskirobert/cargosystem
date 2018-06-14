package eu.jankowskirobert.cargosystem.infrastructure

import eu.jankowskirobert.cargosystem.application.cargo.register.RegisterCargoCommandHandler
import eu.jankowskirobert.cargosystem.domain.cargo.CargoRepository
import eu.jankowskirobert.cargosystem.domain.cargo.TransportNumber
import eu.jankowskirobert.cargosystem.domain.company.Company
import eu.jankowskirobert.cargosystem.domain.location.Location
import eu.jankowskirobert.cargosystem.domain.location.LocationId
import eu.jankowskirobert.cargosystem.domain.location.LocationQueryRepository
import eu.jankowskirobert.cargosystem.infrastructure.http.CargoHttpApi
import eu.jankowskirobert.cargosystem.infrastructure.http.CargoQueryRepository
import eu.jankowskirobert.cargosystem.infrastructure.http.RegisterCargoCommandFactory
import eu.jankowskirobert.cargosystem.infrastructure.http.RegisterCargoDTO
import eu.jankowskirobert.cargosystem.shared.Address
import eu.jankowskirobert.cargosystem.shared.Continent
import spock.lang.Specification

import java.time.LocalDate


class RegisterCargoTest extends Specification {
    def "should register cargo"() {
        given:
        Address addressS1 = Address.of("SAMPLE1", "SAMPLE1", "SAMPLE1", "SAMPLE1", "SAMPLE1", Continent.EUROPE);
        Address addressS2 = Address.of("SAMPLE2", "SAMPLE2", "SAMPLE2", "SAMPLE2", "SAMPLE2", Continent.EUROPE);
        and:
        TransportNumber transportNumber = TransportNumber.of("TEST")
        and:
        Company company = Company.empty();
        and:
        CargoRepository cargoRepository = Mock(CargoRepository)
        and:
        CargoQueryRepository cargoQueryRepository = Mock(CargoQueryRepository)
        cargoQueryRepository.nextTransportNumber() >> transportNumber
        and:
        Location sample1 = Location.of(LocationId.of("SAMPLE1"), addressS1, company, LocalDate.now());
        Location sample2 = Location.of(LocationId.of("SAMPLE2"), addressS2, company, LocalDate.now());
        and:
        RegisterCargoDTO registerCargoCommand = RegisterCargoDTO.of("THING", "", "", LocalDate.now())
        and:
        RegisterCargoCommandHandler registerCargoCommandHandler = RegisterCargoCommandHandler.of(cargoRepository)
        and:
        LocationQueryRepository locationQueryRepository = Mock(LocationQueryRepository)
        and:
        RegisterCargoCommandFactory registerCargoCommandFactory = RegisterCargoCommandFactory.of(locationQueryRepository, cargoQueryRepository)
        and:
        CargoHttpApi cargoHttpApi = CargoHttpApi.of(registerCargoCommandHandler, registerCargoCommandFactory)
        when:
        def result = cargoHttpApi.registerCargo(registerCargoCommand)
        then:
        result.equals(transportNumber.number)
    }
}