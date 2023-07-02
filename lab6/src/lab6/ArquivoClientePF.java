package lab6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ArquivoClientePF implements l_Arquivo{
	@Override
	public boolean gravarArquivo() {
		return true;
	}
	
	@Override
	public String lerArquivo()throws IOException {
        String caminhoArquivo = "src/lab6/lab06-seguradora_arquivos_v2/clientesPF.csv";
        StringBuilder conteudoArquivo = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                conteudoArquivo.append(linha).append("\n");
            }
        } catch (IOException e) {
            throw new IOException("Erro ao ler o arquivo CSV: " + e.getMessage());
        }
        return conteudoArquivo.toString();
	}

	public ClientePF[] criarArrayClientesPF() {
		ArquivoVeículo arquivoVeiculo = new ArquivoVeículo();
		String conteudoArquivo = "";
		try {
			conteudoArquivo = this.lerArquivo();
		}catch(IOException e){
            e.printStackTrace();
        }
		
	    String[] linhas = conteudoArquivo.split("\n");

	    ClientePF[] clientespf = new ClientePF[linhas.length - 1];

	    for (int i = 1; i < linhas.length; i++) {
	        String[] colunas = linhas[i].split(",");

	        String cpf = colunas[0];
	        String nome = colunas[1];
	        String telefone = colunas[2];
	        String endereco = colunas[3];
	        String email = colunas[4];
	        String sexo = colunas[5];
	        String ensino = colunas[6];
	        String dataNascimento = colunas[7];
	        String placa = colunas[8];
	        
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate data = LocalDate.parse(dataNascimento, formatter);
	        
	        //Achar veículo com a placa
	        Veículo veiculo = new Veículo(null, null, null, 0);
	        for (Veículo veiculo1 : arquivoVeiculo.criarArrayVeiculos()) {
	        	if (veiculo1.getPlaca().equalsIgnoreCase(placa)) {
	        		veiculo = veiculo1;
	        	}
	        }
	        
	        ClientePF clientePF = new ClientePF(nome, endereco, email, telefone, cpf, sexo, ensino, data, veiculo) ;

	        clientespf[i - 1] = clientePF; 
	    }

	    return clientespf;
	}
}
