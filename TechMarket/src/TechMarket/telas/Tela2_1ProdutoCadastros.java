package TechMarket.telas;
import java.awt.EventQueue;


import javax.swing.JFormattedTextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import java.awt.List;
import javax.swing.JEditorPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.Canvas;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SpinnerNumberModel;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class Tela2_1ProdutoCadastros extends JFrame {

	private JPanel contentPane;
	private JTextField FieldNome;
	private JTextField PrecoField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela2_1ProdutoCadastros frame = new Tela2_1ProdutoCadastros();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public Tela2_1ProdutoCadastros() throws ParseException {
		setBounds(100, 100, 1083, 681);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(168, 170, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(Tela2_1ProdutoCadastros.class.getResource("/TechMarket/telas/logo.png")));
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setBounds(787, 135, 412, 269);
		contentPane.add(logo);
		
		JPanel ColetaDados = new JPanel();
		ColetaDados.setBackground(new Color(255, 255, 255));
		ColetaDados.setBounds(21, 182, 620, 320);
		contentPane.add(ColetaDados);
		ColetaDados.setLayout(null);
		
		JPanel Nome = new JPanel();
		Nome.setBackground(new Color(255, 255, 255));
		Nome.setBounds(10, 11, 587, 65);
		ColetaDados.add(Nome);
		Nome.setLayout(null);
		
		FieldNome = new JTextField();
		FieldNome.setForeground(new Color(26, 31, 125));
		FieldNome.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		FieldNome.setBackground(new Color(255, 255, 255));
		FieldNome.setBounds(10, 34, 567, 20);
		Nome.add(FieldNome);
		FieldNome.setColumns(10);
		
		JLabel LabelNome = new JLabel("Nome");
		LabelNome.setFont(new Font("Graphik Light", Font.PLAIN, 12));
		LabelNome.setBounds(10, 11, 49, 14);
		Nome.add(LabelNome);
		
		JPanel Categoria = new JPanel();
		Categoria.setBackground(new Color(255, 255, 255));
		Categoria.setBounds(10, 78, 587, 65);
		ColetaDados.add(Categoria);
		Categoria.setLayout(null);
		
		JComboBox comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setForeground(new Color(0, 0, 0));
		comboBoxCategoria.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		comboBoxCategoria.setModel(new DefaultComboBoxModel(new String[] {"Selecione uma categoria", "Limpeza", "Hortifruit", "Comida", "Bebidas"}));
		comboBoxCategoria.setSelectedIndex(0);
		comboBoxCategoria.setBackground(new Color(255, 255, 255));
		comboBoxCategoria.setBounds(10, 36, 567, 22);
		Categoria.add(comboBoxCategoria);
		
		JLabel lblNewLabel = new JLabel("Categoria");
		lblNewLabel.setFont(new Font("Graphik Light", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 11, 73, 14);
		Categoria.add(lblNewLabel);
		
		JPanel Preco = new JPanel();
		Preco.setBackground(new Color(255, 255, 255));
		Preco.setBounds(10, 148, 587, 52);
		ColetaDados.add(Preco);
		Preco.setLayout(null);
		
		PrecoField = new JTextField();
		PrecoField.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		PrecoField.setForeground(new Color(0, 0, 0));
		PrecoField.setBackground(new Color(255, 255, 255));
		PrecoField.setBounds(10, 32, 567, 20);
		Preco.add(PrecoField);
		PrecoField.setColumns(10);

		
		JLabel lblPreco = new JLabel("Preço");
		lblPreco.setFont(new Font("Graphik Light", Font.PLAIN, 12));
		lblPreco.setBounds(10, 11, 73, 14);
		Preco.add(lblPreco);
		
		JPanel Estoque = new JPanel();
		Estoque.setBackground(new Color(255, 255, 255));
		Estoque.setBounds(10, 206, 587, 55);
		ColetaDados.add(Estoque);
		Estoque.setLayout(null);
		
		JSpinner spinnerEstoque = new JSpinner();
		spinnerEstoque.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinnerEstoque.setBackground(new Color(178, 200, 255));
		spinnerEstoque.setBounds(10, 35, 268, 20);
		Estoque.add(spinnerEstoque);
		
		JLabel lblEstoque = new JLabel("Estoque");
		lblEstoque.setFont(new Font("Graphik Light", Font.PLAIN, 12));
		lblEstoque.setBounds(10, 10, 73, 14);
		Estoque.add(lblEstoque);
		

		JButton Botao_confirmar = new JButton("Confirmar");
		Botao_confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ValidadorProduto objValidador = new ValidadorProduto();
				objValidador.ValidarCadastro(FieldNome, comboBoxCategoria, PrecoField, spinnerEstoque);
				
				
				
			}
		});
		Botao_confirmar.setBounds(162, 286, 135, 23);
		ColetaDados.add(Botao_confirmar);
		
		JButton Botao_Limpar = new JButton("Cancelar");
		Botao_Limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela2Produto objproduto = new Tela2Produto();
				objproduto.setVisible(true);
				objproduto.setResizable(true);				
				objproduto.setTitle("Tela2Produto");
				objproduto.setPreferredSize(new Dimension(1000,1000));
				objproduto.pack();
			}
		});
		Botao_Limpar.setBounds(307, 286, 128, 23);
		ColetaDados.add(Botao_Limpar);
		
		JLabel imgSupermercado = new JLabel("");
		imgSupermercado.setBounds(671, -55, 891, 911);
		contentPane.add(imgSupermercado);
		imgSupermercado.setIcon(new ImageIcon(Tela2_1ProdutoCadastros.class.getResource("/TechMarket/telas/PessoaSupermercado.png")));
		
	}
}
