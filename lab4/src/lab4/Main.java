package lab4;
import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {
		//Criação de clientes e veículos
		ClientePJ AAA = new ClientePJ("AAA", "BG", 0, "36.050.859/0001-52", LocalDate.of(1990, 3, 10), 20);
		ClientePJ BBB = new ClientePJ("BBB", "BG", 0, "71.571.125/0001-10", LocalDate.of(2020, 4, 13), 35);
		ClientePF lucca = new ClientePF("Lucca", "SP", 0, "982.922.580-19", "Masculino", LocalDate.of(2013, 10, 15), "Professor", LocalDate.of(2001, 10, 30), "Média");
		Veículo bmw = new Veículo("NEM-8457", "BMW", "320i", 2022);
		Veículo ferrari = new Veículo("NES-9460", "Ferrari", "SP48", 2019);
		AAA.ListaVeiculos.add(bmw);
		AAA.ListaVeiculos.add(ferrari);
		Veículo Toyota = new Veículo("LMN-4825", "Toyota", "corolla", 2015);
		BBB.ListaVeiculos.add(Toyota);
		Veículo Honda = new Veículo("MSI-6731", "Honda", "civic", 2018);
		lucca.ListaVeiculos.add(Honda);
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
		System.out.println();
		
		//Sinistro
		Sinistro sinistro1 = new Sinistro(LocalDate.of(2023, 4, 10), "BG", lucca, lucca.ListaVeiculos.get(0), seguradoraBG);;
		seguradoraBG.gerarSinistro(sinistro1);
		Sinistro sinistro2 = new Sinistro(LocalDate.of(2023, 5, 15), "BG", AAA, AAA.ListaVeiculos.get(0), seguradoraBG);;
		seguradoraBG.gerarSinistro(sinistro2);
		System.out.println();
		
		//Valor Seguro
		lucca.setValorSeguro(seguradoraBG.calcularPrecoSeguroCliente(lucca.getNome()));
		AAA.setValorSeguro(seguradoraBG.calcularPrecoSeguroCliente(AAA.getNome()));
		BBB.setValorSeguro(seguradoraBG.calcularPrecoSeguroCliente(BBB.getNome()));

		int a = 0;
		Scanner scanner = new Scanner(System.in);
		Seguradora seguradora;
		boolean loop = true;
		while (loop) {
			System.out.println("Menu Principal:");
			System.out.println("\t1 - Cadastros");
			System.out.println("\t2 - Listar");
			System.out.println("\t3 - Excluir");
			System.out.println("\t4 - Gerar Sinistro");
			System.out.println("\t5 - Transferir Seguro");
			System.out.println("\t6 - Calcular Receita Seguradora");
			System.out.println("\t7 - Sair");
			a = scanner.nextInt();
			scanner.nextLine();
			switch(MenuOperacoes.values()[a-1]) {
				case CADASTROS:
					System.out.println("Menu de Cadastros:");
					System.out.println("\t1 - Cadastrar Cliente PF/PJ");
					System.out.println("\t2 - Cadastrar Veículo");
					System.out.println("\t3 - Cadastrar Seguradora");
					System.out.println("\t4 - Voltar");
				    int opcao = scanner.nextInt();
				    scanner.nextLine();
				    if (opcao == 1) {
				    	System.out.println("Digite 1 para cadastrar um cliente PF, e 2 para um PJ:");
				    	opcao = scanner.nextInt();
				    	scanner.nextLine();
				    	if (opcao == 1) {
				    		System.out.println("Cadastro para cliente PF:");
							System.out.println("Nome:");
							String nome = scanner.nextLine();
							
							System.out.println("Endereço:");
							String endereco = scanner.nextLine();
														
							System.out.println("Cpf:");
							String cpf = scanner.nextLine();
							
							System.out.println("Gênero:");
							String genero = scanner.nextLine();
							
							System.out.print("Data de Licença no formato dd/MM/yyyy: ");
					        String data = scanner.nextLine();
					        LocalDate dataLicenca = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
							
							System.out.println("Educação:");
							String educacao = scanner.nextLine();
							
							System.out.print("Data de Nascimento no formato dd/MM/yyyy: ");
					        String data2 = scanner.nextLine();
					        LocalDate dataNascimento = LocalDate.parse(data2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
							
							System.out.println("Classe Econômica:");
							String classeEconomica = scanner.nextLine();
							
							ClientePF clientePF = new ClientePF(nome,endereco,0,cpf, genero,dataLicenca,educacao,dataNascimento,classeEconomica);
							if (Validacao.ValidacaoStatic.validarCpf(clientePF.getCpf())) {
								if (Validacao.ValidacaoStatic.validaNome(clientePF.getNome())) {
									if (seguradoraBG.cadastrarCliente(clientePF)) {
										System.out.printf("%s foi cadastrado na %s %n", clientePF.getNome(), seguradoraBG.getNome());
										clientePF.setValorSeguro(seguradoraBG.calcularPrecoSeguroCliente(clientePF.getNome()));
										System.out.println();
									}
									else{
										System.out.println("Erro ao cadastrar.");
									}
								}
							}
							else {
								System.out.println("Cpf inválido.");
							}
							continue;
				 		}
				 		if (opcao == 2) {
				 			System.out.println("Cadastro para cliente PJ:");
							System.out.println("Nome:");
							String nome = scanner.nextLine();
							
							System.out.println("Endereço:");
							String endereco = scanner.nextLine();
														
							System.out.println("Cnpj:");
							String cnpj = scanner.nextLine();
							
							System.out.print("Data de Fundação no formato dd/MM/yyyy: ");
					        String data = scanner.nextLine();
					        LocalDate dataFundacao = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
							
					        System.out.println("Quantidade de Funcionários:");
							int qtdeFuncionarios = scanner.nextInt();
							
							ClientePJ clientePJ = new ClientePJ(nome,endereco,0,cnpj, dataFundacao,qtdeFuncionarios);
							if (Validacao.ValidacaoStatic.validarCnpj(clientePJ.getCnpj())) {
								if (Validacao.ValidacaoStatic.validaNome(clientePJ.getNome())) {
									if (seguradoraBG.cadastrarCliente(clientePJ)) {
										System.out.printf("%s foi cadastrado na %s %n", clientePJ.getNome(), seguradoraBG.getNome());
										clientePJ.setValorSeguro(seguradoraBG.calcularPrecoSeguroCliente(clientePJ.getNome()));
										System.out.println();
									}
									else{
										System.out.println("Erro ao cadastrar.");
									}
								}
							}
							else {
								System.out.println("Cnpj inválido.");
							}
							continue;
				 		}
				   }
				    else if (opcao == 2) {
				    	System.out.println("Informações do Veículo que será cadastrado:");
				    	scanner.nextLine();
						System.out.println("Placa:");
						String placa = scanner.nextLine();
						
						scanner.nextLine();
						System.out.println("Marca:");
						String marca = scanner.nextLine();
						
						scanner.nextLine();
						System.out.println("Modelo:");
						String modelo = scanner.nextLine();
						
						System.out.println("Ano de Fabricação:");
						int anoFabricacao = scanner.nextInt();
						
						Veículo veiculo = new Veículo(placa, marca, modelo, anoFabricacao);
						
						scanner.nextLine();
						System.out.println("Nome do cliente:");
						String nome = scanner.nextLine();
						
						seguradoraBG.CadastrarVeiculo(nome, veiculo);
						continue;
						
				   }
				    else if (opcao == 4) {
				    	continue;
				   }
				    
				case LISTAR:
					System.out.println("Menu de Listagem:");
					System.out.println("\t1 - Listar Cliente PF/PJ por Seguradora");
					System.out.println("\t2 - Listar Sinistros por Seguradora");
					System.out.println("\t3 - Listar Sinistro por Cliente");
					System.out.println("\t4 - Listar Veículo por Cliente");
					System.out.println("\t5 - Listar Veículo por Seguradora");
					System.out.println("\t6 - Voltar");
				    int opcaoli = scanner.nextInt();
				    scanner.nextLine();
				    if (opcaoli == 1) {
				    	seguradoraBG.ListarCLientes();
				    	continue;
				   }
				    else if (opcaoli == 2) {
				    	seguradoraBG.ListarSinistros();
				    	continue;
				   }
				    else if (opcaoli == 3) {
						System.out.println("Digite um nome para vizualisar o sinistro:");
						String nome;
						nome = scanner.nextLine();
						seguradoraBG.visualizarSinistro(nome);
						continue;
				    }
				    else if (opcaoli == 4) {
						System.out.println("Digite um nome para vizualisar os veiculos:");
						String nome;
						nome = scanner.nextLine();
						seguradoraBG.visualizarVeiculos(nome);
						continue;
				    }
				    else if (opcaoli == 5) {
				    	seguradoraBG.ListarVeiculos();
				    	continue;
				    }
				    else if (opcaoli == 6) {
				    	continue;
				   }
				case EXCLUIR:
					System.out.println("Menu de Excluir:");
					System.out.println("\t1 - Excluir cliente");
					System.out.println("\t2 - Excluir Veículo");
					System.out.println("\t3 - Excluir Sinistro");
					System.out.println("\t4 - Voltar");
				    int opcaoex = scanner.nextInt();
				    scanner.nextLine();
				     
				    if (opcaoex == 1) {
						System.out.println("Digite um nome para excluir cliente da seguradora:");
						String nome;
						nome = scanner.nextLine();
						seguradoraBG.removerCliente(nome);
						continue;
				   }
				    else if (opcaoex == 2) {
						System.out.println("Digite uma placa para remover o veiculo:");
						String placa;
						placa = scanner.nextLine();
						seguradoraBG.removerVeiculo(placa);
						continue;
				   }
				    else if (opcaoex == 3) {
						System.out.println("Digite um id para remover o sinistro:");
						int id;
						id = scanner.nextInt();
						seguradoraBG.removerSinistro(id);
						continue;
				    }
				    else if (opcaoex == 4) {
				    	continue;
				   }
				case GERARSINISTRO:
					System.out.println("Data no formato dd/MM/yyyy: ");
			        String data1 = scanner.nextLine();
			        LocalDate data = LocalDate.parse(data1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					
					System.out.println("Endereço:");
					String endereco = scanner.nextLine();
					
					System.out.println("Digite o nome de um dos clientes abaixo para vincular ao sinistro:");
					for (Cliente cliente : seguradoraBG.getListaCliente()) {
						System.out.println(cliente.getNome());
					}
					String nome;
					nome = scanner.nextLine();
					Cliente clienteSeguro;
					Veículo veiculoSeguro;
					Sinistro sinistro;
					for (Cliente cliente : seguradoraBG.getListaCliente()) {
						if (cliente.getNome().equalsIgnoreCase(nome)) {
							clienteSeguro = cliente;
							System.out.println("Digite a placa de um dos veiculos do cliente para vincular ao sinistro:");
							for (Veículo veiculo : clienteSeguro.ListaVeiculos) {
								System.out.println(veiculo.getPlaca());
							}
							String placa;
							placa = scanner.nextLine();
							for (Veículo veiculo : clienteSeguro.getListaVeiculos()) {
								if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
									veiculoSeguro = veiculo;
									sinistro = new Sinistro(data, endereco, clienteSeguro, veiculoSeguro, seguradoraBG);
									seguradoraBG.gerarSinistro(sinistro);
									System.out.println(sinistro.toString());
									System.out.println("Sinistro atualizado.");
								}
							}
						}
					}
					continue;
				case TRANSFERIRSEGURO:
					System.out.println("Nomes de todos clientes da seguradora:");
					for (Cliente cliente : seguradoraBG.getListaCliente()) {
						System.out.println(cliente.getNome());
					}
					System.out.println("Digite o nome do cliente que quer transferir seu seguro:");
					String nomet;
					nomet = scanner.nextLine();
					Cliente clienteTransferir;
					Cliente clienteReceber;
					for (Cliente clientet : seguradoraBG.getListaCliente()) {
						if (clientet.getNome().equalsIgnoreCase(nomet)) {
							clienteTransferir = clientet;
							System.out.println("Digite o nome do cliente que quer receber o seguro:");
							String nomer;
							nomer = scanner.nextLine();
							for (Cliente clienter : seguradoraBG.getListaCliente()) {
								if (clienter.getNome().equalsIgnoreCase(nomer)) {
									clienteReceber = clienter;
									seguradoraBG.TransferirSeguro(clienteTransferir, clienteReceber);
									System.out.println("Seguros Atualizados");
								}
							}
						}
					}
					continue;
				case CALCRECEITASEGURADORA:
					System.out.printf("O valor da receita da seguradora é de %.2f reais %n", seguradoraBG.calcularReceita());
					continue;
				case SAIR:
					loop = false;
					break;
			}
		}
	}
}
