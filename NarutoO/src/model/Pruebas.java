package model;

public class Pruebas {
	
	
	public static void main(String[] args) {
		Clan a = new Clan("Prueba");
		a.ingresarPersonajeAlFinal("Kirito Uzumaki", "d","d", 3, null);
		a.ingresarPersonajeAlFinal("Kazuma God", "d","d", 5, null);
		a.ingresarPersonajeAlFinal("Dio Jotaro", "b","b", 4, null);	
		a.ingresarPersonajeAlFinal("Ganta Saiyayin", "b","b", 2, null);
		
		System.out.println(a.pintar());
		a.ordenarByPower();
		System.out.println(a.pintar());
		System.out.println(a.contarElementos());
	
		
		
		
		

		
	

		
	
		
	}
}
