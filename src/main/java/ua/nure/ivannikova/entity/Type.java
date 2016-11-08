package ua.nure.ivannikova.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "type")
public class Type extends Model<Long> {

	private static final long serialVersionUID = 2367428205585937190L;

	@Column(length = 30, nullable = false, unique = true)
	private String name;

	@OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
	private Set<Realty> realties = new HashSet<Realty>();

	public Set<Realty> getRealties() {
		return realties;
	}

	public void setRealties(Set<Realty> realties) {
		this.realties = realties;
	}

	public Type() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
