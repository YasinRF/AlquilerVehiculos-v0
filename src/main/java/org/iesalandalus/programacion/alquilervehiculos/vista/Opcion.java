package org.iesalandalus.programacion.alquilervehiculos.vista;

import javax.naming.OperationNotSupportedException;

public enum Opcion {
	SALIR("Salir"),
	INSERTAR_CLIENTE("Insertar un Cliente"), INSERTAR_TURISMO("Insertar un Turismo"), INSERTAR_ALQUILER("Insertar un Alquiler"),
	BUSCAR_CLIENTE("Buscar un Cliente"), BUSCAR_TURISMO("Buscar un Turismo"), BUSCAR_ALQUILER("Buscar un Alquiler"),
	MODIFICAR_CLIENTE("Modificar un Cliente"),
	DEVOLVER_ALQUILER("Devolver un Alquiler"),
	BORRAR_CLIENTE("Borrar un Cliente"), BORRAR_TURISMO("Borrar un Turismo"), BORRAR_ALQUILER("Borrar un Alquiler"),
	LISTAR_CLIENTES("Listar los Clientes"), LISTAR_TURISMOS("Listar los Turismos"), LISTAR_ALQUILERES("Listar los Alquileres"),

	LISTAR_ALQUILERES_CLIENTE("Listar los Alquileres del Cliente"),
	LISTAR_ALQUILERES_TURISMO("Listar los Alquileres del Turismo");

	private String texto;

	private Opcion(String texto) {
		this.texto = texto;
	}

	private static boolean esOrdinalValido(int ordinal) {
		boolean ordinalCorrecto = true;
		if (ordinal < 0 || ordinal >= values().length) {
			ordinalCorrecto = false;
		}
		return ordinalCorrecto;
	}

	public static Opcion get(int ordinal) throws OperationNotSupportedException {
		if (!esOrdinalValido(ordinal)) {
			throw new OperationNotSupportedException("El ordinal introducido no es correcto");
		}
		return values()[ordinal];
	}

	@Override
	public String toString() {
		return String.format("%d-%s", ordinal(), texto);
	}
}