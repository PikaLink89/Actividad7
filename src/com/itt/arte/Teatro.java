/**
 * Clase Teatro.
 * 
 * Implementa la inferface de Sala y hereda de Local.
 * Asignaciones de Metdodos:
 * 
 * String verProgramacion();
 * String verLocalidades();
 * String VerLocalidadesOcupadas();
 * Juan Antonio Pavón -> Método String VenderLocalidad(int fila, int butaca, Espectador e);
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
	 * @param precio -> Tipo numérico Double - Valor de la obra.
	 */	
	public Teatro(String domicilio, int metros, int accesos, Obra obra, double precio) {
		super(domicilio, metros, accesos);
		this.obra = obra;
		this.precio = precio;
        this.localidades = new Espectador[5][10]; 

	}	
	
	//*******************************************************************/
	//Métodos implementados por la interface
	//*******************************************************************/

	@Override
	public String verProgramcion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String verLocalidades() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String verLocalidadesOcupadas() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @author Juan Antonio Pavón Carmona
	 * Método para vender una localidad en el Teatro.
	 * 
	 * @return Tipo String con un mensaje indicado la ubiación de la localidad vendida, 
	 * a quien ha sido vendida y el precio.
	 *   
	 */
	@Override
	public String venderLocalidad(int fila, int butaca, Espectador e) {		
		this.localidades[fila][butaca] = e;
		double precioEspectador;
		precioEspectador = (e.getEdad()<=12)?this.precio*0.5:(e.getEdad()<=17)?this.precio*0.20:(e.getEdad()>=65)?this.precio*0.66:this.precio;
		return "Se ha vendido la localidad " + fila + "." + butaca + " a " + e.getNombre() + " por " + precioEspectador + " euros.";		
	}	


	@Override
	public String cancelarLocalidad(int fila, int butaca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String consultarLocalidad(int fila, int butaca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calcularRecaudacion() {
		// TODO Auto-generated method stub
		return 0;
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
