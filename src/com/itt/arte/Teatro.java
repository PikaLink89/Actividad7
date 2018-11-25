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
	
	/**
	 * Método para ver todas las localidades del teatro.
	 * @return String con todas las localidades del teatro con información si esta libre o ocupada.
	 * 
	 * Se utiliza el StringBuilder para ir recogiendo las localidades.
	 * Al finalizar se utiliza .toString(); para hacer transfomarlo a String y para hacer el método acorde al enunciado.
	 */
	@Override
	public String verLocalidades() {
		StringBuilder localidades = new StringBuilder();
		for (int i=0; i < this.localidades.length; i++) {
			for (int j=0; j < this.localidades[i].length; j++) {
				if (this.localidades[i][j] == null)
					localidades = localidades.append(i + "." + j + " libre\t");
				else
					localidades = localidades.append(i + "." + j + " ocupado\t");
			}
			localidades = localidades.append("\n");
		}		
		return localidades.toString();
	}
		
	/**
	 * Metodo para ver las localidades ocupadas del teatro.
	 * @return String con la información de todas las localidades ocupadas, con información del Espectador como
	 * Nombre, teléfono y tio de espetador.
	 */
	@Override
	public String verLocalidadesOcupadas() {
		StringBuilder localidades = new StringBuilder();
		for (int i=0; i < this.localidades.length; i++) {
			for (int j=0; j < this.localidades[i].length; j++) {
				if (this.localidades[i][j] != null)
					localidades = localidades.append(i + "." + j + " " + this.localidades[i][j].getNombre().toUpperCase() + ", Tlf: " + this.localidades[i][j].getTlf() + ", Tipo: " + this.localidades[i][j].rangoEdad().toUpperCase() + "\n");
			}
		}		
		return localidades.toString();
	}

	/**
	 * Método para vender una localidad en el Teatro.	  
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
	
	/**
	 * Método para cancelar una localidad de en el teatro 
	 * @param 
	 */
	@Override
	public String cancelarLocalidad(int fila, int butaca) {
		if(localidades[fila][butaca] == null)
			return "La plaza ya está libre\n\n";
		else {
			String nombre = localidades[fila][butaca].getNombre();
			localidades[fila][butaca] = null;
			return nombre.toUpperCase() + " ha cancelado su reserva\n\n";
		}			
	}
	
	/**
	 * Método para consultar una localidad en contreto. Debe de recoger la fila y butaca a consultar.
	 * 
	 * @param fila -> Tipo entero, para recoger la fila de la localidad a consultar.
	 * @param butaca -> Tipo entero, para recoger la butaca de la fila determinada a consultar.
	 * @return String Si la localidad esta ocupada devuelte una cadena con la información, si no lo está, devuelve null.
	 * 
	 * <b>Nota</b>Este método tambíen se usa para en el momento de vender una localidad saber si esta ocupada, por ello el asignarle null sino lo está y
	 * poder reutilizar el método.
	 */
	@Override
	public String consultarLocalidad(int fila, int butaca) {
		if (this.localidades[fila][butaca] != null)
			return "Localidad ocupada por " + this.localidades[fila][butaca].getNombre() + ", tlf: " + this.localidades[fila][butaca].getTlf() + ", " + this.localidades[fila][butaca].rangoEdad() + ", Precio: " + precioEspectador(this.localidades[fila][butaca]) + "€.";			 
		else
			return null;
	}
	
	/**
	 * Método para calcular la recaudación total del Teatro
	 * @return double con el total de la recaudación, teniendo en cuenta el tipo de espetador.
	 * 
	 * Se usa el método precioEspectador(e) para calcular el precio del espectador según su edad.	
	 */
	@Override
	public double calcularRecaudacion() {
		double recaudacion = 0;
		for (int i=0; i < this.localidades.length; i++) {
			for (int j=0; j < this.localidades[i].length; j++) {
				if (this.localidades[i][j] != null)
					recaudacion += precioEspectador(this.localidades[i][j]);					
			}
		}		
		return recaudacion;
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
				+ ", género: "+getObra().getGenero() + ", Duración: "
				+ getObra().getMinutosDuracion() + "\nEn "+ getDomicilio() 
				+ ", Local de " +getMetros() + " metros, con "+ getAccesos() + " accesos\nPrecio: "+getPrecio();
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
