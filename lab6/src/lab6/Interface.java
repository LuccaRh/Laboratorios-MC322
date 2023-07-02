package lab6;
import javax.swing.*;
import java.io.IOException;



public class Interface extends JFrame{
	/**
	 * 
	 */
	public Interface(JTable seguros, JTable sinistros) throws IOException{
	JTabbedPane tabbedPane = new JTabbedPane();
	
	JPanel sinistroPanel = new JPanel();
	JPanel seguroPanel = new JPanel();
	tabbedPane.addTab("Sinistro", sinistroPanel);
	tabbedPane.addTab("Seguro", seguroPanel);
	getContentPane().add(tabbedPane);
	setSize(600,500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
	//Tabela
    JScrollPane scrollPane1 = new JScrollPane(seguros);
    JScrollPane scrollPane2 = new JScrollPane(sinistros);
    	//Ajustar tamanho das colunas
    seguroPanel.add(scrollPane1);
    sinistroPanel.add(scrollPane2);
	}	
	
   
}