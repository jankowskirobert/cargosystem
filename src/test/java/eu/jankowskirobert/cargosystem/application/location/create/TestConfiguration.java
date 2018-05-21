package eu.jankowskirobert.cargosystem.application.location.create;

import eu.jankowskirobert.cargosystem.domain.cargo.*;
import eu.jankowskirobert.cargosystem.domain.company.Company;
import eu.jankowskirobert.cargosystem.domain.company.CompanyId;
import eu.jankowskirobert.cargosystem.domain.company.CompanyRepository;
import eu.jankowskirobert.cargosystem.domain.company.CompanyRepositoryException;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.location.LocationId;
import eu.jankowskirobert.cargosystem.domain.location.LocationRepository;
import eu.jankowskirobert.cargosystem.domain.location.LocationRepositoryException;
import eu.jankowskirobert.cargosystem.domain.transportcompany.TransportCompany;
import eu.jankowskirobert.cargosystem.domain.transportcompany.TransportCompanyId;
import eu.jankowskirobert.cargosystem.domain.transportcompany.TransportCompanyRepository;
import eu.jankowskirobert.cargosystem.domain.transportcompany.TransportCompanyRepositoryException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

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
    public TransportCompanyRepository transportCompanyRepository() {
        return new TransportCompanyRepository() {
            Set<TransportCompany> transportCompanies = new HashSet<TransportCompany>();
            @Override
            public void store(TransportCompany transportCompany) {
                if (!transportCompanies.add(transportCompany)) throw new TransportCompanyRepositoryException();
            }

            @Override
            public TransportCompany find(TransportCompanyId id) {
                return transportCompanies.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
            }
        };
    }

    @Bean
    public CargoRepository cargoRepository() {
        return new CargoRepository() {

            Set<Cargo> cargos = new HashSet<>();
            @Override
            public void store(Cargo cargo) {
                if (!cargos.add(cargo)) throw new CargoRepositoryException();
            }

            @Override
            public CargoId nextCargoId() {
                return CargoId.of(UUID.randomUUID().toString());
            }
        };
    }

    @Bean
    public CompanyRepository companyRepository() {
        return new CompanyRepository() {
            Set<Company> companies = new HashSet<>();
            @Override
            public Company find(CompanyId companyId) {
                return companies.stream().filter(x -> x.getCompanyId().equals(companyId)).findFirst().orElse(null);
            }

            @Override
            public void store(Company company) {
                if (!companies.add(company)) throw new CompanyRepositoryException();
            }
        };

    }

    ;
}
