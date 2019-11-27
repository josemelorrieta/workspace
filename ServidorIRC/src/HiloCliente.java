import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HiloCliente implements Runnable {
	Thread miHilo;
	
	private Socket skCliente;
	private Servidor vServidor;
	
	public HiloCliente (Socket skCliente, Servidor vServidor) {
		this.skCliente = skCliente;
		this.vServidor = vServidor;
		
		miHilo = new Thread(this);
		miHilo.start();
	}
	
	public void run() {
		InputStream entrada;
		OutputStream salida;
		DataInputStream flujoEntrada;
		DataOutputStream flujoSalida;
		String nombreCliente = "";
		String mensaje = "";
		boolean primeraVez = true;
		
		while (true) {
			try {
				entrada = skCliente.getInputStream();
				flujoEntrada = new DataInputStream(entrada);
				if (primeraVez) {
					nombreCliente = flujoEntrada.readUTF();
					primeraVez = false;
					vServidor.textArea.append(nombreCliente + " se ha conectado al chat.\n");
				} else {
					mensaje = flujoEntrada.readUTF();
					vServidor.textArea.append(nombreCliente + ": " + mensaje + "\n");
				}
				
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}
	
	
}
