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

import dao.CarrinhoDAO;
import dao.ProdutoDAO;
import model.Carrinho;
import model.ItemCarrinho;
import model.Produtos;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SpinnerNumberModel;

public class Tela2_2ProdutoCompra extends JFrame {
	double valorTotal = 0;
	
	private JPanel PainelProduto;
	private JTextField textFieldCpf;
	private JTextField FieldIDProduto;
	private JTable table;

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
		setBounds(100, 100, 1219, 675);
		PainelProduto = new JPanel();
		PainelProduto.setBackground(new Color(255, 255, 255));
		PainelProduto.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(PainelProduto);
		PainelProduto.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Carrinho");
		lblNewLabel.setForeground(new Color(0, 0, 121));
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(265, 125, 612, 60);
		PainelProduto.add(lblNewLabel);
		
		JPanel DadosCompra = new JPanel();
		DadosCompra.setBackground(new Color(189, 200, 232));
		DadosCompra.setBounds(225, 183, 756, 179);
		PainelProduto.add(DadosCompra);
		DadosCompra.setLayout(null);
		
		JLabel lblCPF = new JLabel("CPF Cliente");
		lblCPF.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		lblCPF.setBounds(28, 21, 108, 14);
		DadosCompra.add(lblCPF);
		
		
		JFormattedTextField textFieldCpf = new JFormattedTextField();
		textFieldCpf.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
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
		lblIDProduto.setBounds(28, 46, 81, 14);
		DadosCompra.add(lblIDProduto);
		
		FieldIDProduto = new JTextField();
		

		
		FieldIDProduto.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		FieldIDProduto.setBounds(100, 43, 95, 20);
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
		lblQuantidade.setBounds(28, 71, 74, 14);
		DadosCompra.add(lblQuantidade);
		
		JSpinner spinnerQuantidade = new JSpinner();
		spinnerQuantidade.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinnerQuantidade.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		spinnerQuantidade.setBounds(100, 71, 95, 20);
		DadosCompra.add(spinnerQuantidade);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotal.setBounds(28, 113, 55, 14);
		DadosCompra.add(lblTotal);
		
		JLabel lblTotalValor = new JLabel("0");
		lblTotalValor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTotalValor.setBounds(90, 113, 105, 14);
		DadosCompra.add(lblTotalValor);
		
		
		JButton botaoAdicionar = new JButton("Adicionar");
		botaoAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				
				
