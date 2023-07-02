package lab6;
import java.time.LocalDate;
import java.util.ArrayList;


public class Seguradora {
	private String nome ;
	private String telefone ;
	private String email ;
	private String endereco ;
	private String cnpj;
	private ArrayList<Seguro> listaSeguros = new ArrayList<Seguro>();
	private ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
	//Constructor
	public Seguradora(String nome, String telefone, String email, String endereco, String cnpj,
			ArrayList<Seguro> listaSeguros, ArrayList<Cliente> listaCliente) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.cnpj = cnpj;
		this.listaSeguros = listaSeguros;
		this.listaCliente = listaCliente;
	}
	

	//Getters e Setters
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
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

	public ArrayList<Seguro> getListaSeguros() {
		return listaSeguros;
	}

	public void setListaSeguros(ArrayList<Seguro> listaSeguros) {
		listaSeguros = listaSeguros;
	}

	public ArrayList<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(ArrayList<Cliente> listaCliente) {
		listaCliente = listaCliente;
	}

	
	//Métodos
	//Cliente
	public boolean cadastrarCliente(Cliente cliente) {
		if (cliente == null) {
			return false;
		}
		this.listaCliente.add(cliente);
		return true;
	}
	
	public boolean removerCliente(String email) {
	    for (Cliente cliente : this.listaCliente) {
	        if (cliente.getEmail().equalsIgnoreCase(email)) { 
	        	this.listaCliente.remove(cliente); 
	            return true; 
	        }
	    }
	    return false;
	}
	
	public void ListarCLientes() {
		for(Cliente cliente: this.listaCliente) {
			System.out.println(cliente.toString());
		}
	}
	
	//Seguro
	public boolean gerarSeguro(LocalDate dataInicio, LocalDate dataFim, Cliente cliente, Veículo veiculo, Frota frota, ArrayList<Sinistro> listaSinistro, ArrayList<Condutor> listaCondutor) {
		if (cliente instanceof ClientePF) {
			SeguroPF seguro = new SeguroPF(dataInicio, dataFim, this, listaSinistro, listaCondutor, veiculo, (ClientePF) cliente);
			this.listaSeguros.add(seguro);
			return true;
		}
		else if (cliente instanceof ClientePJ) {
			SeguroPJ seguro = new SeguroPJ(dataInicio, dataFim, this, listaSinistro, listaCondutor, frota, (ClientePJ) cliente);
			this.listaSeguros.add(seguro);
			return true;
		}
		
		return false;
	}
	
	public boolean cancelarSeguro(int id) {
		for (Seguro seguro : this.listaSeguros) {
	        if (seguro.getId() == id) { 
	        	this.listaSeguros.remove(seguro);
	            return true; 
	        }
	    }
	    return false;
	}
	public ArrayList<Seguro> getSegurosPorCliente(Cliente cliente){
		ArrayList<Seguro> listaSegurosCliente = new ArrayList<Seguro>();
		for (Seguro seguro : this.listaSeguros) {
			if (seguro.getCliente().equals(cliente)) {
				listaSegurosCliente.add(seguro);
			}
		}
		return listaSegurosCliente;
	}
	public ArrayList<Sinistro> getSinistrosPorCliente(Cliente cliente){
		ArrayList<Sinistro> listaSinistrosCliente = new ArrayList<Sinistro>();
		for (Seguro seguro : this.listaSeguros) {
			if (seguro.getCliente().equals(cliente)) {
				listaSinistrosCliente.addAll(seguro.getListaSinistro());
			}
		}
		return listaSinistrosCliente;
	}
	public ArrayList<Sinistro> getSinistrosPorCondutores(Cliente cliente){
		ArrayList<Sinistro> listaSinistrosCondutores = new ArrayList<Sinistro>();
		for (Seguro seguro : this.listaSeguros) {
			if (seguro.getCliente().equals(cliente)) {
				for (Condutor condutor : seguro.getListaCondutor()) {
					listaSinistrosCondutores.addAll(condutor.getListaSinistro());
				}
			}
		}
		
		return listaSinistrosCondutores;
	} 
	
	public ArrayList<Veículo> getVeiculosPorClientePJ(ClientePJ cliente){
		ArrayList<Veículo> listaVeiculoCliente = new ArrayList<Veículo>();
		for (Seguro seguro : this.listaSeguros) {
			if (seguro.getCliente().equals(cliente)) {
				SeguroPJ seguroPJ = (SeguroPJ) seguro;
				listaVeiculoCliente.addAll(seguroPJ.getFrota().getListaVeiculos());
			}
		}
		return listaVeiculoCliente;
	}
	
	//Calculos

	public double calcularReceita() {
		double resultado = 0;
		for (Seguro seguro : this.listaSeguros) {
	        resultado += seguro.calculaValor(this);
	    }
		return resultado;
	}
	
	@Override
    public String toString() {
        return "Nome: " + this.getNome() + "\n\tEndereço: " +this.getEndereco() + "\n\tTelefone: " + this.getTelefone() + "\n\tEmail: " + this.getEmail() +
         "\n\tCnpj: " + this.cnpj + "\n\tQuantidade de Seguros:" + this.listaSeguros.size()+ "\n\tQuantidade de Clientes:" + this.listaCliente.size();
    }
}