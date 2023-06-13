package lab5;
import java.time.LocalDate;
import java.util.ArrayList;

public class ClientePJ extends Cliente{
	private String cnpj;
	private LocalDate dataFundacao;
	private int qtdeFuncionarios;
	private ArrayList<Frota> listaFrota = new ArrayList<Frota>();

	//Constructor
	
	public ClientePJ(String nome, String endereco, String email, String telefone, String cnpj, LocalDate dataFundacao,
			int qtdeFuncionarios, ArrayList<Frota> listaFrota) {
		super(nome, endereco, email, telefone);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
		this.qtdeFuncionarios = qtdeFuncionarios;
		this.listaFrota = listaFrota;
	}
	
	//Getters e Setters (deixar private setters que não fazem sentido serem mudados)
	public boolean cadastrarFrota(Frota frota) {
		if (frota == null) {
			return false;
		}
		this.listaFrota.add(frota);
		return true;
	}
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public int getQtdeFuncionarios() {
		return qtdeFuncionarios;
	}

	public void setQtdeFuncionarios(int qtdeFuncionarios) {
		this.qtdeFuncionarios = qtdeFuncionarios;
	}

	public ArrayList<Frota> getListaFrota() {
		return listaFrota;
	}

	public void setListaFrota(ArrayList<Frota> listaFrota) {
		this.listaFrota = listaFrota;
	}

	//Métodos
	public ArrayList<Veículo> getVeiculosPorFrota(Frota frota) {
		ArrayList<Veículo> listaVeiculo = new ArrayList<Veículo>();
		for (Frota frotas: this.listaFrota) {
			if (frotas.equals(frota)) {
				listaVeiculo.addAll(frotas.getListaVeiculos());
			}
		}
		return listaVeiculo;
	}
	@Override
    public String toString() {
        return "Nome: " + this.getNome() + "\n\tEndereço: " +this.getEndereco() + "\n\tTelefone: " + this.getTelefone() + "\n\tEmail: " + this.getEmail() +
         "\n\tCnpj: " + this.cnpj + "\n\tData de Fundação: " + this.dataFundacao+ "\n\tQuantidade de Funcionários: " + this.qtdeFuncionarios
         + "\n\tQuantidade de Frotas:" + this.listaFrota.size();
    }
}
