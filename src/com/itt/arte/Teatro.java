package com.itt.arte;

public class Teatro extends Local implements Sala {
	private Obra obra;
	private double precio;
	Espectador [] [] localidades;
	
	public Teatro (Obra obra, double precio, Espectador[][] localidades) {
		super();
		this.obra = obra;
		this.precio = precio;
		this.localidades = localidades;
	}

	@Override
	public String verProgramacion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String verLocalidades() {
		int contador = 0;
		
		return "pepe";
	}

	@Override
	public String verLocalidadesOcupadas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String consultarLocalidad(int fila, int butaca) {
		// TODO Auto-generated method stub
		return null;
	}
}
