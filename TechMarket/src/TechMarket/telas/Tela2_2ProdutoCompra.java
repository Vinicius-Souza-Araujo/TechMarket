package TechMarket.telas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class Tela2_2ProdutoCompra extends JFrame {

	private JPanel PainelProduto;
	private JTextField textFieldCpf;
	private JTextField FieldIDProduto;
	private JTable table;
	private JTextField TotalField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela2_2ProdutoCompra frame = new Tela2_2ProdutoCompra();
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
	public Tela2_2ProdutoCompra() throws ParseException {
		
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 578);
		PainelProduto = new JPanel();
		PainelProduto.setBackground(new Color(255, 255, 255));
		PainelProduto.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(PainelProduto);
		PainelProduto.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Carrinho");
		lblNewLabel.setForeground(new Color(0, 0, 121));
		lblNewLabel.setFont(new Font("Bebas Neue", Font.PLAIN, 43));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(95, 55, 612, 42);
		PainelProduto.add(lblNewLabel);
		
		JPanel DadosCompra = new JPanel();
		DadosCompra.setBackground(new Color(189, 200, 232));
		DadosCompra.setBounds(95, 122, 612, 160);
		PainelProduto.add(DadosCompra);
		DadosCompra.setLayout(null);
		
		JLabel lblCPF = new JLabel("CPF Cliente");
		lblCPF.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		lblCPF.setBounds(28, 21, 108, 14);
		DadosCompra.add(lblCPF);
		
		
		JFormattedTextField textFieldCpf = new JFormattedTextField();
		textFieldCpf.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textFieldCpf.setBounds(100, 18, 414, 20);
		DadosCompra.add(textFieldCpf);
		textFieldCpf.setColumns(10);
		textFieldCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
		
		textFieldCpf.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caractere = e.getKeyChar();
				if ( ((caractere < '0') || (caractere > '9')) && (caractere !=KeyEvent.VK_BACK_SPACE)) {
				    e.consume();     
				JOptionPane.showMessageDialog(lblCPF, "CPF recebe apenas números.");
				}
			}});
				
		JLabel lblIDProduto = new JLabel("ID Produto");
		lblIDProduto.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		lblIDProduto.setBounds(28, 61, 81, 14);
		DadosCompra.add(lblIDProduto);
		
		FieldIDProduto = new JTextField();
		FieldIDProduto.setBounds(98, 59, 151, 20);
		DadosCompra.add(FieldIDProduto);
		FieldIDProduto.setColumns(10);
		FieldIDProduto.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caractere = e.getKeyChar();
				if ( ((caractere < '0') || (caractere > '9')) && (caractere !=KeyEvent.VK_BACK_SPACE)) {
				    e.consume();     
				JOptionPane.showMessageDialog(FieldIDProduto, "ID produto recebe apenas números.");
				}
			}});
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		lblQuantidade.setBounds(310, 61, 74, 14);
		DadosCompra.add(lblQuantidade);
		
		JSpinner spinnerQuantidade = new JSpinner();
		spinnerQuantidade.setBounds(395, 59, 119, 20);
		DadosCompra.add(spinnerQuantidade);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		lblTotal.setBounds(28, 114, 49, 14);
		DadosCompra.add(lblTotal);
		
		TotalField = new JTextField();
		TotalField.setBounds(101, 112, 413, 20);
		DadosCompra.add(TotalField);
		TotalField.setColumns(10);
		
		
		JPanel TabelasCompras = new JPanel();
		TabelasCompras.setBounds(95, 310, 612, 106);
		PainelProduto.add(TabelasCompras);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_TabelasCompras = new GroupLayout(TabelasCompras);
		gl_TabelasCompras.setHorizontalGroup(
			gl_TabelasCompras.createParallelGroup(Alignment.LEADING)
				    .addGroup(gl_TabelasCompras.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_TabelasCompras.setVerticalGroup(
			gl_TabelasCompras.createParallelGroup(Alignment.LEADING)
				    .addGroup(gl_TabelasCompras.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				},
			
			new String[] {
				"Quantidade", "Produto", "Valor"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		TabelasCompras.setLayout(gl_TabelasCompras);
		
		JButton botaoConfirmar = new JButton("Confirmar");
		botaoConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ValidadorProduto objValidador = new ValidadorProduto();
				objValidador.validarProduto(FieldIDProduto, textFieldCpf, TotalField);
			}
		});
		botaoConfirmar.setBounds(445, 466, 111, 23);
		PainelProduto.add(botaoConfirmar);
		
		JButton botaoAlterar = new JButton("Alterar");
		botaoAlterar.setBounds(329, 466, 111, 23);
		PainelProduto.add(botaoAlterar);
		
		JButton btnNovoCliente = new JButton("Novo Cliente");
		btnNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela3_2CadastroCliente objItemConsultaProduto = null;
				try {
					objItemConsultaProduto = new Tela3_2CadastroCliente();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				objItemConsultaProduto.setVisible(true);
				objItemConsultaProduto.setResizable(true);				
				objItemConsultaProduto.setTitle("Tela3_2CadastroCliente");
				objItemConsultaProduto.setPreferredSize(new Dimension(1080,720));
				objItemConsultaProduto.pack();
						}
		});
		
		btnNovoCliente.setBounds(208, 466, 111, 23);
		PainelProduto.add(btnNovoCliente);
		
	}
}
