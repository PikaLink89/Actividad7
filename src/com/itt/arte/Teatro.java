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
		
		
	}
	
	/*
	 * Mismo método que verlocalidades pero esta vez solo imprime las que están diferente a null, mostrando los datos que se piden.
	 * 
	 */

	@Override
	public void verLocalidadesOcupadas() {
		
		
		
		
			
	}

/*
 * En la clase principal recoge fila butaca y el espectador, calcula el precio en base la edad mediante if y muestra la localidad vendida.
 * 
 */
	@Override
	public String venderLocalidad(int fila, int butaca, Espectador e) {
		
		
		
	}
	
	/*
	 * Para cancelar una localidad se recoge la fila y butaca, se comprueba que está ocupada, recoge el nombre en una variable
	 * llamada nombretemporal, deja la localidad con valor null y devuelve nombretemporal.
	 * 
	 */

	@Override
	public String cancelarLocalidad(int fila, int butaca) {
		
	}

	/*
	 * Recoge fila y butaca e imprime lo solicitado
	 * 
	 */
	
	@Override
	public void consultarLocalidad(int fila, int butaca) {
		
		
		
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
