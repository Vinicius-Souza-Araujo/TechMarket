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
	 */
	public Tela3_2CadastroCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Tela3.2 Cadastro Cliente");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JLabel lblTitulo = new JLabel("Cadastro Cliente");
		lblTitulo.setFont(new Font("Graphik Semibold", Font.PLAIN, 43));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setBounds(323, 129, 678, 111);
		contentPane.add(lblTitulo);

		//painel para adicionar as guias cliente e endereco
		JTabbedPane pnlGuias = new JTabbedPane(JTabbedPane.TOP);
		pnlGuias.setBounds(0, 24, 736, 419);
		contentPane.add(pnlGuias);

		//guia cliente
		JPanel pnlAba1 = new JPanel();
		pnlGuias.add(pnlAba1);
			pnlGuias.setTitleAt(0, "Cliente");
		pnlAba1.setLayout(null);

		//componentes da guia cliente
		JLabel lblSubtitulo = new JLabel("Dados Do Cliente");
		lblSubtitulo.setFont(new Font("Graphik Semibold", Font.PLAIN, 43));
		lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitulo.setForeground(new Color(255, 255, 255));
		lblSubtitulo.setBounds(323, 129, 678, 111);
		pnlAba1.add(lblSubtitulo);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(10, 31, 63, 33);
		pnlAba1.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(71, 34, 610, 33);
		pnlAba1.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCPF.setBounds(28, 89, 38, 33);
		pnlAba1.add(lblCPF);

		JFormattedTextField txtCPF = new JFormattedTextField();
		txtCPF.setBounds(71, 86, 229, 33);
		pnlAba1.add(txtCPF);
		//formato a mascara do CPF
						try {
			txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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
						lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 18));
						lblSexo.setBounds(28, 149, 38, 33);
						pnlAba1.add(lblSexo);

						//botão de opção feminino
						JRadioButton rboF = new JRadioButton("Feminino");
						rboF.setBounds(6, 18, 103, 21);
						rboF.setActionCommand("Feminino");
						pnlAba1.add(rboF);

						// botão de opção masculino
						JRadioButton rboM = new JRadioButton("Masculino");
						rboM.setBounds(136, 18, 103, 21);
						rboM.setActionCommand("Masculino");
						pnlAba1.add(rboM);

						// botão de opção outros
						JRadioButton rboO= new JRadioButton("Outros");
						rboO.setBounds(258, 18, 103, 21);
						rboO.setActionCommand("Outros");
						pnlAba1.add(rboO);

						ButtonGroup grupoSexo = new ButtonGroup();
						grupoSexo.add(rboF);
						grupoSexo.add(rboM);
						grupoSexo.add(rboO);

						JLabel lblEstadoCivil = new JLabel("EstadoCivil");
						lblEstadoCivil.setFont(new Font("Tahoma", Font.PLAIN, 18));
						lblEstadoCivil.setBounds(28, 149, 38, 33);
						pnlAba1.add(lblEstadoCivil);

						// botão de alternância solteiro
						JToggleButton tgS = new JToggleButton("Solteiro");
						tgS.setBounds(10, 24, 115, 40);
						tgS.setActionCommand("Solteiro");
						pnlAba1.add(tgS);

						// botão de alternância casado
						JToggleButton tgC = new JToggleButton("Casado");
						tgC.setBounds(242, 24, 115, 40);
						tgC.setActionCommand("Casado");
						pnlAba1.add(tgC);

						// botão de alternância outros
						JToggleButton tgO = new JToggleButton("Outros");
						tgO.setBounds(242, 24, 115, 40);
						tgO.setActionCommand("Outros");
						pnlAba1.add(tgO);
						
						ButtonGroup grupoEstadoCivil = new ButtonGroup();
						grupoEstadoCivil.add(tgS);
						grupoEstadoCivil.add(tgC);
						grupoEstadoCivil.add(tgO);
						
						JLabel lblTelefone= new JLabel("Telefone:");
						lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 18));
						lblTelefone.setBounds(28, 149, 38, 33);
						pnlAba1.add(lblTelefone);

						JFormattedTextField txtTelefone = new JFormattedTextField();
						txtTelefone.setBounds(71, 86, 229, 33);
						pnlAba1.add(txtTelefone);
						//formato a mascara do telefone
										try {
							txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
										
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
										lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
										lblEmail.setBounds(10, 31, 63, 33);
										pnlAba1.add(lblEmail);
										
										txtEmail = new JTextField();
										txtEmail.setBounds(71, 34, 610, 33);
										pnlAba1.add(txtEmail);
										txtEmail.setColumns(10);

										//crio o botão que vai para a próxima guia
										JButton btnProximo = new JButton("Próximo");
										btnProximo.setFont(new Font("Tahoma", Font.PLAIN, 18));
										btnProximo.setBounds(550, 334, 171, 48);
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
								new String[] {"Selecione um estado", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio De Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins", "Distrito Federal"}));
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
