package TechMarket.telas;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Tela3_cliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela3_cliente frame = new Tela3_cliente();
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
	public Tela3_cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("tela3_cliente");
		setBounds(100, 100, 832, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu mnuTela = new JMenu("Tela");
		mnuTela.setMnemonic('A');
		menuBar.add(mnuTela);
		
		JMenuItem menuPrincipal = new JMenuItem("Tela Principal");
		menuPrincipal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I,
				java.awt.event.InputEvent.ALT_DOWN_MASK));

		mnuTela.add(menuPrincipal);
		menuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela1_principal objPrincipal = new Tela1_principal();
				objPrincipal.setVisible(true);
												objPrincipal.setResizable(true);				
								objPrincipal.setTitle("Tela1_principal");
							objPrincipal.setPreferredSize(new Dimension(200,200));
								objPrincipal.pack();
				contentPane.add(objPrincipal);
							}
		});

		JMenuItem menuProdutos = new JMenuItem("Tela Produtos");
		menuProdutos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P,
				java.awt.event.InputEvent.ALT_DOWN_MASK));
		mnuTela.add(menuProdutos);
		menuProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela2Produto objProduto = new Tela2Produto();
				objProduto.setVisible(true);
												objProduto.setResizable(true);				
								objProduto.setTitle("Tela2Produto");
							objProduto.setPreferredSize(new Dimension(200,200));
								objProduto.pack();
				contentPane.add(objProduto);
							}
		});

		JMenuItem menuRelatorios = new JMenuItem("Tela Relatorio");
		menuRelatorios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R,
				java.awt.event.InputEvent.ALT_DOWN_MASK));
		mnuTela.add(menuRelatorios);
		menuRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela4_relatorios objRelatorio = new Tela4_relatorios();
				objRelatorio.setVisible(true);
												objRelatorio.setResizable(true);				
								objRelatorio.setTitle("Tela4_relatorios");
							objRelatorio.setPreferredSize(new Dimension(200,200));
								objRelatorio.pack();
				contentPane.add(objRelatorio);
							}
		});

		JLabel lblTitulo = new JLabel("Cliente");
		lblTitulo.setFont(new Font("Graphik Semibold", Font.PLAIN, 43));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setBounds(323, 129, 678, 111);
		contentPane.add(lblTitulo);

		JPanel pnlTabela = new JPanel();
		pnlTabela.setBounds(0, 0, 786, 316);
		contentPane.add(pnlTabela);
		
		JTable tabelaClientes = new JTable();
		tabelaClientes.setModel(new DefaultTableModel(new Object[][] {},
								new String[] { "Id", "Nome", "CPF", "Total Compras" }));
		tabelaClientes.setBounds(10, 32, 342, 278);
		pnlTabela.add(tabelaClientes);
		
				JButton btnNovo = new JButton("Cadastrar Novo Cliente");
		btnNovo.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNovo.setToolTipText("");
		btnNovo.setForeground(new Color(27, 40, 161));
		btnNovo.setFont(new Font("Graphik Medium", Font.PLAIN, 22));
		btnNovo.setBackground(new Color(93, 127, 216));
		btnNovo.setBounds(763, 325, 205, 199);
		contentPane.add(btnNovo);
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela3_2CadastroCliente objCadastro = null;
				try {
					objCadastro = new Tela3_2CadastroCliente();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				objCadastro.setVisible(true);
				objCadastro.setResizable(true);				
				objCadastro.setTitle("Tela3_2CadastroCliente");
				objCadastro.setPreferredSize(new Dimension(200,200));
				objCadastro.pack();
				contentPane.add(objCadastro);
						}
		});
		
		JButton btnExcluir = new JButton("Excluir Cliente");
		btnExcluir.setVerticalAlignment(SwingConstants.BOTTOM);
		btnExcluir.setToolTipText("");
		btnExcluir.setForeground(new Color(27, 40, 161));
		btnExcluir.setFont(new Font("Graphik Medium", Font.PLAIN, 22));
		btnExcluir.setBackground(new Color(93, 127, 216));
		btnExcluir.setBounds(763, 325, 205, 199);
		contentPane.add(btnExcluir);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JButton btnAlterar = new JButton("Alterar Cliente");
		btnAlterar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnAlterar.setToolTipText("");
		btnAlterar.setForeground(new Color(27, 40, 161));
		btnAlterar.setFont(new Font("Graphik Medium", Font.PLAIN, 22));
		btnAlterar.setBackground(new Color(93, 127, 216));
		btnAlterar.setBounds(763, 325, 205, 199);
		contentPane.add(btnAlterar);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnConsultar = new JButton("Consultar Cliente");
		btnConsultar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnConsultar.setToolTipText("");
		btnConsultar.setForeground(new Color(27, 40, 161));
		btnConsultar.setFont(new Font("Graphik Medium", Font.PLAIN, 22));
		btnConsultar.setBackground(new Color(93, 127, 216));
		btnConsultar.setBounds(763, 325, 205, 199);
		contentPane.add(btnConsultar);
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

	}
}