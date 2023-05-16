package lab4;
import java.util.ArrayList;

public class Seguradora {
	private String nome ;
	private String telefone ;
	private String email ;
	private String endereco ;
	private ArrayList<Sinistro> ListaSinistro = new ArrayList<Sinistro>();
	private ArrayList<Cliente> ListaCliente = new ArrayList<Cliente>();
	//Constructor

	public Seguradora(String nome, String telefone, String email, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
	}

	//Getters e Setters
	
	public String getNome() {
		return nome;
	}	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public ArrayList<Sinistro> getListaSinistro() {
		return ListaSinistro;
	}

	public void setListaSinistro(ArrayList<Sinistro> listaSinistro) {
		ListaSinistro = listaSinistro;
	}

	public ArrayList<Cliente> getListaCliente() {
		return ListaCliente;
	}

	public void setListaCliente(ArrayList<Cliente> listaCliente) {
		ListaCliente = listaCliente;
	}

	
	//Métodos
	//Cliente
	public boolean cadastrarCliente(Cliente cliente) {
		if (cliente == null) {
			return false;
		}
		this.ListaCliente.add(cliente);
		return true;
	}
	
	public boolean removerCliente(String nome) {
	    for (Cliente cliente : this.ListaCliente) {
	        if (cliente.getNome().equalsIgnoreCase(nome)) { 
	        	this.ListaCliente.remove(cliente); 
	            return true; 
	        }
	    }
	    return false;
	}
	
	public void ListarCLientes() {
		for(Cliente cliente: this.ListaCliente) {
			System.out.println(cliente.toString());
		}
	}
	public void TransferirSeguro(Cliente clientet, Cliente clienter) {
		clienter.setValorSeguro(clienter.getValorSeguro() + clientet.getValorSeguro());
		clientet.setValorSeguro(0);
		clienter.ListaVeiculos.addAll(clientet.ListaVeiculos);
		clientet.ListaVeiculos.clear();
	}
	
	//Veiculos
	public boolean CadastrarVeiculo(String nome, Veículo veiculo) {
		for (Cliente cliente : this.ListaCliente) {
	        if (cliente.getNome().equalsIgnoreCase(nome)) { 
	        	cliente.ListaVeiculos.add(veiculo);
	        	System.out.println("Veículo cadastrado.");
	            return true; 
	        }
	    }
	    return false;
	}
	
	public boolean visualizarVeiculos(String nome) {
		for (Cliente cliente : this.ListaCliente) {
	        if (cliente.getNome().equalsIgnoreCase(nome)) { 
	        	for (Veículo veiculo : cliente.ListaVeiculos) {
	        		System.out.println(veiculo.toString());
	        	}
	            return true; 
	        }
	    }
	    return false;
	}
	
	public void ListarVeiculos() {
		for (Cliente cliente : this.ListaCliente) {
			for (Veículo veiculo : cliente.ListaVeiculos) {
	        	System.out.println(veiculo.toString());
	        }
	    }
	}
	public boolean removerVeiculo(String placa) {
		for (Cliente cliente : this.ListaCliente) {
			for (Veículo veiculo : cliente.ListaVeiculos) {
				if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
					cliente.ListaVeiculos.remove(veiculo);
					return true;
				}
	        }
	    }
		return false;
	}
	
	//Sinistro
	public boolean gerarSinistro(Sinistro sinistro) {
		if (sinistro == null) {
			return false;
		}
		this.ListaSinistro.add(sinistro);
		return true;
	}
	
	public void visualizarSinistro(String nome) {
	    for (Sinistro sinistro : this.ListaSinistro) {
	        if (sinistro.cliente.getNome().equalsIgnoreCase(nome)) { 
	        	System.out.println(sinistro.toString());
	        }
	    }
	}
	public void ListarSinistros() {
		for (Sinistro sinistro : this.ListaSinistro) {
			System.out.println(sinistro.toString());
		}
	}
	public boolean removerSinistro(int id) {
		for (Sinistro sinistro : this.ListaSinistro) {
	        if (sinistro.getId() == id) { 
	        	this.ListaSinistro.remove(sinistro);
	            return true; 
	        }
	    }
	    return false;
	}
	
	//Calculos
	public double calcularPrecoSeguroCliente(String nome) {
		for (Cliente cliente : this.ListaCliente) {
	        if (cliente.getNome().equalsIgnoreCase(nome)) { 
	        	double resultado = cliente.calculaScore() * (1 + this.ListaSinistro.size());
	        	return resultado;
	        }
	    }
		return 0;
	}
	public double calcularReceita() {
		double resultado = 0;
		for (Cliente cliente : this.ListaCliente) {
	        resultado += calcularPrecoSeguroCliente(cliente.getNome());
	    }
		return resultado;
	}
}