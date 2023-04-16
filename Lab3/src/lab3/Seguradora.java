package lab3;
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
		//Sinistro
	public boolean gerarSinistro(Sinistro sinistro) {
		if (sinistro == null) {
			return false;
		}
		this.ListaSinistro.add(sinistro);
		return true;
	}
	public boolean visualizarSinistro(String nome) {
	    for (Sinistro sinistro : this.ListaSinistro) {
	        if (sinistro.cliente.getNome().equalsIgnoreCase(nome)) { 
	        	System.out.println(sinistro.toString());
	            return true; 
	        }
	    }
	    return false;
	}
	public void ListarSinistros() {
		for (Sinistro sinistro : this.ListaSinistro) {
			System.out.println(sinistro.toString());
		}
	}
}