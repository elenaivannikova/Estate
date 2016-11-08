package ua.nure.ivannikova.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Model<T extends Serializable> implements Serializable {

	private static final long serialVersionUID = -6645012707410889057L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private T id;

	public Model() {
	}

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}
}
