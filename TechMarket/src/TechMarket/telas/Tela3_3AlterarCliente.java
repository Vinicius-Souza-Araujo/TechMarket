package TechMarket.telas;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.text.MaskFormatter;

import model.Clientes;
import model.Produtos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.text.MaskFormatter;

public class Tela3_3AlterarCliente extends JFrame {
	Clientes cliente = new Clientes();
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtCPF;
	private JLabel lblNewLabel_3;
	private JTextField textField_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField txtRua;
	private JTextField txtCidade;
	private JTextField txtNumero;
	private JTextField textField_7;
	private JTextField textField_2;

	
	
	public Tela3_3AlterarCliente(int id) {
		setBounds(100, 100, 756, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(23, 35, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(23, 48, 162, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("E-mail:");
		lblNewLabel_1.setBounds(23, 79, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(23, 94, 162, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setBounds(23, 125, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JFormattedTextField txtCPF = new JFormattedTextField();
		txtCPF.setBounds(23, 139, 162, 20);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);
		try {
			txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		txtCPF.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		JLabel lblvalorID = new JLabel("");
		lblvalorID.setBounds(48, 16, 46, 14);
		contentPane.add(lblvalorID);
		lblvalorID.setText(String.valueOf(id));
		
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
		
		
		lblNewLabel_3 = new JLabel("Data de Nascimento:");
		lblNewLabel_3.setBounds(23, 170, 122, 14);
		contentPane.add(lblNewLabel_3);
		
		JFormattedTextField txtDataNascimento = new JFormattedTextField();
		txtDataNascimento.setBounds(23, 183, 162, 21);
		contentPane.add(txtDataNascimento);
		try {
			txtDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
		
		ButtonGroup grupoSexo = new ButtonGroup();
		
		lblNewLabel_4 = new JLabel("Sexo:");
		lblNewLabel_4.setBounds(23, 257, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		
		
		JRadioButton rdbF = new JRadioButton("Feminino");
		rdbF.setBounds(23, 278, 76, 14);
		contentPane.add(rdbF);
		grupoSexo.add(rdbF);
		
		JRadioButton rdbM = new JRadioButton("Masculino");
		rdbM.setBounds(97, 274, 88, 23);
		contentPane.add(rdbM);
		grupoSexo.add(rdbM);
		
		JRadioButton rdbO= new JRadioButton("Outros");
		rdbO.setBounds(186, 274, 109, 23);
		contentPane.add(rdbO);
		grupoSexo.add(rdbO);
		
		
		ButtonGroup grupoEstadoCivil = new ButtonGroup();
		
		lblNewLabel_5 = new JLabel("Estado Civil:");
		lblNewLabel_5.setBounds(23, 299, 92, 14);
		contentPane.add(lblNewLabel_5);
		
		JToggleButton tgS = new JToggleButton("Solteiro");
		tgS.setBounds(23, 313, 97, 23);
		contentPane.add(tgS);
		grupoEstadoCivil.add(tgS);
		
		JToggleButton tgC = new JToggleButton("Casado");
		tgC.setBounds(122, 313, 92, 23);
		contentPane.add(tgC);
		grupoEstadoCivil.add(tgC);
		
		
		JToggleButton tgO = new JToggleButton("Outros");
		tgO.setBounds(216, 313, 97, 23);
		contentPane.add(tgO);
		grupoEstadoCivil.add(tgO);
		
		JLabel lblNewLabel_6 = new JLabel("Rua:");
		lblNewLabel_6.setBounds(308, 35, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		txtRua = new JTextField();
		txtRua.setBounds(308, 48, 178, 20);
		contentPane.add(txtRua);
		txtRua.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Cidade:");
		lblNewLabel_7.setBounds(308, 79, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(308, 94, 178, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Estado:");
		lblNewLabel_8.setBounds(308, 125, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		JComboBox comboEstado = new JComboBox();
		comboEstado.setBounds(308, 139, 178, 22);
		comboEstado.setModel(new DefaultComboBoxModel(
				new String[] {"Selecione um estado", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio De Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins", "Distrito Federal"}));
		contentPane.add(comboEstado);
		
		JLabel lblNewLabel_9 = new JLabel("Número");
		lblNewLabel_9.setBounds(308, 170, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(308, 183, 178, 20);
		contentPane.add(txtNumero);
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
		JLabel lblNewLabel_10 = new JLabel("CEP:");
		lblNewLabel_10.setBounds(308, 214, 46, 14);
		contentPane.add(lblNewLabel_10);
		
		JFormattedTextField txtCep = new JFormattedTextField();
		txtCep.setBounds(307, 231, 179, 20);
		contentPane.add(txtCep);
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
		
		
		JLabel lblNewLabel_11 = new JLabel("ID:");
		lblNewLabel_11.setBounds(23, 16, 15, 14);
		contentPane.add(lblNewLabel_11);
		
		
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(23, 215, 109, 14);
		contentPane.add(lblTelefone);
		
		JFormattedTextField txtTelefone = new JFormattedTextField();
		txtTelefone.setBounds(21, 231, 164, 21);
		contentPane.add(txtTelefone);
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
		
		JButton btnNewButton = new JButton("Alterar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cliente != null){ 
					 cliente.setIdCliente(Integer.parseInt(lblvalorID.getText()));
					 cliente.setNome(txtNome.getText());
					 if(rdbF.isSelected()) {
						 cliente.setSexo("Feminino");
					 }
					 if(rdbM.isSelected()) {
						 cliente.setSexo("Masculino");
					 }
					 if(rdbO.isSelected()) {
						 cliente.setSexo("Outros");
					 }
					 cliente.setCpf(txtCPF.getText());
					 cliente.setEmail(txtEmail.getText());
					 cliente.setDataNasc(txtDataNascimento.getText());
					 cliente.setTelefone(txtTelefone.getText());
					 if(tgS.isSelected()) {
						 cliente.setEstadoCivil("Solteiro");
					 }
					 if(tgC.isSelected()) {
						 cliente.setEstadoCivil("Casado");
					 }
					 if(tgO.isSelected()) {
						 cliente.setEstadoCivil("Outros");
					 }
					 
					 cliente.setRua(txtRua.getText());
					 cliente.setCidade(txtCidade.getText());
					 cliente.setEstado(comboEstado.getSelectedItem().toString());
					 cliente.setNumero(txtNumero.getText());
					 cliente.setCep(txtCep.getText());
					 
					 
					 boolean retorno = dao.ClienteDAO.alterar(cliente);
					 if(retorno == true) {
						 JOptionPane.showMessageDialog(btnNewButton,"Informações alteradas com sucesso!");
					 }else{JOptionPane.showMessageDialog(btnNewButton,"Falha na gravação!");}
				 }
			}
		});
		
		
		btnNewButton.setBounds(513, 313, 88, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Buscar Dados");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
					
							try {
								cliente = dao.ClienteDAO.listarPorID(id);
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
					
						
				
				txtNome.setText(cliente.getNome());
				txtEmail.setText(cliente.getEmail());
				txtCPF.setText(cliente.getCpf());
				txtDataNascimento.setText(cliente.getDataNasc());
				txtTelefone.setText(cliente.getTelefone());
				if(cliente.getSexo().equals("Feminino")) {
					rdbF.setSelected(true);
				}
				if(cliente.getSexo().equals("Masculino")) {
					rdbM.setSelected(true);
				}if(cliente.getSexo().equals("Outros")) {
					rdbO.setSelected(true);
				}
				if(cliente.getEstadoCivil().equals("Solteiro")) {
					tgS.setSelected(true);
				}
				if(cliente.getEstadoCivil().equals("Casado")) {
					tgC.setSelected(true);
				}
				if(cliente.getEstadoCivil().equals("Outros")) {
					tgO.setSelected(true);
				}
				txtRua.setText(cliente.getRua());
				txtCidade.setText(cliente.getCidade());
				txtNumero.setText(cliente.getNumero());
				txtCep.setText(cliente.getCep());
				comboEstado.setSelectedItem(cliente.getEstado());
				
			}
		});
		btnNewButton_1.setBounds(375, 313, 128, 23);
		contentPane.add(btnNewButton_1);
		
		
		
		
	}
}
