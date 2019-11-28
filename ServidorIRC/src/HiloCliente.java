import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class HiloCliente implements Runnable {
	Thread miHilo;
	
	private Socket skCliente;
	private Servidor vServidor;
	private ServidorIRC servidor;
	private ArrayList<HiloCliente> clientes;
	InputStream entrada;
	DataInputStream flujoEntrada;
	DataOutputStream flujoSalida;
	OutputStream salida;
	
	public HiloCliente (Socket skCliente, Servidor vServidor, ServidorIRC servidor) {
		this.skCliente = skCliente;
		this.vServidor = vServidor;
		this.servidor = servidor;
		
		miHilo = new Thread(this);
		miHilo.start();
	}
	
	public void run() {
		
		String nombreCliente = "";
		String mensaje = "";
		boolean primeraVez = true;	

		try {
			entrada = skCliente.getInputStream();
			flujoEntrada = new DataInputStream(entrada);
			salida = skCliente.getOutputStream();
			flujoSalida = new DataOutputStream(salida);
			while (true) {
				if (primeraVez) {
					nombreCliente = flujoEntrada.readUTF();
					primeraVez = false;
					vServidor.textArea.append(nombreCliente + " se ha conectado al chat.\n");
					//responder(nombreCliente + " se ha conectado al chat.\n");
					servidor.broadcast(nombreCliente + " se ha conectado al chat.\n");
				} else {
					mensaje = flujoEntrada.readUTF();
					vServidor.textArea.append(nombreCliente + ": " + mensaje + "\n");
					//responder(nombreCliente + ": " + mensaje + "\n");
					servidor.broadcast(nombreCliente + ": " + mensaje + "\n");
				}
		
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public void responder(String mensaje) {
		try {
			flujoSalida.writeUTF(mensaje);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
