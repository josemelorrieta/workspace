import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServidorIRC {
	private Servidor vServidor;
	
	final int PUERTO = 5000;
	ServerSocket skServidor = null;
	Socket skCliente = null;
	ArrayList<HiloCliente> clientes = new ArrayList<HiloCliente>();
	
	public ServidorIRC (Servidor vServidor) {
		this.vServidor = vServidor;
	
	
		int numClientes = 0;
		vServidor.textField.setText("Conexiones actuales = " + numClientes);
		vServidor.btnSalir.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//salir();
			}
		});
		
		
		try {
			skServidor = new ServerSocket(PUERTO);
			
			while (true) {
				skCliente = skServidor.accept();
				clientes.add(new HiloCliente(skCliente, vServidor, this));
				
				numClientes ++;
				vServidor.textField.setText("Conexiones actuales = " + numClientes);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void broadcast(String mensaje) {
		for (HiloCliente cliente: clientes) {
			cliente.responder(mensaje);
		}
	}
}
