package ua.nure.ivannikova.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "viewing")
public class Viewing extends Model<Long> {

	private static final long serialVersionUID = 2835925962902308470L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "realty_id", nullable = false)
	private Realty realty;

	@Column(nullable = false)
	private Date datetime;

	@Column(length = 40, nullable = false)
	private String firstname;

	@Column(length = 40, nullable = false)
	private String lastname;

	@Column(length = 15, nullable = false)
	private String phone;

	public Viewing() {
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public Realty getRealty() {
		return realty;
	}

	public void setRealty(Realty realty) {
		this.realty = realty;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
