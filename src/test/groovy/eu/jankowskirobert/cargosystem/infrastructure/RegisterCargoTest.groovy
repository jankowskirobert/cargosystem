package eu.jankowskirobert.cargosystem.infrastructure

import eu.jankowskirobert.cargosystem.composite.cargo.CargoQueryRepository
import eu.jankowskirobert.cargosystem.application.cargo.handlers.RegisterCargoCommandHandler
import eu.jankowskirobert.cargosystem.composite.location.LocationProjection
import eu.jankowskirobert.cargosystem.composite.location.LocationQueryRepository
import eu.jankowskirobert.cargosystem.domain.cargo.CargoRepository
import eu.jankowskirobert.cargosystem.domain.cargo.TransportNumber
import eu.jankowskirobert.cargosystem.domain.company.Company
import eu.jankowskirobert.cargosystem.domain.location.Location
import eu.jankowskirobert.cargosystem.domain.location.LocationId

import eu.jankowskirobert.cargosystem.infrastructure.http.cargo.CargoHttpApi
import eu.jankowskirobert.cargosystem.composite.cargo.RegisterCargoCommandFactory
import eu.jankowskirobert.cargosystem.composite.cargo.RegisterCargoDTO
import eu.jankowskirobert.cargosystem.shared.Address
import eu.jankowskirobert.cargosystem.shared.Continent
import org.springframework.context.ApplicationEventPublisher
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
        ApplicationEventPublisher applicationEventPublisher = Mock(ApplicationEventPublisher)
        and:
        CargoQueryRepository cargoQueryRepository = Mock(CargoQueryRepository)
        cargoQueryRepository.nextTransportNumber() >> transportNumber
        and:
        Optional<LocationProjection> sample1 = Optional.of(new LocationProjection("SAMPLE1", addressS1, company.getCompanyId(), company.getName(), LocalDate.now()))
        Optional<LocationProjection> sample2 = Optional.of(new LocationProjection("SAMPLE2", addressS2, company.getCompanyId(), company.getName(), LocalDate.now()))
        and:
        RegisterCargoDTO registerCargoCommand = RegisterCargoDTO.of("THING", "SAMPLE1", "SAMPLE2", LocalDate.now())
        and:
        RegisterCargoCommandHandler registerCargoCommandHandler = RegisterCargoCommandHandler.of(cargoRepository, applicationEventPublisher)
        and:
        LocationQueryRepository locationQueryRepository = Mock(LocationQueryRepository)
        and:
        RegisterCargoCommandFactory registerCargoCommandFactory = RegisterCargoCommandFactory.of(locationQueryRepository, cargoQueryRepository)
        and:
        CargoHttpApi cargoHttpApi = CargoHttpApi.of(registerCargoCommandHandler, registerCargoCommandFactory)
        when:
        locationQueryRepository.findById("SAMPLE1") >> sample1
        locationQueryRepository.findById("SAMPLE2") >> sample2
        and:
        def result = cargoHttpApi.registerCargo(registerCargoCommand)
        then:
        1*cargoRepository.store(_);

    }
}
