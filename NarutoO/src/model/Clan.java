package model;

import java.util.ArrayList;

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

	public int contarElementos() {
		int contador = 0;
		Personaje actual = primero;
		while (actual != null) {
			contador++;
			actual = actual.getSiguiente();
		}
		return contador;
	}

	public ArrayList<Personaje> darLista() {
		ArrayList<Personaje> personajes = new ArrayList<Personaje>();
		Personaje actual = primero;
		while (actual != null) {
			personajes.add(actual);
			actual = actual.getSiguiente();
		}
		return personajes;
	}

	public ArrayList<Personaje> ordenarPorBurbuja() {
		ArrayList<Personaje> p = darLista();
		for (int i = 0; i < p.size(); i++) {
			for (int j = 0; j < p.size() - 1 - i; j++) {
				if (p.get(j).compareTo(p.get(j + 1)) > 0) {
					Personaje temp = p.get(j);
					p.set(j, p.get(j + 1));
					p.set(j + 1, temp);
				}
			}
		}
		return p;
	}

	public void agregarOrdenadosLista() {
		ArrayList<Personaje> ordenado = ordenarPorBurbuja();
		primero = null;
		ultimo = null;
		for (int i = 0; i < ordenado.size(); i++) {
			ingresarPersonajeAlFinal(ordenado.get(i).getNombre(), ordenado.get(i).getPersonalidad(),
					ordenado.get(i).getFechaCreacion(), ordenado.get(i).getPoder(), ordenado.get(i).getTecnicaBase());
		}
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

	public String buscarBinarioPorNombre(String nombre) {
		String msj = "";

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
