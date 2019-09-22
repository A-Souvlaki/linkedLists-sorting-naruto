package prueba;

import model.Clan;
import model.ElementoExisteExcepcion;
import model.Personaje;
import model.Tecnica;

public class Pruebas {
	
	
		public static void main(String[] args) throws ElementoExisteExcepcion {
			Clan a = new Clan("Prueba");
			a.ingresarPersonajeAlFinal("Kazuma God     ", "PUES NO HAY MUCHO QUE DECIR ES EL MISMISIMO CRISTO!","19/09/2019", 8000, null);
			a.ingresarPersonajeAlFinal("Dio Jotaro     ", "Is this a motherfucker jojo's reference!?","19/09/2019", 4500, null);
			a.ingresarPersonajeAlFinal("Kirito Uzumaki ", "Un tipo con hacks bien chingones que tiene una waffle deliciosa","19/09/2019", 6200, null);
			a.ingresarPersonajeAlFinal("Anata wa       ", "Oki desu! hashimemaste","19/09/2019", 1250, null);
			a.ingresarPersonajeAlFinal("Jhon Wick      ", "Que Dios se apiade de los que enfrenten a Jhon papasito Wick","19/09/2019", 8002, null);
//			a.ingresarPersonajeAlFinal("Ganta Saiyayin ", "Que los fans de Deadman wonderland no estaba extintos?","19/09/2019", 2596, null);
//			a.ingresarPersonajeAlFinal("Belezza        ", "Que los fans de Deadman wonderland no estaba extintos?","19/09/2019", 2596, null);
			
			
			
			Personaje b = new Personaje("Dio Jotaro     ", "Is this a motherfucker jojo's reference!?","19/09/2019", 4500, null);
			b.insertarAlFinal("Anillo del oropel", 6);
			b.insertarAlFinal("Kim Crimson", 3);
			b.insertarAlFinal("Espejo del crepusculo", 5);
			b.insertarAlFinal("Hamon", 2);
			b.insertarAlFinal("Zemiramis", 9);
			b.insertarAlFinal("Hombres del pilar", 1);
			b.insertarAlFinal("Bitral Maria", 1);
			b.insertarAlFinal("Estratogema", 1);
			b.insertarAlFinal("Stand", 4);		
			
			System.out.println(b.pintar());
			b.ordenarNombresPorSelectionSort();
			System.out.println(b.pintar());
		}
		
		
		
	
		
		
		
		
}
