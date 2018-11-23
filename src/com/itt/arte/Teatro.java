package com.itt.arte;

public class Teatro extends Local implements Sala  {
	private double precio;
	private Obra obra;
	private Espectador localidades[][];
	
	 //Constructor.
	
	public Teatro(String domicilio, int metros, int accesos, Obra obra, double precio) {
		super(domicilio, metros, accesos);
		this.obra = obra;
		this.precio = precio;
        this.localidades = new Espectador[5][10]; 

	}	
	//Para la interface

	@Override
	public String verProgramacion() {
		
		//System.out.println(Obra.toString);
		//System.out.println(Obra.consultar());
		return null;
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
			return "La plaza ya estaba libre";
		else {
			String nombre = localidades[fila][butaca].getNombre();
			localidades[fila][butaca] = null;
			return nombre.toUpperCase() + " ha cancelado su reserva";
		}
			
	}

	@Override
	public String consultarLocalidad(int fila, int butaca) {
		if (localidades [fila][butaca]!=null) {
			this.localidades[fila][butaca]=localidades[fila][butaca];
			double precioEspectador;
			precioEspectador = (this.localidades[fila][butaca].getEdad()<=12)?this.precio*0.5:(this.localidades[fila][butaca].getEdad()<=17)?this.precio*0.20:(this.localidades[fila][butaca].getEdad()>=65)?this.precio*0.66:this.precio;	
			
			return "localidad ocupada por "+ localidades[fila][butaca].getNombre().toUpperCase() + ", tlf: " + localidades[fila][butaca].getTlf()
					+ ", tipo: " + localidades[fila][butaca].rangoEdad() + ", precio: " + precioEspectador;				
		}else {
			return "localidad libre";}
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
	//Getter and Setter
	
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
