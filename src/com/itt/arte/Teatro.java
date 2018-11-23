/**
 * Clase Teatro.
 * 
 * Implementa la inferface de Sala y hereda de Local.
 * Asignaciones de Metdodos:
 * 
 * String verProgramacion();
 * String verLocalidades();
 * String VerLocalidadesOcupadas();
 * Juan Antonio Pavón -> String VenderLocalidad(int fila, int butaca, Espectador e);
 * String candelarLocalidad(int fila, int butaca);
 * String consultarLocalidad(int fila, int butaca);
 * double calcularRecaudacion();    
 * 
 */

package com.itt.arte;

public class Teatro extends Local implements Sala  {
	double precio;
	Obra obra;
	Espectador localidades[][];
	
	public Teatro(String domicilio, int metros, int accesos) {
		super(domicilio, metros, accesos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String verProgramcion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String verLocalidades() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String verLocalidadesOcupadas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String venderLocalidad(int fila, int butaca, Espectador e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String cancelarLocalidad(int fila, int butaca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String consultarLocalidad(int fila, int butaca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calcularRecaudacion() {
		// TODO Auto-generated method stub
		return 0;
	}

}
