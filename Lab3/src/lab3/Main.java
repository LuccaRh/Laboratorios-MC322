package lab3;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Criação de clientes e veículos
		ClientePJ AAA = new ClientePJ("AAA", "BG", "36.050.859/0001-52", LocalDate.of(1990, 3, 10));
		ClientePJ BBB = new ClientePJ("BBB", "BG", "71.571.125/0001-10", LocalDate.of(2020, 4, 13));
		ClientePF lucca = new ClientePF("Lucca", "SP", "982.922.580-19", "Masculino", LocalDate.of(2013, 10, 15), "Professor", LocalDate.of(2001, 10, 30), "Média");
		Veículo bmw = new Veículo("NEM-8457", "BMW", "320i", 2022);
		Veículo ferrari = new Veículo("NES-9460", "Ferrari", "SP48", 2019);
		AAA.ListaVeiculos.add(bmw);
		AAA.ListaVeiculos.add(ferrari);
		Veículo Toyota = new Veículo("LMN-4825", "Toyota", "corolla", 2015);
		BBB.ListaVeiculos.add(Toyota);
		Veículo Honda = new Veículo("MSI-6731", "Honda", "civic", 2018);
		lucca.ListaVeiculos.add(Honda);
		System.out.println();
		
		//Validação de cpf e cnpj
		if (AAA.validarCnpj()) {
			System.out.printf("cnpj de %s Válido %n", AAA.getNome());
		}
		if (lucca.validarCpf()) {
			System.out.printf("cpf de %s Válido %n", lucca.getNome());
		};
		System.out.println();
		
		//Criação de seguradora e cadastro e remoção de clientes
		Seguradora seguradoraBG = new Seguradora("SeguradoraBG", "19-997645670", "SeguradoraBG@gmail.com", "BG");
		if (seguradoraBG.cadastrarCliente(lucca)) {
			System.out.printf("%s foi cadastrado na %s %n", lucca.getNome(), seguradoraBG.getNome());
		}
		if (seguradoraBG.cadastrarCliente(AAA)) {
			System.out.printf("%s foi cadastrado na %s %n", AAA.getNome(), seguradoraBG.getNome());
		}
		if (seguradoraBG.cadastrarCliente(BBB)) {
			System.out.printf("%s foi cadastrado na %s %n", BBB.getNome(), seguradoraBG.getNome());
		}
		if (seguradoraBG.removerCliente("BBB")) {
			System.out.printf("%s foi removido da %s %n", BBB.getNome(), seguradoraBG.getNome());
		}
		System.out.println();
		
		//Sinistro
		Sinistro sinistro = new Sinistro(LocalDate.of(2023, 4, 10), "BG", lucca, lucca.ListaVeiculos.get(0));;
		seguradoraBG.gerarSinistro(sinistro);
		System.out.println();
		
		//ToString
		System.out.println("ToString sinistro:");
		System.out.println(sinistro.toString());
		System.out.println("\nToString veículo bmw:");
		System.out.println(bmw.toString());
		System.out.println("\nToString clientePF:");
		System.out.println(lucca.toString());
		System.out.println("\nToString clientePJ:");
		System.out.println(AAA.toString());
		System.out.println();
		
		//
		System.out.println("Controle de métodos da seguradora:");
		System.out.println("\tAperte 1 para usar ListarClientes");
		System.out.println("\tAperte 2 para usar visualizarSinistro");
		System.out.println("\tAperte 3 para usar ListarSinistros");
		System.out.println("\tAperte 4 para sair do controle");
		int a = 0;
		Scanner scanner = new Scanner(System.in);
		while (a != 4) {
			a = scanner.nextInt();
			if (a == 1) {
				seguradoraBG.ListarCLientes();
			}
			else if (a == 2) {
				scanner.nextLine();
				System.out.println("Digite um nome para vizualisar o sinistro:");
				String nome;
				nome = scanner.nextLine();
				seguradoraBG.visualizarSinistro(nome);
			}
			else if (a == 3) {
				seguradoraBG.ListarSinistros();
			}
		}
	}
}
