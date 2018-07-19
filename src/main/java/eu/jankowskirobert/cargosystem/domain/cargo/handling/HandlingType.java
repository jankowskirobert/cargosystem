package eu.jankowskirobert.cargosystem.domain.cargo.handling;

public enum HandlingType {

    LOAD(true), UNLOAD(true), RECEIVE(false), CLAIM(false), REFUSE(false), CHECK(true), UNKNOWN(false);

    HandlingType(boolean transit) {
        this.transit = transit;
    }

    private boolean transit;

    public boolean isTransitRequired() {
        return transit;
    }
}
