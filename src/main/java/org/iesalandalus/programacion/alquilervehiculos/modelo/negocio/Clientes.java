package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

public class Clientes {
	
	private List<Cliente> coleccioneCliente;

	
	public Clientes() {
		coleccioneCliente = new ArrayList<>();
	}

	public List<Cliente> get() {
		return new ArrayList<Cliente>(coleccioneCliente);
	}

	public int getCantidad() {
		return coleccioneCliente.size();
	}

	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
		}

		if (coleccioneCliente.contains(cliente)) {
			throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese DNI.");
		}

		coleccioneCliente.add(cliente);
	}

	public Cliente buscar(Cliente cliente) {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");
		}
		if (coleccioneCliente.contains(cliente)) {
			return cliente;
		}
		return null;
	}

	public void borrar(Cliente cliente) throws OperationNotSupportedException {

		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede borrar un cliente nulo.");
		}
		if (!coleccioneCliente.contains(cliente)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		}
		coleccioneCliente.remove(cliente);
	}

	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {

		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede modificar un cliente nulo.");
		}
		if (!coleccioneCliente.contains(cliente)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		} else {
			if (nombre != null && !nombre.trim().isEmpty()) {
				cliente.setNombre(nombre);
			}

			if (telefono != null && !telefono.trim().isEmpty()) {
				cliente.setTelefono(telefono);
			}
		}

	}

}
}
