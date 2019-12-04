import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HiloCliente implements Runnable {
	Thread miHilo;
	
	public Socket skCliente;
	private Servidor vServidor;
	private ServidorIRC servidor;
	DataInputStream flujoEntrada;
	DataOutputStream flujoSalida;
	String nombreCliente = "";
	
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
			while (true) {
				if (primeraVez) {
					nombreCliente = flujoEntrada.readUTF();
					nombreCliente = servidor.comprobarNombreCliente(nombreCliente);
					primeraVez = false;
					//responder al cliente
					vServidor.textArea.append(nombreCliente + " se ha conectado al chat.\n");
					servidor.broadcast(nombreCliente);
					Thread.sleep(100);
					servidor.broadcast(nombreCliente + " se ha conectado al chat.\n");
					//Añadir cliente a lista clientes
					vServidor.listModel.addElement(nombreCliente);
					servidor.anadirCliente(nombreCliente);
				} else {
					mensaje = flujoEntrada.readUTF();
					vServidor.textArea.append(nombreCliente + ": " + mensaje + "\n");
					servidor.broadcast(nombreCliente + ": " + mensaje + "\n");
				}
			}
		} catch (Exception e) {
			if (!skCliente.isClosed())
				salir("cliente");
		}
	}
	
	public void responder(String mensaje) {
		try {
			flujoSalida.writeUTF(mensaje);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void salir(String origen) {
		try {
			vServidor.textArea.append(nombreCliente + " se ha desconectado del chat.\n");
			if (origen.equals("cliente")) {
				servidor.broadcast(nombreCliente + " se ha desconectado del chat.\n");
			}			
			servidor.cerrarCliente(nombreCliente);
			Thread.sleep(250);
			flujoEntrada.close();
			flujoSalida.close();
			skCliente.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
