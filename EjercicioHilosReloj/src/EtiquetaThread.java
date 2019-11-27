import java.awt.Color;
import java.util.Random;

import javax.swing.JLabel;

public class EtiquetaThread implements Runnable {
	Thread etiqueta;
	JLabel lblMayor, lblMenor;
	
	public EtiquetaThread(JLabel lblMayor, JLabel lblMenor) {
		this.etiqueta = new Thread(this);		
		this.lblMayor = lblMayor;
		this.lblMenor = lblMenor;
	}
	
	@Override
	public void run() {
		while (etiqueta.isAlive()) {
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}

			
			lblMayor.setForeground(new Color(randomColor(), randomColor(), randomColor()));
			lblMenor.setForeground(new Color(randomColor(), randomColor(), randomColor()));
		}
			
	}
		
//	private String randomColor() {
//		Random obj = new Random();
//		int rand_num = obj.nextInt(0xffffff + 1);
//		// format it as hexadecimal string and print
//		String colorCode = String.format("#%06x", rand_num);
//		
//		return colorCode;
//	}
	
	private int randomColor() {
		Random obj = new Random();

		return obj.nextInt(255);
	}
	
	public void start() {
		etiqueta.start();
	}

}
