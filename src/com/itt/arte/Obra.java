package com.itt.arte;

public class Obra extends Teatro {
	private String titulo , genero;
	private int minutosDuracion;
	
	public Obra(String titulo, String genero, int minutosDuracion) {
		this.titulo = titulo;
		this.genero = genero;
		this.minutosDuracion = minutosDuracion;
	}

	@Override
	public String toString() {
		return "Obra [titulo=" + titulo + ", genero=" + genero + 
				", minutosDuracion=" + minutosDuracion + "]";
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getMinutosDuracion() {
		return minutosDuracion;
	}
	public void setMinutosDuracion(int minutosDuracion) {
		this.minutosDuracion = minutosDuracion;
	}		
}
