package model;

public class Pruebas {
	
	
	public static void main(String[] args) {
		Clan a = new Clan("Prueba");
		a.ingresarPersonajeAlFinal("Jhon Jairo", "b","b", 5000, null);
		a.ingresarPersonajeAlFinal("Cristian", "c","c", 5000, null); 
		a.ingresarPersonajeAlFinal("Kilo", "d","d", 5000, null);
		System.out.println(a.pintar());
		a.darLista();
		a.ordenarPorBurbuja();
		a.agregarOrdenadosLista();
		System.out.println(a.pintar());
		
		
	
		
	}
}
