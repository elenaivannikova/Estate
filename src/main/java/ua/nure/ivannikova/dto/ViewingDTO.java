package ua.nure.ivannikova.dto;

import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import ua.nure.ivannikova.entity.Model;

public class ViewingDTO extends Model<Long> {

	private static final long serialVersionUID = -596733171672240812L;

	private Date datetime;

	private Date time;

	private String address;

	@Size(min = 1, message = "First name cannot be empty.")
	private String firstname;

	@Size(min = 1, message = "Last name cannot be empty.")
	private String lastname;

	@Pattern(regexp = "\\+[1-9][0-9]{11}", message = "Incorrect phone format.")
	private String phone;

	public ViewingDTO() {
	}

	@Override
	public String toString() {
		return "ViewingDTO [datetime=" + datetime + ", address=" + address + ", firstname=" + firstname + ", lastname="
				+ lastname + ", phone=" + phone + "]";
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
