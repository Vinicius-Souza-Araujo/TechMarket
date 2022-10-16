package TechMarket.telas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.awt.event.InputEvent;

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
		setBounds(100, 100, 1006, 651);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu mnuTela = new JMenu("Menu");
		mnuTela.setMnemonic('A');
		menuBar.add(mnuTela);
		contentPane.setLayout(null);
		
		JLabel lblImgCliente = new JLabel("");
		lblImgCliente.setIcon(new ImageIcon(Tela3_cliente.class.getResource("/TechMarket/telas/add_client.png")));
		lblImgCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblImgCliente.setBounds(697, 382, 80, 60);
		contentPane.add(lblImgCliente);
		
		JLabel ImagemLogo = new JLabel("");
		ImagemLogo.setIcon(new ImageIcon(Tela3_cliente.class.getResource("/TechMarket/telas/img.png")));
		ImagemLogo.setHorizontalAlignment(SwingConstants.CENTER);
		ImagemLogo.setBounds(-406, -16, 1836, 257);
		contentPane.add(ImagemLogo);
		
		JDesktopPane pnlJanelas = new JDesktopPane();
		pnlJanelas.setBounds(48, 37, 1, 1);
		contentPane.add(pnlJanelas);
		
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
				pnlJanelas.add(objPrincipal);
							}
		});

		JMenuItem menuProdutos = new JMenuItem("Tela Produtos");
		menuProdutos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P,
				java.awt.event.InputEvent.ALT_DOWN_MASK));

		mnuTela.add(menuProdutos);
		menuProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela2Produto objProdutos = new Tela2Produto();
				objProdutos.setVisible(true);
												objProdutos.setResizable(true);				
								objProdutos.setTitle("Tela1_principal");
							objProdutos.setPreferredSize(new Dimension(200,200));
								objProdutos.pack();
				pnlJanelas.add(objProdutos);
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
				pnlJanelas.add(objRelatorio);
							}
		});

		JPanel pnlTabela = new JPanel();
		pnlTabela.setBounds(75, 345, 450, 182);
		contentPane.add(pnlTabela);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_pnlTabela = new GroupLayout(pnlTabela);
		gl_pnlTabela.setHorizontalGroup(
			gl_pnlTabela.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		);
		gl_pnlTabela.setVerticalGroup(
			gl_pnlTabela.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
		);
		
		JTable tabelaClientes = new JTable();
		scrollPane.setViewportView(tabelaClientes);
		tabelaClientes.setModel(new DefaultTableModel(new Object[][] {},
								new String[] { "Id", "Nome", "CPF", "Total Compras" }));
		tabelaClientes.setBounds(10, 32, 342, 278);
		pnlTabela.setLayout(gl_pnlTabela);
		
				JButton btnNovo = new JButton("Cadastrar Novo Cliente");
		btnNovo.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNovo.setToolTipText("");
		btnNovo.setForeground(new Color(255, 255, 255));
		btnNovo.setFont(new Font("Segoe UI Light", Font.PLAIN, 24));
		btnNovo.setBackground(new Color(0, 0, 140));
		btnNovo.setBounds(600, 453, 276, 37);
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
				pnlJanelas.add(objCadastro);
						}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setToolTipText("");
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		btnExcluir.setBackground(new Color(93, 127, 216));
		btnExcluir.setBounds(133, 538, 80, 23);
		contentPane.add(btnExcluir);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setToolTipText("");
		btnAlterar.setForeground(new Color(255, 255, 255));
		btnAlterar.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		btnAlterar.setBackground(new Color(93, 127, 216));
		btnAlterar.setBounds(223, 538, 80, 23);
		contentPane.add(btnAlterar);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setToolTipText("");
		btnConsultar.setForeground(new Color(255, 255, 255));
		btnConsultar.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		btnConsultar.setBackground(new Color(93, 127, 216));
		btnConsultar.setBounds(344, 538, 115, 23);
		contentPane.add(btnConsultar);
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

	}
}