package TechMarket.telas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JToggleButton;
import java.awt.List;
import javax.swing.JEditorPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.Canvas;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Tela2_1ProdutoCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField FieldNome;
	private JTextField PrecoLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela2_1ProdutoCadastro frame = new Tela2_1ProdutoCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela2_1ProdutoCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1083, 681);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(168, 170, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(Tela2_1ProdutoCadastro.class.getResource("/TechMarket/telas/logo.png")));
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(0, 0, 0));
		comboBox.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Limpeza", "Hortifruit", "Comida", "Bebidas"}));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(10, 36, 567, 22);
		Categoria.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Categoria");
		lblNewLabel.setFont(new Font("Graphik Light", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 11, 73, 14);
		Categoria.add(lblNewLabel);
		
		JPanel Preco = new JPanel();
		Preco.setBackground(new Color(255, 255, 255));
		Preco.setBounds(10, 148, 587, 52);
		ColetaDados.add(Preco);
		Preco.setLayout(null);
		
		PrecoLabel = new JTextField();
		PrecoLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		PrecoLabel.setForeground(new Color(0, 0, 0));
		PrecoLabel.setText("R$ ");
		PrecoLabel.setBackground(new Color(255, 255, 255));
		PrecoLabel.setBounds(10, 32, 567, 20);
		Preco.add(PrecoLabel);
		PrecoLabel.setColumns(10);
		
		JPanel Estoque = new JPanel();
		Estoque.setBackground(new Color(255, 255, 255));
		Estoque.setBounds(10, 206, 587, 55);
		ColetaDados.add(Estoque);
		Estoque.setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setBackground(new Color(178, 200, 255));
		spinner.setBounds(10, 35, 268, 20);
		Estoque.add(spinner);
		

		JButton Botao_confirmar = new JButton("Confirmar");
		Botao_confirmar.setBounds(179, 286, 118, 23);
		ColetaDados.add(Botao_confirmar);
		
		JButton Botao_Limpar = new JButton("Cancelar");
		Botao_Limpar.setBounds(307, 286, 111, 23);
		ColetaDados.add(Botao_Limpar);
		
		JLabel imgSupermercado = new JLabel("");
		imgSupermercado.setBounds(671, -55, 891, 911);
		contentPane.add(imgSupermercado);
		imgSupermercado.setIcon(new ImageIcon(Tela2_1ProdutoCadastro.class.getResource("/TechMarket/telas/PessoaSupermercado.png")));
		
	}
}
