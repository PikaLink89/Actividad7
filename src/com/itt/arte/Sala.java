package com.itt.arte;

public interface Sala {
	//Ver programacion
	/*int VerProgramacion
		for (int i =0; i<matrizTeatro.length; i++) {
			if(teatro.Equals(matrizteatro[i][1])) {
					VerLocalidades = VerLocalidades+1;
				}else {
					LocalidadesOcupadas = LocalidadesOcupadas+1;
				}	
			}*/
	String verProgramacion();
		//system.out.println(teatro1.Programacion());
	String verLocalidades();
	//System.out.println("Hay "+ VerLocalidades +" Localidades");
		//system.out.println(teatro1.Localidades());
	String verLocalidadesOcupadas();
//	System.out.println("Hay "+ LocalidadesOcupadas + "Localidades Ocupadas");
		//	system.out.println(teatro1.LocalidadesOcupadas());
	String consultarLocalidad(int fila, int butaca);
		//	system.out.println(teatro1.consultarProgramacion());
}
