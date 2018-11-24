package com.itt.arte;


public class Teatro extends Local implements Sala {

	
	//Propiedades Teatro
		private Obra obra;
		private double precio;
		private Espectador[][] localidades;
		
		
		
	//Constructor
		public Teatro(String domicilio, int metros, int accesos, Obra obra, double precio) {
			super(domicilio, metros, accesos);
			this.obra = obra;
			this.precio = precio;
	        this.localidades = new Espectador[5][10];

		}

		
	//Getters & setters
	
	public Obra getObra() {
		return obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Espectador[][] getLocalidades() {
		return localidades;
	}

	public void setLocalidades(Espectador[][] localidades) {
		this.localidades = localidades;
	}
	
	
	
	//Métodos propios
	public String verProgramacion() {
		
		return "Hoy representamos "+ getObra().getTitulo() 
				+ ", género: "+getObra().getGenero() + ", Duracción: "
				+ getObra().getMinutosDuracion() + "\n En "+ getDomicilio() 
				+ ", Local de " +getMetros() + " metros, con "+ getAccesos() + " accesos\n Precio: "+getPrecio();
	}

			
		@Override
		public void verLocalidades() {
			for (int i = 0; i<localidades.length; i++) {
				for (int d = 0; d<localidades[i].length; d++) {
										
					if (localidades[i][d] != null)  {
						System.out.print(i+"."+d+" Ocupada ");
					}
					else {
						System.out.print(i+"."+d+" Libre ");
					}
					
					}
				System.out.println("");
			}
			
		}
		

		@Override
		public void verLocalidadesOcupadas() {
			for (int i = 0; i<localidades.length; i++) {
				for (int d = 0; d<localidades[i].length; d++) {
					if (localidades[i][d] != null)  {
						System.out.println(i+"."+d+" "+localidades[i][d].getNombre()+", tlf: "+localidades[i][d].getTlf()
								+", Tipo: "+localidades[i][d].rangoEdad());
					}
				}
			}
		}
		@Override
		public String venderLocalidad(int fila, int butaca, Espectador e) {
			this.localidades[fila][butaca] = e;
			double precioEspectador;
			precioEspectador = (e.getEdad()<=12)?this.precio*0.5:(e.getEdad()<=17)?this.precio*0.20:(e.getEdad()>=65)?this.precio*0.66:this.precio;
			return "Se ha vendido la localidad " + fila + "." + butaca + " a " + e.getNombre() + " por " + precioEspectador + " euros.";				
			
			
		}
		
		
		@Override
		public String cancelarLocalidad(int fila, int butaca) {
			
			if(localidades[fila][butaca] == null)
				return "La plaza ya estaba libre\n\n";
			else {
				String nombre = localidades[fila][butaca].getNombre();
				localidades[fila][butaca] = null;
				return nombre.toUpperCase() + " ha cancelado su reserva\n\n";
			}
				
		}
		
		@Override
		public String consultarLocalidad(int fila, int butaca) {
			if(this.localidades[fila][butaca] != null ) {
				double preciocondescuento=0;
				
				if(this.localidades[fila][butaca].rangoEdad()=="INFANTIL") {
					preciocondescuento= (50*precio)/100;
				}
				else {
					if(this.localidades[fila][butaca].rangoEdad()=="MENOR") {
						preciocondescuento= (20*precio)/100;
					}
					else {
						if(this.localidades[fila][butaca].rangoEdad()=="MAYOR") {
							preciocondescuento= precio;
						}
						else {
							if(this.localidades[fila][butaca].rangoEdad()=="JUBILADO") {
								preciocondescuento= (66*precio)/100;
							}
						}
					}
				}
				return"Localidad ocupada por " +localidades[fila][butaca].getNombre()+", tlf: "+localidades[fila][butaca].getTlf()
						+" Tipo: "+localidades[fila][butaca].rangoEdad()+", Precio: " +preciocondescuento;
			}
			else{
				return"Localidad Vacía ";
			}
			
			
			
		}
		@Override
		public double calcularRecaudacion() {
			double preciocondescuento =0;
			double acumulado = 0;
			for (int i = 0; i<localidades.length; i++) {
				for (int d = 0; d<localidades[i].length; d++) {
					
					if (localidades[i][d] != null)  {
						if(localidades[i][d].rangoEdad()=="INFANTIL") {
							
							preciocondescuento= (50*precio)/100;
							acumulado = acumulado + preciocondescuento;
						}
						else {
							if(localidades[i][d].rangoEdad()=="MENOR") {
								preciocondescuento= (20*precio)/100;
								acumulado = acumulado + preciocondescuento;
							}
							else {
								if(localidades[i][d].rangoEdad()=="MAYOR") {
									preciocondescuento= precio;
									acumulado = acumulado + preciocondescuento;
								}
								else {
									if(localidades[i][d].rangoEdad()=="JUBILADO") {
										preciocondescuento= (66*precio)/100;
										acumulado = acumulado + preciocondescuento;
									}
								}
							}
						}
					}
					
				}
			}
			
			return acumulado;
				
		}

}
