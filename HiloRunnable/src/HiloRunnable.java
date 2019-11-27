
public class HiloRunnable implements Runnable {
	Thread miThread;
	
	public HiloRunnable() {
		miThread = new Thread(this);
		miThread.start();
	}
	
	public void run() {
		System.out.println("Soy el hilo creado. Voy a contar.");
		while (miThread.isAlive()) {
			for (int i=1;i<=10;i++) {
				System.out.println("Hilo " + i);
				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			miThread.stop();
		}

	}
	
	
}
