package lab2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sinistro teste = new Sinistro("30/10/2001", "Barão Geraldo");
		System.out.println(teste.getId());
		Sinistro teste2 = new Sinistro("13/06/2003", "Barão Geraldo");
		System.out.println(teste2.getId());
		
		Cliente lucca = new Cliente("lucca", "971.550.110-96", "30/10/2001", "Barão Geraldo", 21);
		if (lucca.validarCpf()) {
			System.out.println("Ok");
		};
		//lucca.setCpf("124.124.211-42"); Método não funciona aqui por ser private
		lucca.setEndereco("Valinhos");
		System.out.println(lucca.getEndereco());
		
		Seguradora A = new Seguradora("A", "12-996733060", "A@gmail.com", "Barão Geraldo");
		A.setNome("AAA");
		System.out.println(A.getNome());
		
		Veículo carro = new Veículo("BRA2E19", "Ferrari", "*12 GTS");
		carro.setModelo("SP48");
		System.out.println(carro.getModelo());
	}
}