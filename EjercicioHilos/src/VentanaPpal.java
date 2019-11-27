import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Position;

import org.omg.PortableServer.ServantRetentionPolicyOperations;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPpal extends JFrame {

	private JPanel contentPane;
	private static HiloThread hilo1;
	private static HiloThread hilo2;
	private static HiloThread hilo3;
	
	private static JLabel lblPrio1, lblPrio2, lblPrio3;
	private static JLabel lblCont1, lblCont2, lblCont3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPpal frame = new VentanaPpal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		});
		
		// Iniciar los hilos
		hilo1 = new HiloThread();
		hilo2 = new HiloThread();
		hilo3 = new HiloThread();
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lblPrio1.setText(String.valueOf(hilo1.getPriority()));
		lblPrio2.setText(String.valueOf(hilo1.getPriority()));
		lblPrio3.setText(String.valueOf(hilo1.getPriority()));
		
		while (true) {
			try {
			Thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (hilo1.isAlive())
				lblCont1.setText(String.valueOf(hilo1.getCont()));
			if (hilo2.isAlive())
				lblCont2.setText(String.valueOf(hilo2.getCont()));
			if (hilo3.isAlive())
				lblCont3.setText(String.valueOf(hilo3.getCont()));
		}
	}

	/**
	 * Create the frame.
	 */
	public VentanaPpal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 334, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Ejercicio Hilos");
		contentPane.setLayout(null);
		
		JButton btnMenos1 = new JButton("--");
		btnMenos1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (hilo1.isAlive()) {
					hilo1.setPriority(Thread.MIN_PRIORITY);
					lblPrio1.setText(String.valueOf(hilo1.getPriority()));
				}
			}
		});
		btnMenos1.setBounds(47, 11, 50, 23);
		contentPane.add(btnMenos1);
		
		JButton btnMenos2 = new JButton("--");
		btnMenos2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hilo2.isAlive()) {
					hilo2.setPriority(Thread.MIN_PRIORITY);
					lblPrio2.setText(String.valueOf(hilo2.getPriority()));
				}
			}
		});
		btnMenos2.setBounds(47, 45, 50, 23);
		contentPane.add(btnMenos2);
		
		JButton btnMenos3 = new JButton("--");
		btnMenos3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hilo3.isAlive()) {
					hilo3.setPriority(Thread.MIN_PRIORITY);
					lblPrio3.setText(String.valueOf(hilo3.getPriority()));
				}
			}
		});
		btnMenos3.setBounds(47, 82, 50, 23);
		contentPane.add(btnMenos3);
		
		JButton btnFinHilo1 = new JButton("Fin Hilo 1");
		btnFinHilo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo1.stop();
				try {
					Thread.sleep(150);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if (!hilo1.isAlive())
					lblPrio1.setText("0");
			}
		});
		btnFinHilo1.setBounds(107, 11, 99, 23);
		contentPane.add(btnFinHilo1);
		
		JButton btnFinHilo2 = new JButton("Fin Hilo 2");
		btnFinHilo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo2.stop();
				try {
					Thread.sleep(150);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if (!hilo2.isAlive())
					lblPrio2.setText("0");
			}
		});
		btnFinHilo2.setBounds(107, 45, 99, 23);
		contentPane.add(btnFinHilo2);
		
		JButton btnFinHilo3 = new JButton("Fin Hilo 3");
		btnFinHilo3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo3.stop();
				try {
					Thread.sleep(150);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if (!hilo3.isAlive())
					lblPrio3.setText("0");
			}
		});
		btnFinHilo3.setBounds(107, 82, 99, 23);
		contentPane.add(btnFinHilo3);
		
		JButton btnMas1 = new JButton("++");
		btnMas1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hilo1.isAlive()) {
					hilo1.setPriority(Thread.MAX_PRIORITY);
					lblPrio1.setText(String.valueOf(hilo1.getPriority()));
				}
			}
		});
		btnMas1.setBounds(216, 11, 50, 23);
		contentPane.add(btnMas1);
		
		JButton btnMas2 = new JButton("++");
		btnMas2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hilo2.isAlive()) {
					hilo2.setPriority(Thread.MAX_PRIORITY);
					lblPrio2.setText(String.valueOf(hilo2.getPriority()));
				}
			}
		});
		btnMas2.setBounds(216, 45, 50, 23);
		contentPane.add(btnMas2);
		
		JButton btnMas3 = new JButton("++");
		btnMas3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hilo3.isAlive()) {
					hilo3.setPriority(Thread.MAX_PRIORITY);
					lblPrio3.setText(String.valueOf(hilo3.getPriority()));
				}
			}
		});
		btnMas3.setBounds(216, 82, 50, 23);
		contentPane.add(btnMas3);
		
		JButton btnFinalizarTodos = new JButton("Finalizar Todos");
		btnFinalizarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo1.stop();
				hilo2.stop();
				hilo3.stop();
				try {
					Thread.sleep(150);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				if (!hilo1.isAlive())
					lblPrio1.setText("0");
				if (!hilo2.isAlive())
					lblPrio2.setText("0");
				if (!hilo3.isAlive())
					lblPrio3.setText("0");
			}
		});
		btnFinalizarTodos.setBounds(81, 130, 153, 23);
		contentPane.add(btnFinalizarTodos);
		
		JLabel lblHilo1 = new JLabel("Hilo 1:");
		lblHilo1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHilo1.setBounds(66, 198, 50, 25);
		contentPane.add(lblHilo1);
		
		JLabel lblHilo2 = new JLabel("Hilo 2:");
		lblHilo2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHilo2.setBounds(66, 234, 50, 25);
		contentPane.add(lblHilo2);
		
		JLabel lblHilo3 = new JLabel("Hilo 3:");
		lblHilo3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHilo3.setBounds(66, 270, 50, 25);
		contentPane.add(lblHilo3);
		
		lblCont1 = new JLabel("0");
		lblCont1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCont1.setBounds(117, 198, 40, 25);
		contentPane.add(lblCont1);
		
		lblCont2 = new JLabel("0");
		lblCont2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCont2.setBounds(117, 234, 40, 25);
		contentPane.add(lblCont2);
		
		lblCont3 = new JLabel("0");
		lblCont3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCont3.setBounds(117, 270, 40, 25);
		contentPane.add(lblCont3);
		
		JLabel lblPri1 = new JLabel("Pri 1:");
		lblPri1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPri1.setBounds(182, 198, 50, 25);
		contentPane.add(lblPri1);
		
		lblPrio1 = new JLabel("0");
		lblPrio1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrio1.setBounds(233, 198, 20, 25);
		contentPane.add(lblPrio1);
		
		JLabel lblPri2 = new JLabel("Pri 2:");
		lblPri2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPri2.setBounds(182, 234, 50, 25);
		contentPane.add(lblPri2);
		
		lblPrio2 = new JLabel("0");
		lblPrio2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrio2.setBounds(233, 234, 20, 25);
		contentPane.add(lblPrio2);
		
		JLabel lblPri3 = new JLabel("Pri 3:");
		lblPri3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPri3.setBounds(182, 270, 50, 25);
		contentPane.add(lblPri3);
		
		lblPrio3 = new JLabel("0");
		lblPrio3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrio3.setBounds(233, 270, 20, 25);
		contentPane.add(lblPrio3);
	}
}
