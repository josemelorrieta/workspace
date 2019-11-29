import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class Cliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtMensaje;
	public JTextArea textArea;
	public JButton btnEnviar, btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente frame = new Cliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cliente() {
		setResizable(false);
		setTitle("Ventana Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtMensaje = new JTextField();
		txtMensaje.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMensaje.setBounds(10, 11, 320, 25);
		contentPane.add(txtMensaje);
		txtMensaje.setColumns(10);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEnviar.setBounds(340, 12, 84, 25);
		contentPane.add(btnEnviar);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 47, 414, 173);
		contentPane.add(textArea);
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalir.setBounds(165, 239, 97, 32);
		btnSalir.setFocusPainted(false);
		btnSalir.setContentAreaFilled(false);
		contentPane.add(btnSalir);
	}
}
