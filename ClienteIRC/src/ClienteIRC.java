import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClienteIRC {
	private NickCliente vNick;
	Cliente vCliente;
	final String HOST = "localhost";
	final int PUERTO = 5000;
	Socket skCliente;
	InputStream respuesta;
	DataInputStream flujoRespuesta;
	OutputStream envio;
	InputStream entrada;
	DataInputStream flujoEntrada;
	DataOutputStream flujoEnvio;
	String nick = ""; 
	
	public ClienteIRC(NickCliente vNick) {
		this.vNick = vNick;
		vCliente = new Cliente();
		
		vNick.btnAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				aceptarNick();
			}
			
		});
		
		vCliente.btnEnviar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				enviarMensaje();
			}
		});
		
		try {
			
			while (true) {
				vCliente.textArea.append(flujoEntrada.readUTF());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void aceptarNick() {
		if (!vNick.txtNick.getText().equals("")) {
			vNick.setVisible(false);
			vCliente.setVisible(true);
			vNick.lblError.setText("");
			nick = vNick.txtNick.getText();
			iniciarChat();
		} else {
			vNick.lblError.setText("Debe introducir un nick para empezar un chat");
		}
	}
	
	private void iniciarChat() {
		try {
			skCliente = new Socket(HOST, PUERTO);
			envio = skCliente.getOutputStream();
			flujoEnvio = new DataOutputStream(envio);
			flujoEnvio.writeUTF(nick);
			entrada = skCliente.getInputStream();
			flujoEntrada = new DataInputStream(entrada);
			//escucharServidor();
				
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	private void enviarMensaje() {
		try {
			flujoEnvio.writeUTF(vCliente.txtMensaje.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void escucharServidor() {
		
	}
}
