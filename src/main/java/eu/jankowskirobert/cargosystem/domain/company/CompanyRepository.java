package eu.jankowskirobert.cargosystem.domain.company;

public interface CompanyRepository {

	Company find(CompanyId companyId);

    void store(Company company);
}
