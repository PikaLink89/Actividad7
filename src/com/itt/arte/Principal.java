package com.itt.arte;

import java.util.Scanner;

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
						//Se consulta programación
						System.out.println(teatro.verProgramacion());
						break;
 
            		case '2':
            			//Se ven todas las localidades
            			System.out.println(teatro.verLocalidades());
            			break;        	  
             
            		case '3':
            			//Se muestran unicamente las ocupadas
            			System.out.println(teatro.verLocalidadesOcupadas());
            			break;
 
        			case '4':
						// Case 4
						// Juan Antonio Pavón
						
						int fila, butaca, edad;
						String nombre, tlf;
						Espectador e;
						
						//Se comprueba que la localidad elegida esta libre;
						//S
						//Mientras la localidad este ocupada, le pedirá de nuevo libre sigue el proceso, sino 
						 	
						System.out.println("¿En qué fila quieres sentante (0-4)?");
						fila = Integer.parseInt(lector.next());
						while ((fila < 0) || (fila > 4)) {
							System.out.println("Debes introducir un valor entre 0 o 4, vuelve a intentarlo");
							fila = Integer.parseInt(lector.next());								
						}															
						System.out.println("Y en qué butaca (0-9)?");
						butaca = Integer.parseInt(lector.next());
						while ((butaca < 0) || (butaca > 9)) {
							System.out.println("Debes introducir un valor entre 0 o 9, vuelve a intentarlo");
							butaca = Integer.parseInt(lector.next());								
						}
						if (teatro.consultarLocalidad(fila, butaca) !=null)
							System.out.println("La plaza está ocupada, elige otra.\n");
						else {
							//Si la localidad esta libre sigue el proceso 
							System.out.println("¿Cómo se llama?");
							nombre = lector.next();
							System.out.println("¿Cuál es su teléfono?");
							tlf = lector.next();
							System.out.println("¿Qué edad tiene?");
							edad = Integer.parseInt(lector.next());	
							e = new Espectador(nombre, tlf, edad);
							//teatro.venderLocalidad(fila, butaca, e);
							System.out.println(teatro.venderLocalidad(fila, butaca, e));
						}
						break;
	   
        			case '5':
        				//Se realiza una lectura para el metodo cancelarlocalidad
						System.out.print("¿Fila (0-4)? ");
						fila = lector.nextInt();  
						System.out.print("¿Butaca (0-9)? ");
						butaca = lector.nextInt();
						System.out.print(teatro.cancelarLocalidad(fila, butaca));
						break;

   
        			case '6':
        				//Se hace una lecutra para consultarlocalidad
        				System.out.print("¿Fila (0-4)? ");
        				fila = Integer.parseInt(lector.next());  
				
        				System.out.print("¿Butaca (0-9)? ");
        				butaca = Integer.parseInt(lector.next());
						if (teatro.consultarLocalidad(fila, butaca) != null) 
							System.out.println(teatro.consultarLocalidad(fila, butaca) + "\n");
							else 							
								System.out.println("La plaza está libre\n");
						break;
   
        			case '7':
        				//llama al método que calcular la recaudación
        				System.out.println(teatro.calcularRecaudacion());
        				break;
       
				   case '8':
					   	//Salida del programa
					   	System.out.println("Hasta pronto");
					   	break;
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