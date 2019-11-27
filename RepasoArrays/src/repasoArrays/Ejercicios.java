package repasoArrays;

import java.util.Scanner;

public class Ejercicios {
	public void bucleEquivalente() {
//		int lim = 10;
//		int c = 1;
//		Scanner sc = new Scanner(System.in);
//		for (int i = 0; i < lim && c != 0; i++, c = sc.nextInt()) {}
		
		int[] array = new int[10];
		
		for (int i=0;i<array.length;i++) {
			
		}
	}
	
	public void numeroPrimo(Scanner reader) {
			int[] divisores = {2, 3, 5, 7, 11};
			boolean primo = true;
			
			System.out.println("Introduzca un número entero: ");
			int numero = reader.nextInt();
			
			for (int i=0;i<divisores.length;i++) {
				if (numero != divisores[i] && numero % divisores[i] == 0) {
					primo = false;
					break;
				}
			}
			
			if (primo) {
				System.out.println(numero + " es primo.");
			} else {
				System.out.println(numero + " no es primo.");
			}
	}
	
	public void sumarArray(int[] array) {
		int suma = 0;
		for (int i=0;i<array.length;i++) {
			suma += array[i];
		}
		
		System.out.println("La suma de los números del array " + mostrarArray(array) + " es " + suma + ".");
	}
	
	public void comparaArrays(int[] array1, int[] array2) {
		boolean iguales = true;
		
		if (array1.length != array2.length) {
			iguales = false;
		} else {
			for (int i=0;i<array1.length;i++) {
				if(array1[i] != array2[i]) {
					iguales = false;
					break;
				}
			}
		}
		
		System.out.print("Los arrays " + mostrarArray(array1) + " y " + mostrarArray(array2));
		if (iguales) {
			System.out.println(" son iguales.");
		} else {
			System.out.println(" no son iguales.");
		}
	}
	
	public void multiplicarArrays(Scanner reader) {
		System.out.println("Longitud de los arrays? ");
		int longitud = reader.nextInt();
		int[] array1 = new int[longitud];
		int[] array2 = new int[longitud];
		int[] array3 = new int[longitud];
		
		System.out.println("Introducir datos de los arrays:");
		
		for (int i=0;i<longitud;i++) {
			System.out.println("Array 1 posicion " + i + ":");
			array1[i] = reader.nextInt();
			
			System.out.println("Array 2 posicion " + i + ":");
			array2[i] = reader.nextInt();
			
			array3[i] = array1[i] * array2[i];
		}
		
		System.out.print("Multiplicación de los dos arrays: " + mostrarArray(array3));
		
	}
	
	public void asteriscos(Scanner reader) {
		System.out.println("Longitud del arrays? ");
		int longitud = reader.nextInt();
		int[] array = new int[longitud];
		
		System.out.println("Introducir datos del array:");
		
		for (int i=0;i<longitud;i++) {
			System.out.print("Array posicion " + i + ":");
			array[i] = reader.nextInt();
			System.out.println();
		}
		
		for (int i=0;i<longitud;i++) {
			for (int j=1;j<=array[i];j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void matriz() {
		int[][] matriz = {{1,2,3},{4,5,6}};
		
		for (int i=0;i<matriz.length;i++) {
			for (int j=0;j<matriz[i].length;j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void determinante(int[][] matriz) {
		int aei = matriz[0][0] * matriz[1][1] * matriz [2][2];
		int bfg = matriz[0][1] * matriz[1][2] * matriz [2][0];
		int cdh = matriz[0][2] * matriz[1][0] * matriz [2][1];
		int afh = matriz[0][0] * matriz[1][2] * matriz [2][1];
		int bdi = matriz[0][1] * matriz[1][0] * matriz [2][2];
		int ceg = matriz[0][2] * matriz[1][1] * matriz [2][0];
		
		System.out.println("Determinante: " + (aei + bfg + cdh - afh - bdi - ceg));
	}
	
	public String mostrarArray(int[] array) {
		String salida = "";
		
		for (int i=0;i<array.length;i++) {
			salida += array[i] + ", ";
		}
		
		salida = "{" + salida.substring(0, salida.length() - 2) +"}";
		
		return salida;
	}

}
