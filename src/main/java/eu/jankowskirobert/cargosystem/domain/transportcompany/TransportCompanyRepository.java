package eu.jankowskirobert.cargosystem.domain.transportcompany;

public interface TransportCompanyRepository {
    public void store(TransportCompany transportCompany);
    TransportCompany find(TransportCompanyId of);
}
