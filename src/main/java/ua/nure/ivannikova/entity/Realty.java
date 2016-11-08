package ua.nure.ivannikova.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "realty")
public class Realty extends Model<Long> {

	private static final long serialVersionUID = 8468977831110857982L;

	@Column(length = 200, unique = true, nullable = false)
	private String address;

	@ManyToOne
	@JoinColumn(name = "type_id", nullable = false)
	private Type type;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;

	@Column(nullable = false)
	private Double square;

	@OneToMany(mappedBy = "realty", fetch = FetchType.LAZY)
	private Set<Viewing> viewings = new HashSet<Viewing>();

	public Set<Viewing> getViewings() {
		return viewings;
	}

	public void setViewings(Set<Viewing> viewings) {
		this.viewings = viewings;
	}

	public Realty() {
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Double getSquare() {
		return square;
	}

	public void setSquare(Double square) {
		this.square = square;
	}

}
