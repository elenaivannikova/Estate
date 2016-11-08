package ua.nure.ivannikova.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "owner")
public class Owner extends Model<Long> {

	private static final long serialVersionUID = 3762691308997544439L;

	@Size(min = 6, message = "Minimum password length is 6 symbols.")
	@Column(length = 128, nullable = false)
	private String password;

	@Size(min = 5, message = "Incorrect email.")
	@Pattern(regexp = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$", message = "Incorrect email.")
	@Column(length = 100, unique = true, nullable = false)
	private String email;

	@Column(length = 20, unique = true, nullable = false)
	private String login;

	@OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
	private Set<Realty> realties = new HashSet<Realty>();

	public Owner() {
	}

	public Set<Realty> getObjects() {
		return realties;
	}

	public void setObjects(Set<Realty> objects) {
		this.realties = objects;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
