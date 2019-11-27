import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainIRC {
	static final int PUERTO = 5000;
	static ServerSocket skServidor = null;
	static Servidor vServidor = new Servidor();
	static Socket skCliente;
	
	public static void main(String[] args) {
		vServidor.setVisible(true);
		
		int numClientes = 0;
		vServidor.textField.setText("Conexiones actuales = " + numClientes);
		vServidor.btnSalir.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});

		try {
			skServidor = new ServerSocket(PUERTO);
			
			while (true) {
				skCliente = skServidor.accept();
				HiloCliente hilo = new HiloCliente(skCliente, vServidor);
				
				numClientes ++;
				vServidor.textField.setText("Conexiones actuales = " + numClientes);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void salir() {
		vServidor.dispose();
		try {
			if (skCliente != null)
				skCliente.close();
			if (skServidor != null) 
				skServidor.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
