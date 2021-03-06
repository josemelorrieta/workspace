import java.io.DataInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Servidor {
	static final int PUERTO = 5000;	
	ServerSocket skServidor;
	Socket skCliente;
	OutputStream salida;
	InputStream entrada;
	ObjectOutputStream flujoSalida;
	ObjectInputStream flujoEntrada;
	
	public Servidor() {
		try {
			skServidor = new ServerSocket(PUERTO);
			System.out.println("Escuchando el puerto " + PUERTO + "...");
			
			skCliente = skServidor.accept();
			System.out.println("Cliente conectado. Mando Persona.");
			
			Persona persona = new Persona();
			persona.setNif("12345678Z");
			persona.setNombre("Pepito");
			persona.setApellido("Pérez");
			persona.setFechaNacimiento(new Date("18/04/1973"));
			persona.setGenero('M');
			
			System.out.println("Datos de la persona enviados");
			System.out.println(persona.getNombre());
			salida = skCliente.getOutputStream();
			flujoSalida = new ObjectOutputStream(salida);
			flujoSalida.writeObject(persona);
			
			while (true) {
				entrada = skCliente.getInputStream();
				flujoEntrada = new ObjectInputStream(entrada);
				if(flujoEntrada != null) {
					Persona persona2 = (Persona)flujoEntrada.readObject();
					System.out.println("Datos de la persona modificados por el cliente:");
					System.out.println(persona2.getNombre());
					break;
				}
			}
			
		} catch (Exception e) {
			try {
				flujoEntrada.close();
				flujoSalida.close();
				entrada.close();
				salida.close();
				skCliente.close();
			} catch (Exception ex) {
				System.out.println(ex.getStackTrace());
			}
		}
	}

	public static void main(String[] args) {
		new Servidor();
	}

}
