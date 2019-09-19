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
	
	public void ingresarPersonajeAlInicio(Personaje personaje) {
		
		if (primero != null) {
			Personaje temp = primero.getSiguiente();
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
	
	public void modificarPersonaje(String nombreActual,Personaje nuevo) {
		Personaje actual = primero,anterior = null,siguiente = null;
		boolean cerrar = false;
		while (actual != null && !cerrar) {
			if(actual.getNombre().equals(nombreActual)) {
				anterior = actual.getAnterior();
				siguiente = actual.getSiguiente();
				cerrar = true;
			}
			actual = actual.getSiguiente();
		}
		if(nombreActual.equals(primero.getNombre())) {
			ingresarPersonajeAlInicio(nuevo);
		} else if (siguiente == null) {
			anterior.setSiguiente(nuevo);
			nuevo.setAnterior(anterior);
			nuevo.setSiguiente(null);
		} else {
			anterior.setSiguiente(nuevo);
			nuevo.setAnterior(anterior);
			siguiente.setAnterior(nuevo);
			nuevo.setSiguiente(siguiente);
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
	
	public Personaje retornarIndice(int pos) {
		Personaje actual = primero;
		if(pos == 0) {
			actual = primero;
		}else {
			for (int i = 0; i < pos; i++) {
				actual = actual.getSiguiente();	
			}
		}
		
		return actual;
	}
	
	public void ordenarByPower() {
		Personaje actual = primero;
		
		while (actual != null) {
			
			int va = 0;
			while (va < contarElementos()-1) {
				if (retornarIndice(va).getPoder() > retornarIndice(va+1).getPoder()) {
					Personaje aux1 = retornarIndice(va);
					Personaje aux2 = retornarIndice(va+1);
					//
					if (aux1.getAnterior() == null) {
						
						Personaje temp = aux1;
						primero = aux2;
						temp.setAnterior(aux2);
						temp.setSiguiente(aux2.getSiguiente());
						aux2.setSiguiente(temp);
						aux1.setAnterior(null);	
						
					} else if (aux2.getSiguiente() == null) {
						
						Personaje temp = aux1;
						Personaje anterior = aux1.getAnterior();
						temp.setSiguiente(aux2.getSiguiente());
						temp.setAnterior(aux2);
						anterior.setSiguiente(aux2);
						aux2.setAnterior(anterior);
						aux2.setSiguiente(temp);
						
					} else {
						
						Personaje temp = aux1;
						Personaje anterior = aux1.getAnterior();
						Personaje next = aux2.getSiguiente();
						temp.setAnterior(aux2);
						temp.setSiguiente(next);
						anterior.setSiguiente(aux2);
						aux2.setAnterior(anterior);
						aux2.setSiguiente(temp);
					}
					//
				}
				va++;
			}
			actual = actual.getSiguiente();
		}
	}



	public String buscarSecuencialPorNombre(String nombre) {
		Personaje actual = primero;
		String msj = "";
		boolean cerrar = false;
		while (actual != null && !cerrar) {
			if (actual.getNombre().equals(nombre)) {
				msj += actual;
				cerrar = true;
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
