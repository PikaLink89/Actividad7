package com.itt.arte;

public interface Sala {

	public String verProgramacion();
	public void verLocalidades();
	public void verLocalidadesOcupadas();
	public String venderLocalidad(int fila, int butaca, Espectador e);
	public String cancelarLocalidad(int fila, int butaca);
	public void consultarLocalidad(int fila, int butaca);
	public double calcularRecaudacion();
	
	
}
