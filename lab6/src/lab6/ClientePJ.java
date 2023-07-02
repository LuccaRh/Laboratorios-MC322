package lab6;
import java.time.LocalDate;

public class ClientePJ extends Cliente{
	private String cnpj;
	private LocalDate dataFundacao;
	private Frota frota;

	//Constructor
	
	public ClientePJ(String nome, String endereco, String email, String telefone, String cnpj, LocalDate dataFundacao,
			Frota frota) {
		super(nome, endereco, email, telefone);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
		this.frota = frota;
	}
	
	//Getters e Setters (deixar private setters que não fazem sentido serem mudados)
	
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

	
	public Frota getFrota() {
		return frota;
	}

	public void setFrota(Frota frota) {
		this.frota = frota;
	}

	@Override
    public String toString() {
        return "Nome: " + this.getNome() + "\n\tEndereço: " +this.getEndereco() + "\n\tTelefone: " + this.getTelefone() + "\n\tEmail: " + this.getEmail() +
         "\n\tCnpj: " + this.cnpj + "\n\tData de Fundação: " + this.dataFundacao+ "\n\tCódigo da frota:" + this.frota.getCode();
    }
}
