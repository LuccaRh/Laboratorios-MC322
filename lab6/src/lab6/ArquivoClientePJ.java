package lab6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ArquivoClientePJ implements l_Arquivo{
	@Override
	public boolean gravarArquivo() {
		return true;
	}
	
	@Override
	public String lerArquivo()throws IOException {
        String caminhoArquivo = "src/lab6/lab06-seguradora_arquivos_v2/clientesPJ.csv";
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

	public ClientePJ[] criarArrayClientesPJ() {
		ArquivoFrota arquivoFrota = new ArquivoFrota();
		String conteudoArquivo = "";
		try {
			conteudoArquivo = this.lerArquivo();
		}catch(IOException e){
            e.printStackTrace();
        }
		
	    String[] linhas = conteudoArquivo.split("\n");


	    ClientePJ[] clientespj = new ClientePJ[linhas.length - 1];
	    
	    for (int i = 1; i < linhas.length; i++) {
	        String[] colunas = linhas[i].split(",");

	        String cnpj = colunas[0];
	        String nome = colunas[1];
	        String telefone = colunas[2];
	        String endereco = colunas[3];
	        String email = colunas[4];
	        String dataFundacao = colunas[5];
	        String codeFrota = colunas[6];
	        
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate data = LocalDate.parse(dataFundacao, formatter);
	        
	        //Achar veículo com a placa
	        Frota frota = new Frota(null, new ArrayList<Veículo>());
	        for (Frota frota1: arquivoFrota.criarArrayFrotas()) {
	        	if (frota1.getCode().equalsIgnoreCase(codeFrota)) {
	        		frota = frota1;
	        	}
	        }
	        
	        ClientePJ clientePJ = new ClientePJ(nome, endereco, email, telefone, cnpj, data, frota) ;

	        clientespj[i - 1] = clientePJ; 
	    }

	    return clientespj;
	}

}
