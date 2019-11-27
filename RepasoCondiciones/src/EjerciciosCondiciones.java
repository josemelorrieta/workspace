import java.util.Scanner;

public class EjerciciosCondiciones {
	Scanner reader = new Scanner(System.in);
	
	public void parImpar() {
		int numero = 0;
		
		System.out.println("Introduzca un n�mero entero: ");
		numero = reader.nextInt();
		
		if (numero % 2 == 0) {
			System.out.println("El n�mero " +  numero +  " es par.");
		} else {
			System.out.println("El n�mero " +  numero +  " es impar.");
		}
	}
	
	public void mayorDeDos() {
		int numero1 = 0;
		int numero2 = 0;
		
		System.out.println("Introduzca el primer n�mero entero: ");
		numero1 = reader.nextInt();
		
		System.out.println("Introduzca el segundo n�mero entero: ");
		numero2 = reader.nextInt();
		
		if (numero1 > numero2) {
			System.out.println("El n�mero mayor es " + numero1);
		} else if (numero2 > numero1) {
			System.out.println("El n�mero mayor es " + numero2);
		} else {
			System.out.println("Los dos n�meros son iguales.");
		}	
	}
	
	public void multiplo() {
		int numero = 0;
		
		System.out.println("Introduzca un n�mero entero: ");
		numero = reader.nextInt();
		
		if (numero %2 != 0 && numero % 3 != 0 && numero % 5 != 0) {
			System.out.println("El " + numero + " no es m�ltiplo de 2, ni de 3, ni de 5");
		} else {
			if (numero % 2 == 0) {
				System.out.println("El " +  numero + " es m�ltiplo de 2");
			}
			if (numero % 3 == 0) {
				System.out.println("El " +  numero + " es m�ltiplo de 3");
			}
			if (numero % 5 == 0) {
				System.out.println("El " +  numero + " es m�ltiplo de 5");
			}
		}
	}
	
	public void ladosTriangulo() {
		int lado1 = 0;
		int lado2 = 0;
		int lado3 = 0;
		
		System.out.println("Introduzca la medida del primer lado del tri�ngulo: ");
		lado1 = reader.nextInt();
		System.out.println("Introduzca la medida del segundo lado del tri�ngulo: ");
		lado2 = reader.nextInt();
		System.out.println("Introduzca la medida del tercer lado del tri�ngulo: ");
		lado3 = reader.nextInt();
		
		if (lado1 + lado2 > lado3) {
			if (lado2 + lado3 > lado1) {
				if (lado1 + lado3 > lado2) {
					System.out.println("Es posible construir el tri�ngulo.");
				}
			}
		} else {
			System.out.println("No es posible construir el tri�ngulo.");
		}
	}
}
