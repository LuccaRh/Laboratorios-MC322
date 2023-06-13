package lab5;
import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		//Veiculos e Frotas
		Veículo bmw = new Veículo("NEM-8457", "BMW", "320i", 2022);
		Veículo ferrari = new Veículo("NES-9460", "Ferrari", "SP48", 2019);
		Veículo toyota = new Veículo("LMN-4825", "Toyota", "corolla", 2015);
		Veículo honda = new Veículo("MSI-6731", "Honda", "civic", 2018);
		ArrayList<Veículo> listaVeiculoAAA = new ArrayList<Veículo>(Arrays.asList(bmw, ferrari));
		ArrayList<Veículo> listaVeiculoBBB = new ArrayList<Veículo>(Arrays.asList(toyota, honda));
		ArrayList<Veículo> listaVeiculolucca = new ArrayList<Veículo>(Arrays.asList(toyota));
		ArrayList<Veículo> listaVeiculoewertom = new ArrayList<Veículo>(Arrays.asList(honda));
		Frota frotaAAA = new Frota("AAAf", listaVeiculoAAA);
		Frota frotaBBB = new Frota("BBBf", listaVeiculoBBB);
		ArrayList<Frota> listaFrotaAAA = new ArrayList<Frota>(Arrays.asList(frotaAAA));
		ArrayList<Frota> listaFrotaBBB = new ArrayList<Frota>(Arrays.asList(frotaBBB));
		System.out.println("ToString Veículo bmw:");
		System.out.println(bmw.toString());
		System.out.println("ToString Frota AAA:");
		System.out.println(frotaAAA.toString());
		System.out.println();
		
		//Criação de clientes
		ClientePJ AAA = new ClientePJ("AAA", "BG", "AAA@gmail.com", "19992855740", "36.050.859/0001-52", LocalDate.of(1990, 3, 10), 20, listaFrotaAAA);
		ClientePJ BBB = new ClientePJ("BBB", "BG", "BBB@gmail.com", "19993267740", "71.571.125/0001-10", LocalDate.of(2020, 4, 13), 35, listaFrotaBBB);
		ClientePF lucca = new ClientePF("Lucca", "SP", "lucca@gmail.com", "11993202740", "982.922.580-19", "Masculino", "Faculdade", LocalDate.of(2002, 10, 15), listaVeiculolucca);
		ClientePF ewertom = new ClientePF("Ewertom", "SP", "ewertom@gmail.com", "11993209430", "891.374.130-07", "Masculino", "Ensino Médio", LocalDate.of(1994, 5, 12), listaVeiculoewertom);
		System.out.println("ToString ClientePJ AAA:");
		System.out.println(AAA.toString());
		System.out.println("ToString ClientePF lucca:");
		System.out.println(lucca.toString());
		System.out.println();
		
		//Condutor
		Condutor condutor1 = new Condutor("893.574.150-76", "João Silva", "19987654321", "Rua A, 123", "joao@gmail.com", LocalDate.of(1990, 5, 15), new ArrayList<Sinistro>());
		Condutor condutor2 = new Condutor("410.865.910-46", "Maria Souza", "11123456789", "Rua B, 456", "maria@gmail.com", LocalDate.of(1985, 8, 20), new ArrayList<Sinistro>());
		ArrayList<Condutor> listaCondutorAAA = new ArrayList<Condutor>(Arrays.asList(condutor1, condutor2));
		Condutor condutor3 = new Condutor("079.968.870-39", "Pedro Alves", "19123456789", "Av. C, 789", "pedro@gmail.com", LocalDate.of(1992, 3, 10), new ArrayList<Sinistro>());
        Condutor condutor4 = new Condutor("457.176.000-03", "Ana Oliveira", "11987654321", "Rua X, 789", "ana@gmail.com", LocalDate.of(1995, 10, 3), new ArrayList<Sinistro>());
        ArrayList<Condutor> listaCondutorBBB = new ArrayList<Condutor>(Arrays.asList(condutor3, condutor4));
        Condutor condutor5 = new Condutor("982.922.580-19", "Lucca", "11993202740", "SP", "lucca@gmail.com",  LocalDate.of(2002, 10, 15), new ArrayList<Sinistro>());
        ArrayList<Condutor> listaCondutorLucca = new ArrayList<Condutor>(Arrays.asList(condutor5));
        Condutor condutor6 = new Condutor("891.374.130-07", "Ewertom", "11993209430", "SP", "ewertom@gmail.com",  LocalDate.of(1994, 5, 12), new ArrayList<Sinistro>());
        ArrayList<Condutor> listaCondutorEwertom = new ArrayList<Condutor>(Arrays.asList(condutor6));
        System.out.println("ToString Condutor1:");
		System.out.println(condutor1.toString());
		System.out.println();
		
        //Seguradora
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>(Arrays.asList(AAA, BBB, lucca, ewertom));
        Seguradora seguradoraBG = new Seguradora("SeguradoraBG", "19-997645670", "SeguradoraBG@gmail.com", "BG", "21.901.626/0001-49", new ArrayList<Seguro>(), listaClientes);
        System.out.println("ToString SeguradoraBG:");
		System.out.println(seguradoraBG.toString());
		System.out.println();
		
        //Seguros
        seguradoraBG.gerarSeguro(LocalDate.of(2010, 3, 10), LocalDate.of(2024, 3, 10), seguradoraBG.getListaCliente().get(0), null, ((ClientePJ)seguradoraBG.getListaCliente().get(0)).getListaFrota().get(0), new ArrayList<Sinistro>(), listaCondutorAAA);
		seguradoraBG.gerarSeguro(LocalDate.of(2015, 4, 12), LocalDate.of(2026, 4, 12), seguradoraBG.getListaCliente().get(1), null, ((ClientePJ)seguradoraBG.getListaCliente().get(1)).getListaFrota().get(0), new ArrayList<Sinistro>(), listaCondutorBBB);
		seguradoraBG.gerarSeguro(LocalDate.of(2020, 12, 12), LocalDate.of(2034, 12, 12), seguradoraBG.getListaCliente().get(2), ((ClientePF)seguradoraBG.getListaCliente().get(2)).getListaVeiculos().get(0), null, new ArrayList<Sinistro>(), listaCondutorLucca);
		seguradoraBG.gerarSeguro(LocalDate.of(2019, 5, 5), LocalDate.of(2032, 5, 5), seguradoraBG.getListaCliente().get(3), ((ClientePF)seguradoraBG.getListaCliente().get(3)).getListaVeiculos().get(0), null, new ArrayList<Sinistro>(), listaCondutorEwertom);
		System.out.println("ToString SeguroPJ AAA:");
		System.out.println(seguradoraBG.getListaSeguros().get(0).toString());
		System.out.println("ToString SeguroPF lucca:");
		System.out.println(seguradoraBG.getListaSeguros().get(2).toString());
		System.out.println();
		
		//Sinistros
		seguradoraBG.getListaSeguros().get(0).gerarSinistro(LocalDate.of(2010, 3, 11), "Rua G 120", seguradoraBG.getListaSeguros().get(0).getListaCondutor().get(1));
		seguradoraBG.getListaSeguros().get(1).gerarSinistro(LocalDate.of(2018, 10, 9), "Rua Y 110", seguradoraBG.getListaSeguros().get(1).getListaCondutor().get(0));
		seguradoraBG.getListaSeguros().get(2).gerarSinistro(LocalDate.of(2021, 6, 6), "Rua U 58", seguradoraBG.getListaSeguros().get(0).getListaCondutor().get(0));
		seguradoraBG.getListaSeguros().get(3).gerarSinistro(LocalDate.of(2023, 4, 6), "Rua X 18", seguradoraBG.getListaSeguros().get(0).getListaCondutor().get(0));
		System.out.println("ToString Sinistro AAA:");
		System.out.println(seguradoraBG.getListaSeguros().get(0).getListaSinistro().get(0));
		System.out.println();
		
	}
}
