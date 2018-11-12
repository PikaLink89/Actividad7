package com.itt.arte;

public class Obra {

	private String titulo;
	private String genero;
	private int minutosDuracion;
	
	
	public Obra(String titulo, String genero, int minutosDuracion) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.minutosDuracion = minutosDuracion;
	}


	@Override
	public String toString() {
		return "Obra [titulo=" + titulo + ", genero=" + genero + ", minutosDuracion=" + minutosDuracion + "]";
	}
	
	
}
