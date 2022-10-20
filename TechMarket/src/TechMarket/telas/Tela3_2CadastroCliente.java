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
		setBounds(100, 100, 1271, 709);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblTitulo = new JLabel("Cadastro Cliente");
		lblTitulo.setFont(new Font("Graphik Semibold", Font.PLAIN, 43));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setBounds(218, 11, 435, 111);
		contentPane.add(lblTitulo);

		//painel para adicionar as guias cliente e endereco
		JTabbedPane pnlGuias = new JTabbedPane(JTabbedPane.TOP);
		pnlGuias.setBounds(48, 106, 801, 506);
		contentPane.add(pnlGuias);
		ButtonGroup grupoSexo = new ButtonGroup();
						
						ButtonGroup grupoEstadoCivil = new ButtonGroup();
						//guia cliente
				JPanel pnlAba1 = new JPanel();
				pnlGuias.add(pnlAba1);
				pnlGuias.setTitleAt(0, "Cliente");
				pnlAba1.setLayout(null);
				
						JLabel lblNome = new JLabel("Nome:");
						lblNome.setBounds(30, 45, 52, 33);
						lblNome.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
						pnlAba1.add(lblNome);
						
						txtNome = new JTextField();
						txtNome.setBounds(81, 53, 397, 21);
						pnlAba1.add(txtNome);
						txtNome.setColumns(10);
						
						JLabel lblDataNascimento = new JLabel("Data De Nascimento:");
						lblDataNascimento.setBounds(34, 149, 141, 33);
						lblDataNascimento.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
						pnlAba1.add(lblDataNascimento);
						
								JFormattedTextField txtDataNascimento = new JFormattedTextField();
								txtDataNascimento.setBounds(175, 157, 304, 21);
								pnlAba1.add(txtDataNascimento);
								try {
									txtDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
								} catch (ParseException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
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
														lblCPF.setBounds(33, 117, 38, 33);
														lblCPF.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
														pnlAba1.add(lblCPF);
														
																JFormattedTextField txtCPF = new JFormattedTextField();
																txtCPF.setBounds(81, 125, 397, 21);
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
																						
																						JPanel panel = new JPanel();
																						panel.setBounds(0, 0, 10, 10);
																						pnlAba1.add(panel);
																						
																												JLabel lblEstadoCivil = new JLabel("EstadoCivil");
																												lblEstadoCivil.setBounds(34, 213, 75, 33);
																												lblEstadoCivil.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
																												pnlAba1.add(lblEstadoCivil);
																												
																																		// botão de alternância solteiro
																																		JToggleButton tgS = new JToggleButton("Solteiro");
																																		tgS.setBounds(119, 221, 96, 21);
																																		tgS.setActionCommand("Solteiro");
																																		pnlAba1.add(tgS);
																																		
																																								// botão de alternância casado
																																								JToggleButton tgC = new JToggleButton("Casado");
																																								tgC.setBounds(225, 221, 94, 21);
																																								tgC.setActionCommand("Casado");
																																								pnlAba1.add(tgC);
																																								
																																														// botão de alternância outros
																																														JToggleButton tgO = new JToggleButton("Outros");
																																														tgO.setBounds(331, 221, 96, 21);
																																														tgO.setActionCommand("Outros");
																																														pnlAba1.add(tgO);
																																														grupoEstadoCivil.add(tgS);
																																														grupoEstadoCivil.add(tgC);
																																														grupoEstadoCivil.add(tgO);
																																														
																																														JLabel lblTelefone= new JLabel("Telefone:");
																																														lblTelefone.setBounds(34, 191, 75, 21);
																																														lblTelefone.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
																																														pnlAba1.add(lblTelefone);
																																														
																																																				JFormattedTextField txtTelefone = new JFormattedTextField();
																																																				txtTelefone.setBounds(119, 189, 360, 21);
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
																																																														lblEmail.setBounds(30, 85, 63, 33);
																																																														lblEmail.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
																																																														pnlAba1.add(lblEmail);
																																																														
																																																														txtEmail = new JTextField();
																																																														txtEmail.setBounds(82, 93, 397, 21);
																																																														pnlAba1.add(txtEmail);
																																																														txtEmail.setColumns(10);
																																																														
																																																																								//crio o botão que vai para a próxima guia
																																																																								JButton btnProximo = new JButton("Proximo");
																																																																								btnProximo.setBounds(544, 374, 171, 48);
																																																																								btnProximo.setFont(new Font("Tahoma", Font.PLAIN, 18));
																																																																								pnlAba1.add(btnProximo);										
																																																																								
																																																																								JLabel lblSexo = new JLabel("Sexo:");
																																																																								lblSexo.setBounds(40, 252, 34, 20);
																																																																								pnlAba1.add(lblSexo);
																																																																								lblSexo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
																																																																								
																																																																								JRadioButton rboM = new JRadioButton("Masculino");
																																																																								rboM.setBounds(99, 253, 75, 23);
																																																																								pnlAba1.add(rboM);
																																																																								rboM.setActionCommand("Masculino");
																																																																								
																																																																								JRadioButton rboF = new JRadioButton("Feminino");
																																																																								rboF.setBounds(182, 253, 71, 23);
																																																																								pnlAba1.add(rboF);
																																																																								rboF.setActionCommand("Feminino");
																																																																								
																																																																								JRadioButton rboO = new JRadioButton("Outros");
																																																																								rboO.setBounds(262, 253, 59, 23);
																																																																								pnlAba1.add(rboO);
																																																																								rboO.setActionCommand("Outros");
																																																																								btnProximo.addActionListener(new ActionListener() {
																																																																									public void actionPerformed(ActionEvent e) {
																																																																										//chamo o metodo da classe ValidadorCliente que verifica se todos os campos de cadastro do cliente foram preenchidos
																																																																										ValidadorCliente objValidador = new ValidadorCliente();
objValidador.validarCadastro(grupoSexo, grupoEstadoCivil, txtNome, txtEmail, txtDataNascimento, txtCPF, txtTelefone, pnlGuias);
																																																																									}
																																																																								}); //Fim da ação do botão próximo
										
		//guia endereco
		JPanel pnlAba2 = new JPanel();
		pnlGuias.add(pnlAba2);
		pnlGuias.setTitleAt(1, "Endereço");
		pnlAba2.setLayout(null);
		
		//componentes da guia endereco
		JLabel lblSubtitulo2 = new JLabel("Dados De Endereço");
		lblSubtitulo2.setFont(new Font("Graphik Semibold", Font.PLAIN, 43));
		lblSubtitulo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitulo2.setForeground(new Color(255, 255, 255));
		lblSubtitulo2.setBounds(323, 129, 678, 111);
		pnlAba2.add(lblSubtitulo2);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRua.setBounds(29, 27, 38, 28);
		pnlAba2.add(lblRua);

		txtRua = new JTextField();
		txtRua.setBounds(69, 28, 652, 33);
		pnlAba2.add(txtRua);
		txtRua.setColumns(10);
		
		JLabel lblNumero= new JLabel("Numero:");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumero.setBounds(10, 77, 57, 28);
		pnlAba2.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(69, 28, 652, 33);
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
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCep.setBounds(29, 27, 38, 28);
		pnlAba2.add(lblCep);

		JFormattedTextField txtCep = new JFormattedTextField();
		txtCep.setBounds(71, 86, 229, 33);
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
						lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 18));
						lblEstado.setBounds(10, 31, 63, 33);
						pnlAba2.add(lblEstado);
						
						JComboBox comboEstado = new JComboBox();
						comboEstado.setModel(new DefaultComboBoxModel(
								new String[] {"Selecione um estado", "Acre", "Alagoas", "Amapa", "Amazonas", "Bahia", "Ceara", "Espirito Santo", "Goias", "Maranhao", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Para", "Paraiba", "Parana", "Pernambuco", "Piaui", "Rio De Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondonia", "Roraima", "Santa Catarina", "Sao Paulo", "Sergipe", "Tocantins", "Distrito Federal"}));
						comboEstado.setBounds(62, 23, 295, 31);
						pnlAba2.add(comboEstado);

						JLabel lblCidade= new JLabel("Cidade:");
						lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
						lblCidade.setBounds(10, 31, 63, 33);
						pnlAba2.add(lblCidade);
						
						txtCidade= new JTextField();
						txtCidade.setBounds(71, 34, 610, 33);
						pnlAba2.add(txtCidade);
						txtCidade.setColumns(10);
										
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVoltar.setBounds(10, 341, 123, 41);
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
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								//chamo o metodo da classe ValidadorCliente que verifica se todos os campos de endereco foram preenchidos
				ValidadorCliente objValidador = new ValidadorCliente();
				objValidador.validarEndereco(comboEstado, txtRua, txtNumero, txtCidade, txtCep);
			}});
	}
}