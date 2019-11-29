public class MainIRC {
	
	
	public static void main(String[] args) {
		Servidor vServidor = new Servidor();
		vServidor.setVisible(true);
		
		ServidorIRC servidor = new ServidorIRC(vServidor);
		
	}

}
