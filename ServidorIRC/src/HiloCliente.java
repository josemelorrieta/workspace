import java.net.Socket;

public class HiloCliente extends Thread {
	private Socket skCliente;
	private Servidor vServidor;
	
	public HiloCliente (Socket skCliente, Servidor vServidor) {
		this.skCliente = skCliente;
		this.vServidor = vServidor;
		
		while (true) {
			
		}
	}
	
	
}
