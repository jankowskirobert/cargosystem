package eu.jankowskirobert.cargosystem.domain.transportcompany;

public interface TransportCompanyRepository {
    void store(TransportCompany transportCompany);
    TransportCompany find(TransportCompanyId of);
}
