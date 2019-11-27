package procesos;

import java.io.IOException;
import java.util.Arrays;

public class RunProcess {
	public static void main(String[] args) throws IOException {
//		if (args.length <= 0) {
//			System.out.println("Se necesita un programa a ejecutar");
//			System.exit(-1);
//		}
		
		ProcessBuilder pb = new ProcessBuilder(args);
		
		try {
			Process process = pb.start();
			int retorno = process.waitFor();
			System.out.println("La ejecuci�n de " + Arrays.toString(args) + " devuelve " + retorno);
			
		} catch (Exception e) {
			
		}
	}

}
