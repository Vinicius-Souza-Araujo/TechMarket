package TechMarket.telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Tela1_principal extends JFrame {

	private JPanel Tela1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela1_principal frame = new Tela1_principal();
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
	Tela2Produto tela2 = new Tela2Produto();
	Tela3_cliente tela3 = new Tela3_cliente();
	Tela4_relatorios tela4 = new Tela4_relatorios();
	
	public Tela1_principal() {
		setBackground(new Color(27, 40, 161));
		setBounds(100, 100, 1108, 702);
		Tela1 = new JPanel();
		Tela1.setBackground(new Color(27, 40, 161));
		Tela1.setBorder(null);

		setContentPane(Tela1);
		Tela1.setLayout(null);
		
		JLabel icon_produtos_img = new JLabel("");
		icon_produtos_img.setBounds(369, 371, 122, 111);
		
		JButton botao_produto = new JButton("");
		botao_produto.setIcon(new ImageIcon(Tela1_principal.class.getResource("/TechMarket/telas/product.png")));
		botao_produto.setBounds(323, 339, 196, 199);
		botao_produto.setToolTipText("");
		botao_produto.setForeground(new Color(27, 40, 161));
		botao_produto.setFont(new Font("Graphik Semibold", Font.PLAIN, 19));
		botao_produto.setBackground(new Color(18, 27, 103));
		botao_produto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela2Produto objProduto = new Tela2Produto();
				objProduto.setVisible(true);
				objProduto.setResizable(true);				
				objProduto.setTitle("Tela2Produto");
				objProduto.setPreferredSize(new Dimension(1000,1000));
				objProduto.pack();
				
			}
		});
		
		JLabel labelProduto = new JLabel("Produto");
		labelProduto.setLabelFor(botao_produto);
		labelProduto.setForeground(new Color(255, 255, 255));
		labelProduto.setFont(new Font("Graphik Medium", Font.PLAIN, 22));
		labelProduto.setHorizontalAlignment(SwingConstants.CENTER);
		labelProduto.setBounds(375, 311, 89, 16);
		Tela1.add(labelProduto);
		Tela1.add(botao_produto);
		
		JLabel label_text_Titulo = new JLabel("BEM VINDO, USUÁRIO!");
		label_text_Titulo.setBounds(323, 129, 678, 111);
		label_text_Titulo.setFont(new Font("Graphik Semibold", Font.PLAIN, 43));
		label_text_Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		label_text_Titulo.setForeground(new Color(255, 255, 255));
		Tela1.add(label_text_Titulo);
		
		JLabel label_text_subtitulo = new JLabel("O que deseja fazer?");
		label_text_subtitulo.setBounds(578, 229, 168, 16);
		label_text_subtitulo.setFont(new Font("Graphik", Font.PLAIN, 17));
		label_text_subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		label_text_subtitulo.setForeground(new Color(255, 255, 255));
		Tela1.add(label_text_subtitulo);
		
		JButton botao_cliente = new JButton("");
		botao_cliente.setIcon(new ImageIcon(Tela1_principal.class.getResource("/TechMarket/telas/client.png")));
		botao_cliente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		botao_cliente.setBounds(541, 339, 205, 199);
		botao_cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela3_cliente objCliente = new Tela3_cliente();
				objCliente.setVisible(true);
				objCliente.setResizable(true);				
				objCliente.setTitle("Tela3_cliente");
				objCliente.setPreferredSize(new Dimension(1000,1000));
				objCliente.pack();
			}
		});
		botao_cliente.setToolTipText("");
		botao_cliente.setForeground(new Color(27, 40, 161));
		botao_cliente.setFont(new Font("Graphik Medium", Font.PLAIN, 22));
		botao_cliente.setBackground(new Color(28, 28, 104));
		Tela1.add(botao_cliente);
		
		JButton botao_relatorio = new JButton("");
		botao_relatorio.setIcon(new ImageIcon(Tela1_principal.class.getResource("/TechMarket/telas/dashboard.png")));
		botao_relatorio.setBounds(763, 339, 205, 199);
		botao_relatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela4_relatorios objRelatorios = new Tela4_relatorios();
				objRelatorios.setVisible(true);
				objRelatorios.setResizable(true);				
				objRelatorios.setTitle("Tela4_relatorios");
				objRelatorios.setPreferredSize(new Dimension(1000,1000));
				objRelatorios.pack();
			}
		});
		botao_relatorio.setToolTipText("");
		botao_relatorio.setForeground(new Color(27, 40, 161));
		botao_relatorio.setFont(new Font("Graphik Medium", Font.PLAIN, 22));
		botao_relatorio.setBackground(new Color(28, 28, 104));
		Tela1.add(botao_relatorio);
		
		JLabel Cliente = new JLabel("Cliente");
		Cliente.setHorizontalAlignment(SwingConstants.CENTER);
		Cliente.setForeground(Color.WHITE);
		Cliente.setFont(new Font("Graphik Medium", Font.PLAIN, 22));
		Cliente.setBounds(578, 311, 124, 16);
		Tela1.add(Cliente);
		
		JLabel Relatorios = new JLabel("Relatórios");
		Relatorios.setHorizontalAlignment(SwingConstants.CENTER);
		Relatorios.setForeground(Color.WHITE);
		Relatorios.setFont(new Font("Graphik Medium", Font.PLAIN, 22));
		Relatorios.setBounds(793, 311, 124, 16);
		Tela1.add(Relatorios);
	}
}


