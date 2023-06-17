package lab5;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.util.ArrayList;

public class SeguroPJ extends Seguro{
	private Frota frota;
	private ClientePJ cliente;
	public SeguroPJ(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora,
			ArrayList<Sinistro> listaSinistro, ArrayList<Condutor> listaCondutor, Frota frota, ClientePJ cliente) {
		super(dataInicio, dataFim, seguradora, listaSinistro, listaCondutor);
		this.frota = frota;
		this.cliente = cliente;
		this.calculaValor(seguradora);
	}
	public Frota getFrota() {
		return frota;
	}
	public void setFrota(Frota frota) {
		this.frota = frota;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(ClientePJ cliente) {
		this.cliente = cliente;
	}
	
	public double calculaValor(Seguradora seguradora) {
		double AnosPosFundacao = ChronoUnit.YEARS.between(this.cliente.getDataFundacao(), LocalDate.now());
		return CalcSeguro.VALOR_BASE.valores * (10 + this.cliente.getQtdeFuncionarios()/10) *
				(1 + 1/(seguradora.getVeiculosPorClientePJ(cliente).size() + 2)) * (1 + 1/(AnosPosFundacao  +2)) *
				(2 + seguradora.getSinistrosPorCliente(cliente).size()/10) * (5 + seguradora.getSinistrosPorCondutores(cliente).size()/10); 
	}
	
	public String toString() {
		StringBuilder condutores = new StringBuilder();
		for (Condutor condutor : this.getListaCondutor()) {
            condutores.append("\n\t").append("Condutor: ").append(condutor.getNome());
        }
        return "Nome: " + this.cliente.getNome() + "\n\tId:" + this.getId() + "\n\tData de Inicio:" + this.getDataInicio() + "\n\tData de Fim:" + this.getDataFim()
        + "\n\tNome da Seguradora:" + this.getSeguradora().getNome() + "\n\tCode da Frota: " + this.frota.getCode() +  "\n\tCondutores: " + condutores; 
    }
	
}
