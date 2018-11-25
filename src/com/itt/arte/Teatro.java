/**
4 * Clase Teatro.
 * 
 * Implementa la inferface de Sala y hereda de Local.
 * Asignaciones de Metdodos:
 * 
 * String verProgramacion();
 * String verLocalidades();
 * String VerLocalidadesOcupadas();
 * Juan Antonio Pav�n -> M�todo String VenderLocalidad(int fila, int butaca, Espectador e);
 * String candelarLocalidad(int fila, int butaca);
 * String consultarLocalidad(int fila, int butaca);
 * double calcularRecaudacion();    
 * 
 */

package com.itt.arte;

public class Teatro extends Local implements Sala  {
	private double precio;
	private Obra obra;
	private Espectador localidades[][];
	
	//*******************************************************************/
	//Constructores.
	//*******************************************************************/

	/**
	 * Constructor de Teatro.
	 * 
	 * @param domicilio -> Tipo String - Domicilio del Local.
	 * @param metros -> Tipo entero - Metros del Local.
	 * @param accesos -> Tipo entero - Numero de entradas del local.
	 * @param obra -> Tipo Objeto Obra - Contiene: titulo, genero y minutosDuraion. 
	 * @param precio -> Tipo num�rico Double - Valor de la obra.
	 */	
	public Teatro(String domicilio, int metros, int accesos, Obra obra, double precio) {
		super(domicilio, metros, accesos);
		this.obra = obra;
		this.precio = precio;
        this.localidades = new Espectador[5][10]; 

	}	
	
	//*******************************************************************/
	//M�todos implementados por la interface
	//*******************************************************************/
	/**
	 * M�todo para ver la programaci�n del teatro.
	 * @return String con la informaci�n completa de la programaci�n.
	 */
	@Override
	public String verProgramacion() {
		return "---- HOY REPRESENTAMOS: ----\n\"" + this.obra.getTitulo().toUpperCase() + (".") +
				"\"\nG�nero: " + this.obra.getGenero() + ". Duraci�n: " + this.obra.getMinutosDuracion() + (".") +
				"\nDirecci�n: " + this.getDomicilio() + ". Local de " + this.getMetros() + " metros, con " + this.getAccesos() + " accesos." + 
				"\nPRECIO: " + this.precio + "�.\n";		
	}

	/**
	 * M�todo para ver todas las localidades del teatro.
	 * @return String con todas las localidades del teatro con informaci�n si esta libre o ocupada.
	 * 
	 * Se utiliza el StringBuilder para ir recogiendo las localidades.
	 * Al finalizar se utiliza .toString(); para hacer transfomarlo a String y para hacer el m�todo acorde al enunciado.
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
	 * @return String con la informaci�n de todas las localidades ocupadas, con informaci�n del Espectador como
	 * Nombre, te�fono y tio de espetador.
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
	 * M�todo para vender una localidad en el Teatro.	 * 
	 * @return Tipo String con un mensaje indicado la ubiaci�n de la localidad vendida, 
	 * a quien ha sido vendida y el precio.
	 *   
	 */
	@Override
	public String venderLocalidad(int fila, int butaca, Espectador e) {		
		this.localidades[fila][butaca] = e;
		double precioEspectador = precioEspectador(e);
		return "Se ha vendido la localidad " + fila + "." + butaca + " a " + e.getNombre() + " por " + precioEspectador + "�.";		
	}

	/**
	 * Refractor.
	 * Metodo para calcular el precio de cada espectador seg�n su edad
	 * 
	 * @param e -> Tipo Objeto Espectador
	 * @return -> Tipo double con el precio los descuentos.
	 */
	private double precioEspectador(Espectador e) {
		double precioEspectador;
		precioEspectador = (e.getEdad()<=12)?this.precio*0.50:(e.getEdad()<=17)?this.precio - (this.precio*0.20):(e.getEdad()>=65)?this.precio - (this.precio*0.66):this.precio;
		return precioEspectador;
	}
	
	/**
	 * Metodo para anular una localidad en el teatro.
	 * @return String indicando que se canzelado la reserva con el nombre del espectador.
	 */
	@Override
	public String cancelarLocalidad(int fila, int butaca) {
		String nombre = this.localidades[fila][butaca].getNombre();		
		this.localidades[fila][butaca] = null;
		return nombre.toUpperCase() + "ha cancelado la reserva.";
	}

	/**
	 * M�todo para consultar una localidad en contreto. Debe de recoger la fila y butaca a consultar.
	 * 
	 * @param fila -> Tipo entero, para recoger la fila de la localidad a consultar.
	 * @param butaca -> Tipo entero, para recoger la butaca de la fila determinada a consultar.
	 * @return String Si la localidad esta ocupada devuelte una cadena con la informaci�n, si no lo est�, devuelve null.
	 * 
	 * <b>Nota</b>Este m�todo tamb�en se usa para en el momento de vender una localidad saber si esta ocupada, por ello el asignarle null sino lo est� y
	 * poder reutilizar el m�todo.
	 */
	@Override
	public String consultarLocalidad(int fila, int butaca) {
		if (this.localidades[fila][butaca] != null)
			return "Localidad ocupada por " + this.localidades[fila][butaca].getNombre() + ", tlf: " + this.localidades[fila][butaca].getTlf() + ", " + this.localidades[fila][butaca].rangoEdad() + " " + precioEspectador(this.localidades[fila][butaca]) + "�.";			 
		else
			return null;
	}

	/**
	 * M�todo para calcular la recaudaci�n total del Teatro
	 * @return double con el total de la recaudaci�n, teniendo en cuenta el tipo de espetador.
	 * 
	 * Se usa el m�todo precioEspectador(e) para calcular el precio del espectador seg�n su edad.	
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
	//Get & Set
	//*******************************************************************/
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Obra getObra() {
		return obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

	public Espectador[][] getLocalidades() {
		return localidades;
	}

	public void setLocalidades(Espectador[][] localidades) {
		this.localidades = localidades;
	}

}
