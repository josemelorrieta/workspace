
public class HiloThread extends Thread {
	private int cont;
	
	public HiloThread() {
		this.cont = 0;
	}
	
	public void run() {
		while (this.isAlive()) {
			this.cont += 1;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public int getCont() {
		return cont;
	}

}
