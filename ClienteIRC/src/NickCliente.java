import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;

public class NickCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtNick;
	public JButton btnAceptar;
	public JLabel lblError;

	public NickCliente() {
		setTitle("Ventana cliente entrada");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 299, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIntroduceTuNick = new JLabel("Introduce tu nick:");
		lblIntroduceTuNick.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIntroduceTuNick.setBounds(10, 21, 263, 22);
		contentPane.add(lblIntroduceTuNick);
		
		txtNick = new JTextField();
		txtNick.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNick.setBounds(10, 50, 263, 22);
		contentPane.add(txtNick);
		txtNick.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAceptar.setBounds(83, 113, 113, 33);
		contentPane.add(btnAceptar);
		
		lblError = new JLabel("");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblError.setBounds(10, 83, 263, 22);
		contentPane.add(lblError);
	}
}
