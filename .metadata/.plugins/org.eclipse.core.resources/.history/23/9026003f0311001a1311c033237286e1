import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente {
	static final String HOST = "localhost";
	static final int PUERTO = 5000;
	Socket skCliente;
	InputStream respuesta;
	DataInputStream flujoRespuesta;
	OutputStream pregunta;
	DataOutputStream flujoPregunta;
	
	public Cliente() {
		try {
			skCliente = new Socket(HOST, PUERTO);
			pregunta = skCliente.getOutputStream();
			flujoPregunta = new DataOutputStream(pregunta);
			System.out.println("Envío un 2");
			flujoPregunta.writeUTF("2");
			respuesta = skCliente.getInputStream();
			flujoRespuesta = new DataInputStream(respuesta);
			System.out.println(DataInputStream.readUTF(flujoRespuesta));
		} catch(Exception e) {
			System.out.println(e.getStackTrace());
		} finally {
			try {
			flujoPregunta.close();
			pregunta.close();
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
