import javax.swing.JLabel;

public class RelojThread implements Runnable {
	Thread reloj;
	Integer seg;
	Integer min;
	JLabel lblReloj;
	
	public RelojThread(JLabel lblReloj) {
		this.reloj = new Thread(this);
		this.lblReloj = lblReloj;
		this.seg = 0;
		this.min = 0;
	}
	
	public void run() {
		while (reloj.isAlive()) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			seg++;
			
			if (seg == 60) {
				seg = 0;
				min++;
				if (min == 60) {
					min = 0;
				}
			}
			lblReloj.setText(String.format("%02d",min) + ":" + String.format("%02d",seg));
		}
	}
	
	public int getSeg() {
		return this.seg;
	}
	
	public int getMin() {
		return this.min;
	}
	
	public boolean isAlive() {
		if (reloj.isAlive())
			return true;
		else
			return false;
	}
	
	public void start() {
		reloj.start();
	}
	
	public void restart() {
		this.min = 0;
		this.seg = 0;
		lblReloj.setText(String.format("%02d",min) + ":" + String.format("%02d",seg));
	}
	
	@SuppressWarnings("deprecation")
	public void pause() {
		reloj.suspend();
	}
	
	@SuppressWarnings("deprecation")
	public void resume() {
		reloj.resume();
	}
	
	public void stop() {
		reloj.interrupt();
		seg = 0;
		min = 0;
	}
}
