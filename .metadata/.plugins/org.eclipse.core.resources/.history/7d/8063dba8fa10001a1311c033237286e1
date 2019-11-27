import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	static final int PUERTO = 5000;	
	ServerSocket skServidor;
	Socket skCliente;
	OutputStream salida;
	InputStream entrada;
	DataOutputStream flujoSalida;
	DataInputStream flujoEntrada;
	
	public Servidor() {
		try {
			skServidor = new ServerSocket(PUERTO);
			System.out.println("Escuchando el puerto " + PUERTO + "...");
			for (int i=1;i<=3;i++) {
				skCliente = skServidor.accept();
				System.out.println("Sirvo al cliente " + i);
				entrada = skCliente.getInputStream();
				flujoEntrada = new DataInputStream(entrada);
				if(flujoEntrada.readUTF().equals("1")) {
					salida = skCliente.getOutputStream();
					flujoSalida = new DataOutputStream(salida);
					flujoSalida.writeUTF("Cliente " + i + " ha enviado un 1");
				} else {
					salida = skCliente.getOutputStream();
					flujoSalida = new DataOutputStream(salida);
					flujoSalida.writeUTF("Cliente " + i + " NO ha enviado un 1");
				}
				
			}
		} catch (Exception e) {
			try {
				flujoEntrada.close();
				flujoSalida.close();
				entrada.close();
				salida.close();
				skCliente.close();
			} catch (Exception ex) {
				System.out.println(ex.getStackTrace());
			}
		}
	}

	public static void main(String[] args) {
		new Servidor();
	}

}
