package TechMarket.telas;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class ValidadorProduto {
	private JPanel contentPane;
		
public void validarProduto(JTextField FieldIDProduto, JFormattedTextField textFieldCpf, JTextField TotalField) {
	
	
	if(textFieldCpf.getText().replace(".", "").replace("-","").trim().equals("")) {
		JOptionPane.showMessageDialog(contentPane,"Digite o CPF!");
		return;
	}
	
	else if(FieldIDProduto.getText().trim().equals("")) {
		JOptionPane.showMessageDialog(contentPane,"Digite o ID do produto!");
															return;
	} 
	
	else if(TotalField.getText().trim().equals("")) {
		JOptionPane.showMessageDialog(contentPane,"Preenchar o total do produto!");
															return;
	}
	
	else {
		JOptionPane.showMessageDialog(contentPane,"Compra confirmada!");
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
		JOptionPane.showMessageDialog(contentPane,"Produto Cadastrado!");
	}
}


	}