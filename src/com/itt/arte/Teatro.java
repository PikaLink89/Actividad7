package com.itt.arte;
public class Teatro extends Local implements Sala {

		private Obra obra;
		private double precio;
		private Espectador[][] localidades;
		
		
		
	//CONSTRUCTOR
		public Teatro(String domicilio, int metros, int accesos, Obra obra, double precio) {
			super(domicilio, metros, accesos);
			this.obra = obra;
			this.precio = precio;
	        this.localidades = new Espectador[5][10];

		}

	
	
	//METODOS DE LA INTERFAZ SALA
	@Override
	public String verProgramacion() {
		
		return "Hoy representamos "+ getObra().getTitulo() 
				+ ", género: "+getObra().getGenero() + ", Duracción: "
				+ getObra().getMinutosDuracion() + "\n En "+ getDomicilio() 
				+ ", Local de " +getMetros() + " metros, con "+ getAccesos() + " accesos\n Precio: "+getPrecio();
	}

	

	/*
	 * Para este método realizamos dos bucles para la lectura del Array bidimensional, si el valor es difernte a null mostrará que está ocupada
	 * por el contrario, si el valor es null mostrará que está libre
	 */
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
	
	/*
	 * Mismo método que verlocalidades pero esta vez solo imprime las que están diferente a null, mostrando los datos que se piden.
	 * 
	 */

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

/*
 * En la clase principal recoge fila butaca y el espectador, calcula el precio en base la edad mediante if y muestra la localidad vendida.
 * 
 */
	@Override
	public String venderLocalidad(int fila, int butaca, Espectador e) {
		double preciocondescuento=0;
		if(e.rangoEdad()=="INFANTIL") {
			preciocondescuento= (50*precio)/100;
		}
		else {
			if(e.rangoEdad()=="MENOR") {
				preciocondescuento= (20*precio)/100;
			}
			else {
				if(e.rangoEdad()=="MAYOR") {
					preciocondescuento= precio;
				}
				else {
					if(e.rangoEdad()=="JUBILADO") {
						preciocondescuento= (66*precio)/100;
					}
				}
			}
		}
		if(localidades[fila][butaca] != null ) {
			return "La localidad está ocupada";
			
		}
		else
		{
			localidades[fila][butaca] = e;
			
			
			return "Se ha vendido la localidad " +fila +"."+ butaca+" a "+e.getNombre() + " por "+preciocondescuento;
			
				}
		
		
		
	}
	
	/*
	 * Para cancelar una localidad se recoge la fila y butaca, se comprueba que está ocupada, recoge el nombre en una variable
	 * llamada nombretemporal, deja la localidad con valor null y devuelve nombretemporal.
	 * 
	 */

	@Override
	public String cancelarLocalidad(int fila, int butaca) {
		if(localidades[fila][butaca] != null ) {
			String nombretemporal;
			nombretemporal = localidades[fila][butaca].getNombre();
			localidades[fila][butaca] = null;
			return nombretemporal+" ha cancelado su reserva";
		}
		else
		{
			return "La localidad ya estaba vacía";
		}
	}

	/*
	 * Recoge fila y butaca e imprime lo solicitado
	 * 
	 */
	
	@Override
	public void consultarLocalidad(int fila, int butaca) {
		if(localidades[fila][butaca] != null ) {
			double preciocondescuento=0;
			
			if(localidades[fila][butaca].rangoEdad()=="INFANTIL") {
				preciocondescuento= (50*precio)/100;
			}
			else {
				if(localidades[fila][butaca].rangoEdad()=="MENOR") {
					preciocondescuento= (20*precio)/100;
				}
				else {
					if(localidades[fila][butaca].rangoEdad()=="MAYOR") {
						preciocondescuento= precio;
					}
					else {
						if(localidades[fila][butaca].rangoEdad()=="JUBILADO") {
							preciocondescuento= (66*precio)/100;
						}
					}
				}
			}
			System.out.println("Localidad ocupada por " +localidades[fila][butaca].getNombre()+", tlf: "+localidades[fila][butaca].getTlf()
					+" Tipo: "+localidades[fila][butaca].rangoEdad()+", Precio: " +preciocondescuento);
		}
		else{
			System.out.println("Localidad Vacía ");
		}
		
		
		
	}
	
	/*
	 * Se calcula el precio de todas las localidadeds ocupadas en base a la edad y se almacena en acumulado,
	 * cuando termina de recorrer todo el array devuelve acumulado.
	 * 
	 */

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
		
	

	
	//GETTERS AND SETTERS
	
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
	
	
	
	

}
