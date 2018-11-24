package com.itt.arte;

import java.util.Scanner;

import com.itt.arte.*;

public class Principal {

              private static Scanner lector;

              private static Obra obra =

                   new Obra("La cena de los idiotas", "Comedia", 95);

              private static Teatro teatro = new Teatro("C/ Sol, 45", 300, 2, obra, 30);

              public static void main(String[] args) {
            	            	             	            	  
                            lector = new Scanner(System.in);
                            


                        char opc;

                            do {

                                         opc = mostrarMenu();
                                         
                                         switch (opc) {
                                         					//Se consulta programación
                                         
                                                       case '1': System.out.println(teatro.verProgramacion());
                                                       			 break;
                                                       			 
                                                       		//Se ven todas las localidades
                                                       case '2': teatro.verLocalidades();
                                                                 break;
                                                                 
                                                            //Se muestran unicamente las ocupadas
                                                                 
                                                       case '3': teatro.verLocalidadesOcupadas();
                                                       	 		 break;
                                                       	 		 
                                                       	 		 
                                                       	 	//Se realiza una lectura para el método venderlocalidad
                                                       case '4':
                                                    	int fila, butaca, edad;
                                   						String nombre, tlf;
                                   						Espectador e;						
                                   						/*
                                   						 *Se comprueba que la localidad elegida esta libre; 
                                   						 */	
                                   						
                                   						do {
                                   							System.out.println("¿En qué fila quieres sentante (0-4)?");
                                   							fila = Integer.parseInt(lector.next());
                                   							System.out.println("Y en qué butaca (0-9)?");
                                   							butaca = Integer.parseInt(lector.next());
                                   							teatro.consultarLocalidad(fila, butaca);
                                   						}						
                                   						while (teatro.consultarLocalidad(fila, butaca) == null);						
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
                                   						break;
                                                    	   
                                                       //Se realiza una lectura para el metodo cancelarlocalidad
                                                       case '5':
                                                    	   
                                                    	   System.out.print("¿Fila (0-4)? ");
                                                    	   fila = lector.nextInt();  

                                                    	   System.out.print("¿Butaca (0-9)? ");
                                                    	   butaca = lector.nextInt();
                                                    	   System.out.print(teatro.cancelarLocalidad(fila, butaca));
                                                    	   break;

                                                    	   
                                                    	   //Se hace una lecutra para consultarlocalidad
                                                       case '6':
                                                    	   
                                                    	   System.out.print("¿Fila (0-4)? ");
                                                    	   fila = lector.nextInt();  

                                                    	   System.out.print("¿Butaca (0-9)? ");
                                                    	   butaca = lector.nextInt();
                                                    	   
                                                    	   teatro.consultarLocalidad(fila, butaca);
                                                    	   
                                                    	   break;
                                                    	   
                                                    	   
                                                    	   //llama al método que calcular la recaudación
                                                       case '7': System.out.println(teatro.calcularRecaudacion());
                                                           break;
                                                           
                                                       case '8': System.out.println("Hasta pronto");
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