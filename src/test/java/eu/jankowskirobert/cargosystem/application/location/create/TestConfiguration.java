package eu.jankowskirobert.cargosystem.application.location.create;

import eu.jankowskirobert.cargosystem.domain.company.Company;
import eu.jankowskirobert.cargosystem.domain.company.CompanyId;
import eu.jankowskirobert.cargosystem.domain.company.CompanyRepository;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.location.LocationId;
import eu.jankowskirobert.cargosystem.domain.location.LocationRepository;
import eu.jankowskirobert.cargosystem.shared.Address;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class TestConfiguration {
    @Bean
    public LocationRepository locationRepositoryDummy() {
        return new LocationRepository() {

            @Override
            public void store(Location newLocation) {

            }

            @Override
            public Location find(LocationId id) {
                return Location.of(id, Address.builder().build(), CompanyId.of(""), LocalDate.now());
            }
        };
    }

    @Bean
    public CompanyRepository companyRepository() {
        return new CompanyRepository() {
            @Override
            public Company find(CompanyId companyId) {
                return Company.of(companyId, "");
            }
        };

    }

    ;
}
