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
	
	
	
	//M�todos propios
		@Override
		public String verProgramacion() {
			
			
		}

			
		@Override
		public void verLocalidades() {
			
			
		}
		

		@Override
		public void verLocalidadesOcupadas() {
			
				
		}


		@Override
		public String venderLocalidad(int fila, int butaca, Espectador e) {
				
			
			
		}
		
		

		@Override
		public String cancelarLocalidad(int fila, int butaca) {
			
		}

		
		
		@Override
		public void consultarLocalidad(int fila, int butaca) {
			
		}
		
		

		@Override
		public double calcularRecaudacion() {
			double preciocondescuento =0;
			double acumulado = 0;
			for (int i = 0; i<localidades.length; i++) {
				for (int j = 0; j<localidades[i].length; j++) {
					
					while (localidades[i][j] != null)  {
						if(localidades[i][j].rangoEdad()=="INFANTIL") {
							
							preciocondescuento= (50*precio)/100;
							acumulado = acumulado + preciocondescuento;
						}
						else {
							if(localidades[i][j].rangoEdad()=="MENOR") {
								preciocondescuento= (20*precio)/100;
								acumulado = acumulado + preciocondescuento;
							}
							else {
								if(localidades[i][j].rangoEdad()=="MAYOR") {
									preciocondescuento= precio;
									acumulado = acumulado + preciocondescuento;
								}
								else {
									if(localidades[i][j].rangoEdad()=="JUBILADO") {
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
