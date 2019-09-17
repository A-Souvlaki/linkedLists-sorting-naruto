package model;

import java.util.Comparator;

public class Personaje implements Comparable<Personaje>{

	private String nombre;
	private String personalidad;
	private String fechaCreacion;
	private double poder;
	private Tecnica tecnicaBase;
	private Personaje siguiente;
	private Personaje anterior;

	public Personaje(String nombre, String personalidad, String fechaCreacion, double poder, Tecnica tecnicaBase) {
		this.nombre = nombre;
		this.personalidad = personalidad;
		this.fechaCreacion = fechaCreacion;
		this.poder = poder;
		this.tecnicaBase = null;
		this.siguiente = null;
		this.anterior = null;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPersonalidad() {
		return personalidad;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public double getPoder() {
		return poder;
	}

	public Tecnica getTecnicaBase() {
		return tecnicaBase;
	}

	public Personaje getSiguiente() {
		return siguiente;
	}

	public Personaje getAnterior() {
		return anterior;
	}

	public void setSiguiente(Personaje siguiente) {
		this.siguiente = siguiente;
	}

	public void setAnterior(Personaje anterior) {
		this.anterior = anterior;
	}

	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + ", personalidad=" + personalidad + ", fechaCreacion=" + fechaCreacion
				+ ", poder=" + poder + ", tecnicaBase=" + tecnicaBase + "]";
	}

	public void insertarAlFinal(String nombreTecnica, double factorDeInfluencia) {
		Tecnica tecnica = new Tecnica(nombreTecnica, factorDeInfluencia);
		if(tecnicaBase == null) {
			tecnicaBase = tecnica;
		} else {
			Tecnica actual = tecnicaBase;
			while (actual.getSiguiente() != null) {
				actual = actual.getSiguiente();
			}
			actual.setSiguiente(tecnica);
		}
	}
	
	public void insertarAlInicio(String nombreTecnica, double factorDeInfluencia) {
		Tecnica tecnica = new Tecnica(nombreTecnica, factorDeInfluencia);
		if(tecnicaBase == null) {
			tecnicaBase = tecnica;
		}
		else {
			tecnica.setSiguiente(tecnicaBase);
			tecnicaBase = tecnica;
		}
	}
	
	public void insertarDespuesDe(String nombreAnterior,String nombreTecnica, double factorDeInfluencia) {
		Tecnica actual = tecnicaBase,tecnica = new Tecnica(nombreTecnica, factorDeInfluencia), siguiente = null;
		while (actual.getSiguiente() != null) {
			if(actual.getSiguiente().getNombreTecnica().equals(nombreAnterior)) {
				siguiente = actual.getSiguiente();
			}
			actual = actual.getSiguiente();
		}
		Tecnica temp = siguiente.getSiguiente();
		siguiente.setSiguiente(tecnica);
		tecnica.setSiguiente(temp);
	}
	
	public void insertarAntesDe(String nombreAnterior,String nombreTecnica, double factorDeInfluencia) {
		Tecnica actual = tecnicaBase,tecnica = new Tecnica(nombreTecnica, factorDeInfluencia), anterior = null;
		while (actual.getSiguiente() != null) {
			if(actual.getSiguiente().getNombreTecnica().equals(nombreAnterior)) {
				anterior = actual;
			}
			actual = actual.getSiguiente();
		}
		Tecnica temp = anterior.getSiguiente();
		anterior.setSiguiente(tecnica);
		tecnica.setSiguiente(temp);
	}
	
	public void eliminarTecnica(String nombreTecnica) {
		Tecnica actual = tecnicaBase,siguiente = null, anterior = null;
		while (actual.getSiguiente() != null) {
			if(actual.getSiguiente().getNombreTecnica().equals(nombreTecnica)) {
				anterior = actual;
				siguiente = actual.getSiguiente();
			}
			actual = actual.getSiguiente();
		}
		anterior.setSiguiente(siguiente.getSiguiente());
	}
	
	
	public String pintar() {
		String pintar = "";
		Tecnica actual = tecnicaBase;
		while(actual != null) {
			pintar += "\n"+actual;
			actual = actual.getSiguiente();
		}
		return pintar;
	}

	@Override
	public int compareTo(Personaje o) {
		return nombre.compareTo(o.getNombre());
	}

	
	

}
