package CachorroQuenteQueGeraArvores;


public class Pedido {
		public Cliente cliente;
		public CachorroQuente cachorroQuente[];
		
		public Pedido(Cliente cliente, CachorroQuente cachorroQuente[]) {
			this.cliente = cliente;
			this.cachorroQuente = cachorroQuente;
		}
		
}
