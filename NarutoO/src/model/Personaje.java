package model;

import java.util.Comparator;

public class Personaje implements Comparator<Personaje>{

	private String nombre;
	private String personalidad;
	private String fechaCreacion;
	private int poder;
	private Tecnica tecnicaBase;
	private Personaje siguiente;
	private Personaje anterior;

	public Personaje(String nombre, String personalidad, String fechaCreacion, int poder, Tecnica tecnicaBase) {
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

	public int getPoder() {
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
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Personaje [nombre: " + String.format("%1$-13s",nombre) + "| personalidad: " + String.format("%1$-70s",personalidad) + "| fechaCreacion: " + String.format("%1$-8s", fechaCreacion)
				+ "| poder: " + String.format("%1$-8s", poder) + "| tecnicaBase: " + String.format("%1$-8s", tecnicaBase) + "]";
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
	
	public void insertarAlInicio(String nombreTecnica, int factorDeInfluencia) {
		Tecnica tecnica = new Tecnica(nombreTecnica, factorDeInfluencia);
		if(tecnicaBase == null) {
			tecnicaBase = tecnica;
		}
		else {
			tecnica.setSiguiente(tecnicaBase);
			tecnicaBase = tecnica;
		}
	}
	
	public void insertarDespuesDe(String nombreAnterior,String nombreTecnica, int factorDeInfluencia) {
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
	
	public void insertarAntesDe(String nombreAnterior,String nombreTecnica, int factorDeInfluencia) {
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

	public int contarElementos() {
		int contador = 0;
		Tecnica actual = tecnicaBase ;
		while (actual != null) {
			contador++;
			actual = actual.getSiguiente();
		}
		return contador;
	}
	
	public Tecnica retornarIndice(int pos) {
		Tecnica actual = tecnicaBase;
		for (int i = 0; i < pos; i++) {
			actual = actual.getSiguiente();	
		}
		return actual;
	}
	
	public void ordenarPorPoder() {
		Tecnica actual = tecnicaBase, temp = null;
		int j;
		for (int i = 1; i < contarElementos(); i++) {
			temp = retornarIndice(i);
			j = i - 1;
			while ((retornarIndice(j).getFactorDeInfluencia()>temp.getFactorDeInfluencia()) && (j >= 0)) {
				retornarIndice(j).setSiguiente(retornarIndice(j+1));
				j--;
			}
			retornarIndice(j+1).setSiguiente(temp);
		}
	}

	@Override
	public int compare(Personaje o1, Personaje o2) {
		return o1.getNombre().compareTo(o2.getNombre());
	}

	
	

}
