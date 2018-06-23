package eu.jankowskirobert.cargosystem.domain.company;

import eu.jankowskirobert.cargosystem.domain.company.Company;
import eu.jankowskirobert.cargosystem.domain.company.CompanyId;

public interface CompanyRepository {

	Company find(CompanyId companyId);

    void store(Company company);
}
