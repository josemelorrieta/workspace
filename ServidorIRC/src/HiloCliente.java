import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class HiloCliente implements Runnable {
	Thread miHilo;
	
	private Socket skCliente;
	private Servidor vServidor;
	private ServidorIRC servidor;
	DataInputStream flujoEntrada;
	DataOutputStream flujoSalida;
	String nombreCliente = "";
	boolean isAlive = true;
	
	public HiloCliente (Socket skCliente, Servidor vServidor, ServidorIRC servidor) {
		this.skCliente = skCliente;
		this.vServidor = vServidor;
		this.servidor = servidor;
		
		miHilo = new Thread(this);
		miHilo.start();
	}
	
	public void run() {
		
		
		String mensaje = "";
		boolean primeraVez = true;

		try {
			flujoEntrada = new DataInputStream(skCliente.getInputStream());
			flujoSalida = new DataOutputStream(skCliente.getOutputStream());
			while (isAlive) {
				if (primeraVez) {
					nombreCliente = flujoEntrada.readUTF();
					primeraVez = false;
					//responder al cliente
					vServidor.textArea.append(nombreCliente + " se ha conectado al chat.\n");
					servidor.broadcast(nombreCliente + " se ha conectado al chat.\n");
					//Añadir cliente a lista clientes
					vServidor.listModel.addElement(nombreCliente);
					servidor.anadirCliente(nombreCliente);
				} else {
					if (!mensaje.equals("exit")) {
						mensaje = flujoEntrada.readUTF();
						vServidor.textArea.append(nombreCliente + ": " + mensaje + "\n");
						servidor.broadcast(nombreCliente + ": " + mensaje + "\n");
					} else {
						servidor.cerrarCliente(nombreCliente);
					}
				}
		
			}
		} catch (Exception e) {
			salir();
		}
	}
	
	public void responder(String mensaje) {
		try {
			flujoSalida.writeUTF(mensaje);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void salir() {
		try {
			vServidor.textArea.append(nombreCliente + " se ha desconectado del chat.\n");
			servidor.broadcast(nombreCliente + " se ha desconectado del chat.\n");
			servidor.cerrarCliente(nombreCliente);
			flujoEntrada.close();
			flujoSalida.close();
			skCliente.close();
			isAlive = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
