package eu.jankowskirobert.cargosystem.application.location.create;

import eu.jankowskirobert.cargosystem.domain.company.Company;
import eu.jankowskirobert.cargosystem.domain.company.CompanyId;
import eu.jankowskirobert.cargosystem.domain.company.CompanyRepository;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.location.LocationId;
import eu.jankowskirobert.cargosystem.domain.location.LocationRepository;
import eu.jankowskirobert.cargosystem.domain.location.LocationRepositoryException;
import eu.jankowskirobert.cargosystem.shared.Address;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class TestConfiguration {
    @Bean
    public LocationRepository locationRepositoryDummy() {
        return new LocationRepository() {

            Set<Location> location = new HashSet<Location>();

            @Override
            public void store(Location newLocation) {
                if (!location.add(newLocation)) throw new LocationRepositoryException();
            }

            @Override
            public Location find(LocationId id) {
                return location.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
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
