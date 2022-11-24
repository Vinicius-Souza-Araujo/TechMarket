package TechMarket.telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Clientes;

import javax.swing.ImageIcon;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;



public class Tela3_2CadastroCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
private JTextField txtNome;
private JTextField txtEmail;
private JTextField txtRua;
private JTextField txtNumero;
private JTextField txtCidade;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela3_2CadastroCliente frame = new Tela3_2CadastroCliente();
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
	public Tela3_2CadastroCliente() throws ParseException {
		setTitle("Tela3.2 Cadastro Cliente");
		setBounds(100, 100, 1286, 693);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblTitulo = new JLabel("Cadastro Cliente");
		lblTitulo.setFont(new Font("Bebas Neue", Font.PLAIN, 60));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setBounds(298, 114, 678, 58);
		contentPane.add(lblTitulo);

		//painel para adicionar as guias cliente e endereco
		JTabbedPane pnlGuias = new JTabbedPane(JTabbedPane.TOP);
		pnlGuias.setBounds(193, 200, 873, 420);
		contentPane.add(pnlGuias);
		ButtonGroup grupoSexo = new ButtonGroup();
						
						ButtonGroup grupoEstadoCivil = new ButtonGroup();
		//guia cliente
				JPanel pnlAba1 = new JPanel();
				pnlAba1.setBackground(new Color(183, 199, 242));
				pnlGuias.add(pnlAba1);
				pnlGuias.setTitleAt(0, "Cliente");
				pnlAba1.setLayout(null);
						
								JLabel lblNome = new JLabel("Nome:");
								lblNome.setBackground(new Color(10, 13, 133));
								lblNome.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
								lblNome.setBounds(22, 27, 63, 33);
								pnlAba1.add(lblNome);
								
								txtNome = new JTextField();
								txtNome.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 11));
								txtNome.setBounds(76, 34, 610, 21);
								pnlAba1.add(txtNome);
								txtNome.setColumns(10);
								
								JLabel lblDataNascimento = new JLabel("Data De Nascimento:");
								lblDataNascimento.setBackground(new Color(10, 13, 133));
								lblDataNascimento.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
								lblDataNascimento.setBounds(22, 147, 126, 21);
								pnlAba1.add(lblDataNascimento);
								
										JFormattedTextField txtDataNascimento = new JFormattedTextField();
										txtDataNascimento.setHorizontalAlignment(SwingConstants.CENTER);
										txtDataNascimento.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 11));
										txtDataNascimento.setBounds(154, 147, 52, 21);
										pnlAba1.add(txtDataNascimento);
										txtDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
										//crio um evento de teclado que impede o usuário de digitar letras no campo Data Nascimento
										txtDataNascimento.addKeyListener(new KeyAdapter() {
											@Override
											public void keyTyped(KeyEvent e) {
												char caractere = e.getKeyChar();
												if ( ((caractere < '0') || (caractere > '9')) && (caractere !=KeyEvent.VK_BACK_SPACE)) {
												    e.consume();     
												JOptionPane.showMessageDialog(contentPane, "Campo Data Nascimento permite somente números!");
												}
											}});
										
																JLabel lblCPF = new JLabel("CPF:");
																lblCPF.setBackground(new Color(10, 13, 133));
																lblCPF.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
																lblCPF.setBounds(22, 103, 38, 19);
																pnlAba1.add(lblCPF);
																
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
																		pnlAba1.add(txtCPF);
																		txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
																		
																								//crio um evento de teclado que impede o usuário de digitar letras no campo CPF
																								txtCPF.addKeyListener(new KeyAdapter() {
																									@Override
																									public void keyTyped(KeyEvent e) {
																										char caractere = e.getKeyChar();
																										if ( ((caractere < '0') || (caractere > '9')) && (caractere !=KeyEvent.VK_BACK_SPACE)) {
																										    e.consume();     
																										JOptionPane.showMessageDialog(contentPane, "Campo CPF permite somente números!");
																										}
																									}});
																								
																								JLabel lblSexo = new JLabel("Sexo:");
																								lblSexo.setBackground(new Color(10, 13, 133));
																								lblSexo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
																								lblSexo.setBounds(22, 190, 38, 21);
																								pnlAba1.add(lblSexo);
																								
																														//botão de opção feminino
																														JRadioButton rboF = new JRadioButton("Feminino");
																														rboF.setBackground(new Color(183, 199, 242));
																														rboF.setBounds(76, 191, 96, 21);
																														rboF.setActionCommand("Feminino");
																														pnlAba1.add(rboF);
																														
																																				// botão de opção masculino
																																				JRadioButton rboM = new JRadioButton("Masculino");
																																				rboM.setBackground(new Color(183, 199, 242));
																																				rboM.setBounds(174, 191, 104, 21);
																																				rboM.setActionCommand("Masculino");
																																				pnlAba1.add(rboM);
																																				
																																										// botão de opção outros
																																										JRadioButton rboO= new JRadioButton("Outros");
																																										rboO.setBackground(new Color(183, 199, 242));
																																										rboO.setBounds(280, 191, 92, 21);
																																										rboO.setActionCommand("Outros");
																																										pnlAba1.add(rboO);
																																										grupoSexo.add(rboF);
																																										grupoSexo.add(rboM);
																																										grupoSexo.add(rboO);
																																										
																																																JLabel lblEstadoCivil = new JLabel("EstadoCivil");
																																																lblEstadoCivil.setBackground(new Color(10, 13, 133));
																																																lblEstadoCivil.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
																																																lblEstadoCivil.setBounds(22, 234, 75, 33);
																																																pnlAba1.add(lblEstadoCivil);
																																																
																																																						// botão de alternância solteiro
																																																						JToggleButton tgS = new JToggleButton("Solteiro");
																																																						tgS.setForeground(new Color(255, 255, 255));
																																																						tgS.setBackground(new Color(67, 63, 220));
																																																						tgS.setBounds(107, 241, 115, 21);
																																																						tgS.setActionCommand("Solteiro");
																																																						pnlAba1.add(tgS);
																																																						
																																																												// botão de alternância casado
																																																												JToggleButton tgC = new JToggleButton("Casado");
																																																												tgC.setForeground(new Color(255, 255, 255));
																																																												tgC.setBackground(new Color(67, 63, 220));
																																																												tgC.setBounds(232, 241, 115, 21);
																																																												tgC.setActionCommand("Casado");
																																																												pnlAba1.add(tgC);
																																																												
																																																																		// botão de alternância outros
																																																																		JToggleButton tgO = new JToggleButton("Outros");
																																																																		tgO.setForeground(new Color(255, 255, 255));
																																																																		tgO.setBackground(new Color(67, 63, 220));
																																																																		tgO.setBounds(357, 241, 97, 21);
																																																																		tgO.setActionCommand("Outros");
																																																																		pnlAba1.add(tgO);
																																																																		grupoEstadoCivil.add(tgS);
																																																																		grupoEstadoCivil.add(tgC);
																																																																		grupoEstadoCivil.add(tgO);
																																																																		
																																																																		JLabel lblTelefone= new JLabel("Telefone:");
																																																																		lblTelefone.setBackground(new Color(10, 13, 133));
																																																																		lblTelefone.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
																																																																		lblTelefone.setBounds(269, 146, 52, 22);
																																																																		pnlAba1.add(lblTelefone);
																																																																		
																																																																								JFormattedTextField txtTelefone = new JFormattedTextField();
																																																																								txtTelefone.setBounds(328, 148, 309, 21);
																																																																								pnlAba1.add(txtTelefone);
																																																																								txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
																																																																								
																																																																								//crio um evento de teclado que impede o usuário de digitar letras no campo telefone
																																																																								txtTelefone.addKeyListener(new KeyAdapter() {
																																																																									@Override
																																																																									public void keyTyped(KeyEvent e) {
																																																																										char caractere = e.getKeyChar();
																																																																										if ( ((caractere < '0') || (caractere > '9')) && (caractere !=KeyEvent.VK_BACK_SPACE)) {
																																																																										    e.consume();     
																																																																										JOptionPane.showMessageDialog(contentPane, "Campo Telefone permite somente números!");
																																																																										}
																																																																									}});
																																																																								
																																																																																		JLabel lblEmail= new JLabel("Email:");
																																																																																		lblEmail.setBackground(new Color(10, 13, 133));
																																																																																		lblEmail.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
																																																																																		lblEmail.setBounds(22, 71, 63, 21);
																																																																																		pnlAba1.add(lblEmail);
																																																																																		
																																																																																		txtEmail = new JTextField();
																																																																																		txtEmail.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 11));
																																																																																		txtEmail.setBounds(76, 71, 610, 21);
																																																																																		pnlAba1.add(txtEmail);
																																																																																		txtEmail.setColumns(10);
																																																																																		
																																																																																												//crio o botão que vai para a próxima guia
																																																																																												JButton btnProximo = new JButton("Próximo");
																																																																																												btnProximo.setForeground(new Color(255, 255, 255));
																																																																																												btnProximo.setBackground(new Color(12, 22, 120));
																																																																																												btnProximo.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
																																																																																												btnProximo.setBounds(641, 348, 171, 33);
																																																																																												pnlAba1.add(btnProximo);										
																																																																																												
		//guia endereco
		JPanel pnlAba2 = new JPanel();
		pnlAba2.setBackground(new Color(183, 199, 242));
		pnlGuias.add(pnlAba2);
		pnlGuias.setTitleAt(1, "Endereço");
		pnlAba2.setLayout(null);
		
				JLabel lblRua = new JLabel("Rua:");
				lblRua.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
				lblRua.setBounds(38, 70, 38, 28);
				pnlAba2.add(lblRua);
				
						txtRua = new JTextField();
						txtRua.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
						txtRua.setBounds(87, 77, 491, 20);
						pnlAba2.add(txtRua);
						txtRua.setColumns(10);
						
						JLabel lblNumero= new JLabel("Número:");
						lblNumero.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
						lblNumero.setBounds(623, 70, 112, 28);
						pnlAba2.add(lblNumero);
						
						txtNumero = new JTextField();
						txtNumero.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
						txtNumero.setBounds(710, 77, 112, 20);
						pnlAba2.add(txtNumero);
						txtNumero.setColumns(10);
						//crio um evento de teclado que impede o usuário de digitar letras no campo Numero
						txtNumero.addKeyListener(new KeyAdapter() {
							@Override
							public void keyTyped(KeyEvent e) {
								char caractere = e.getKeyChar();
								if ( ((caractere < '0') || (caractere > '9')) && (caractere !=KeyEvent.VK_BACK_SPACE)) {
								    e.consume();     
								JOptionPane.showMessageDialog(contentPane, "Campo Número permite somente números!");
								}
							}});
						
								JLabel lblCep= new JLabel("Cep:");
								lblCep.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
								lblCep.setBounds(623, 109, 38, 28);
								pnlAba2.add(lblCep);
								
										JFormattedTextField txtCep = new JFormattedTextField();
										txtCep.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
										txtCep.setBounds(713, 118, 109, 20);
										pnlAba2.add(txtCep);
										txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
										//crio um evento de teclado que impede o usuário de digitar letras no campo Cep
										txtCep.addKeyListener(new KeyAdapter() {
											@Override
											public void keyTyped(KeyEvent e) {
												char caractere = e.getKeyChar();
												if ( ((caractere < '0') || (caractere > '9')) && (caractere !=KeyEvent.VK_BACK_SPACE)) {
												    e.consume();     
												JOptionPane.showMessageDialog(contentPane, "Campo Cep permite somente números!");
												}
											}});
										
														JLabel lblEstado= new JLabel("Estado:");
														lblEstado.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
														lblEstado.setBounds(38, 153, 63, 33);
														pnlAba2.add(lblEstado);
														
														JComboBox comboEstado = new JComboBox();
														comboEstado.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
														comboEstado.setModel(new DefaultComboBoxModel(
																new String[] {"Selecione um estado", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio De Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins", "Distrito Federal"}));
														comboEstado.setBounds(115, 160, 295, 26);
														pnlAba2.add(comboEstado);
														
																				JLabel lblCidade= new JLabel("Cidade:");
																				lblCidade.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
																				lblCidade.setBounds(38, 109, 63, 33);
																				pnlAba2.add(lblCidade);
																				
																				txtCidade= new JTextField();
																				txtCidade.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
																				txtCidade.setBounds(115, 118, 463, 20);
																				pnlAba2.add(txtCidade);
																				txtCidade.setColumns(10);
																				
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(229, 229, 229));
		btnVoltar.setBackground(new Color(10, 13, 133));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVoltar.setBounds(78, 341, 123, 41);
		pnlAba2.add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								pnlGuias.setSelectedIndex(0);
							}
		});
		
		JButton btnConfirmar= new JButton("Confirmar");
		btnConfirmar.setBackground(new Color(10, 13, 133));
		btnConfirmar.setForeground(new Color(227, 227, 227));
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConfirmar.setBounds(647, 341, 123, 41);
		pnlAba2.add(btnConfirmar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Tela3_2CadastroCliente.class.getResource("/TechMarket/telas/logo_pequeno.png")));
		lblNewLabel.setBounds(483, 31, 269, 72);
		contentPane.add(lblNewLabel);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								//chamo o método da classe ValidadorCliente que verifica se todos os campos de endereço foram preenchidos
				ValidadorCliente objValidador = new ValidadorCliente();
				objValidador.validarEndereco(comboEstado, txtRua, txtNumero, txtCidade, txtCep);
				
				Clientes objCliente = new Clientes();
				String nome = txtNome.getText();
				String sexo = grupoSexo.getSelection().getActionCommand();
				String email = txtEmail.getText();
				String estadoCivil = grupoEstadoCivil.getSelection().getActionCommand();
				String dataNasc = txtDataNascimento.getText();
				String cpf = txtCPF.getText();
				String telefone = txtTelefone.getText();

				objCliente.setNome(nome);
				objCliente.setSexo(sexo);
				objCliente.setEmail(email);
				objCliente.setEstadoCivil(estadoCivil);
				objCliente.setDataNasc(dataNasc);
				objCliente.setCpf(cpf);
				objCliente.setTelefone(telefone);

				String rua = txtRua.getText();
				String estado = (String) comboEstado.getSelectedItem();
				String numero = txtNumero.getText();
				String cidade = txtNumero.getText();
				String cep = txtCep.getText();
					
				objCliente.setRua(rua);
				objCliente.setEstado(estado);
				objCliente.setNumero(numero);
				objCliente.setCidade(cidade);
				objCliente.setCep(cep);
								
				try {
					
				   if(txtNome.getText() != "" && !grupoSexo.getSelection().equals("") && txtEmail.getText()!=""
					  && !grupoEstadoCivil.getSelection().equals("") && txtDataNascimento.getText()!=""
					  && txtCPF.getText()!="" && txtTelefone.getText()!="" && txtRua.getText()!= ""
					  && !comboEstado.getSelectedItem().equals("Selecione um estado") && txtNumero.getText()!= ""
					  && txtCidade.getText()!= "" && txtCep.getText()!="") {
					boolean retorno = dao.ClienteDAO.cadastrar(objCliente);
				    
					if(retorno == true) {
						JOptionPane.showMessageDialog(contentPane,"Dados enviados com sucesso!");
						txtNome.setText("");
						grupoSexo.clearSelection();
						txtEmail.setText("");
						grupoEstadoCivil.clearSelection();
						txtDataNascimento.setText("");
						txtCPF.setText("");
						txtTelefone.setText("");
						txtRua.setText("");
						comboEstado.getSelectedItem().equals("Selecione um estado");
						txtNumero.setText("");
						txtCidade.setText("");
						txtCep.setText("");
						
						Tela1_principal objPrincipal = new Tela1_principal();
						objPrincipal.setVisible(true);
														objPrincipal.setResizable(true);				
										objPrincipal.setTitle("Tela1_principal");
									objPrincipal.setPreferredSize(new Dimension(200,200));
										
						
					}
				   }
				}catch(Exception ex) {JOptionPane.showMessageDialog(contentPane,"Falha ao tentar cadastrar cliente!");}
			}});
		btnProximo.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		try {
			boolean retorno = dao.ClienteDAO.verificarCpfExistente(txtCPF.getText());
			if(retorno == false) {
				JOptionPane.showMessageDialog(contentPane, "CPF já existe no sistema!");
				txtCPF.setText("");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//chamo o método da classe ValidadorCliente que verifica se todos os campos de cadastro do cliente foram preenchidos
		ValidadorCliente objValidador = new ValidadorCliente();
		
		
		
		
		
objValidador.validarCadastro(grupoSexo, grupoEstadoCivil, txtNome, txtEmail, txtDataNascimento, txtCPF, txtTelefone, pnlGuias);


																																																																																													}
																																																																																												}); //Fim da ação do botão próximo
	
	}
}