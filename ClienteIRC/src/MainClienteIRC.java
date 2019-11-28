

public class MainClienteIRC {
	public static void main(String[] args) {
		NickCliente vNick = new NickCliente();
		vNick.setVisible(true);
		
		ClienteIRC cliente = new ClienteIRC(vNick);
	}

}
