package com.itt.arte;

public class Teatro extends Local {
	private Obra obra;
	private double precio;
	Espectador [] [] localidades;
	
	public Teatro (Obra obra, double precio) {
		this.obra = obra;
		this.precio = precio;
	}
}
