package model;

public class Clan {

	private String nombreClan;
	private Personaje primero;
	private Personaje ultimo;

	public Clan(String nombreClan) {
		this.nombreClan = nombreClan;
		primero = null;
		ultimo = null;
	}

	public String getNombreClan() {
		return nombreClan;
	}

	public void ingresarPersonajeAlFinal(String nombre, String personalidad, String fechaCreacion, double poder,
			Tecnica tecnicaBase) {
		Personaje personaje = new Personaje(nombre, personalidad, fechaCreacion, poder, tecnicaBase);

		if (primero == null) {
			primero = personaje;
			primero.setAnterior(null);
			ultimo = primero;
		} else {
			ultimo.setSiguiente(personaje);
			personaje.setAnterior(ultimo);
			personaje.setSiguiente(null);
			ultimo = personaje;
		}
	}

	public void ingresarPersonajeAlInicio(String nombre, String personalidad, String fechaCreacion, double poder,
			Tecnica tecnicaBase) {
		Personaje personaje = new Personaje(fechaCreacion, fechaCreacion, fechaCreacion, poder, tecnicaBase);
		if (primero != null) {
			Personaje temp = primero;
			primero = personaje;
			temp.setAnterior(personaje);
			personaje.setSiguiente(temp);
			personaje.setAnterior(null);
		}
	}

	public void ingresarPersonajeDespuesDe(String nombreAnterior, String nombre, String personalidad,
			String fechaCreacion, double poder, Tecnica tecnicaBase) {
		Personaje actual = primero, anterior = null, siguiente = null,
				porInsertar = new Personaje(nombre, personalidad, fechaCreacion, poder, tecnicaBase);
		boolean cerrar = false;
		while (actual != null && !cerrar) {
			if (actual.getNombre().equals(nombreAnterior)) {
				siguiente = actual.getSiguiente();
				anterior = actual;
				cerrar = true;
			}
			actual = actual.getSiguiente();
		}
		anterior.setSiguiente(porInsertar);
		siguiente.setAnterior(porInsertar);
		porInsertar.setSiguiente(siguiente);
		porInsertar.setAnterior(anterior);
	}

	public void ingresarPersonajeAntesDe(String nombreAnterior, String nombre, String personalidad,
			String fechaCreacion, double poder, Tecnica tecnicaBase) {
		Personaje actual = primero, anterior = null, siguiente = null,
				porInsertar = new Personaje(nombre, personalidad, fechaCreacion, poder, tecnicaBase);
		boolean cerrar = false;
		while (actual != null && !cerrar) {
			if (actual.getNombre().equals(nombreAnterior)) {
				siguiente = actual;
				anterior = actual.getAnterior();
				cerrar = true;
			}
			actual = actual.getSiguiente();
		}
		anterior.setSiguiente(porInsertar);
		siguiente.setAnterior(porInsertar);
		porInsertar.setSiguiente(siguiente);
		porInsertar.setAnterior(anterior);
	}

	public void eliminarPersonaje(String nombre) {
		Personaje actual = primero, anterior = null, siguiente = null;
		boolean cerrar = false;
		while (actual != null && !cerrar) {
			if (actual.getNombre().equals(nombre)) {
				anterior = actual.getAnterior();
				siguiente = actual.getSiguiente();
				cerrar = true;
			}
			actual = actual.getSiguiente();
		}
		anterior.setSiguiente(siguiente);
		siguiente.setAnterior(anterior);
	}
	
	public void modificarNombrePersonaje(String nombreActual,String nombreActualizar) {
		Personaje actual = primero;
		boolean cerrar = false;
		while (actual != null && !cerrar) {
			if(actual.getNombre().equals(nombreActual)) {
				actual.setNombre(nombreActualizar);
				cerrar = true;
			}
			actual = actual.getSiguiente();
		}
	}

	public int contarElementos() {
		int contador = 0;
		Personaje actual = primero;
		while (actual != null) {
			contador++;
			actual = actual.getSiguiente();
		}
		return contador;
	}
	
	public Personaje retornarPorPosicion(int pos) {
		Personaje actual = primero,index = null;
		int posicion = 0;
		boolean cerrar = false;
		while (actual != null && !cerrar) {
			++posicion;
			if(pos == posicion) {
				index = actual;
				cerrar = true;
			}
		}
		return actual;
	}
	
	public void insertarPorPosicion(int pos, Personaje p) {
		
	}

	public String buscarSecuencialPorNombre(String nombre) {
		Personaje actual = primero;
		String msj = "";
		boolean cerrar = false;
		while (actual != null && !cerrar) {
			if (actual.getNombre().equals(nombre)) {
				msj += actual;
			}
			actual = actual.getSiguiente();
		}
		return msj;
	}

	public String pintar() {
		String pintar = "";
		Personaje actual = primero;
		while (actual != null) {
			pintar += "\n" + actual;
			actual = actual.getSiguiente();
		}
		return pintar;
	}

}
