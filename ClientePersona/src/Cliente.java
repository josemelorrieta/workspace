import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente {
	static final String HOST = "localhost";
	static final int PUERTO = 5000;
	Socket skCliente;
	InputStream respuesta;
	ObjectInputStream flujoRespuesta;
	OutputStream envio;
	ObjectOutputStream flujoEnvio;
	
	public Cliente() {
		try {
			skCliente = new Socket(HOST, PUERTO);
			System.out.println("Petición de persona");
			respuesta = skCliente.getInputStream();
			flujoRespuesta = new ObjectInputStream(respuesta);
			Persona persona = (Persona)flujoRespuesta.readObject();
			System.out.println("Datos de persona recibidos");
			System.out.println(persona.getNombre());
			System.out.println("Modificar datos");
			persona.setNombre("Juana");
			System.out.println("Nombre modificado a Juana");
			envio = skCliente.getOutputStream();
			flujoEnvio = new ObjectOutputStream(envio);
			flujoEnvio.writeObject(persona);
		} catch(Exception e) {
			System.out.println(e.getStackTrace());
		} finally {
			try {
			flujoEnvio.close();
			envio.close();
			skCliente.close();
			} catch (Exception ex) {
				System.out.println(ex.getStackTrace());
			}
		}
	}
	
	public static void main(String[] args) {
		new Cliente();		
	}

}
