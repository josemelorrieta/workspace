
public class PrincipalThread {

	public static void main(String[] args) {
		HiloThread miHilo = new HiloThread();
		miHilo.start();
		
		System.out.println("Hola desde el principal.");
		for (int i=1;i<=10;i++) {
			System.out.println("Principal " + i);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
