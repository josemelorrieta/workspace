package repasoArrays;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ejercicios ejercicios = new Ejercicios();
		
		Scanner reader = new Scanner(System.in);
		
		ejercicios.numeroPrimo(reader);
		
		int[] a = {1, 2, 3, 4, 5, 6};
		ejercicios.sumarArray(a);
		int[] array1 = {1,2,3};
		int[] array2 = {1,2,3};
		ejercicios.comparaArrays(array1, array2);
		
		int[] array3 = {1,2,3,4};
		int[] array4 = {1,2,3};
		ejercicios.comparaArrays(array3, array4);
		
		int[] array5 = {1,2,3};
		int[] array6 = {1,2,2};
		ejercicios.comparaArrays(array5, array6);
		
		ejercicios.multiplicarArrays(reader);
		
		ejercicios.asteriscos(reader);
		
		ejercicios.matriz();
		
		int[][] matriz = {{1,2,3}, {4,5,6}, {7,8,8}};
		ejercicios.determinante(matriz);
	}

}
