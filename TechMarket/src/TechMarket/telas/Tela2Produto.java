package TechMarket.telas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;

import model.Produtos;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.Insets;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JToggleButton;
import java.awt.Font;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class Tela2Produto extends JFrame {
	private ButtonGroup btng = new ButtonGroup(); 
	private JPanel Painel_produto;
	private JTable table;
	private JPanel Painel_botoes;
	private JTextField CampoPesquisa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela2Produto frame = new Tela2Produto();
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
	public Tela2Produto() {
		setBounds(100, 100, 1328, 706);
		Painel_produto = new JPanel();
		Painel_produto.setBackground(new Color(255, 255, 255));
		Painel_produto.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(Painel_produto);
		Painel_produto.setLayout(null);
		
		JPanel Tabela = new JPanel();
		Tabela.setBackground(new Color(255, 255, 255));
		Tabela.setBounds(312, 347, 613, 231);
		Painel_produto.add(Tabela);
		Tabela.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 593, 209);
		Tabela.add(scrollPane);
		
		table = new JTable();
		table.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				try {
					ArrayList<Produtos> lista =  dao.ProdutoDAO.listarTodos();
					DefaultTableModel modelo = (DefaultTableModel) table.getModel();
					modelo.setRowCount(0);
					
					for (Produtos item : lista) {
		                modelo.addRow(new String[]{String.valueOf(item.getIdProduto()),
		                    String.valueOf(item.getNome()),
		                    String.valueOf(item.getPreco()),
		                    String.valueOf(item.getEstoque())
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
		table.setBackground(new Color(192, 192, 192));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "", "", ""},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "Nome do produto", "Pre\u00E7o", "QAT"
			}
		));
		scrollPane.setViewportView(table);
		
		Painel_botoes = new JPanel();
		Painel_botoes.setBackground(new Color(255, 255, 255));
		Painel_botoes.setBounds(381, 589, 322, 47);
		Painel_produto.add(Painel_botoes);
		Painel_botoes.setLayout(null);
		
		JButton BotaoNovo = new JButton("Novo");
		BotaoNovo.setBackground(new Color(128, 128, 255));
		
		BotaoNovo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Tela2_1ProdutoCadastros objcadastro = null;
				try {
					objcadastro = new Tela2_1ProdutoCadastros();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				objcadastro.setVisible(true);
				objcadastro.setResizable(true);				
				objcadastro.setTitle("Tela2_1ProdutoCadastro");
				objcadastro.setPreferredSize(new Dimension(1000,720));
				objcadastro.pack();
			}
		});
		BotaoNovo.setBounds(32, 11, 80, 25);
		Painel_botoes.add(BotaoNovo);
		
		JButton BotaoExcluir = new JButton("Excluir");
		BotaoExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = table.getSelectedRow();
		        int id = Integer.parseInt(table.getValueAt(linhaSelecionada, 0).toString());
		        
		        boolean retorno;
				try {
					retorno = dao.ProdutoDAO.excluir(id);
					
					if(retorno){
			            JOptionPane.showMessageDialog(BotaoExcluir, "Produto exclu??do com sucesso!");
			        }else{
			            JOptionPane.showMessageDialog(BotaoExcluir, "Falha na exclus??o!");
			        }
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(BotaoExcluir, "N??o foi possivel apagar esse prduto pois o mesmo j?? esta registrado no relat??rio de vendas!");
				}
		        
			}
		});
		BotaoExcluir.setBackground(new Color(128, 128, 255));
		BotaoExcluir.setBounds(122, 11, 80, 25);
		Painel_botoes.add(BotaoExcluir);
		
		JButton BotaoAlterar = new JButton("Alterar");
		BotaoAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indiceLinha =  table.getSelectedRow();
				if(indiceLinha >= 0){
					String produto = table.getModel().getValueAt(indiceLinha, 0).toString();
					
					Produtos obj = new Produtos();
		            obj.setIdProduto(Integer.parseInt(table.getValueAt(indiceLinha, 0).toString()));
		            obj.setNome(table.getValueAt(indiceLinha, 1).toString());
		            obj.setPreco(Double.parseDouble(table.getValueAt(indiceLinha, 2).toString()));
		            obj.setEstoque(Integer.parseInt(table.getValueAt(indiceLinha, 3).toString()));
		           
		            Tela2_3ProdutoAlterar novaTela = new Tela2_3ProdutoAlterar(obj);
		            novaTela.setVisible(true);
		            novaTela.setPreferredSize(new Dimension(200,200));
		            novaTela.setResizable(false);
		            
		           
																	
									
					
			       }else{
			           JOptionPane.showMessageDialog(BotaoAlterar, "Selecione uma linha para fazer a altera????o.");
			       }
				
			}
			
		});
		BotaoAlterar.setBackground(new Color(128, 128, 255));
		BotaoAlterar.setBounds(212, 11, 80, 25);
		Painel_botoes.add(BotaoAlterar);
		
		JPanel Painel_Logo = new JPanel();
		Painel_Logo.setBackground(new Color(255, 255, 255));
		Painel_Logo.setBounds(-29, 0, 1350, 238);
		Painel_produto.add(Painel_Logo);
		Painel_Logo.setLayout(null);
		
		JLabel ImagemLogo = new JLabel("New label");
		ImagemLogo.setIcon(new ImageIcon(Tela2Produto.class.getResource("/TechMarket/telas/img.png")));
		ImagemLogo.setHorizontalAlignment(SwingConstants.CENTER);
		ImagemLogo.setBounds(-83, -26, 1764, 264);
		Painel_Logo.add(ImagemLogo);
		
		CampoPesquisa = new JTextField();
		CampoPesquisa.setBackground(new Color(190, 185, 253));
		CampoPesquisa.setBounds(326, 249, 589, 20);
		Painel_produto.add(CampoPesquisa);
		
		JPanel Painel_Menu = new JPanel();
		Painel_Menu.setBackground(new Color(255, 255, 255));
		Painel_Menu.setBounds(347, 267, 533, 32);
		Painel_produto.add(Painel_Menu);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(128, 128, 255));
		Painel_Menu.add(menuBar, "1, 1, center, top");
		
		JMenu MenuCliente = new JMenu("Cliente");
		menuBar.add(MenuCliente);
		
		JMenuItem ClienteItem = new JMenuItem("Consultar cliente");
		ClienteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
		MenuCliente.add(ClienteItem);
		ClienteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Tela3_cliente objItemConsultarCliente = new Tela3_cliente();
					objItemConsultarCliente.setVisible(true);
					objItemConsultarCliente.setResizable(true);				
					objItemConsultarCliente.setTitle("Tela3_cliente");
					objItemConsultarCliente.setPreferredSize(new Dimension(1080,720));
					objItemConsultarCliente.pack();
				
							}
		});
		
		JMenuItem CadastrarCliente = new JMenuItem("Cadastrar Cliente");
		CadastrarCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_DOWN_MASK));
		MenuCliente.add(CadastrarCliente);
		CadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Tela3_2CadastroCliente objItemCadastrarCliente = null;
				try {
					objItemCadastrarCliente = new Tela3_2CadastroCliente();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					objItemCadastrarCliente.setVisible(true);
					objItemCadastrarCliente.setResizable(true);				
					objItemCadastrarCliente.setTitle("Tela3_2CadastroCliente");
					objItemCadastrarCliente.setPreferredSize(new Dimension(1080,720));
					objItemCadastrarCliente.pack();
				
							}
		});
		
		JMenu MenuProduto = new JMenu("Produtos");
		menuBar.add(MenuProduto);
		
		JMenuItem CadastrarProdutoItem = new JMenuItem("Cadastrar produto");
		CadastrarProdutoItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_DOWN_MASK));
		MenuProduto.add(CadastrarProdutoItem);
		
		CadastrarProdutoItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Tela2_1ProdutoCadastros objItemCadastroProduto = null;
					try {
						objItemCadastroProduto = new Tela2_1ProdutoCadastros();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					objItemCadastroProduto.setVisible(true);
					objItemCadastroProduto.setResizable(true);				
					objItemCadastroProduto.setTitle("Tela2_1ProdutoCadastros");
					objItemCadastroProduto.setPreferredSize(new Dimension(1080,720));
					objItemCadastroProduto.pack();
							}
		});
		
		JMenuItem ConsultarMenu = new JMenuItem("Consultar produto");
		ConsultarMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
		MenuProduto.add(ConsultarMenu);
		CadastrarProdutoItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Tela2Produto objItemConsultaProduto = null;
					objItemConsultaProduto = new Tela2Produto();
					objItemConsultaProduto.setVisible(true);
					objItemConsultaProduto.setResizable(true);				
					objItemConsultaProduto.setTitle("Tela2_1ProdutoCadastros");
					objItemConsultaProduto.setPreferredSize(new Dimension(1080,720));
					objItemConsultaProduto.pack();
							}
		});
		
		JMenu MenuRelatorios = new JMenu("Relat??rios");
		menuBar.add(MenuRelatorios);
		
		JMenuItem ConsultarRelatorios = new JMenuItem("Consultar relat??rios");
		ConsultarRelatorios.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_DOWN_MASK));
		MenuRelatorios.add(ConsultarRelatorios);
		
		ConsultarRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela4_relatorios objItemRelatorios = null;
				objItemRelatorios = new Tela4_relatorios();
				objItemRelatorios.setVisible(true);
				objItemRelatorios.setResizable(true);				
				objItemRelatorios.setTitle("Tela4_relatorios");
				objItemRelatorios.setPreferredSize(new Dimension(1080,720));
				objItemRelatorios.pack();
							}
		});
		
		
		JPanel Botoes_Categoria = new JPanel();
		Botoes_Categoria.setLayout(null);
		Botoes_Categoria.setForeground(Color.WHITE);
		Botoes_Categoria.setBackground(Color.WHITE);
		Botoes_Categoria.setBounds(278, 298, 721, 38);
		Painel_produto.add(Botoes_Categoria);
		
		JToggleButton BotaoCatLimpeza = new JToggleButton("Limpeza");
		BotaoCatLimpeza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<Produtos> lista = dao.ProdutoDAO.listarPorCategoria(BotaoCatLimpeza.getText());
					
					DefaultTableModel modelo = (DefaultTableModel) table.getModel();
					
		            modelo.setRowCount(0);
		            
		            for (Produtos item : lista) {
		                modelo.addRow(new String[]{
		                    String.valueOf(item.getIdProduto()),
		                    String.valueOf(item.getNome()),
		                    String.valueOf(item.getPreco()),
		                    String.valueOf(item.getEstoque())
		                });
		            }
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		BotaoCatLimpeza.setBounds(167, 11, 83, 23);
		Botoes_Categoria.add(BotaoCatLimpeza);
		btng.add(BotaoCatLimpeza);
		
		JToggleButton BotaoCatHortifruit = new JToggleButton("Hortifruit");
		BotaoCatHortifruit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<Produtos> lista = dao.ProdutoDAO.listarPorCategoria(BotaoCatHortifruit.getText());
					
					DefaultTableModel modelo = (DefaultTableModel) table.getModel();
					
		            modelo.setRowCount(0);
		            
		            for (Produtos item : lista) {
		                modelo.addRow(new String[]{
		                    String.valueOf(item.getIdProduto()),
		                    String.valueOf(item.getNome()),
		                    String.valueOf(item.getPreco()),
		                    String.valueOf(item.getEstoque())
		                });
		            }
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		BotaoCatHortifruit.setBounds(260, 11, 91, 23);
		Botoes_Categoria.add(BotaoCatHortifruit);
		btng.add(BotaoCatHortifruit);
		
		
		JToggleButton BotaoCatBebidas = new JToggleButton("Bebidas");
		BotaoCatBebidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<Produtos> lista = dao.ProdutoDAO.listarPorCategoria(BotaoCatBebidas.getText());
					
					DefaultTableModel modelo = (DefaultTableModel) table.getModel();
					
		            modelo.setRowCount(0);
		            
		            for (Produtos item : lista) {
		                modelo.addRow(new String[]{
		                    String.valueOf(item.getIdProduto()),
		                    String.valueOf(item.getNome()),
		                    String.valueOf(item.getPreco()),
		                    String.valueOf(item.getEstoque())
		                });
		            }
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		BotaoCatBebidas.setBounds(361, 11, 89, 23);
		Botoes_Categoria.add(BotaoCatBebidas);
		btng.add(BotaoCatBebidas);
		
		JToggleButton BotaoCatComida = new JToggleButton("Comida");
		BotaoCatComida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<Produtos> lista = dao.ProdutoDAO.listarPorCategoria(BotaoCatComida.getText());
					
					DefaultTableModel modelo = (DefaultTableModel) table.getModel();
					
		            modelo.setRowCount(0);
		            
		            for (Produtos item : lista) {
		                modelo.addRow(new String[]{
		                    String.valueOf(item.getIdProduto()),
		                    String.valueOf(item.getNome()),
		                    String.valueOf(item.getPreco()),
		                    String.valueOf(item.getEstoque())
		                });
		            }
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		BotaoCatComida.setBounds(460, 11, 83, 23);
		Botoes_Categoria.add(BotaoCatComida);
		btng.add(BotaoCatComida);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(925, 249, 105, 25);
		Painel_produto.add(btnConsultar);
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<Produtos> lista = dao.ProdutoDAO.listarPorNome(CampoPesquisa.getText());
					
					DefaultTableModel modelo = (DefaultTableModel) table.getModel();
					
		            modelo.setRowCount(0);
		            
		            for (Produtos item : lista) {
		                modelo.addRow(new String[]{
		                    String.valueOf(item.getIdProduto()),
		                    String.valueOf(item.getNome()),
		                    String.valueOf(item.getPreco()),
		                    String.valueOf(item.getEstoque())
		                });
		            }
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConsultar.setBackground(new Color(128, 128, 255));
		
		JButton BtnCompra = new JButton("Nova Compra");
		BtnCompra.setBounds(713, 594, 136, 42);
		Painel_produto.add(BtnCompra);
		BtnCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela2_2ProdutoCompra objcompras = null;
				try {
					objcompras = new Tela2_2ProdutoCompra();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				objcompras.setVisible(true);
				objcompras.setResizable(true);				
				objcompras.setTitle("Tela2Produto");
				objcompras.setPreferredSize(new Dimension(1000,1000));
				objcompras.pack();
			}
		});
		
		BtnCompra.setIcon(new ImageIcon(Tela2Produto.class.getResource("/TechMarket/telas/Botao adicionar imagem (1).png")));
		BtnCompra.setBackground(new Color(255, 255, 255));
		BtnCompra.setVerticalAlignment(SwingConstants.TOP);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}


