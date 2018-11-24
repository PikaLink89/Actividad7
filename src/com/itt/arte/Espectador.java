package com.itt.arte;

public class Espectador {
	private String nombre;
	private String tlf;
	private int edad;
	
	//METODOS
	public String rangoEdad() {
		
		if (edad <= 12) {
	
			return "INFANTIL";
		}
		else { 
			if (edad > 12 && edad <= 17) {
				return "MENOR";
			}
			else {
				if(edad > 17 && edad <= 64) {
					return "MAYOR";
				}
				else
					if(edad>=65) {
						return "JUBILADO";
					}
			}
			
		}
		return "";
		
		
	}
	
	
	
	//CONSTRUCTORES
	public Espectador() {
		super();
	}
	
	public Espectador(String nombre, String tlf, int edad) {
		super();
		this.nombre = nombre;
		this.tlf = tlf;
		this.edad = edad;
	}




	



	@Override
	public String toString() {
		return "Espectador [nombre=" + nombre + ", tlf=" + tlf + ", edad=" + edad + "]";
	}
	
	
	

	//GETTER AND SETTERS
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

	
}
