package lab4;
import java.time.LocalDate;
import java.util.ArrayList;

public class ClientePJ extends Cliente{
	private String cnpj;
	private LocalDate dataFundacao;
	private int qtdeFuncionarios;

	//Constructor
	public ClientePJ(String nome, String endereco, double valorSeguro, String cnpj,
			LocalDate dataFundacao, int qtdeFuncionarios) {
		super(nome, endereco, valorSeguro);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
		this.qtdeFuncionarios = qtdeFuncionarios;
	}
	
	//Getters e Setters (deixar private setters que não fazem sentido serem mudados)
	public String getCnpj() {
		return cnpj;
	}

	private void setCnpj(String cnpj) {
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
	
	//Métodos
	@Override
	public double calculaScore(){
		return CalcSeguro.VALOR_BASE.valores * (1+(this.qtdeFuncionarios/100)) * this.ListaVeiculos.size();
	}
	@Override
    public String toString() {
        return "Nome: " + this.getNome() + "\n\tEndereço: " +this.getEndereco() + "\n\tValor do Seguro: " + this.getValorSeguro()
         + "\n\tCnpj: " + this.cnpj + 
        "\n\tData de Fundação: " + this.dataFundacao+ "\n\tQuantidade de Funcionários: " + this.qtdeFuncionarios;
    }
}
