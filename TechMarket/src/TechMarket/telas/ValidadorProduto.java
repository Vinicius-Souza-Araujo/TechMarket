package TechMarket.telas;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import dao.ProdutoDAO;
import model.Produtos;

public class ValidadorProduto {
	private JPanel contentPane;
		
public void validarProduto(JTextField FieldIDProduto, JFormattedTextField textFieldCpf) {
	
	
	if(textFieldCpf.getText().replace(".", "").replace("-","").trim().equals("")) {
		JOptionPane.showMessageDialog(contentPane,"Digite o CPF!");
		return;
	}
	
	else if(FieldIDProduto.getText().trim().equals("")) {
		JOptionPane.showMessageDialog(contentPane,"Digite o ID do produto!");
															return;
	} 
	
	
	
}

public void ValidarCadastro(JTextField FieldNome, JComboBox comboBoxCategoria , JTextField PrecoField, JSpinner spinnerEstoque) {
	
	if(FieldNome.getText().trim().equals("")) {
		JOptionPane.showMessageDialog(contentPane,"Informe o nome do produto!");
															return;
	} 
	
	else if(comboBoxCategoria.getSelectedIndex()==0) {
		JOptionPane.showMessageDialog(contentPane,"Escolha uma categoria!");
		return;
	}
	
	else if(spinnerEstoque.getValue() == null) {
		JOptionPane.showMessageDialog(contentPane,"Adicione um item ao estoque!");
		return;
	}
	
	
	else if(PrecoField.getText().trim().equals("")) {
		JOptionPane.showMessageDialog(contentPane,"Informe o preço do produto!");
															return;
	} 
	
	
	else {
		try {
			String nome = FieldNome.getText();
			String categoria = (String) comboBoxCategoria.getSelectedItem();
			double preco = Double.parseDouble(PrecoField.getText().toString());
			int estoque = Integer.parseInt(spinnerEstoque.getValue().toString());
			
			Produtos objProduto = new Produtos(nome, categoria, preco, estoque);
			
			boolean retorno = ProdutoDAO.cadastrar(objProduto);
			
			if(retorno) {
			JOptionPane.showMessageDialog(contentPane, "Produto cadastrado com sucesso!");
			}
		}catch(Exception ex) {JOptionPane.showMessageDialog(contentPane,"Falha ao gravar produto!");}
		
	}
}


	}