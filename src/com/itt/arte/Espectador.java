package com.itt.arte;

import org.omg.Messaging.SyncScopeHelper;

public class Espectador {
	private String nombre, tlf;
	private int edad;
		
	public Espectador (String nombre, String tlf, int edad) {
	this.nombre = nombre;
	this.tlf = tlf;
	this.edad = edad;
	}

	@Override
	public String toString() {
		return "Espectador [nombre=" + nombre + ", tlf=" + tlf + ", edad=" + edad + "]";
	}

	public String rangoEdad() {
		if (edad <=12) {
			return"INFANTIL";}
			if (edad>=13 && edad<=17) {
				return "MENOR";}
				if (edad>=18 && edad<=64) {
					return "MAYOR";}
					if (edad>=65) {
						return "JUBILADO";}
					return "su edad es: "+edad;
	}
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