				try {
					if(FieldIDProduto.getText().equals("")) {
						boolean verficarProduto = dao.CarrinhoDAO.verificarProduto("0");
					}
					
					boolean verficarProduto = dao.CarrinhoDAO.verificarProduto(FieldIDProduto.getText());
					if(verficarProduto == true) {
						
						Produtos prod = ProdutoDAO.listarPorID(Integer.parseInt(FieldIDProduto.getText()));
						int id = Integer.parseInt(FieldIDProduto.getText());
						String produto = prod.getNome();
						double valor = prod.getPreco();
						int quantidade = Integer.parseInt(spinnerQuantidade.getValue().toString());
						int quantidadeEstoque =  prod.getEstoque();
						if(quantidade <= quantidadeEstoque ) {
							
								
						DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				        modelo.addRow(new String[]{
				                                    String.valueOf(id),
				                                    produto, 
				                                    String.valueOf(valor),
				                                    String.valueOf(quantidade)
				                                    }
				                    );
						
						
				        
				        double valorLinha = valor * quantidade;
				        valorTotal += valorLinha;
				        
				        lblTotalValor.setText(String.valueOf(valorTotal));
				        
				        boolean vender;
						try {
							CarrinhoDAO.vender(id, quantidade);
				
					        
						} catch (SQLException e1 ) {
							// TODO Auto-generated catch block
							
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				        
						}else {JOptionPane.showMessageDialog(botaoAdicionar, "Estoque insuficiente no momento!");}
				        
						
					}
					
					
						
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					
					FieldIDProduto.setText("");
					
					JOptionPane.showMessageDialog(botaoAdicionar, "Esse produto não existe no sistema!");
				} 
				
				
				
				
				
			}
		});
		botaoAdicionar.setBounds(551, 111, 111, 23);
		DadosCompra.add(botaoAdicionar);
		
		
		
		
		
		JPanel TabelasCompras = new JPanel();
		TabelasCompras.setBounds(225, 373, 756, 218);
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
			},
			new String[] {
				"ID", "Produto", "Valor", "Quantidade"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true
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
				
				
					try {
						
						
						int idCliente = dao.CarrinhoDAO.verificarCpf(textFieldCpf.getText());
						
						if (idCliente!= 0) {
							ArrayList<ItemCarrinho> lista = new ArrayList<ItemCarrinho>();
							
							if(table.getRowCount()>0){
				                for(int i=0;i<table.getRowCount();i++){
				                	ItemCarrinho item = new ItemCarrinho();

				                    item.setIdProduto(Integer.parseInt(table.getValueAt(i, 0).toString()));
				                    item.setNome(table.getValueAt(i, 1).toString());
				                    item.setValor(Double.parseDouble(table.getValueAt(i, 2).toString()));
				                    item.setQuantidade(Integer.parseInt(table.getValueAt(i, 3).toString()));
				                   

				                    //Adiciono o objeto à listaItens
				                    lista.add(item);

				                }
				        }
							Double valorTotal = Double.parseDouble(lblTotalValor.getText());
							
					     
							Carrinho objCarrinho = new Carrinho();
							
							objCarrinho.setIdCliente(idCliente);
							
							objCarrinho.setListaItens(lista);
							
							objCarrinho.setTotal(valorTotal);
							
							DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
						    Date date = new Date();
						    String data = dateFormat.format(date);
						    
						    objCarrinho.setDataEhora(data);
							if(objCarrinho.getListaItens().size() > 0) {
							boolean retorno = CarrinhoDAO.salvar(objCarrinho);
						
					        if (retorno == true){
					        	   
					        		DefaultTableModel model = (DefaultTableModel) table.getModel();
					        		int quantidadeLinhas = table.getRowCount();
						                for (int i= 1;i<= quantidadeLinhas ;i++){

						    				model.removeRow(0);
						                }            
						                
						        FieldIDProduto.setText("");   
						        textFieldCpf.setText("");
					        	JOptionPane.showMessageDialog(botaoConfirmar, "Compra gravada com sucesso!");
					        	
					        } else{
					        	FieldIDProduto.setText("");   
						        textFieldCpf.setText("");
					            JOptionPane.showMessageDialog(botaoConfirmar, "Falha na gravação!");
					        }
							}
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						textFieldCpf.setText("");
						JOptionPane.showMessageDialog(botaoConfirmar, "CPF não localizado no sistema!");
						
					}
				
				
				
					
					
					objValidador.validarProduto(FieldIDProduto, textFieldCpf);
				
				
			}
		});
		botaoConfirmar.setBounds(557, 602, 111, 23);
		PainelProduto.add(botaoConfirmar);
		
		JButton botaoExcluir = new JButton("Excluir");
		
		botaoExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int linhaSelecionada = table.getSelectedRow();
				int id = Integer.parseInt(table.getValueAt(linhaSelecionada, 0).toString());
				double valorUnit = Double.parseDouble(table.getValueAt(linhaSelecionada, 2).toString());
				int quantidade = Integer.parseInt(table.getValueAt(linhaSelecionada, 3).toString());
				
				try {
					ProdutoDAO.restorno(id, quantidade);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.removeRow(linhaSelecionada); 
				
				valorTotal -= (valorUnit * quantidade);
				lblTotalValor.setText(String.valueOf(valorTotal));
			}
		});
		botaoExcluir.setBounds(436, 602, 111, 23);
		PainelProduto.add(botaoExcluir);
		
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
		
		btnNovoCliente.setBounds(305, 602, 111, 23);
		PainelProduto.add(btnNovoCliente);
		
		JLabel Img = new JLabel("");
		Img.setIcon(new ImageIcon(Tela2_2ProdutoCompra.class.getResource("/TechMarket/telas/PessoaSupermercado.png")));
		Img.setBounds(-70, 0, 1409, 131);
		PainelProduto.add(Img);
		
	}
}
