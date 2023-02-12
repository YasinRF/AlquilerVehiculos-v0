package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

public class Turismo {
	
	private static final String ER_MARCA = "^[A-z][a-z]*|[A-Z][a-z]* \s [A-z][a-z]*|[A-Z][a-z] - [A-z][a-z]*|[A-Z][a-z]*|[A-z][a-z]*|[A-Z][a-z]**";
	private static final String ER_MATRICULA = "^[0-9]{4}(?!.*(LL|CH))[BCDFGHJKLMNPRSTVWXYZ]{3}";
	
	private String marca;
	private String modelo;
	private int cilindrada;
	private String matricula;
	
	//CREAMOS LOS CONSTRUCTORES Y EL CONSTRUCTOR COPIA
	
	public Turismo(String marca, String modelo, int cilindrada, String matricula) {
		setMarca(marca);
		setModelo(modelo);
		setCilindrada(cilindrada);
		setMatricula(matricula);
	}
	
	public Turismo(Turismo turismo) {
		setMarca(ER_MARCA);
		setModelo(modelo);
		setCilindrada(cilindrada);
		setMatricula(matricula);
	}
	
	//GETTERS Y SETTERS

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		if(!marca.matches(ER_MARCA)) {
			throw new IllegalArgumentException("ERROR: La marca no tiene un formato válido.");
		}
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		if(!modelo.matches(modelo)) {
			throw new IllegalArgumentException("ERROR: El modelo no es correcto");
		}
		if(modelo.isBlank()) {
			throw new IllegalArgumentException("ERROR: El modelo no puede estar en blanco.");
		}
		this.modelo = modelo;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		if(cilindrada<=0 || cilindrada > 5000) {
			throw new IllegalArgumentException("ERROR: La cilindrada no es correcta");
		}
		this.cilindrada = cilindrada;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		if(!matricula.matches(ER_MATRICULA)) {
			throw new NullPointerException("ERROR: La matrícula no puede ser nula.");
		}
		this.matricula = matricula;
	}
	
	public static Turismo getTurismoConMatricula(String matricula) {
		return new Turismo ("KIA", "DIESEL", 250, matricula);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cilindrada, marca, matricula, modelo);
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
		return cilindrada == other.cilindrada && Objects.equals(marca, other.marca)
				&& Objects.equals(matricula, other.matricula) && Objects.equals(modelo, other.modelo);
	}

	@Override
	public String toString() {
		return String.format("Turismo [marca=%s, modelo=%s, cilindrada=%s, matricula=%s]", marca, modelo, cilindrada,
				matricula);
	}
	

}
