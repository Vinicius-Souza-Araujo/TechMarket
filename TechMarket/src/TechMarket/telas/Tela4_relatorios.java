package TechMarket.telas;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Produtos;
import model.RelatorioAnalitico;
import model.RelatorioSintetico;

import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JToggleButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class Tela4_relatorios extends JFrame {
    private ButtonGroup btng = new ButtonGroup(); 
	DefaultTableModel model;
	private JTable tblSintetico;
	private JTable tblAnalitico;
	private JTextField textField;
	
	String mes = "";
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela4_relatorios frame = new Tela4_relatorios();
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
	public Tela4_relatorios() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 1302, 662);
		getContentPane().setLayout(null);
		model = new DefaultTableModel();
		Object[] colunas = {"Cliente","Valor Total","Data"};
		model.setColumnIdentifiers(colunas);
		
		
		JPanel PanelLucroMes = new JPanel();
		PanelLucroMes.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		PanelLucroMes.setBounds(193, 556, 313, 56);
		getContentPane().add(PanelLucroMes);
		PanelLucroMes.setLayout(null);
		
		JLabel lblTotalVendasResult = new JLabel("0");
		
		lblTotalVendasResult.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTotalVendasResult.setBounds(22, 11, 96, 34);
		PanelLucroMes.add(lblTotalVendasResult);
		
		JLabel lblNewLabel_1 = new JLabel("Relatórios");
		lblNewLabel_1.setForeground(new Color(27, 40, 161));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(593, 11, 214, 38);
		getContentPane().add(lblNewLabel_1);
		model = new DefaultTableModel();
		Object[] colunas2 = {"Produto","Quantidade","Subtotal"};
		model.setColumnIdentifiers(colunas2);
		
		JLabel lblNewLabel_2 = new JLabel("Relatório Sintético");
		lblNewLabel_2.setForeground(new Color(27, 40, 161));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(337, 137, 186, 25);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Relatório Analítico");
		lblNewLabel_3.setForeground(new Color(27, 40, 161));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(941, 136, 168, 26);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Valor total de vendas:");
		lblNewLabel.setForeground(new Color(27, 40, 161));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(194, 528, 233, 25);
		getContentPane().add(lblNewLabel);
		
		JPanel PanelBotao = new JPanel();
		PanelBotao.setBackground(new Color(255, 255, 255));
		PanelBotao.setForeground(new Color(255, 255, 255));
		PanelBotao.setBounds(110, 45, 1155, 38);
		getContentPane().add(PanelBotao);
		PanelBotao.setLayout(null);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Janeiro");
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mes = "01";
			}
		});
		tglbtnNewToggleButton.setBounds(27, 11, 83, 23);
		PanelBotao.add(tglbtnNewToggleButton);
		btng.add(tglbtnNewToggleButton);
		
		JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("Fevereiro");
		tglbtnNewToggleButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mes = "02";
			}
		});
		tglbtnNewToggleButton_1.setBounds(120, 11, 91, 23);
		PanelBotao.add(tglbtnNewToggleButton_1);
		btng.add(tglbtnNewToggleButton_1);
		
		JToggleButton tglbtnNewToggleButton_2 = new JToggleButton("Março");
		tglbtnNewToggleButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mes = "03";
			}
		});
		tglbtnNewToggleButton_2.setBounds(221, 11, 73, 23);
		PanelBotao.add(tglbtnNewToggleButton_2);
		btng.add(tglbtnNewToggleButton_2);
		
		JToggleButton tglbtnNewToggleButton_3 = new JToggleButton("Abril");
		tglbtnNewToggleButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mes = "04";
			}
		});
		tglbtnNewToggleButton_3.setBounds(304, 11, 69, 23);
		PanelBotao.add(tglbtnNewToggleButton_3);
		btng.add(tglbtnNewToggleButton_3);
		
		JToggleButton tglbtnNewToggleButton_4 = new JToggleButton("Maio");
		tglbtnNewToggleButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mes = "05";
			}
		});
		tglbtnNewToggleButton_4.setBounds(383, 11, 61, 23);
		PanelBotao.add(tglbtnNewToggleButton_4);
		btng.add(tglbtnNewToggleButton_4);
		
		JToggleButton tglbtnNewToggleButton_5 = new JToggleButton("Junho");
		tglbtnNewToggleButton_5.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				mes = "06";
			}
		});
		tglbtnNewToggleButton_5.setBounds(454, 11, 73, 23);
		PanelBotao.add(tglbtnNewToggleButton_5);
		btng.add(tglbtnNewToggleButton_5);
		
		JToggleButton tglbtnNewToggleButton_6 = new JToggleButton("Julho");
		tglbtnNewToggleButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mes = "07";
			}
		});
		tglbtnNewToggleButton_6.setBounds(537, 11, 76, 23);
		PanelBotao.add(tglbtnNewToggleButton_6);
		btng.add(tglbtnNewToggleButton_6);
		
		JToggleButton tglbtnNewToggleButton_7 = new JToggleButton("Agosto");
		tglbtnNewToggleButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mes = "08";
			}
		});
		tglbtnNewToggleButton_7.setBounds(623, 11, 76, 23);
		PanelBotao.add(tglbtnNewToggleButton_7);
		btng.add(tglbtnNewToggleButton_7);
		
		
		JToggleButton tglbtnNewToggleButton_8 = new JToggleButton("Setembro");
		tglbtnNewToggleButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mes = "09";
			}
		});
		tglbtnNewToggleButton_8.setBounds(709, 11, 115, 23);
		PanelBotao.add(tglbtnNewToggleButton_8);
		btng.add(tglbtnNewToggleButton_8);
		
		JToggleButton tglbtnNewToggleButton_9 = new JToggleButton("Outubro");
		tglbtnNewToggleButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mes = "10";
			}
		});
		tglbtnNewToggleButton_9.setBounds(834, 11, 97, 23);
		PanelBotao.add(tglbtnNewToggleButton_9);
		btng.add(tglbtnNewToggleButton_9);
		
		JToggleButton tglbtnNewToggleButton_10 = new JToggleButton("Novembro");
		tglbtnNewToggleButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mes = "11";
			}
		});
		tglbtnNewToggleButton_10.setBounds(941, 11, 97, 23);
		PanelBotao.add(tglbtnNewToggleButton_10);
		btng.add(tglbtnNewToggleButton_10);
		
		JToggleButton tglbtnNewToggleButton_11 = new JToggleButton("Dezembro");
		tglbtnNewToggleButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mes = "12";
			}
		});
		tglbtnNewToggleButton_11.setBounds(1048, 11, 97, 23);
		PanelBotao.add(tglbtnNewToggleButton_11);
		btng.add(tglbtnNewToggleButton_11);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(193, 174, 454, 299);
		getContentPane().add(panel_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
		);
		
		tblSintetico = new JTable();
		tblSintetico.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tblSintetico.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				double valorVendas = 0;
		        
				try {
					ArrayList<RelatorioSintetico> lista = dao.RelatorioDAO.listarTodosSinteticos();
					DefaultTableModel modelo = (DefaultTableModel) tblSintetico.getModel();
					modelo.setRowCount(0);
					
					for (RelatorioSintetico item : lista) {
						valorVendas = valorVendas + item.getValorTotal();
		                modelo.addRow(new String[]{String.valueOf(item.getIdCarrinho()),
		                    String.valueOf(item.getCliente()),
		                    String.valueOf(item.getValorTotal()),
		                    String.valueOf(item.getData())
		                    
		                   
		                });
		            }
					lblTotalVendasResult.setText(String.valueOf(valorVendas));
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
		tblSintetico.setModel(new DefaultTableModel(
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
				"N\u00B0 do Carrinho", "Cliente", "Valor total", "Data"
			}
		));
		tblSintetico.getColumnModel().getColumn(3).setPreferredWidth(100);
		scrollPane_2.setViewportView(tblSintetico);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(797, 174, 468, 299);
		getContentPane().add(panel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
		);
		
		tblAnalitico = new JTable();
		tblAnalitico.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Produto", "Quantidade", "Valor Unitário"
			}
		));
		scrollPane_1.setViewportView(tblAnalitico);
		panel_2.setLayout(gl_panel_2);
		
		JButton btnAnalitico = new JButton("Gerar Relatório Analítico");
		btnAnalitico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indiceLinha =  tblSintetico.getSelectedRow();
				if(indiceLinha >= 0){
					int idCarrinho = Integer.parseInt((String) tblSintetico.getModel().getValueAt(indiceLinha, 0));
					
					try {
						ArrayList<RelatorioAnalitico> lista = dao.RelatorioDAO.listarTodosAnaliticos(idCarrinho);
						DefaultTableModel modelo = (DefaultTableModel) tblAnalitico.getModel();
						modelo.setRowCount(0);
						
						for (RelatorioAnalitico item : lista) {
			                modelo.addRow(new String[]{String.valueOf(item.getNomeProduto()),
			                    String.valueOf(item.getQuantidade()),
			                    String.valueOf(item.getValorUnit())
			                    
			                });
			            }
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
			       }else{
			           JOptionPane.showMessageDialog(btnAnalitico, "Selecione uma linha!");
			       }
			}
		});
		btnAnalitico.setBounds(193, 484, 180, 33);
		getContentPane().add(btnAnalitico);
		
		textField = new JTextField();
		textField.setBounds(643, 91, 151, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Digite o ano:");
		lblNewLabel_4.setBounds(560, 94, 71, 14);
		getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Filtrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double valorVendas = 0;
				String ano = textField.getText();
				String data = ano+"-"+mes;
				
				if(ano.length() <4 || ano.length() >4) {
					ano = "";
					JOptionPane.showMessageDialog(btnNewButton, "Ano inválido!");
				}
				if(mes =="") {
				JOptionPane.showMessageDialog(btnNewButton, "Selecione o mês desejado!");
				}
				
				if(ano.length() == 4 && mes!= "") {
					
					
					try {
						ArrayList<RelatorioSintetico> lista = dao.RelatorioDAO.listarPorDataSinteticos(data);
						DefaultTableModel modelo = (DefaultTableModel) tblSintetico.getModel();
						modelo.setRowCount(0);
						
						for (RelatorioSintetico item : lista) {
							valorVendas = valorVendas + item.getValorTotal();
			                modelo.addRow(new String[]{String.valueOf(item.getIdCarrinho()),
			                    String.valueOf(item.getCliente()),
			                    String.valueOf(item.getValorTotal()),
			                    String.valueOf(item.getData())
			                });
			            }
						lblTotalVendasResult.setText(String.valueOf(valorVendas));
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnNewButton.setBounds(807, 90, 89, 23);
		getContentPane().add(btnNewButton);
		
		//comentario qualquer
		
		
	}
}
