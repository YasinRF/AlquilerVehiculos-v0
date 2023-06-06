package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

	private static final String PATRON_FECHA = "dd/MM/yyyy";
	private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern(PATRON_FECHA);

	private Consola() {
	}

	public static void mostrarCabecera(String mensaje) {
		System.out.println(mensaje);
		for (int i = 0; i < mensaje.length(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public static void mostrarMenu() {
		mostrarCabecera("Menu para la gestión en Alquiler de Vehiculos: ");
		for (Opcion opcion : Opcion.values()) {
			System.out.println(opcion);
		}
	}

	private static String leerCadena(String mensaje) {
		System.out.print(mensaje);
		return Entrada.cadena();
	}

	private static Integer leerEntero(String mensaje) {
		System.out.print(mensaje);
		return Entrada.entero();
	}

	private static LocalDate leerFecha(String mensaje) {
		LocalDate fechaDeterminada = null;
		System.out.print(mensaje);
		try {
			fechaDeterminada = LocalDate.parse(Entrada.cadena(), FORMATO_FECHA);
		} catch (DateTimeException e) {
			System.out.println(e.getMessage());
		}
		return fechaDeterminada;
	}

	public static Opcion elegirOpcion()  {
		Opcion opcion = null;
		do {
			try {
				int numEntero = leerEntero("Introduce una opción correcta:");
				opcion = Opcion.get(numEntero);
			} catch (OperationNotSupportedException e) {
				System.out.println(e.getMessage());
				opcion = null;
			}
		} while (opcion == null);
		return opcion;
	}

	public static Cliente leerCliente() {
		String nombre = leerCadena("Introduce el Nombre:");
		String dni = leerCadena("Introduce el DNI:");
		String telefono = leerCadena("Introduce el teléfono:");
		return new Cliente(nombre, dni, telefono);
	}

	public static Cliente leerClienteDni() {
		String dni = leerCadena("Introduce el DNI:");
		return Cliente.getClienteConDni(dni);
	}

	public static String leerNombre() {
		return leerCadena("Introduce el Nombre:");
	}

	public static String leerTelefono() {
		return leerCadena("Introduce el telefono:");
	}

	public static Turismo leerTurismo() {
		String marca = leerCadena("Introduce la marca:");
		String modelo = leerCadena("Introduce el modelo:");
		int cilindrada = leerEntero("Indroduce la cilindrada:");
		String matricula = leerCadena("Introduce la matricula:");
		return new Turismo(marca, modelo, cilindrada, matricula);
	}

	public static Turismo leerTurismoMatricula() {
		return Turismo.getTurismoConMatricula(leerCadena("Introduce la matricula:"));
	}

	public static Alquiler leerAlquiler() {
		Cliente cliente = leerClienteDni();
		Turismo turismo = leerTurismoMatricula();
		LocalDate fechaAlquiler = leerFecha("Introduce la fecha de Alquiler con el formato: " + PATRON_FECHA);
		return new Alquiler(cliente, turismo, fechaAlquiler);
	}

	public static LocalDate leerFechaDevolucion() {
		return leerFecha("Introduce la fecha de Devolucion con el formato: " + PATRON_FECHA);
	}

}
