package TechMarket.telas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
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
import java.awt.event.ActionEvent;

public class Tela2_2ProdutoCompra extends JFrame {

	private JPanel PainelProduto;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_2;

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
	 */
	public Tela2_2ProdutoCompra() {
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
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textField.setBounds(100, 18, 414, 20);
		DadosCompra.add(textField);
		textField.setColumns(10);
		
		JLabel lblIDProduto = new JLabel("ID Produto");
		lblIDProduto.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		lblIDProduto.setBounds(28, 61, 81, 14);
		DadosCompra.add(lblIDProduto);
		
		textField_1 = new JTextField();
		textField_1.setBounds(98, 59, 151, 20);
		DadosCompra.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		lblQuantidade.setBounds(310, 61, 74, 14);
		DadosCompra.add(lblQuantidade);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(395, 59, 119, 20);
		DadosCompra.add(spinner);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		lblTotal.setBounds(28, 114, 49, 14);
		DadosCompra.add(lblTotal);
		
		textField_2 = new JTextField();
		textField_2.setBounds(101, 112, 413, 20);
		DadosCompra.add(textField_2);
		textField_2.setColumns(10);
		
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
		botaoConfirmar.setBounds(445, 466, 111, 23);
		PainelProduto.add(botaoConfirmar);
		
		JButton botaoAlterar = new JButton("Alterar");
		botaoAlterar.setBounds(329, 466, 111, 23);
		PainelProduto.add(botaoAlterar);
		
		JButton btnNovoCliente = new JButton("Novo Cliente");
		btnNovoCliente.setBounds(208, 466, 111, 23);
		PainelProduto.add(btnNovoCliente);
	}
}
