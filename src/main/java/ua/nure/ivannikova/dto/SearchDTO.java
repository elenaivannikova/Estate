package ua.nure.ivannikova.dto;

import java.io.Serializable;

public class SearchDTO implements Serializable {

	private static final long serialVersionUID = 318724339633134637L;

	private String type;
	private String minSquare;
	private String maxSquare;
	private String address;

	public SearchDTO() {
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMinSquare() {
		return minSquare;
	}

	public void setMinSquare(String minSquare) {
		this.minSquare = minSquare;
	}

	public String getMaxSquare() {
		return maxSquare;
	}

	public void setMaxSquare(String maxSquare) {
		this.maxSquare = maxSquare;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
