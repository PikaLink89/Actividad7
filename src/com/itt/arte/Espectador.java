package com.itt.arte;

public class Espectador {

	//Propiedades de espectador
	private String nombre;
	private String tlf;
	private int edad;
	
	//Constructor de Espectador	
	public Espectador(String nombre, String tlf, int edad) {
		this.nombre = nombre;
		this.tlf = tlf;
		this.edad = edad;
	}
	
	//Getters & Setters para el acceso a las propiedades	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	//Métodos Object
	@Override
	public String toString() {
		return "Espectador [nombre=" + nombre + ", tlf=" + tlf + ", edad=" + edad + "]";
	}
	
	
	//Métodos propios de la clase
	public String rangoEdad() {
		if (edad <= 12 || edad == 0) 
			return "Tipo: INFANTIL";
			if (edad >= 13 && edad <= 17) 
				return "Tipo: MENOR";
				if (edad >= 18 && edad <= 64)
					return "Tipo: MAYOR";
					if (edad >= 65)
						return "Tipo: JUBILADO";
					else
						return "Por favor, ponga una edad correcta";
	}		
}	
		


	
	
	

