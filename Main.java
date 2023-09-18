package CachorroQuenteQueGeraArvores;

import java.util.Scanner;

public class Main {
	public static Scanner leitor = new Scanner(System.in);

	public static Cliente criarCliente() {
		System.out.println("Digite seu nome:");
		String nome = leitor.nextLine();
		System.out.println("Digite sua matrícula:");
		int numeroMatricula = leitor.nextInt();
		return new Cliente(nome, numeroMatricula);
	}

	public static boolean decidirAdicionais(String complemento) {
		Scanner leitor2 = new Scanner(System.in);
		System.out.println("Você deseja adicionar o complemento " + complemento + " ?");
		String resposta = leitor2.nextLine();
		if (resposta.toLowerCase().equals("sim"))
			return true;
		else
			return false;
	}

	public static CachorroQuente criarCachorro() {
		Scanner leitor3 = new Scanner(System.in);
		System.out.print("Digite sua proteina: ");
		String proteina = leitor3.nextLine();
		System.out.print("Digite seu queijo: ");
		String queijo = leitor3.nextLine();
		System.out.print("Digite sua bebida: ");
		String bebida = leitor3.nextLine();
		boolean maionese = decidirAdicionais("maionese");
		boolean ketchup = decidirAdicionais("ketchup");
		boolean ovo = decidirAdicionais("ovo");
		boolean batataFrita = decidirAdicionais("batata frita");
		return new CachorroQuente(proteina, queijo, bebida, maionese, ketchup, ovo, batataFrita);
	}

	public static void imprimirPedido(Pedido pedido) {
		System.out.println("\n\n CLIENTE");
		System.out.println("Nome: " + pedido.cliente.nome);
		System.out.println("Matricula: " + pedido.cliente.numeroMatricula);
		for (int i = 0; i < pedido.cachorroQuente.length; i++) {
			System.out.println("\n\nCachorro quente n: " + (i + 1));
			System.out.println("Proteina: " + pedido.cachorroQuente[i].proteina);
			System.out.println("Queijo: " + pedido.cachorroQuente[i].queijo);
			System.out.println("Bebida: " + pedido.cachorroQuente[i].bebida);
			System.out.print("Complementos: ");
			if (pedido.cachorroQuente[i].maionese) {
				System.out.print("Maionese; ");
			}
			if (pedido.cachorroQuente[i].ketchup) {
				System.out.print("ketchup; ");
			}
			if (pedido.cachorroQuente[i].ovo) {
				System.out.print("ovo; ");
			}
			if (pedido.cachorroQuente[i].batataFrita) {
				System.out.print("batata frita;");
			}
		}
	}

	public static void main(String[] args) {
		Cliente cliente = criarCliente();
		System.out.println("Escolha quantos cachorros quentes serão comprados: ");
		int quantidade = leitor.nextInt();
		CachorroQuente cachorro[] = new CachorroQuente[quantidade];
		for (int i = 0; i < quantidade; i++) {
			cachorro[i] = criarCachorro();
		}
		Pedido pedido = new Pedido(cliente, cachorro);
		imprimirPedido(pedido);
		leitor.close();
	}

}

