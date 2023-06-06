package org.iesalandalus.programacion.alquilervehiculos.vista;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;

public class Vista {

	private Controlador controlador;

	public void setControlador(Controlador controlador) {
		if (controlador == null) {
			throw new NullPointerException("ERROR: El controlador no puede ser nulo");
		}
		this.controlador = controlador;
	}

	public void comenzar(){
		Opcion opcion;
		do {
			Consola.mostrarMenu();
			opcion = Consola.elegirOpcion();
			ejecutar(opcion);
			System.out.println("");
		} while (opcion != Opcion.SALIR);
	}

	public void terminar() {
		System.out.print("Hasta la próxima!!!");
		System.exit(0);
	}

	private void ejecutar(Opcion opcion) {
		switch (opcion.ordinal()) {
		case 0:
			terminar();
			break;
		case 1:
			insertarCliente();
			break;
		case 2:
			insertarTurismo();
			break;
		case 3:
			insertarAlquiler();

			break;
		case 4:
			buscarCliente();

			break;
		case 5:
			buscarTurismo();

			break;
		case 6:
			buscarAlquiler();

			break;
		case 7:
			modificarCliente();

			break;
		case 8:
			devolverAlquiler();

			break;
		case 9:
			borrarCliente();

			break;
		case 10:
			borrarTurismo();

			break;
		case 11:
			borrarAlquiler();

			break;
		case 12:
			listarClientes();

			break;
		case 13:
			listarTurismos();

			break;
		case 14:
			listarAlquileres();

			break;
		case 15:
			listarAlquileresCliente();

			break;
		case 16:
			listarAlquileresTurismo();

			break;
		}
	}

	private void insertarCliente() {
		try {
			Consola.mostrarCabecera("Opcion 1 -> Insertar Cliente");
			controlador.insertar(Consola.leerCliente());
			System.out.print("El cliente se ha insertado correctamente.");
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void insertarTurismo() {
		try {
			Consola.mostrarCabecera("Opcion 2 -> Insertar Turismo");
			controlador.insertar(Consola.leerTurismo());
			System.out.print("El turismo se ha insertado correctamente.");
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void insertarAlquiler() {
		try {
			Consola.mostrarCabecera("Opcion 3 -> Insertar Alquiler");
			controlador.insertar(Consola.leerAlquiler());
			System.out.print("El alquiler se ha insertado correctamente.");
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void buscarCliente() {
		try {
			Consola.mostrarCabecera("Opcion 4 -> Buscar Cliente");
			System.out.print(controlador.buscar(Consola.leerClienteDni()));
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void buscarTurismo() {
		try {
			Consola.mostrarCabecera("Opcion 5 -> Buscar Turismo");
			System.out.print(controlador.buscar(Consola.leerTurismoMatricula()));
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}

	}

	private void buscarAlquiler() {
		try {
			Consola.mostrarCabecera("Opcion 6 -> Buscar Alquiler");
			System.out.print(controlador.buscar(Consola.leerAlquiler()));
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void modificarCliente() {
		try {
			Consola.mostrarCabecera("Opcion 7 -> Modificar Cliente");
			controlador.modificar(Consola.leerClienteDni(), Consola.leerNombre(), Consola.leerTelefono());
			System.out.print("El cliente se ha modificado correctamente.");
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void devolverAlquiler() {
		try {
			Consola.mostrarCabecera("Opcion 8 -> Devolver Alquiler");
			controlador.devolver(Consola.leerAlquiler(), Consola.leerFechaDevolucion());
			System.out.print("El alquiler se ha devuelto correctamente.");
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void borrarCliente() {
		try {
			Consola.mostrarCabecera("Opcion 9 -> Borrar Cliente");
			controlador.borrar(Consola.leerClienteDni());
			System.out.print("El cliente se ha borrado correctamente.");
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void borrarTurismo() {
		try {
			Consola.mostrarCabecera("Opcion 10 -> Borrar Turismo");
			controlador.borrar(Consola.leerTurismoMatricula());
			System.out.print("El turismo se ha borrado correctamente.");
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void borrarAlquiler() {
		try {
			Consola.mostrarCabecera("Opcion 11 -> Borrar Alquiler");
			controlador.borrar(Consola.leerAlquiler());
			System.out.print("El alquiler se ha borrado correctamente.");
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void listarClientes() {
		Consola.mostrarCabecera("Opcion 12 -> Listar Clientes");
		System.out.println(controlador.getClientes());
	}

	private void listarTurismos() {
		Consola.mostrarCabecera("Opcion 13 -> Listar Turismos");
		System.out.println(controlador.getTurismos());
	}

	private void listarAlquileres() {
		Consola.mostrarCabecera("Opcion 14 -> Listar Alquileres");
		System.out.println(controlador.getAlquileres());
	}

	private void listarAlquileresCliente() {

		try {
			Consola.mostrarCabecera("Opcion 15 -> Listar los alquileres de un Cliente");
			System.out.println(controlador.getAlquileres(Consola.leerClienteDni()));
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void listarAlquileresTurismo() {
		try {
			Consola.mostrarCabecera("Opcion 16 -> Listar los alquileres de un Turismo");
			System.out.println(controlador.getAlquileres(Consola.leerTurismoMatricula()));
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

}