package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

public class Turismo {

	private static final String ER_MARCA = "^[A-Z][a-z]+|^[A-Z][a-z]+\\s[A-Z][a-z]+|^[A-Z]+|^[A-Z][a-z]+[A-Z][a-z]+|^[A-Z][a-z]+-[A-Z][a-z]+";
	private static final String ER_MATRICULA = "^[0-9]{4}[BCDFGHJKLMNPRSTVWXYZ]{3}";

	private String marca;
	private String modelo;
	private int cilindrada;
	private String matricula;

	// CREAMOS LOS CONSTRUCTORES Y EL CONSTRUCTOR COPIA

	public Turismo(String marca, String modelo, int cilindrada, String matricula) {
		setMarca(marca);
		setModelo(modelo);
		setCilindrada(cilindrada);
		setMatricula(matricula);
	}

	public Turismo(Turismo turismo) {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No es posible copiar un turismo nulo.");
		}
		this.marca = turismo.getMarca();
		this.modelo = turismo.getModelo();
		this.cilindrada = turismo.getCilindrada();
		this.matricula = turismo.getMatricula();
	}

	// GETTERS Y SETTERS

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		if (marca == null) {
			throw new NullPointerException("ERROR: La marca no puede ser nula.");
		}
		if (!marca.matches(ER_MARCA)) {
			throw new IllegalArgumentException("ERROR: La marca no tiene un formato válido.");
		}
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		if (modelo == null) {
			throw new NullPointerException("ERROR: El modelo no puede ser nulo.");
		}
		if (modelo.isBlank()) {
			throw new IllegalArgumentException("ERROR: El modelo no puede estar en blanco.");
		}
		this.modelo = modelo;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		if (cilindrada <= 0 || cilindrada > 5000) {
			throw new IllegalArgumentException("ERROR: La cilindrada no es correcta.");
		}
		this.cilindrada = cilindrada;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		if (matricula == null) {
			throw new NullPointerException("ERROR: La matrícula no puede ser nula.");
		}
		if (!matricula.matches(ER_MATRICULA)) {
			throw new IllegalArgumentException("ERROR: La matrícula no tiene un formato válido.");
		}
		this.matricula = matricula;
	}

	public static Turismo getTurismoConMatricula(String matricula) {
		return new Turismo("KIA", "CEED", 250, matricula);
	}

	// CREAMOS EL HASHCODE, EQUALS Y TOSTRING

	@Override
	public String toString() {
		return String.format("%s %s (%sCV) - %s", marca, modelo, cilindrada, matricula);
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turismo other = (Turismo) obj;
		return Objects.equals(matricula, other.matricula);
	}

}
