package interfaz;

import java.util.Scanner;

import dominio.Locomotora;
import dominio.MarcaVagon;
import dominio.Vagon;

public class PruebaLocomotora {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("ingrese el id de la locomotora");
		int idLocomotora=sc.nextInt();
		System.out.println("ingrese el nombre de la locomotora:");
		String nombre=sc.next();
		System.out.println("ingrese la cantidad maxima de vagones");
		int cant=sc.nextInt();
		Locomotora actual=new Locomotora(idLocomotora,nombre,cant);
		
		int opcion;
	do {	
	System.out.println("Bienvenido QtrainQtrain"
			+ "\n1 - Agregar un vagon"
			+ "\n2 - Obtener el vagon de menor peso"
			+ "\n3 - Obtener peso promedio para una marca"
			+ "\n4 - Editar la descripcion de un vagon"
			+ "\n5 - Ordenar vagones por id"
			+ "\n9 - salir");
	opcion=sc.nextInt();
	
	switch(opcion) {
		case 1: agregarVagon(sc, actual);
			break;
			
		case 2: obtenerVagonDeMenorPeso(actual);
			break;
			
		case 3: obtenerPesopromedioMarca(sc,actual);
			break;
			
		case 4: editarDescVagon(sc,actual);
			break;
			
		case 5: ordenarVagonesPorid(actual);
			break;
			
		case 9: System.out.println("adios!");
			break;
			
		default: System.out.println("opcion incorrecta");
			break;
	}
	
   }while(opcion!=9);
	
 }
	
	public static void ordenarVagonesPorid(Locomotora actual){
		actual.ordenarVagonesPorIdVagon();
		System.out.println("se ordenaron los vagones");
	}
	
	public static void editarDescVagon(Scanner sc,Locomotora actual) {
		System.out.println("ingrese el id del vagon");
		String id=sc.next();
		System.out.println("ingrese la nueva descripcion");
		String desc=sc.next();
		
		if(actual.editarDescripcionVagon(id, desc)){
			System.out.println("se cambio la descripcion del vagon");
		}else {
			System.out.println("el id no es correcto o el vagon no existe");
		}
	}
	
	public static void obtenerPesopromedioMarca(Scanner sc, Locomotora actual){
		int opcion;
		MarcaVagon marca;
		do {
			System.out.println("ingrese la marca:"
					+ "\n1 - LIMA"
					+ "\n2 - ROCO"
					+ "\n3 - PHILOTRAIN");
			opcion=sc.nextInt();
			marca=MarcaVagon.values()[opcion-1];
			
		}while(opcion<0 && opcion>3);
		
		double peso=actual.obtenerPesoPromedioDeVagonParaUnaMarca(marca);
		
		System.out.println("el peso promedio para la marca " + marca +" es: " + peso +"kg");
		
	}
	
	public static void obtenerVagonDeMenorPeso(Locomotora actual) {
		if(actual.obtenerVagonDeMenorPeso()!=null) {
			System.out.println(actual.obtenerVagonDeMenorPeso().toString());
		}else {
			System.out.println("no hay vagones aun");
		}
	}
	
	public static void agregarVagon(Scanner sc, Locomotora actual) {
		System.out.println("ingrese el id del vagon, debe seguir el siguiente formato: ABC123");
		String id=sc.next();
		
		System.out.println("ingrese la descripcion del vagon");
		String desc=sc.next();
		
		int opcion;
		MarcaVagon marca;
		do {
			System.out.println("ingrese la marca:"
					+ "\n1 - LIMA"
					+ "\n2 - ROCO"
					+ "\n3 - PHILOTRAIN");
			opcion=sc.nextInt();
			marca=MarcaVagon.values()[opcion-1];
			
		}while(opcion<0 && opcion>3);
		
		System.out.println("ingrese el peso maximo soportado");
		double pesomax=sc.nextDouble();
		System.out.println("ingrese el peso de carga");
		double pesocarga=sc.nextDouble();
		
		Vagon vagon=new Vagon(id,desc,marca,pesomax,pesocarga);
		
		while(!Vagon.validarIdentificadorDeVagon(id)) {
			System.out.println("el id no cumple con el formato, vuelva a intentarlo:");
			id=sc.next();
			vagon.setIdVagon(id);
		}
		
		if(actual.agregarVagon(vagon)) {
			System.out.println("se agrego el vagon");
		} else {
			System.out.println("error al agregar el vagon");
		}
		
	}

}
