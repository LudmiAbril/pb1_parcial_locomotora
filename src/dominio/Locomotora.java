package dominio;

public class Locomotora {
private int idLocomotora;
private String nombre;
private int cantidadMaximaDeVagones;
private Vagon[] formacion;

public Locomotora(int idLocomotora, String nombre, int cantidadMaximaDeVagones) {
	this.idLocomotora = idLocomotora;
	this.nombre = nombre;
	this.formacion=new Vagon[cantidadMaximaDeVagones];
}

public boolean agregarVagon(Vagon vagon) {
	for(int i=0;i<formacion.length;i++) {
		if(formacion[i]==null) {
			formacion[i]=vagon;
			return true;
		}
	} return false;
} 

public Vagon obtenerVagonDeMenorPeso() {
	Vagon aux;
	for(int i=0;i<formacion.length;i++) {
		for(int j=0;i<formacion.length-1;i++) {
			if(formacion[j]!=null && formacion[j+1]!=null && formacion[j].getPesoDeCarga()>formacion[j+1].getPesoDeCarga()) {
				aux=formacion[j];
				formacion[j]=formacion[j+1];
				formacion[j+1]=aux;
			}
		}
	} return formacion[0];
}

public double obtenerPesoPromedioDeVagonParaUnaMarca(MarcaVagon marca) {
	int pesoTotal=0;
	double cantidad=0.0;
	
	for(int i=0;i<formacion.length;i++) {
		if(formacion[i]!=null && formacion[i].getMarca().equals(marca)) {
			cantidad++;
			pesoTotal+=formacion[i].getPesoDeCarga();
		}
	} 
	if(cantidad==0) {
		return 0;
	}
	
	double pesoPromedio=Math.round((pesoTotal/cantidad)*100)/100;
	return pesoPromedio;
	
}

public boolean editarDescripcionVagon(String id,String desc) {
	for(int i=0;i<formacion.length;i++) {
		if(formacion[i]!=null && formacion[i].getIdVagon().equals(id)) {
			formacion[i].setDescripcion(desc);
			return true;
		}
	} return false;
}	
	
public void ordenarVagonesPorIdVagon(){
	Vagon aux;
	for(int i=0;i<formacion.length;i++) {
		for(int j=0;i<formacion.length-1;i++) {
			if(formacion[j]!=null && formacion[j+1]!=null && formacion[j].getIdVagon().compareTo(formacion[j+1].getIdVagon())>0) {
				aux=formacion[j];
				formacion[j]=formacion[j+1];
				formacion[j+1]=aux;
			}
		}
	}
  }

public int getIdLocomotora() {
	return idLocomotora;
}

public void setIdLocomotora(int idLocomotora) {
	this.idLocomotora = idLocomotora;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public int getCantidadMaximaDeVagones() {
	return cantidadMaximaDeVagones;
}

public void setCantidadMaximaDeVagones(int cantidadMaximaDeVagones) {
	this.cantidadMaximaDeVagones = cantidadMaximaDeVagones;
}

public Vagon[] getFormacion() {
	return formacion;
}

public void setFormacion(Vagon[] formacion) {
	this.formacion = formacion;
}





}
