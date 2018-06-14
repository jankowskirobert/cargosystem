package eu.jankowskirobert.cargosystem.standalone;

import eu.jankowskirobert.cargosystem.composite.location.LocationQueryRepository;
import eu.jankowskirobert.cargosystem.composite.location.LocationWithAssignedCompanyViewDTO;
import eu.jankowskirobert.cargosystem.domain.company.Company;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.location.LocationId;
import eu.jankowskirobert.cargosystem.domain.location.LocationRepositoryException;
import eu.jankowskirobert.cargosystem.domain.location.LocationWriteRepository;
import eu.jankowskirobert.cargosystem.shared.Address;
import eu.jankowskirobert.cargosystem.shared.Continent;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LocationDB implements LocationWriteRepository, LocationQueryRepository {


    Address addressS1 = Address.of("SAMPLE1", "SAMPLE1", "SAMPLE1", "SAMPLE1", "SAMPLE1", Continent.EUROPE);
    Address addressS2 = Address.of("SAMPLE2", "SAMPLE2", "SAMPLE2", "SAMPLE2", "SAMPLE2", Continent.EUROPE);
    Company company = Company.empty();
    Location sample1 = Location.of(LocationId.of("SAMPLE1"), addressS1, company, LocalDate.now());
    Location sample2 = Location.of(LocationId.of("SAMPLE2"), addressS2, company, LocalDate.now());
    Set<Location> location = init();

    private Set<Location> init() {
        Set<Location> location = new HashSet<>();
        boolean s1 = location.add(sample1);
        boolean s2 = location.add(sample2);
        return location;
    }

    @Override
    public void store(Location newLocation) {
        if (!location.add(newLocation)) throw new LocationRepositoryException();
    }

    @Override
    public Location find(LocationId id) {
        return location.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
    }


    @Override
    public LocationWithAssignedCompanyViewDTO findProjection(String id) {
        return null;
    }

    @Override
    public List<LocationWithAssignedCompanyViewDTO> findProjections() {
        return null;
    }

}
