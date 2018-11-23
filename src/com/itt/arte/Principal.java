package com.itt.arte;
import java.util.Scanner;

import com.itt.arte.*;

public class Principal {
private static Scanner lector;
private static Obra obra = new Obra("La cena de los idiotas", "Comedia", 95);
private static Teatro teatro = new Teatro("C/ Sol, 45", 300, 2, obra, 30);
	public static void main(String[] args) {
        lector = new Scanner(System.in);
        char opc;
		do {
			opc = mostrarMenu();
				switch (opc) {
					case '1':
					case '2':
					case '3':
					/*
					 * Case 4
					 * Autor Juan Antonio Pavón
					 * 
					 */	
					case '4':
						int fila, butaca, edad;
						String nombre, tlf;
						Espectador e;
						System.out.println("¿En que fila quieres sentante (0-4)?");
						fila = Integer.parseInt(lector.next());
						System.out.println("Y en qué butaca (0-9)?");
						butaca = Integer.parseInt(lector.next());
						System.out.println("¿Cómo se llama?");
						nombre = lector.next();
						System.out.println("¿Cuál es su teléfono?");
						tlf = lector.next();
						System.out.println("¿Qué edad tiene?");
						edad = Integer.parseInt(lector.next());	
						e = new Espectador(nombre, tlf, edad);
						
						/*
						 *Se comprueba que la localidad elegida esta libre; 
						 */	
						if (teatro.consultarLocalidad(fila, butaca) == null) {
							System.out.println(teatro.venderLocalidad(fila, butaca, e));							
						} else {
							System.out.println(teatro.consultarLocalidad(fila, butaca)); 							
						}
						
					case '5':
					case '6':
					case '7':
					case '8':
					default:
				}
		} while (opc!='8');
			lector.close();
		}

	public static char mostrarMenu() {
		String opcion;
		
		System.out.println ("TEATRO LA BOMBILLA DE DON BLAS");
		System.out.println ("------------------------------");
		System.out.println ("1. Ver la programación actual");
		System.out.println ("2. Mostrar todas las localidades");
		System.out.println ("3. Mostrar localidades ocupadas");
		System.out.println ("4. Vender localidad");
		System.out.println ("5. Cancelar localidad");
		System.out.println ("6. Consultar localidad");
		System.out.println ("7. Calcular recaudación");
		System.out.println ("8. Terminar programa");
		System.out.println ("------------------------------");
		System.out.println ("¿Qué opción deseas?");
		
		opcion = lector.next();
		
		return opcion.charAt(0); // Devuelvo el primer caracter tecleado.
	}
}