
public class HiloThread extends Thread {
	public void run() {
		System.out.println("Soy el hilo creado. Voy a contar.");
		while (this.isAlive()) {
			for (int i=1;i<=10;i++) {
				System.out.println("Hilo " + i);
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.stop();
		}
	}
}
