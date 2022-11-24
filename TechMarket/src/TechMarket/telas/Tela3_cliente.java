package TechMarket.telas;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Clientes;
import model.Produtos;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class Tela3_cliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDigiteOCpf;

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
		setTitle("tela3_cliente");
		setBounds(100, 100, 1217, 689);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu mnuTela = new JMenu("Menu");
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
		contentPane.setLayout(null);

		JPanel pnlTabela = new JPanel();
		pnlTabela.setBounds(107, 308, 657, 209);
		contentPane.add(pnlTabela);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_pnlTabela = new GroupLayout(pnlTabela);
		gl_pnlTabela.setHorizontalGroup(
			gl_pnlTabela.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlTabela.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnlTabela.setVerticalGroup(
			gl_pnlTabela.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlTabela.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JTable tabelaClientes = new JTable();
		tabelaClientes.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				try {
					ArrayList<Clientes> lista =  dao.ClienteDAO.listarTodos();
					DefaultTableModel modelo = (DefaultTableModel) tabelaClientes.getModel();
					modelo.setRowCount(0);
					
					for (Clientes item : lista) {
		                modelo.addRow(new String[]{String.valueOf(item.getIdCliente()),
		                    String.valueOf(item.getNome()),
		                    String.valueOf(item.getCpf())
		                    
		                });
		            }
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		scrollPane.setViewportView(tabelaClientes);
		tabelaClientes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nome", "CPF"
			}
		));
		tabelaClientes.setBounds(10, 32, 342, 278);
		pnlTabela.setLayout(gl_pnlTabela);
		
				JButton btnNovo = new JButton("Cadastrar Novo Cliente");
		btnNovo.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNovo.setToolTipText("");
		btnNovo.setForeground(new Color(218, 218, 218));
		btnNovo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		btnNovo.setBackground(new Color(10, 13, 133));
		btnNovo.setBounds(813, 451, 247, 31);
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
				objCadastro.setPreferredSize(new Dimension(1000,720));
				objCadastro.pack();
				contentPane.add(objCadastro);
						}
		});
		
		JButton btnExcluir = new JButton("Excluir Cliente");
		btnExcluir.setVerticalAlignment(SwingConstants.BOTTOM);
		btnExcluir.setToolTipText("");
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		btnExcluir.setBackground(new Color(93, 127, 216));
		btnExcluir.setBounds(147, 546, 130, 31);
		contentPane.add(btnExcluir);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = tabelaClientes.getSelectedRow();
		        int id = Integer.parseInt(tabelaClientes.getValueAt(linhaSelecionada, 0).toString());
		        
		        boolean retorno;
				try {
					retorno = dao.ClienteDAO.excluir(id);
					
					if(retorno){
			            JOptionPane.showMessageDialog(btnExcluir, "Cliente excluído com sucesso!");
			        }else{
			            JOptionPane.showMessageDialog(btnExcluir, "Falha na exclusão!");
			        }
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(btnExcluir, "Não foi possivel apagar esse cliente, pois o mesmo já esta registrado no relatório de vendas!");
				}
			}
		});

		JButton btnAlterar = new JButton("Alterar Cliente");
		btnAlterar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnAlterar.setToolTipText("");
		btnAlterar.setForeground(new Color(255, 255, 255));
		btnAlterar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		btnAlterar.setBackground(new Color(93, 127, 216));
		btnAlterar.setBounds(287, 546, 142, 31);
		contentPane.add(btnAlterar);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indiceLinha =  tabelaClientes.getSelectedRow();
				if(indiceLinha >= 0){
					String produto = tabelaClientes.getModel().getValueAt(indiceLinha, 0).toString();
					
					JFormattedTextField txtCPF = new JFormattedTextField();
					txtCPF.addAncestorListener(new AncestorListener() {
						public void ancestorAdded(AncestorEvent event) {
							
						}
						public void ancestorMoved(AncestorEvent event) {
						}
						public void ancestorRemoved(AncestorEvent event) {
						}
					});
					txtCPF.setBounds(76, 103, 397, 21);
		            int id = Integer.parseInt(tabelaClientes.getValueAt(indiceLinha, 0).toString());
		            Tela3_3AlterarCliente novaTela = new Tela3_3AlterarCliente(id);
		            novaTela.setVisible(true);
		            novaTela.setPreferredSize(new Dimension(700,700));
		            novaTela.setResizable(false);
		            
		           
																	
									
					
			       }else{
			           JOptionPane.showMessageDialog(btnAlterar, "Selecione uma linha para fazer a alteração.");
			       }
			}
		});
		
		JButton btnConsultar = new JButton("Consultar Cliente");
		btnConsultar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnConsultar.setToolTipText("");
		btnConsultar.setForeground(new Color(218, 218, 218));
		btnConsultar.setFont(new Font("Segoe UI Semilight", Font.BOLD, 16));
		btnConsultar.setBackground(new Color(10, 13, 133));
		btnConsultar.setBounds(797, 272, 169, 26);
		contentPane.add(btnConsultar);
		
		JLabel ImagemLogo = new JLabel("");
		ImagemLogo.setIcon(new ImageIcon(Tela3_cliente.class.getResource("/TechMarket/telas/img.png")));
		ImagemLogo.setHorizontalAlignment(SwingConstants.CENTER);
		ImagemLogo.setBounds(-413, -29, 1906, 284);
		contentPane.add(ImagemLogo);
		
		JLabel ImgIconCliente = new JLabel("");
		ImgIconCliente.setIcon(new ImageIcon(Tela3_cliente.class.getResource("/TechMarket/telas/add_client.png")));
		ImgIconCliente.setBounds(902, 371, 64, 80);
		contentPane.add(ImgIconCliente);
		
		txtDigiteOCpf = new JTextField();
		txtDigiteOCpf.setBackground(new Color(183, 199, 242));
		txtDigiteOCpf.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
		txtDigiteOCpf.setBounds(107, 271, 680, 26);
		contentPane.add(txtDigiteOCpf);
		txtDigiteOCpf.setColumns(10);
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<Clientes> lista = dao.ClienteDAO.listarPorNome(txtDigiteOCpf.getText());
					
					DefaultTableModel modelo = (DefaultTableModel) tabelaClientes.getModel();
					
		            modelo.setRowCount(0);
		            
		            for (Clientes item : lista) {
		                modelo.addRow(new String[]{
		                    String.valueOf(item.getIdCliente()),
		                    String.valueOf(item.getNome()),
		                    String.valueOf(item.getCpf())
		                    
		                });
		            }
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

	}
}