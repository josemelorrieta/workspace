import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Servidor extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField textField;
	public JTextArea textArea;
	public JButton btnSalir, btnDesconectar;
	public JList<String> list;
	public DefaultListModel<String> listModel;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Servidor frame = new Servidor();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Servidor() {
		setResizable(false);
		setTitle("Ventana servidor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setEditable(false);
		textField.setBounds(10, 11, 414, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textArea.setEditable(false);
		textArea.setBounds(10, 42, 414, 285);
		contentPane.add(textArea);
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalir.setBounds(231, 338, 98, 30);
		btnSalir.setFocusPainted(false);
		btnSalir.setContentAreaFilled(false);
		contentPane.add(btnSalir);
		
		list = new JList<String>();
		listModel = new DefaultListModel<String>();
		list.setModel(listModel);
		list.setBounds(436, 42, 130, 285);
		contentPane.add(list);
		
		btnDesconectar = new JButton("Desconectar");
		btnDesconectar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDesconectar.setBounds(446, 338, 113, 30);
		btnDesconectar.setFocusPainted(false);
		btnDesconectar.setContentAreaFilled(false);
		contentPane.add(btnDesconectar);
	}
}
