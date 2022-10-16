package TechMarket.telas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Tela3.2 Cadastro Cliente");
		setBounds(100, 100, 667, 457);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 94));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//painel para adicionar as guias cliente e endereco
		JTabbedPane pnlGuias = new JTabbedPane(JTabbedPane.TOP);
		pnlGuias.setBounds(44, 111, 551, 271);
		contentPane.add(pnlGuias);
		ButtonGroup grupoSexo = new ButtonGroup();
						
						ButtonGroup grupoEstadoCivil = new ButtonGroup();
						//guia cliente
				JPanel pnlAba1 = new JPanel();
				pnlAba1.setBackground(new Color(255, 255, 255));
				pnlGuias.add(pnlAba1);
				pnlGuias.setTitleAt(0, "Cliente");
				pnlAba1.setLayout(null);
				
						JLabel lblNome = new JLabel("Nome:");
						lblNome.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
						lblNome.setBounds(28, 24, 63, 16);
						pnlAba1.add(lblNome);
						
						txtNome = new JTextField();
						txtNome.setBounds(95, 25, 269, 16);
						pnlAba1.add(txtNome);
						txtNome.setColumns(10);
						
						JLabel lblCPF = new JLabel("CPF:");
						lblCPF.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
						lblCPF.setBounds(28, 102, 38, 16);
						pnlAba1.add(lblCPF);
						
								JFormattedTextField txtCPF = new JFormattedTextField();
								txtCPF.setBounds(95, 102, 269, 17);
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
														lblSexo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
														lblSexo.setBounds(28, 156, 38, 21);
														pnlAba1.add(lblSexo);
														
																				//botão de opção feminino
																				JRadioButton rboF = new JRadioButton("Feminino");
																				rboF.setBounds(95, 157, 78, 21);
																				rboF.setActionCommand("Feminino");
																				pnlAba1.add(rboF);
																				
																										// botão de opção masculino
																										JRadioButton rboM = new JRadioButton("Masculino");
																										rboM.setBounds(186, 157, 71, 21);
																										rboM.setActionCommand("Masculino");
																										pnlAba1.add(rboM);
																										
																																// botão de opção outros
																																JRadioButton rboO= new JRadioButton("Outros");
																																rboO.setBounds(276, 157, 71, 21);
																																rboO.setActionCommand("Outros");
																																pnlAba1.add(rboO);
																																grupoSexo.add(rboF);
																																grupoSexo.add(rboM);
																																grupoSexo.add(rboO);
																																
																																						JLabel lblEstadoCivil = new JLabel("EstadoCivil:");
																																						lblEstadoCivil.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
																																						lblEstadoCivil.setBounds(23, 129, 63, 16);
																																						pnlAba1.add(lblEstadoCivil);
																																						
																																												// botão de alternância solteiro
																																												JToggleButton tgS = new JToggleButton("Solteiro");
																																												tgS.setBounds(95, 130, 71, 18);
																																												tgS.setActionCommand("Solteiro");
																																												pnlAba1.add(tgS);
																																												
																																																		// botão de alternância casado
																																																		JToggleButton tgC = new JToggleButton("Casado");
																																																		tgC.setBounds(176, 130, 80, 17);
																																																		tgC.setActionCommand("Casado");
																																																		pnlAba1.add(tgC);
																																																		
																																																								// botão de alternância outros
																																																								JToggleButton tgO = new JToggleButton("Outros");
																																																								tgO.setBounds(266, 130, 93, 17);
																																																								tgO.setActionCommand("Outros");
																																																								pnlAba1.add(tgO);
																																																								grupoEstadoCivil.add(tgS);
																																																								grupoEstadoCivil.add(tgC);
																																																								grupoEstadoCivil.add(tgO);
																																																								
																																																								JLabel lblTelefone= new JLabel("Telefone:");
																																																								lblTelefone.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
																																																								lblTelefone.setBounds(28, 75, 54, 21);
																																																								pnlAba1.add(lblTelefone);
																																																								
																																																														JFormattedTextField txtTelefone = new JFormattedTextField();
																																																														txtTelefone.setBounds(95, 78, 269, 16);
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
																																																																								lblEmail.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
																																																																								lblEmail.setBounds(28, 51, 63, 16);
																																																																								pnlAba1.add(lblEmail);
																																																																								
																																																																								txtEmail = new JTextField();
																																																																								txtEmail.setBounds(95, 54, 269, 16);
																																																																								pnlAba1.add(txtEmail);
																																																																								txtEmail.setColumns(10);
																																																																								
																																																																																		//crio o botão que vai para a próxima guia
																																																																																		JButton btnProximo = new JButton("Próximo");
																																																																																		btnProximo.setForeground(new Color(255, 255, 255));
																																																																																		btnProximo.setBackground(new Color(0, 0, 128));
																																																																																		btnProximo.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
																																																																																		btnProximo.setBounds(385, 215, 87, 17);
																																																																																		pnlAba1.add(btnProximo);										
																																																																																		btnProximo.addActionListener(new ActionListener() {
																																																																																			public void actionPerformed(ActionEvent e) {
																																																																																				
																																																																																				if(grupoSexo.getSelection() == null) {
																																																																																					JOptionPane.showMessageDialog(contentPane,"Escolha o sexo!");
																																																																																																		return;
																																																																																																														}
									
																																																																																				if(grupoEstadoCivil.getSelection() == null){
																																																																																					JOptionPane.showMessageDialog(contentPane,"Escolha o estado civil!");
																																																																																																		return;
																																																																																																														}
																																																																																				
																																																																																				if(txtNome.getText().trim().equals("")) {
																																																																																					JOptionPane.showMessageDialog(contentPane,"Digite o nome!");
																																																																																																		return;
																																																																																				}
																																																																																				
																																																																																				if(txtCPF.getText().replace(".", "").replace("-","").trim().equals("")) {
																																																																																					JOptionPane.showMessageDialog(contentPane,"Digite o CPF!");
																																																																																					return;
																																																																																				}
																																																																																				
																																																																																				if(txtTelefone.getText().replace("(", "").replace(")","").replace("-","").trim().equals("")) {
																																																																																					JOptionPane.showMessageDialog(contentPane,"Digite o Telefone!");
																																																																																					return;
																																																																																				}
																																																																																				if(txtEmail.getText().trim().equals("")) {
																																																																																					JOptionPane.showMessageDialog(contentPane,"Digite o email!");
																																																																																																		return;
																																																																																				}
																																																																																				
																																																																																					//após o usuário preencher todos os campos, mudo para a próxima guia
																																																																																				pnlGuias.setSelectedIndex(1);
																																																																																			}
																																																																																		}); //Fim da ação do botão próximo
										

		//guia endereco
		JPanel pnlAba2 = new JPanel();
		pnlGuias.add(pnlAba2);
		pnlGuias.setTitleAt(1, "Endereço");
		pnlAba2.setLayout(null);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblRua.setBounds(38, 13, 23, 15);
		pnlAba2.add(lblRua);

		txtRua = new JTextField();
		txtRua.setBounds(85, 13, 248, 15);
		pnlAba2.add(txtRua);
		txtRua.setColumns(10);
		
		JLabel lblNumero= new JLabel("Número:");
		lblNumero.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblNumero.setBounds(343, 13, 57, 15);
		pnlAba2.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(397, 13, 123, 15);
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

		JLabel lblCep= new JLabel("CEP");
		lblCep.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblCep.setBounds(353, 39, 38, 15);
		pnlAba2.add(lblCep);

		JFormattedTextField txtCep = new JFormattedTextField();
		txtCep.setBounds(397, 39, 123, 15);
		pnlAba2.add(txtCep);
		//formato a mascara do Cep
						try {
			txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
						lblEstado.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
						lblEstado.setBounds(38, 70, 46, 22);
						pnlAba2.add(lblEstado);
						
						JComboBox comboEstado = new JComboBox();
						comboEstado.setModel(new DefaultComboBoxModel(
								new String[] {"Selecione um estado", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio De Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins", "Distrito Federal"}));
						comboEstado.setBounds(85, 75, 248, 15);
						pnlAba2.add(comboEstado);

						JLabel lblCidade= new JLabel("Cidade:");
						lblCidade.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
						lblCidade.setBounds(38, 30, 46, 33);
						pnlAba2.add(lblCidade);
						
						txtCidade= new JTextField();
						txtCidade.setBounds(85, 39, 248, 15);
						pnlAba2.add(txtCidade);
						txtCidade.setColumns(10);
										
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVoltar.setBounds(10, 164, 123, 22);
		pnlAba2.add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								pnlGuias.setSelectedIndex(0);
							}
		});
		
		JButton btnConfirmar= new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConfirmar.setBounds(598, 341, 123, 41);
		pnlAba2.add(btnConfirmar);
		JLabel lblTitulo = new JLabel("Cadastro Cliente");
		lblTitulo.setBounds(-37, 0, 678, 111);
		contentPane.add(lblTitulo);
		lblTitulo.setFont(new Font("Graphik Semibold", Font.PLAIN, 43));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(255, 255, 255));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								//próximos passos validar campo estado, rua, numero, cep
				
				if(comboEstado.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(contentPane,"Escolha o estado!");
					return;
				}
				
				if(txtRua.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(contentPane,"Digite a rua!");
																		return;
				}
				
				if(txtNumero.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(contentPane,"Digite o numero!");
																		return;
				}
				
				if(txtCidade.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(contentPane,"Digite a cidade!");
																		return;
				}
				
				if(txtCep.getText().replace("-", "").trim().equals("")) {
					JOptionPane.showMessageDialog(contentPane,"Digite o cep!");
																		return;
				}
				JOptionPane.showMessageDialog(contentPane,"Dados enviados!");
				
			}});
			
	}

}
