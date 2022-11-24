package TechMarket.telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Produtos;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Tela2_3ProdutoAlterar extends JFrame {
    Produtos objProdutos = new Produtos();
	
	private JPanel contentPane;
	private JTextField textField;
	private JComboBox comboBox;
	private JLabel lblNewLabel;
	private JTextField textField_1;
	private JLabel lblNewLabel_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;

	
	
	
	
public Tela2_3ProdutoAlterar(Produtos obj) {
		
        this.objProdutos = obj;
		setBounds(100, 100, 526, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(185, 41, 131, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(objProdutos.getNome());
	
		
		JLabel lblNomeProduto = new JLabel("Nome:");
		lblNomeProduto.setBounds(185, 27, 46, 14);
		contentPane.add(lblNomeProduto);
		
		comboBox = new JComboBox();
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecione uma categoria...", "Limpeza", "Hortifruit", "Bebidas", "Comida"}));
		comboBox.setBounds(185, 87, 182, 22);
		contentPane.add(comboBox);
		
		
		lblNewLabel = new JLabel("Categoria:");
		lblNewLabel.setBounds(185, 72, 94, 14);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(185, 178, 131, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(String.valueOf(obj.getPreco()));
		
		lblNewLabel_1 = new JLabel("Preço:");
		lblNewLabel_1.setBounds(185, 164, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(185, 133, 131, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText(String.valueOf(obj.getEstoque()));
		
		lblNewLabel_2 = new JLabel("Estoque:");
		lblNewLabel_2.setBounds(185, 120, 113, 14);
		contentPane.add(lblNewLabel_2);
		
		btnNewButton = new JButton("Alterar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("Selecione uma categoria...")) {
					JOptionPane.showMessageDialog(btnNewButton, "Opção de categoria inválida!");
				}else {
					 if(objProdutos != null){
						 
						 String nome = textField.getText();
						 String categoria = comboBox.getSelectedItem().toString();
						 int estoque = Integer.parseInt(textField_2.getText());
						 double preco = Double.parseDouble(textField_1.getText());
						 
						 objProdutos.setNome(nome);
						 objProdutos.setCategoria(categoria);
						 objProdutos.setEstoque(estoque);
						 objProdutos.setPreco(preco);
						 
						 boolean retorno = dao.ProdutoDAO.alterar(objProdutos);
						 if(retorno == true) {
							 JOptionPane.showMessageDialog(btnNewButton,"Informações alteradas com sucesso!");
						 }else{JOptionPane.showMessageDialog(btnNewButton,"Falha na gravação!");}
					 }
				}
			}
		});
		btnNewButton.setBounds(185, 227, 131, 23);
		contentPane.add(btnNewButton);
       

    }

}
