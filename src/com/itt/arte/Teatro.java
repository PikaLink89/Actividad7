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
		double precioEspectador = precioEspectador(e);
		return "Se ha vendido la localidad " + fila + "." + butaca + " a " + e.getNombre() + " por " + precioEspectador + " euros.";		
	}

	/**
	 * Refractor.
	 * Metodo para calcular el precio de cada espectador según su edad
	 * 
	 * @param e -> Tipo Objeto Espectador
	 * @return -> Tipo double con el precio los descuentos.
	 */
	private double precioEspectador(Espectador e) {
		double precioEspectador;
		precioEspectador = (e.getEdad()<=12)?this.precio*0.50:(e.getEdad()<=17)?this.precio*0.20:(e.getEdad()>=65)?this.precio*0.66:this.precio;
		return precioEspectador;
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
