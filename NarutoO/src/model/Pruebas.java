package model;

public class Pruebas {
	
	
	public static void main(String[] args) {
		Clan a = new Clan("Prueba");
		a.ingresarPersonajeAlFinal("Kazuma God     ", "¡PUES NO HAY MUCHO QUE DECIR ES EL MISMISIMO CRISTO!","19/09/2019", 8000, null);
		a.ingresarPersonajeAlFinal("Kirito Uzumaki ", "Un tipo con hacks bien chingones que tiene una waffle deliciosa","19/09/2019", 6200, null);
		a.ingresarPersonajeAlFinal("Dio Jotaro     ", "Is this a motherfucker jojo's reference!?","19/09/2019", 4500, null);
		a.ingresarPersonajeAlFinal("Anata wa       ", "Oki desu! hashimemaste","19/09/2019", 1250, null);	
		a.ingresarPersonajeAlFinal("Ganta Saiyayin ", "¿Que los fans de Deadman wonderland no estaba extintos?","19/09/2019", 2596, null);
		a.ingresarPersonajeAlFinal("EL DIOS TANAKA!", "Al fin, un digno oponente para Kazuma","19/09/2019", 8001, null);
		a.ingresarPersonajeAlFinal("Zoro sin piece ", "No estoy llorando, lo juro","19/09/2019", 6666, null);
		a.ingresarPersonajeAlFinal("Jhon Wick      ", "¡Que Dios se apiade de los que enfrenten a Jhon papasito Wick","19/09/2019", 8002, null);
		
		System.out.println(a.pintar());
		a.ordenarPorPoderBubbleSort();;
		
		System.out.println(a.contarElementos());
	
		
		
		
		

		
	

		
	
		
	}
}
