package lab6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArquivoVeículo implements l_Arquivo{
	@Override
	public boolean gravarArquivo() {
		return true;
	}
	@Override
	public String lerArquivo()throws IOException {
        String caminhoArquivo = "src/lab6/lab06-seguradora_arquivos_v2/veiculos.csv";
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
	
	public Veículo[] criarArrayVeiculos() {
	    // Dividir o conteúdo do arquivo em linhas
		String conteudoArquivo = "";
		try {
			conteudoArquivo = this.lerArquivo();
		}catch(IOException e){
            e.printStackTrace();
        }
		
	    String[] linhas = conteudoArquivo.split("\n");

	    // Criar um array de Veículos com base no número de linhas do arquivo
	    Veículo[] veiculos = new Veículo[linhas.length - 1]; // Desconsidera a primeira linha (cabeçalho)

	    // Percorrer as linhas do arquivo (a partir da segunda linha)
	    for (int i = 1; i < linhas.length; i++) {
	        // Dividir a linha em colunas (utilizando a vírgula como separador)
	        String[] colunas = linhas[i].split(",");

	        // Extrair os valores das colunas
	        String placa = colunas[0];
	        String marca = colunas[1];
	        String modelo = colunas[2];
	        int anoFabricacao = Integer.parseInt(colunas[3]);

	        // Criar um objeto Veículo com os valores extraídos
	        Veículo veiculo = new Veículo(placa, marca, modelo, anoFabricacao);

	        // Adicionar o veículo ao array de veículos
	        veiculos[i - 1] = veiculo; // O índice do array começa em 0, por isso subtrai 1 do índice i
	    }

	    // Retornar o array de veículos
	    return veiculos;
	}
}
