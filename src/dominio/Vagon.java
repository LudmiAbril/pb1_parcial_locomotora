package dominio;

public class Vagon {
private String idVagon;
private String descripcion;
private MarcaVagon marca;
private double pesoMaximoSoportado;
private double pesoDeCarga;

public Vagon(String idVagon, String descripcion, MarcaVagon marca, double pesoMaximoSoportado, double pesoDeCarga) {
	this.idVagon = idVagon;
	this.descripcion = descripcion;
	this.marca = marca;
	this.pesoMaximoSoportado = pesoMaximoSoportado;
	this.pesoDeCarga = pesoDeCarga;
}



 @Override
public String toString() {
	return "Vagon [idVagon=" + idVagon + ", descripcion=" + descripcion + ", marca=" + marca + ", pesoMaximoSoportado="
			+ pesoMaximoSoportado + ", pesoDeCarga=" + pesoDeCarga + "]";
}



public static boolean validarIdentificadorDeVagon(String idVagon) {
	if(idVagon.length()==6 && primerasTresLetras(idVagon) && ultimosTresnum(idVagon)) {
		return true;
	}return false;
}

static boolean primerasTresLetras(String idVagon) {
		if(Character.isUpperCase(idVagon.charAt(0)) &&
		Character.isUpperCase(idVagon.charAt(1)) &&
		Character.isUpperCase(idVagon.charAt(2))){
			return true;
		} return false;
	
}

static boolean ultimosTresnum(String idVagon) {
	if(Character.isDigit(idVagon.charAt(3)) &&
			Character.isDigit(idVagon.charAt(4)) &&
			Character.isDigit(idVagon.charAt(5))){
				return true;
			} return false;
}

public String getIdVagon() {
	return idVagon;
}
public void setIdVagon(String idVagon) {
	this.idVagon = idVagon;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public MarcaVagon getMarca() {
	return marca;
}
public void setMarca(MarcaVagon marca) {
	this.marca = marca;
}
public double getPesoMaximoSoportado() {
	return pesoMaximoSoportado;
}
public void setPesoMaximoSoportado(double pesoMaximoSoportado) {
	this.pesoMaximoSoportado = pesoMaximoSoportado;
}
public double getPesoDeCarga() {
	return pesoDeCarga;
}
public void setPesoDeCarga(double pesoDeCarga) {
	this.pesoDeCarga = pesoDeCarga;
}


}
