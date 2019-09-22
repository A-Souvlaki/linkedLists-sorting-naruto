/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad Icesi (Cali - Colombia)
 * Solución laboratorio Unidad 2
 * @author Cristian Rivadeneira - josepthcamilo@gmail.com
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package ui;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Date;

import java.io.*;
import java.text.SimpleDateFormat;

import model.ElementoExisteExcepcion;
import model.Konoha;

public class Menu {

	private Konoha aldeas;
	private Scanner reader;

	public Menu() {
		reader = new Scanner(System.in);
		aldeas = new Konoha("./files/Serializable.dat");
		systemOperation();
	}

	public void systemOperation() {
		boolean close = false;

		while (!close) {
			int userValue = menuSystem();
			switch (userValue) {
			case 0:
				close = true;
				break;
			case 1:
				registrarClan();
				aldeas.saveClanes();
				break;
			case 2:
				registrarPersonaje();
				aldeas.saveClanes();
				break;
			case 3:
				registrarTecnica();
				aldeas.saveClanes();
				break;
			case 4:
				eliminarClan();
				aldeas.saveClanes();
				break;
			case 5:
				eliminarPersonaje();
				aldeas.saveClanes();
				break;
			case 6:
				eliminarTecnica();
				aldeas.saveClanes();
				break;
			case 7:
				mostrarClanesOrdenados();
				break;
			case 8:
				mostrarPersonajesOrdenados();
				break;
			case 9:
				mostrarTecnicasOrdenadas();
				break;
			default:
				break;
			}

		}

	}

	public int menuSystem() {
		System.out.println("\nElije una opcion :)");
		System.out.println("1.  Registrar un clan ");
		System.out.println("2.  Registrar un personaje ");
		System.out.println("3.  Registrar una tecnica a un personaje");
		System.out.println(" ");
		System.out.println("4.  Eliminar un clan");
		System.out.println("5.  Eliminar un personaje");
		System.out.println("6.  Eliminar una tecnica");
		System.out.println(" ");
		System.out.println("7.  Mostrar clanes ordenados");
		System.out.println("8.  Mostrar personajes ordenados por nombre");
		System.out.println("9.  Mostrar tecnicas ordenadas por poder");
		
		System.out.println(String.format("7.  Mostrar lista ordenada de clubes segun numero de dueños"));

		System.out.println(String.format("0.  Salir "));
		int value = 0;
		// Here I catch the exceptions
		try {
			value = reader.nextInt();
			reader.nextLine();
			if (value <= -1 || value > 7) {
				throw new OutOfRangeExcepcion("\"Por favor digite una opcion valida :)...O tu windows se cerrara\"");
			}
		} catch (InputMismatchException e) {
			System.out.println("Por favor digite una opcion valida :)...O tu windows se cerrara");
			reader.nextLine();

		} catch (OutOfRangeExcepcion e) {
			System.out.println(e.getMessage());
		}
		return value;
	}

	public void registrarClan() {
		System.out.println("Ingrese el nombre del clan: ");
		String nombreClan = reader.nextLine();
		try {
			aldeas.crearClan(nombreClan);
			System.out.println("Se ha añadido un clan. ");
		}catch (ElementoExisteExcepcion e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void registrarPersonaje() {
		
		System.out.println("Ingrese el nombre del Personaje: ");
		String nombre = reader.nextLine();
		System.out.println("Ingrese la personalidad del Personaje: ");
		String personalidad = reader.nextLine();
		System.out.println("Ingrese la fecha de creacion:  ");
		String fechaCreacion = reader.nextLine();
		System.out.println("Ingrese el poder del personaje: ");
		int poder = reader.nextInt();
		reader.nextLine();
		System.out.println("Ingrese el nombre del clan: ");
		String nombreClan = reader.nextLine();
		
		try {
			aldeas.retornarObjetoClan(nombreClan).ingresarPersonajeAlFinal(nombre, personalidad, fechaCreacion, poder, null);
			System.out.println("Se ha creado un personaje. ");
		} catch (ElementoExisteExcepcion e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public void registrarTecnica() {
		
		System.out.println("Ingrese el nombre de la tecnica: ");
		String nombreTecnica = reader.nextLine();
		System.out.println("Ingrese el factor de influencia: ");
		int factorDeInfluencia = reader.nextInt();
		
		System.out.println("Ingrese el nombre del clan: ");
		String nombreClan = reader.nextLine();
		
		System.out.println("Ingrese el nombre del personaje: ");
		String nombre = reader.nextLine();
		
		try {
			aldeas.retornarObjetoClan(nombreClan).retornarObjeto(nombre).insertarAlFinal(nombreTecnica, factorDeInfluencia);
			System.out.println("Se ha agregado una tecnica. ");
		} catch (ElementoExisteExcepcion e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void eliminarClan() {
		System.out.println("Ingrese el nombre del clan que desea eliminar: ");
		String nombreClan = reader.nextLine();
		
		aldeas.eliminarClan(nombreClan);
		System.out.println("Se ha eliminado el clan");
	}
	
	public void eliminarPersonaje() {
		System.out.println("Ingrese el nombre del clan: ");
		String nombreClan = reader.nextLine();
		
		System.out.println("Ingrese el nombre del personaje que desea eliminar: ");
		String nombre = reader.nextLine();
		
		aldeas.retornarObjetoClan(nombreClan).eliminarPersonaje(nombre);
		System.out.println("Se ha eliminado el clan");
	}
	
	public void eliminarTecnica() {
		System.out.println("Ingrese el nombre del clan: ");
		String nombreClan = reader.nextLine();
		
		System.out.println("Ingrese el nombre del personaje: ");
		String nombre = reader.nextLine();
		
		System.out.println("Ingrese el nombre de la tecnica que desea eliminar: ");
		String nombreTecnica = reader.nextLine();
		
		aldeas.retornarObjetoClan(nombreClan).retornarObjeto(nombre).eliminarTecnica(nombreTecnica);
	}
	
	public void mostrarClanesOrdenados() {
		aldeas.ordenarPorNombreSeleccionSort();
		System.out.println(aldeas.pintar());
	}
	
	public void mostrarPersonajesOrdenados() {
		System.out.println("Ingrese el nombre del clan: ");
		String nombreClan = reader.nextLine();
		long t1= System.nanoTime();
		aldeas.retornarObjetoClan(nombreClan).ordenarPorNombreBubbleSort();
		long t2 = System.nanoTime();
		System.out.println(aldeas.retornarObjetoClan(nombreClan).pintar());
		System.out.println("\nTiempo en ejecutar la busqueda secuencial: " + (t2-t1)+" Nanosegundos\n");
	}
	
	public void mostrarTecnicasOrdenadas() {
		System.out.println("Ingrese el nombre del clan: ");
		String nombreClan = reader.nextLine();
		
		System.out.println("Ingrese el nombre del personaje: ");
		String nombre = reader.nextLine();
		long t1= System.nanoTime();
		aldeas.retornarObjetoClan(nombreClan).retornarObjeto(nombre).ordenarPorPoderInsertionSort();
		long t2 = System.nanoTime();
		System.out.println(aldeas.retornarObjetoClan(nombreClan).retornarObjeto(nombre).pintar());
		System.out.println("\nTiempo en ejecutar la busqueda secuencial: " + (t2-t1)+" Nanosegundos\n");
	}
	
	public static void main(String[] args) {

		Menu m = new Menu();
	}
}
