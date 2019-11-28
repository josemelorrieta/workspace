public class MainIRC {
	
	
	public static void main(String[] args) {
		Servidor vServidor = new Servidor();
		vServidor.setVisible(true);
		
		ServidorIRC servidor = new ServidorIRC(vServidor);
		
	}

	private static void salir() {
//		vServidor.dispose();
//		try {
//			if (skCliente != null)
//				skCliente.close();
//			if (skServidor != null) 
//				skServidor.close();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
	}
}
