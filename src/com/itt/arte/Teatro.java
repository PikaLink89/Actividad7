/**
 * Clase Teatro.
 * 
 * Implementa la inferface de Sala y hereda de Local.
 * Asignaciones de Metdodos:
 * 
 * String verProgramacion();
 * String verLocalidades();
 * String VerLocalidadesOcupadas();
 * Método String VenderLocalidad(int fila, int butaca, Espectador e);
 * String candelarLocalidad(int fila, int butaca);
 * String consultarLocalidad(int fila, int butaca);
 * double calcularRecaudacion();    
 * 
 */
package com.itt.arte;
public class Teatro extends Local implements Sala {
	
	//*******************************************/
	//	PROPIEDADES
	//*******************************************/
	private Obra obra;
	private double precio;
	private Espectador[][] localidades;
	
	//*******************************************/
	//	CONSTRUCTOR
	//*******************************************/
	/**
	 * Constructor de Teatro.
	 * 
	 * @param domicilio -> Tipo String - Domicilio del Local.
	 * @param metros -> Tipo entero - Metros del Local.
	 * @param accesos -> Tipo entero - Numero de entradas del local.
	 * @param obra -> Tipo Objeto Obra - Contiene: titulo, genero y minutosDuraion. 
	 * @param precio -> Tipo numérico Double - Valor de la obra.
	 */	
	public Teatro(String domicilio, int metros, int accesos, Obra obra, double precio) {
		super(domicilio, metros, accesos);
		this.obra = obra;
		this.precio = precio;
	    this.localidades = new Espectador[5][10]; 
	
	}

	//*******************************************/
	//	GETTERS & SETTERS
	//*******************************************/		
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
	
	
	//*********************************************/
	//	MÉTODOS IMPLEMENTADOS POR LA INTERFACE
	//*********************************************/
	
	//-> Revisar este método se puede hacer con String	
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
		
	//-> Revisar este método se puede hacer con String	
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

	/**
	 * Método para vender una localidad en el Teatro.	 * 
	 * @return Tipo String con un mensaje indicado la ubiación de la localidad vendida, 
	 * a quien ha sido vendida y el precio.
	 *   
	 */
	@Override
	public String venderLocalidad(int fila, int butaca, Espectador e) {		
		this.localidades[fila][butaca] = e;
		double precioEspectador = precioEspectador(e);
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
	
	//*******************************************************************/
	//MÉTODOS PROPIOS
	//*******************************************************************/
	/**
	 * Método ver Programación
	 * @return Tipo String con la información de la programación del teatro.
	 */
	public String verProgramacion() {
		return "Hoy representamos "+ getObra().getTitulo() 
				+ ", género: "+getObra().getGenero() + ", Duracción: "
				+ getObra().getMinutosDuracion() + "\n En "+ getDomicilio() 
				+ ", Local de " +getMetros() + " metros, con "+ getAccesos() + " accesos\n Precio: "+getPrecio();
	}
	
	/**
	 * Refractor.
	 * Se habia implemetnado en venderLocalidad(); pero se ha extraido con
	 * refractor para usarlo como método de la clase.
	 * Metodo para calcular el precio de cada espectador según su edad
	 * 
	 * @param e -> Tipo Objeto Espectador
	 * @return -> Tipo double con el precio los descuentos.
	 */
	private double precioEspectador(Espectador e) {
		double precioEspectador;
		precioEspectador = (e.getEdad()<=12)?this.precio*0.50:(e.getEdad()<=17)?this.precio - (this.precio*0.20):(e.getEdad()>=65)?this.precio - (this.precio*0.66):this.precio;
		return precioEspectador;
	}	

}
