import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MainClienteIRC {
	static NickCliente vNick;
	static Cliente vCliente;
	static final String HOST = "localhost";
	static final int PUERTO = 5000;
	static Socket skCliente;
	static InputStream respuesta;
	static DataInputStream flujoRespuesta;
	static OutputStream envio;
	static DataOutputStream flujoEnvio;
	static String nick = ""; 
	
	public static void main(String[] args) {
		vNick = new NickCliente();
		vCliente = new Cliente();
		
		vNick.setVisible(true);
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
		
//		while (true) {
//			
//		}
	}
	
	private static void aceptarNick() {
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
	
	private static void iniciarChat() {
		try {
			skCliente = new Socket(HOST, PUERTO);
			envio = skCliente.getOutputStream();
			flujoEnvio = new DataOutputStream(envio);
			flujoEnvio.writeUTF(nick);
				
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	private static void enviarMensaje() {
		try {
			flujoEnvio.writeUTF(vCliente.txtMensaje.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
