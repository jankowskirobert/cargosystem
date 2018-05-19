package eu.jankowskirobert.cargosystem.application.location.create;

import eu.jankowskirobert.cargosystem.domain.company.CompanyId;
import eu.jankowskirobert.cargosystem.domain.company.CompanyRepository;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.location.LocationId;
import eu.jankowskirobert.cargosystem.domain.location.LocationRepository;
import eu.jankowskirobert.cargosystem.shared.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;

@SpringBootTest
@ContextConfiguration(classes = {TestConfiguration.class})
public class TestCargoHandler {
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private CompanyRepository companyRepository;

    ;
}
