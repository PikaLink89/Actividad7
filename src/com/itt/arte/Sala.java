package com.itt.arte;

public interface Sala {
	public abstract String verProgramacion();
	public abstract String verLocalidades();
	public abstract String verLocalidadesOcupadas();
	public abstract String venderLocalidad(int fila, int butaca, Espectador e);
	public abstract String cancelarLocalidad(int fila, int butaca);
	public abstract String consultarLocalidad(int fila, int butaca);
	public abstract double calcularRecaudacion();
}
