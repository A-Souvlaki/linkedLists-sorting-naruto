package model;

import java.util.ArrayList;

public class Konoha {
	
	private ArrayList<Clan> clanes;
	
	public Konoha() {
		clanes = loadClanes();
	}
	
	private ArrayList<Clan> loadClanes() {
		return null;
	}

	public ArrayList<Clan> getClanes() {
		return clanes;
	}
	
	public boolean buscarClanRepetido(String nombreClan) {
		boolean detener = true , repetido = false;
		for (int i = 0; i < clanes.size() && detener; i++) {
			if(clanes.get(i).getNombreClan().equals(nombreClan)) {
				detener = false;
				repetido = true;
			}
		}
		return repetido;
	}
	
	public void crearClan(String nombreClan) throws ElementoExisteExcepcion {
		if (buscarClanRepetido(nombreClan)) {
			throw new ElementoExisteExcepcion("Ya existe un clan con este nombre");
		} else {
			clanes.add(new Clan(nombreClan));
		}
	}
	
	public void eliminarClan(String nombreClan) {
		boolean detener = true;
		for (int i = 0; i < clanes.size() && detener; i++) {
			if(clanes.get(i).getNombreClan().equals(nombreClan)) {
				detener = false;
				clanes.remove(i);
			}
		}
	}
	
	public void ordenarPorNombreSeleccionSort() {
		for (int i = 0; i < clanes.size()-1; i++) {
			Clan menor = clanes.get(i);
			int cual = i;
			for (int j = i+1; j < clanes.size(); j++) {
				if (clanes.get(j).compareTo(menor)<0) {
					menor = clanes.get(j);
					cual = j;
				}
			}
			
			Clan temp = clanes.get(i);
			clanes.set(i, menor);
			clanes.set(cual, temp);
		}
	}
	
	
}

