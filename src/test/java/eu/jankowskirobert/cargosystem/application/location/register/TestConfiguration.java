package eu.jankowskirobert.cargosystem.application.location.register;

import eu.jankowskirobert.cargosystem.domain.cargo.CargoRepository;
import eu.jankowskirobert.cargosystem.domain.cargo.InMemoryCargo;
import eu.jankowskirobert.cargosystem.domain.company.Company;
import eu.jankowskirobert.cargosystem.domain.company.CompanyId;
import eu.jankowskirobert.cargosystem.domain.company.CompanyRepository;
import eu.jankowskirobert.cargosystem.domain.company.CompanyRepositoryException;
import eu.jankowskirobert.cargosystem.domain.location.LocationRepository;
import eu.jankowskirobert.cargosystem.domain.transportcompany.TransportCompany;
import eu.jankowskirobert.cargosystem.domain.transportcompany.TransportCompanyId;
import eu.jankowskirobert.cargosystem.domain.transportcompany.TransportCompanyRepository;
import eu.jankowskirobert.cargosystem.domain.transportcompany.TransportCompanyRepositoryException;
import eu.jankowskirobert.cargosystem.infrastructure.InMemoryLocation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class TestConfiguration {

    private InMemoryLocation inMemoryLocation = new InMemoryLocation();

    @Bean
    public LocationRepository locationWriteRepository() {
        return inMemoryLocation;
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
        return new InMemoryCargo();
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
