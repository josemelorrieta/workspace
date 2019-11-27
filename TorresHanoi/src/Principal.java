import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	
	
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int niveles = 0;
		
		ArrayList<ArrayList<String>> palos = new ArrayList<ArrayList<String>>();
		
		System.out.print("Cuantos niveles quieres? ");
		niveles = reader.nextInt();
		reader.nextLine();
		
		palos = inicializarPalos(palos, niveles);
		ArrayList<ArrayList<Integer>> movimientos = new ArrayList<ArrayList<Integer>>();
		movimientos = inicializarMovimientos(movimientos, niveles);
		
		renderizarJuego(palos, reader);
		
		resolverJuego(palos, movimientos, niveles, reader);

		reader.close();
	}
	
	public static ArrayList<ArrayList<String>> inicializarPalos(ArrayList<ArrayList<String>> palos, int niveles) {
		ArrayList<String> palo1 = new ArrayList<String>();
		ArrayList<String> palo2 = new ArrayList<String>();
		ArrayList<String> palo3 = new ArrayList<String>();
		
		
		for (int i=0; i<niveles;i++) {
			palo1.add((i + 1) + "");
			palo2.add("0");
			palo3.add("0");
		}
		
		palos.add(palo1);
		palos.add(palo2);
		palos.add(palo3);
		
		return palos;
	}
	
	public static ArrayList<ArrayList<Integer>> inicializarMovimientos(ArrayList<ArrayList<Integer>> movimientos, int niveles) {
		// Declarar arrays de movimentos a partir del disco 2 (pos 0)
		int mov = 0;
		int salto = 0;
		int movTotales = (int)Math.pow(2, niveles) - 1;
		
		for (int i=0;i<niveles - 1;i++) {
			movimientos.add(new ArrayList<Integer>());
			
			mov = (int)Math.pow(2, i + 1);
			salto = (int)Math.pow(2, i + 2);
			
			// Inicializar array de movimientos
			while (mov < movTotales) {
				movimientos.get(i).add(mov);
				mov += salto;
			}
		}
		
		return movimientos;
	}
	
	public static void renderizarJuego(ArrayList<ArrayList<String>> palos, Scanner reader) {
				
		for (int i=0;i<palos.get(0).size();i++) {
			for (int j=0;j<3;j++) {
				if (!palos.get(j).get(i).equals("0")) {
					System.out.print(" " + palos.get(j).get(i));
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		System.out.print(" - - -");
		System.out.println();
		reader.nextLine();
		clearConsole();
	}
	
	public static void resolverJuego(ArrayList<ArrayList<String>> palos, ArrayList<ArrayList<Integer>> movimientos, int niveles, Scanner reader) {
		
		int numMovimientos =(int) Math.pow(2, palos.get(0).size()) - 1;
		int origen = 0;
		int destino = 0;
		String disco = "";
		
		for (int i=1;i<=numMovimientos;i++) {
			System.out.println("Movimiento: " + i);
			if (i % 2 != 0) {
				disco = "1";
				origen = encontrarDisco(palos, disco);
				if (niveles % 2 != 0) {
					if (origen - 1 < 0) {
						destino = 2;
					} else {
						destino = origen - 1;
					}
				} else {
					if (origen + 1 > 2) {
						destino = 0;
					} else {
						destino = origen + 1;
					}
				}
			} else {
				disco = discoAMover(movimientos, i, niveles);
				origen = encontrarDisco(palos, disco);
				if (Integer.parseInt(disco) % 2 == 0) {
					if (niveles % 2 != 0) {
						if (origen + 1 > 2) {
							destino = 0;
						} else {
							destino = origen + 1;
						}
					} else {
						if (origen - 1 < 0) {
							destino = 2;
						} else {
							destino = origen - 1;
						}
					}
				} else {
					if (niveles % 2 != 0) {
						if (origen - 1 < 0) {
							destino = 2;
						} else {
							destino = origen - 1;
						}					
					} else {
						if (origen + 1 > 2) {
							destino = 0;
						} else {
							destino = origen + 1;
						}
					}
				}
			}
			
			palos = moverDisco(palos, disco, origen, destino);

			renderizarJuego(palos, reader);
		}
		
	}

	public static int encontrarDisco(ArrayList<ArrayList<String>> palos, String disco) {
		int pos = -1;
		for (int i=0;i<3;i++) {
			if(palos.get(i).contains(disco)) {
				pos = i;
				break;
			}
		}
		
		return pos;
	}
	
	public static ArrayList<ArrayList<String>> moverDisco(ArrayList<ArrayList<String>> palos, String disco, int origen, int destino) {
		// Borrar disco en origen
		palos.get(origen).set(palos.get(origen).indexOf(disco), "0");
		
		// Colocar disco en destino
		palos.get(destino).set(palos.get(destino).lastIndexOf("0"), disco);
		
		return palos;
	}
	
	public static String discoAMover(ArrayList<ArrayList<Integer>> movimientos, int mov, int niveles) {
		String disco = "";
		
		for (int i=0;i<niveles-1;i++) {
			if (movimientos.get(i).contains(mov)) {
				disco = (i + 2) + "";
				break;
			}
		}
		
		return disco;
	}
	
	public final static void clearConsole()
	{
		for (int i=0;i<15;i++) {
			System.out.println();
		}
	}
	
}