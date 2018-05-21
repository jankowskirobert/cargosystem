package eu.jankowskirobert.cargosystem.domain.company;

import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor(staticName = "of")
public class CompanyId {
	private String id;

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "CompanyId{" +
				"id='" + id + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CompanyId companyId = (CompanyId) o;
		return Objects.equals(id, companyId.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
