package ejercicios;

import java.util.Scanner;

public class Ejercicio1 {
	Scanner reader = new Scanner(System.in);
	
	public void pasarSegundosAHoras() {
		// Declaración e inicialización de variables
		int segundos = 0;
		int[] tiempoConvertido = new int[3];
		
		// Inicio del programa
		// Pedir numero de segundos a convertir	
		System.out.println("======= EJERCICIO 1 =======");
		System.out.print("Número de segundos a convertir: ");
		segundos = reader.nextInt();
		
		tiempoConvertido = convertirSegundos(segundos);
		
		// Imprimir resultados
		System.out.println("Equivalen a " + tiempoConvertido[0] + " horas, " + tiempoConvertido[1] + " minutos y " + tiempoConvertido[2] + " segundos.");
		
	}
	
	public int[] convertirSegundos(int segundos) {
		// Declaración e inicialización de variables			 
		
		int[] resultado = new int[3];
		
		// Inicio del programa
		
		// Calcular las horas
		resultado[0] = (int) Math.floor(segundos / 3600);
		// Calcular segundos restantes
		segundos = segundos - (resultado[0] * 3600);
		// Calcular minutos
		resultado[1] = (int) Math.floor(segundos / 60);
		// Calcular segundos restantes
		resultado[2] = segundos - (resultado[1] * 60);
		
		return resultado;
		
	}
	
	public void cortarCesped() {
		// Declaración e inicialización de variables	
		int anchoTerreno = 0; 
		int largoTerreno = 0;
		int anchoCasa = 0;
		int largoCasa = 0;
		int superficieTerreno = 0;
		int superficieCasa = 0;
		
		final int VelocidadCorte = 50;
		
		int segundos = 0;
		int[] tiempoConvertido = new int[3];
		
		// Inicio del programa
		// Pedir datos del programa
		System.out.println("======= EJERCICIO 2 =======");
		System.out.println("Medidas del terreno");
		System.out.print("Longitud en metros: ");
		largoTerreno = reader.nextInt();
		System.out.print("Anchura en metros: ");
		anchoTerreno = reader.nextInt();
		
		System.out.println("Medidas de la casa");
		System.out.print("Longitud en metros: ");
		largoCasa = reader.nextInt();
		System.out.print("Anchura en metros: ");
		anchoCasa = reader.nextInt();
		
		superficieTerreno = anchoTerreno * largoTerreno;
		superficieCasa = anchoCasa * largoCasa;
		
		segundos = (int) Math.floor((superficieTerreno - superficieCasa) * 10000 / VelocidadCorte);
		
		tiempoConvertido = convertirSegundos(segundos);
		
		System.out.println("Se tardarán " + segundos + " segundos (" + tiempoConvertido[0] + " horas " + tiempoConvertido[1] + " minutos " + tiempoConvertido[2] + " segundos)");
		
	}
	
	public void circulo() {
		// Declaración e inicialización de variables
		int radio = 0;
		double longitud = 0;
		double area = 0;
		
		// Inicio del programa
		// Pedir radio del circulo
		System.out.println("======= EJERCICIO 3 =======");
		System.out.print("Radio del círulo: ");
		radio = reader.nextInt();
		
		longitud = 2 * Math.PI * radio;
		area = Math.PI * Math.pow(radio, 2);
		
		// Impirimir resultado
		System.out.println("La longitud del círculo es: " + longitud);
		System.out.println("El área del círculo es: " + area);
	}
	
	public void distanciaCiudades() {
		// Declaración e inicialización de variables
		int distancia;
		int km;
		int hm;
		int dm;
		int m;
		
		// Inicio del programa
		// Pedir radio del circulo
		System.out.println("======= EJERCICIO 4 =======");
		System.out.print("introducir distancia en metros: ");
		distancia = reader.nextInt();
		
		km = (int) Math.floor(distancia / 1000);
		distancia = distancia - km * 1000;
		hm =  (int) Math.floor(distancia / 100);
		distancia = distancia - hm * 100;
		dm = (int) Math.floor(distancia / 10);
		m = distancia - dm * 10;
		
		System.out.println("La distancia son " + km + " kilómetros, " + hm + " hectómetros, " + dm + " decámetros y " + m + " metros.");
		
	}
}
