package ua.nure.ivannikova.dto;

import ua.nure.ivannikova.entity.Model;

public class RealtyDTO extends Model<Long> {

	private static final long serialVersionUID = 2073806572672036597L;

	private Double square;
	private String address;

	public RealtyDTO() {
	}

	public Double getSquare() {
		return square;
	}

	public void setSquare(Double square) {
		this.square = square;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
