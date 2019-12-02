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
	int numClientes = 0;
	ArrayList<HiloCliente> clientes = new ArrayList<HiloCliente>();
	ArrayList<String> nombresClientes = new ArrayList<String>();
	
	public ServidorIRC (Servidor vServidor) {
		this.vServidor = vServidor;
	
		vServidor.textField.setText("Conexiones actuales = " + numClientes);
		vServidor.btnSalir.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		
		vServidor.btnDesconectar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int pos = vServidor.list.getSelectedIndex();
				if (pos >= 0)
					clientes.get(pos).salir("servidor");
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
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void broadcast(String mensaje) {
		for (HiloCliente cliente: clientes) {
			cliente.responder(mensaje);
		}
	}
	
	public void anadirCliente(String nombre) {
		nombresClientes.add(nombre);
	}
	
	public void cerrarCliente(String nombreCliente) {
		int indice = nombresClientes.indexOf(nombreCliente);
		nombresClientes.remove(indice);
		clientes.remove(indice);
		vServidor.listModel.remove(indice);
		numClientes --;
		vServidor.textField.setText("Conexiones actuales = " + numClientes);
	}
	
	private void salir() {
		ArrayList<HiloCliente> clientesTemp = new ArrayList<HiloCliente>(clientes);
				
		for (HiloCliente cliente: clientesTemp) {
			try {
				cliente.salir("servidor");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		vServidor.dispose();
		System.exit(0);
	}

	public boolean comprobarNombreCliente(String nombre) {
		if (nombresClientes.contains(nombre)) {
			return true;
		} else {
			return false;
		}
	}
}
