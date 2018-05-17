package eu.jankowskirobert.cargosystem.application.cargo.create;

import eu.jankowskirobert.cargosystem.shared.Address;

import java.math.BigDecimal;

public class NewCargoCommand {
    private String id;
    private String name;
    private BigDecimal weight;
    private String companyId;
    private String transportCompanyId;
    private Address from;
    private Address to;
}
