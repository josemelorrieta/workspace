import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class ClienteIRC {
	private NickCliente vNick;
	Cliente vCliente;
	final String HOST = "localhost";
	final int PUERTO = 5000;
	Socket skCliente;
	DataInputStream flujoEntrada;
	DataOutputStream flujoEnvio;
	String nick = ""; 
	String mensaje;
	String nombreMensaje;
	String textoMensaje;
	boolean isAlive = true;
	
	public ClienteIRC(NickCliente vNick) {
		this.vNick = vNick;
		vCliente = new Cliente();
		
		try {
			skCliente = new Socket(HOST, PUERTO);
			flujoEnvio = new DataOutputStream(skCliente.getOutputStream());
			flujoEntrada = new DataInputStream(skCliente.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		botonesVentanaNick();
		botonesVentanaChat();
		
		while(isAlive) {
			try {
				mensaje = flujoEntrada.readUTF();
				vCliente.textArea.append(mensaje);
			} catch (Exception e) {
				salir();
			}
		}
		
		vCliente.dispose();
	}
	
	private void aceptarNick() {
		if (!vNick.txtNick.getText().equals("")) {
			vNick.setVisible(false);
			vNick.lblError.setText("");
			nick = vNick.txtNick.getText();
			vCliente.setTitle("Ventana cliente " + nick);
			vCliente.setVisible(true);
			try {
				flujoEnvio.writeUTF(nick);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			vNick.lblError.setText("Debe introducir un nick");
		}
	}
	
	private void enviarMensaje() {
		if (!vCliente.txtMensaje.getText().equals("")) {
			try {
				flujoEnvio.writeUTF(vCliente.txtMensaje.getText());
				vCliente.txtMensaje.setText("");
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		}
	}
	
	private void botonesVentanaNick() {
		vNick.btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				aceptarNick();
			}
			
		});
		
		Action actionNick = new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				aceptarNick();				
			}
		};
		
		vNick.txtNick.addActionListener(actionNick);
	}
	
	private void botonesVentanaChat() {
		vCliente.btnEnviar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				enviarMensaje();
			}
		});
		
		Action action = new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				enviarMensaje();				
			}
		};
		
		vCliente.txtMensaje.addActionListener(action);
		
		vCliente.btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
	}

	private void salir() {
		try {
			flujoEntrada.close();
			flujoEnvio.close();
			skCliente.close();
			isAlive = false;
		} catch (Exception ex) {
			vCliente.dispose();
		}
	}

}
