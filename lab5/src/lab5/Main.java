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
		
		int a = 0;
		Scanner scanner = new Scanner(System.in);
		Seguradora seguradora;
		boolean loop = true;
		while (loop) {
			System.out.println("Menu Principal:");
			System.out.println("\t1 - Cadastros");
			System.out.println("\t2 - Gerar Seguro ou Sinistro");
			System.out.println("\t3 - Excluir");
			System.out.println("\t4 - Listar");
			System.out.println("\t5 - Calcular receita da seguradora");
			System.out.println("\t6 - Sair");
			a = scanner.nextInt();
			scanner.nextLine();
			switch(MenuOperacoes.values()[a-1]) {
				case CADASTROS:
					System.out.println("Menu de Cadastros:");
					System.out.println("\t1 - Cadastrar Cliente PF/PJ");
					System.out.println("\t2 - Cadastrar Veículo em Cliente PF");
					System.out.println("\t3 - Cadastrar Frota em Cliente PJ");
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
							
							System.out.println("Telefone:");
							String telefone = scanner.nextLine();
							
							System.out.println("Endereço:");
							String endereco = scanner.nextLine();
							
							System.out.println("Email:");
							String email = scanner.nextLine();
							
							System.out.println("Cpf:");
							String cpf = scanner.nextLine();
							
							System.out.println("Gênero:");
							String genero = scanner.nextLine();
							
							System.out.println("Educação:");
							String educacao = scanner.nextLine();
							
							System.out.print("Data de Nascimento no formato dd/MM/yyyy: ");
					        String data2 = scanner.nextLine();
					        LocalDate dataNascimento = LocalDate.parse(data2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
							
							
							ClientePF clientePF = new ClientePF(nome,endereco, email, telefone, cpf, genero,educacao, dataNascimento, new ArrayList<Veículo>());
							if (Validacao.ValidacaoStatic.validarCpf(clientePF.getCpf())) {
								if (Validacao.ValidacaoStatic.validaNome(clientePF.getNome())) {
									if (seguradoraBG.cadastrarCliente(clientePF)) {
										System.out.printf("%s foi cadastrado na %s %n", clientePF.getNome(), seguradoraBG.getNome());
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
							
							System.out.println("Telefone:");
							String telefone = scanner.nextLine();
							
							System.out.println("Endereço:");
							String endereco = scanner.nextLine();
							
							System.out.println("Email:");
							String email = scanner.nextLine();
														
							System.out.println("Cnpj:");
							String cnpj = scanner.nextLine();
							
							System.out.print("Data de Fundação no formato dd/MM/yyyy: ");
					        String data = scanner.nextLine();
					        LocalDate dataFundacao = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
							
					        System.out.println("Quantidade de Funcionários:");
							int qtdeFuncionarios = scanner.nextInt();
							
							ClientePJ clientePJ = new ClientePJ(nome,endereco,telefone, email,cnpj, dataFundacao,qtdeFuncionarios, new ArrayList<Frota>());
							if (Validacao.ValidacaoStatic.validarCnpj(clientePJ.getCnpj())) {
								if (Validacao.ValidacaoStatic.validaNome(clientePJ.getNome())) {
									if (seguradoraBG.cadastrarCliente(clientePJ)) {
										System.out.printf("%s foi cadastrado na %s %n", clientePJ.getNome(), seguradoraBG.getNome());
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
				    	System.out.println("Placa:");
						String placa = scanner.nextLine();
						
						System.out.println("Marca:");
						String marca = scanner.nextLine();
						
						System.out.println("Modelo:");
						String modelo = scanner.nextLine();
						
						System.out.println("Ano de Fabricação:");
						int anoFabricacao = scanner.nextInt();
						scanner.nextLine();
						
						Veículo veiculo = new Veículo(placa, marca, modelo, anoFabricacao);
						
						System.out.println("Digite o cpf do cliente que terá o veículo cadastrado:");
						String cpfin;
						cpfin = scanner.nextLine();
						for (Cliente cliente: seguradoraBG.getListaCliente()) {
							if (cliente instanceof ClientePF) {
								ClientePF clientepf = (ClientePF) cliente;
								if (clientepf.getCpf().equalsIgnoreCase(cpfin)) {
									clientepf.cadastrarVeiculo(veiculo);
									System.out.println("Veículo cadastrado.");
								}
							}
						}
						continue;
						
				   }
				    else if (opcao == 3) {
				    	System.out.println("Cadastro de frota:");
				    	System.out.println("Código da frota:");
				    	String code = scanner.nextLine();
				    	
				    	System.out.println("Quantos veículos deseja incluir na frota?");
				    	ArrayList<Veículo> lista = new ArrayList<Veículo>();
				    	int qtd = scanner.nextInt();
				    	scanner.nextLine();
				    	for (int i = 0; i<qtd; i++) {
				    		System.out.println("Informações do Veículo que será cadastrado:");
					    	System.out.println("Placa:");
							String placa = scanner.nextLine();
							
							System.out.println("Marca:");
							String marca = scanner.nextLine();
							
							System.out.println("Modelo:");
							String modelo = scanner.nextLine();
							
							System.out.println("Ano de Fabricação:");
							int anoFabricacao = scanner.nextInt();
							scanner.nextLine();
							
							Veículo veiculo = new Veículo(placa, marca, modelo, anoFabricacao);
							lista.add(veiculo);
				    	}
				    	System.out.println("Digite o cnpj do cliente que terá o veículo cadastrado:");
						String cnpj;
						cnpj = scanner.nextLine();
						for (Cliente cliente: seguradoraBG.getListaCliente()) {
							if (cliente instanceof ClientePJ) {
								ClientePJ clientepj = (ClientePJ) cliente;
								if (clientepj.getCnpj().equalsIgnoreCase(cnpj)) {
									Frota frota = new Frota(code, lista);
									clientepj.cadastrarFrota(frota);
									System.out.println("Veículo cadastrado.");
								}
							}
						}
				    	continue;
				   }
				    else if (opcao == 4) {
				    	continue;
				   }
				case GERAR:
					System.out.println("\t1 - Gerar Seguro");
					System.out.println("\t2 - Gerar Sinistro");
					System.out.println("\t3 - Voltar");
					int opcaoge = scanner.nextInt();
				    scanner.nextLine();
				    if (opcaoge == 1) {
				    	System.out.println("Digite 1 para gerar seguro de cliente PF, e 2 para de PJ:");
				    	opcaoge = scanner.nextInt();
				    	scanner.nextLine();
				    	if (opcaoge == 1) {
				    		System.out.println("Gerar seguro para clientePF:");
							System.out.print("Data de início no formato dd/MM/yyyy: ");
					        String datai = scanner.nextLine();
					        LocalDate dataInicio = LocalDate.parse(datai, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
							
					        System.out.print("Data de Fim no formato dd/MM/yyyy: ");
					        String dataf = scanner.nextLine();
					        LocalDate dataFim = LocalDate.parse(dataf, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					        
					        System.out.println("Digite o cpf do clientePF:");
							String cpfin;
							cpfin = scanner.nextLine();
							for (Cliente cliente: seguradoraBG.getListaCliente()) {
								if (cliente instanceof ClientePF) {
									ClientePF clientepf = (ClientePF) cliente;
									if (clientepf.getCpf().equalsIgnoreCase(cpfin)) {
										System.out.println("Digite a placa do Veículo do cliente:");
										String placa;
										placa = scanner.nextLine();
										for (Veículo veiculo : clientepf.getListaVeiculos()) {
											if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
												seguradoraBG.gerarSeguro(dataInicio, dataFim, clientepf, veiculo, null, new ArrayList<Sinistro>(), new ArrayList<Condutor>());
												continue;
											}
										}
									}
								}
							}
				    	}
				    	else if (opcaoge == 2) {
				    		System.out.println("Gerar seguro para clientePJ:");
							System.out.print("Data de início no formato dd/MM/yyyy: ");
					        String datai = scanner.nextLine();
					        LocalDate dataInicio = LocalDate.parse(datai, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
							
					        System.out.print("Data de Fim no formato dd/MM/yyyy: ");
					        String dataf = scanner.nextLine();
					        LocalDate dataFim = LocalDate.parse(dataf, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					        
					        System.out.println("Digite o cnpj do clientePF:");
							String cnpj;
							cnpj = scanner.nextLine();
							for (Cliente cliente: seguradoraBG.getListaCliente()) {
								if (cliente instanceof ClientePJ) {
									ClientePJ clientepj = (ClientePJ) cliente;
									if (clientepj.getCnpj().equalsIgnoreCase(cnpj)) {
										System.out.println("Digite o code da frota do cliente:");
										String code;
										code = scanner.nextLine();
										for (Frota frota : clientepj.getListaFrota()) {
											if (frota.getCode().equalsIgnoreCase(code)) {
												seguradoraBG.gerarSeguro(dataInicio, dataFim, clientepj, null, frota, new ArrayList<Sinistro>(), new ArrayList<Condutor>());
												continue;
											}
										}
									}
								}
							}
				    	}
				    }
				    else if (opcaoge == 2) {
				    	System.out.println("Gerar sinistro:");
				    	System.out.println("Digite o id do seguro:");
				    	opcaoge = scanner.nextInt();
					    scanner.nextLine();
				    	for (Seguro seguro : seguradoraBG.getListaSeguros()) {
				    		if (seguro.getId() == opcaoge) {
								System.out.println("Endereço:");
								String endereco = scanner.nextLine();
								
								System.out.print("Data de Fim no formato dd/MM/yyyy: ");
						        String dataf = scanner.nextLine();
						        LocalDate dataFim = LocalDate.parse(dataf, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
						        
						        System.out.println("Escolha o condutor entre as opções:");
						        for (Condutor condutor : seguro.getListaCondutor()) {
						        	System.out.println(condutor.getNome());
						        }
						        System.out.println("Nome:");
								String nome = scanner.nextLine();
								
								for (Condutor condutor : seguro.getListaCondutor()) {
						        	if (condutor.getNome().equalsIgnoreCase(nome)) {
						        		seguro.gerarSinistro(dataFim, endereco, condutor);
						        		continue;
						        	}
						        }
				    		}
				    	}
				    }
				    else if (opcaoge == 3) {
				    	continue;
				    }
				case EXCLUIR:
					System.out.println("\t1 - Cancelar Seguro");
					System.out.println("\t2 - Remover cliente");
					System.out.println("\t3 - Remover veículo de um clientePF");
					System.out.println("\t4 - Remover veículo de uma frota de clientePJ");
					System.out.println("\t5 - Voltar");
					int opcaoex = scanner.nextInt();
				    scanner.nextLine();
				    if (opcaoex == 1) {
				    	System.out.println("Digite o id do seguro que será cancelado:");
				    	opcaoex = scanner.nextInt();
					    scanner.nextLine();
					    if(seguradoraBG.cancelarSeguro(opcaoex)) {
					    	System.out.println("Seguro removido.");
					    	continue;
					    }
				    }
				    else if (opcaoex == 2) {
				    	System.out.println("Digite o email do cliente que será removido:");
						String email = scanner.nextLine();
						if (seguradoraBG.removerCliente(email)) {
							System.out.println("Cliente removido.");
							continue;
						}
				    }
				    else if (opcaoex == 3) {
				    	System.out.println("Digite o email do clientePF que quer remover um veículo:");
						String email = scanner.nextLine();
						for (Cliente cliente: seguradoraBG.getListaCliente()) {
							if (cliente instanceof ClientePF) {
								ClientePF clientepf = (ClientePF) cliente;
								if (clientepf.getEmail().equalsIgnoreCase(email)) {
									System.out.println("Digite a placa do Veículo do cliente:");
									String placa;
									placa = scanner.nextLine();
									Veículo veiculo1 = new Veículo(null, null, null, 0);
									for (Veículo veiculo : clientepf.getListaVeiculos()) {
										if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
											veiculo1 = veiculo;
										}
									}
									if (veiculo1.getPlaca() != null) {
										clientepf.removerVeiculo(placa);
										System.out.println("Veículo removido.");
									}
								}
							}
						}
						continue;
				    }
				    else if (opcaoex == 4) {
				    	System.out.println("Digite o email do clientePJ que quer remover um veículo da frota:");
						String email = scanner.nextLine();
						for (Cliente cliente: seguradoraBG.getListaCliente()) {
							if (cliente instanceof ClientePJ) {
								ClientePJ clientepj = (ClientePJ) cliente;
								if (clientepj.getEmail().equalsIgnoreCase(email)) {
									System.out.println("Digite o code da Frota do cliente:");
									String code;
									code = scanner.nextLine();
									for (Frota frota : clientepj.getListaFrota()) {
										if (frota.getCode().equalsIgnoreCase(code)) {
											System.out.println("Digite a placa do Veículo do cliente:");
											String placa;
											placa = scanner.nextLine();
											for (Veículo veiculo : frota.getListaVeiculos()) {
												if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
													frota.removeVeiculo(placa);
													continue;
												}
											}
										}
									}
								}
							}
						}
				    }
				    else if (opcaoex == 5) {
				    	continue;
				    }
				case LISTAR:
					System.out.println("\t1 - Listar clientes");
					System.out.println("\t2 - Listar seguro dos clientes");
					System.out.println("\t3 - Listar sinistro dos clientes");
					System.out.println("\t4 - Voltar");
					int opcaoli = scanner.nextInt();
				    scanner.nextLine();
				    if (opcaoli == 1) {
				    	for (Cliente cliente : seguradoraBG.getListaCliente()) {
				    		System.out.println(cliente.toString());
				    	}
				    	continue;
				    }
				    else if (opcaoli == 2) {
				    	for (Cliente cliente : seguradoraBG.getListaCliente()) {
				    		System.out.printf("Seguros de %s %n", cliente.getNome());
				    		for (Seguro seguro : seguradoraBG.getSegurosPorCliente(cliente)) {
				    			System.out.println(seguro.toString());
				    		}
				    	}
				    	continue;
				    }
				    else if (opcaoli == 3) {
				    	for (Cliente cliente : seguradoraBG.getListaCliente()) {
				    		System.out.printf("Sinistros de %s %n", cliente.getNome());
				    		for (Sinistro sinistro : seguradoraBG.getSinistrosPorCliente(cliente)) {
				    			System.out.println(sinistro.toString());
				    		}
				    	}
				    	continue;
				    }
				    else if (opcaoli == 4) {
				    	continue;
				    }
				case CALCULARRECEITA:
					System.out.printf("Receita total: %.2f %n", seguradoraBG.calcularReceita());
				case SAIR:
					loop = false;
					break;
			}
		}
	}
}
