package lab6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArquivoFrota implements l_Arquivo{
	@Override
	public boolean gravarArquivo() {
		return true;
	}
	@Override
	public String lerArquivo()throws IOException {
        String caminhoArquivo = "src/lab6/lab06-seguradora_arquivos_v2/frotas.csv";
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
	
	public Frota[] criarArrayFrotas() {
		ArquivoVeículo arquivoVeiculo = new ArquivoVeículo();
		String conteudoArquivo = "";
		try {
			conteudoArquivo = this.lerArquivo();
		}catch(IOException e){
            e.printStackTrace();
        }
		
	    String[] linhas = conteudoArquivo.split("\n");

	    Frota[] frotas = new Frota[linhas.length - 1];
	    
	    //ID_FROTA,PLACA_VEICULO1,PLACA_VEICULO2,PLACA_VEICULO3
	    for (int i = 1; i < linhas.length; i++) {
	        String[] colunas = linhas[i].split(",");

	        String id = colunas[0];
	        String placa1 = colunas[1];
	        String placa2 = colunas[2];
	        String placa3 = colunas[3];

	        ArrayList<Veículo> listaVeiculos = new ArrayList<Veículo>();
	        
	        for (Veículo veiculo1 : arquivoVeiculo.criarArrayVeiculos()) {
	        	if (veiculo1.getPlaca().equalsIgnoreCase(placa1)) {
	        		listaVeiculos.add(veiculo1);
	        	}
	        	else if (veiculo1.getPlaca().equalsIgnoreCase(placa2)) {
	        		listaVeiculos.add(veiculo1);
	        	} 
	        	else if (veiculo1.getPlaca().equalsIgnoreCase(placa3)) {
	        		listaVeiculos.add(veiculo1);
	        	} 
	        }
	        
	        Frota frota = new Frota(id, listaVeiculos);

	        frotas[i - 1] = frota;
	    }

	    return frotas;
	}
}
