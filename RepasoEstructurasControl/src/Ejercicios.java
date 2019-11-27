import java.util.Scanner;

public class Ejercicios {
	Scanner reader = new Scanner(System.in);
	
	public void nombreDiezVeces(Integer veces) {
		for (int i=1; i<=veces; i++) {
			System.out.println("José Manuel");
		}
	}
	
	public void nombreNVeces() {
		int veces = 0; 
		
		System.out.print("Cuántas veces quieres poner tu nombre? ");
		veces = reader.nextInt();
		
		nombreDiezVeces(veces);
		
	}
	
	public void nombreNumerando() {
		int veces = 0; 
		
		System.out.print("Cuántas veces quieres poner tu nombre? ");
		veces = reader.nextInt();
		
		nombreDiezVecesConNumero(veces);
		
	}
	
	public void nombreDiezVecesConNumero(Integer veces) {
		for (int i=1; i<=veces; i++) {
			System.out.println(i + ". José Manuel");
		}
	}
	
	public void numerosPares() {
		for(int i=0; i<=30; i+=2) {
			System.out.print(i + " ");
		}
	}
	
	public void multiplosDeCinco() {
		int num1 = 0;
		int num2 = 0;
		
		System.out.print("Introduce el primer número: ");
		num1 = reader.nextInt();
		System.out.print("Introduce el segundo número: ");
		num2 = reader.nextInt();
		
		if (num1 < num2) {
			for (int i=num1;i<=num2;i++) {
				if (i % 5 == 0) {
					System.out.print(i + " ");
				}
			}
		} else {
			for (int i=num1;i>=num2;i--) {
				if (i % 5 == 0) {
					System.out.print(i + " ");
				}
			}
		}		
	}
	
	public void diezNumeros(int veces) {
		float suma = 0;
		float mayor = 0;
		float menor = 0;
		float numero = 0;
		float media = 0;
		
		for (int i=1;i<=veces;i++) {
			System.out.print("Introduce un número (" + i + "): ");
			numero = reader.nextInt();
			if (i == 1) {
				mayor = numero;
				menor = numero;
			} else {
				if (numero > mayor) {
					mayor = numero;
				}
				if (numero < menor) {
					menor = numero;
				}
			}
			suma = suma + numero;
		}
		
		media = suma / veces;
		
		System.out.println("El mayor número introducido es: " + mayor);
		System.out.println("El menor número introducido es: " + menor);
		System.out.println("La media de los diez números es: " + media);
		
	}
	
	public void xNumeros() {
		int veces = 0; 
		
		System.out.print("Cuántos números quieres introducir? ");
		veces = reader.nextInt();
		
		diezNumeros(veces);
	}
	
	public void pedirNumeros() {
		float suma = 0;
		float mayor = 0;
		float menor = 0;
		float numero = 0;
		float media = 0;
		int cont = 0;
		String respuesta = "S";
		
		while (respuesta.toUpperCase().equals("S")) {
			cont++;
			System.out.print("Introduce un número (" + cont + "): ");
			numero = reader.nextInt();
			if (cont == 1) {
				mayor = numero;
				menor = numero;
			} else {
				if (numero > mayor) {
					mayor = numero;
				}
				if (numero < menor) {
					menor = numero;
				}
			}
			suma = suma + numero;
			
			System.out.print("Quieres introducir más números (S/N)? ");
			respuesta = reader.next();
		}
		
		media = suma / cont;
		
		System.out.println("El mayor número introducido es: " + mayor);
		System.out.println("El menor número introducido es: " + menor);
		System.out.println("La media de los diez números es: " + media);
	}
	
	public void enteroPositivo() {
		int cont = 1;
		int numero = 0;
		boolean repetir = true;
		
		while (repetir) {
			System.out.print("introduce un número entero positivo: ");
			numero = reader.nextInt();
			
			if (numero > 0) {
				System.out.println("Lo has logrado en " + cont + " intentos.");
				repetir = false;
			} else {
				System.out.println("Tiene que ser positivo");
				cont++;
			}
		}
		
	}
	
	public void enteroPositivo5() {
		int cont = 1;
		int numero = 0;
		boolean repetir = true;
		
		while (repetir) {
			System.out.print("introduce un número entero positivo: ");
			numero = reader.nextInt();
			
			if (numero > 0) {
				System.out.println("Lo has logrado en " + cont + " intentos.");
				repetir = false;
			} else {
				System.out.println("Tiene que ser positivo");
				cont++;
				if (cont > 5) {
					System.out.println("Has agotado las cinco oportunidades.");
					repetir = false;
				}
			}
		}	
	}
	
	public void sumaNumeros() {
		int suma = 0;
		int numero = 1;
		
		while (numero != 0) {
			System.out.print("Introduce un número a sumar: ");
			numero = reader.nextInt();
			
			suma = suma + numero;
		}
		
		System.out.println("La suma de todos los números es " + suma + ".");
	}
	
	public void primo() {
		int numero = 0;
		
		System.out.print("Introduce un número entero positivo: ");
		numero = reader.nextInt();
		
		if (esPrimo(numero)) {
			System.out.println("El número introducido es primo.");
		} else {
			System.out.println("El número introducido NO es primo.");
		}
	}
	
	public boolean esPrimo(int numero) {		
		// sacado de internet - primo si no es divisible exacto por 2, 3, 5, 7 u 11
		if (numero != 2 && numero != 3 && numero != 5 && numero != 7 && numero != 11) {
			if (numero % 2 == 0 || numero % 3 == 0 || numero % 5 == 0 || numero % 7 == 0 || numero % 11 == 0) {
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}
	}
	
	public void factorial() {
		int numero = 0;
		int factorial = 1;
		
		System.out.print("Introduce un número entero positivo: ");
		numero = reader.nextInt();
		
		for (int i=1;i<=numero;i++) {
			factorial = factorial * i;
		}
		
		System.out.println("El factorial de " + numero + " es " + factorial);
	}
	
	public void primosMenores() {
		int numero = 0;
		
		System.out.print("Introduce un número entero positivo: ");
		numero = reader.nextInt();
		
		for (int i=1;i<=numero;i++) {
			if (esPrimo(i)) {
				System.out.print(i + " ");
			}
		}
	}
	
	public void factorialBucle() {
		int numero = 0;
		int factorial = 1;
		
		System.out.print("Introduce un número entero positivo: ");
		numero = reader.nextInt();
		
		while (numero > 0) {
			factorial = 1;
			for (int i=1;i<=numero;i++) {
				factorial = factorial * i;
			}
			
			System.out.println("El factorial de " + numero + " es " + factorial);
			
			System.out.println();
			System.out.print("Introduce un número entero positivo: ");
			numero = reader.nextInt();
		}
	}
	
	public void numeroPerfecto() {
		int numero = 0;
		int suma = 0;
		
		System.out.print("Introduce un número entero positivo: ");
		numero = reader.nextInt();
		
		while (numero > 0) {
			for (int i=1;i<numero;i++) {
				if ( numero % i == 0) {
					suma += i;
				}
			}
			
			if ( suma == numero ) {
				System.out.println("El número " + numero + " es un Número Perfecto!");
			} else {
				System.out.println("El número " + numero + " no es un Número Perfecto");
			}
			
			System.out.println();
			System.out.print("Introduce un número entero positivo: ");
			numero = reader.nextInt();
			suma = 0;
		}
	}
}
