import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VentanaContadorReloj extends JFrame {

	private static final long serialVersionUID = 1L;

	JPanel contentPane;
	
	static JLabel lblReloj, lblMayor, lblMenor;
	static JButton btnIniciar, btnPausar, btnParar, btnReiniciar, btnSalir;
	
	static RelojThread reloj;
	static EtiquetaThread etiqueta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaContadorReloj frame = new VentanaContadorReloj();
					frame.setVisible(true);
					reloj = new RelojThread(lblReloj);
					etiqueta = new EtiquetaThread(lblMayor, lblMenor);
				} catch (Exception e) {
					e.printStackTrace();
				}
	
			}

		});
		
	}

	/**
	 * Create the frame.
	 */
	public VentanaContadorReloj() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 167);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		lblReloj = new JLabel("00:00");
		lblReloj.setHorizontalAlignment(SwingConstants.CENTER);
		lblReloj.setFont(new Font("Arial", Font.PLAIN, 28));
		lblReloj.setBounds(219, 18, 96, 50);
		contentPane.add(lblReloj);
		
		btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (reloj.isAlive()) {
					reloj.resume();
//					etiqueta.resume();
				} else {
					reloj.start();
					etiqueta.start();
					btnPausar.setEnabled(true);
					btnParar.setEnabled(true);
					btnReiniciar.setEnabled(true);
				}
				btnIniciar.setEnabled(false);
			}
		});
		btnIniciar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnIniciar.setBounds(28, 76, 90, 30);
		contentPane.add(btnIniciar);
		
		btnPausar = new JButton("Pausar");
		btnPausar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reloj.pause();
				btnIniciar.setEnabled(true);
			}
		});
		btnPausar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnPausar.setBounds(128, 76, 90, 30);
		btnPausar.setEnabled(false);
		contentPane.add(btnPausar);
		
		btnParar = new JButton("Parar");
		btnParar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reloj.stop();
				btnIniciar.setEnabled(true);
				btnPausar.setEnabled(false);
				btnReiniciar.setEnabled(false);
				btnParar.setEnabled(false);
			}
		});
		btnParar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnParar.setBounds(228, 76, 90, 30);
		btnParar.setEnabled(false);
		contentPane.add(btnParar);
		
		btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reloj.restart();
			}
		});
		btnReiniciar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnReiniciar.setBounds(328, 76, 90, 30);
		btnReiniciar.setEnabled(false);
		contentPane.add(btnReiniciar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (reloj.isAlive())
					reloj.stop();
				System.exit(0);
			}
		});
		btnSalir.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSalir.setBounds(428, 76, 90, 30);
		contentPane.add(btnSalir);
		
		lblMenor = new JLabel("<<");
		lblMenor.setFont(new Font("Arial", Font.PLAIN, 35));
		lblMenor.setBounds(169, 18, 48, 50);
		contentPane.add(lblMenor);
		
		lblMayor = new JLabel(">>");
		lblMayor.setFont(new Font("Arial", Font.PLAIN, 35));
		lblMayor.setBounds(318, 18, 48, 50);
		contentPane.add(lblMayor);
	}
}
