package TechMarket.telas;

import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import dao.ProdutoDAO;
import model.Clientes;
import model.Produtos;

public class ValidadorCliente {
	private JPanel contentPane;
//	Clientes objCliente = new Clientes();
		
 public void validarCadastro(ButtonGroup grupoSexo, ButtonGroup grupoEstadoCivil, JTextField txtNome, JTextField txtEmail, JFormattedTextField txtDataNascimento, JFormattedTextField txtCPF, JFormattedTextField txtTelefone, JTabbedPane pnlGuias) {

	 
	 if(grupoSexo.getSelection() == null) {
		JOptionPane.showMessageDialog(contentPane,"Escolha o sexo!");
															return;
																											}
	
	if(grupoEstadoCivil.getSelection() == null){
		JOptionPane.showMessageDialog(contentPane,"Escolha o estado civil!");
															return;
																											}

	if(txtNome.getText().trim().equals("")) {
		JOptionPane.showMessageDialog(contentPane,"Digite o nome!");
															return;
	}
	
	if(txtEmail.getText().trim().equals("")) {
		JOptionPane.showMessageDialog(contentPane,"Digite o e-mail!");
															return;
	}

	if(txtDataNascimento.getText().replace("-", "").replace("/","").trim().equals("")) {
		JOptionPane.showMessageDialog(contentPane,"Digite a data de nascimento!");
		return;
	}
	
	if(txtCPF.getText().replace(".", "").replace("-","").trim().equals("")) {
		JOptionPane.showMessageDialog(contentPane,"Digite o CPF!");
		return;
	}
	
	if(txtTelefone.getText().replace("(", "").replace(")","").replace("-","").trim().equals("")) {
		JOptionPane.showMessageDialog(contentPane,"Digite o Telefone!");
		return;
	}
	
	

	//após o usuário preencher todos os campos, mudo para a próxima guia
pnlGuias.setSelectedIndex(1);
}

	public void validarEndereco(JComboBox<?> comboEstado, JTextField txtRua, JTextField txtNumero, JTextField txtCidade, JFormattedTextField txtCep) {
		if(comboEstado.getSelectedIndex()==0) {
			JOptionPane.showMessageDialog(contentPane,"Escolha o estado!");
			return;
		}

		if(txtRua.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(contentPane,"Digite a rua!");
																return;
		}
		
		if(txtNumero.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(contentPane,"Digite o numero!");
																return;
		}

		if(txtCidade.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(contentPane,"Digite a cidade!");
																return;
		}
		
		if(txtCep.getText().replace("-", "").trim().equals("")) {
			JOptionPane.showMessageDialog(contentPane,"Digite o cep!");
																return;
		}
		
//		String rua = txtRua.getText();
//		String estado = (String) comboEstado.getSelectedItem();
//		String numero = txtNumero.getText();
//		String cidade = txtNumero.getText();
//		String cep = txtCep.getText();
//		
//		objCliente.setRua(rua);
//		objCliente.setEstado(estado);
//		objCliente.setNumero(numero);
//		objCliente.setCidade(cidade);
//		objCliente.setCep(cep);
		
//		try {
//			
//			
//			
//			System.out.println(objCliente.getEmail()+" eu mereço aaaaaah");
//			System.out.println(objCliente.getRua()+" eu mereço aaaaaah");
//			boolean retorno = dao.ClienteDAO.cadastrar(objCliente);
//			
//			if(retorno) {
//				JOptionPane.showMessageDialog(contentPane,"Dados enviados com sucesso!");
//				Tela1_principal objPrincipal = new Tela1_principal();
//				objPrincipal.setVisible(true);
//												objPrincipal.setResizable(true);				
//								objPrincipal.setTitle("Tela1_principal");
//							objPrincipal.setPreferredSize(new Dimension(200,200));
//								objPrincipal.pack();
//				
//			}
//		}catch(Exception ex) {JOptionPane.showMessageDialog(contentPane,"Falha ao tentar cadastrar cliente!");}
//	
		
						
	}
	
	
	}