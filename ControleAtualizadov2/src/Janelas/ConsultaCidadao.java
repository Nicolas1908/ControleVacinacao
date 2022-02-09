package Janelas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import Conexao.Cidadao;

public class ConsultaCidadao extends JFrame {

	private JPanel contentPane;
	private JTextField nomeCidField;
	private JTextField cpfCidField;
	private JTextField dtNascCidField;
	private JTextField emailCidField;
	private JTextField telCidField;
	private JTextField endCidField;
	private JTextField numCidField;
	private JTextField celCidField;
	private JTextField cepCidField;
	private JTextField bairroCidField;
	private JTextField ufCidField;
	private JTextField cidCidField;
	private String enderecoCid;
	private String bairroCid;
	private String cidadeCid;
	private String ufCid;
	private JButton btnBuscarCep;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaCidadao frame = new ConsultaCidadao();
					frame.setResizable(false);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Controle de Vacinação - Consulta de Cidadãos");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public ConsultaCidadao() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConsultaCidadao.class.getResource("/Imagens/Icone.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);
		setContentPane(contentPane);

		// Mouse (Mão)
		Cursor cursorMao = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);

		// Imagem (cabeçalho)
		JPanel panelImagem = new JPanel();
		panelImagem.setBounds(76, 38, 120, 120);
		contentPane.add(panelImagem);
		panelImagem.setLayout(null);

		JLabel lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon(ConsultaCidadao.class.getResource("/Imagens/ConsultaCid.png")));
		lblImagem.setBounds(0, 0, 120, 120);
		panelImagem.add(lblImagem);

		// (Panel) Topo da Tela
		JPanel panelTopo = new JPanel();
		panelTopo.setBounds(0, 0, 834, 98);
		panelTopo.setBackground(new Color(31, 146, 191));
		contentPane.add(panelTopo);
		panelTopo.setLayout(null);

		JLabel lblTitulo = new JLabel("Consulta de Cidad\u00E3os");
		lblTitulo.setForeground(SystemColor.text);
		lblTitulo.setFont(new Font("Verdana", Font.PLAIN, 23));
		lblTitulo.setBounds(211, 56, 394, 31);
		panelTopo.add(lblTitulo);

		JLabel lblCamposObg = new JLabel("(*) Campos obrigat\u00F3rios");
		lblCamposObg.setForeground(SystemColor.controlHighlight);
		lblCamposObg.setBounds(605, 68, 135, 14);
		panelTopo.add(lblCamposObg);

		JLabel lblTopoGrad = new JLabel("");
		lblTopoGrad.setIcon(new ImageIcon(MenuInicial.class.getResource("/Imagens/Topo.png")));
		lblTopoGrad.setBounds(0, 0, 834, 98);
		panelTopo.add(lblTopoGrad);

		// (Panel) Barra lateral
		JPanel panelBarraLateral = new JPanel();
		panelBarraLateral.setBounds(76, 166, 120, 345);
		panelBarraLateral.setBackground(new Color(54, 191, 191));
		contentPane.add(panelBarraLateral);
		panelBarraLateral.setLayout(null);

		JLabel lblBarraLateral = new JLabel("");
		lblBarraLateral.setIcon(new ImageIcon(CadastroCidadao.class.getResource("/Imagens/Cidad\u00E3o.png")));
		lblBarraLateral.setBounds(0, 0, 120, 345);
		panelBarraLateral.add(lblBarraLateral);

		JSeparator separatorVac = new JSeparator();
		separatorVac.setBounds(76, 161, 120, 10);
		separatorVac.setForeground(new Color(54, 191, 191));
		separatorVac.setBackground(new Color(54, 191, 191));
		contentPane.add(separatorVac);

		// Formulário
		// Busca pelo CPF
		JLabel lblCpfCid = new JLabel("CPF *");
		lblCpfCid.setBounds(239, 131, 105, 14);
		lblCpfCid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblCpfCid);

		cpfCidField = new JTextField();
		try {
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("###.###.###-##");
			cpfCidField = new javax.swing.JFormattedTextField(format_textField4);
		} catch (Exception e1) {
		}
		cpfCidField.setBounds(239, 152, 105, 32);
		cpfCidField.setColumns(10);
		cpfCidField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				// Deixando os campos editáves
				nomeCidField.setEnabled(false);
				dtNascCidField.setEnabled(false);
				telCidField.setEnabled(false);
				celCidField.setEnabled(false);
				emailCidField.setEnabled(false);
				endCidField.setEnabled(false);
				numCidField.setEnabled(false);
				cepCidField.setEnabled(false);
				ufCidField.setEnabled(false);
				cidCidField.setEnabled(false);
				bairroCidField.setEnabled(false);
				btnBuscarCep.setEnabled(false);

				// Limpando os campos

				nomeCidField.setText(null);
				dtNascCidField.setText(null);
				telCidField.setText(null);
				celCidField.setText(null);
				emailCidField.setText(null);
				endCidField.setText(null);
				numCidField.setText(null);
				cepCidField.setText(null);
				ufCidField.setText(null);
				cidCidField.setText(null);
				bairroCidField.setText(null);

				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});
		contentPane.add(cpfCidField);

		JButton btnBuscarCid = new JButton("BUSCAR");
		btnBuscarCid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cpfCidField.getText().isBlank() || "   .   .   -  ".equals(cpfCidField.getText())) {
					JOptionPane.showMessageDialog(null, "Preencha o campo: CPF *", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					cpfCidField.setText(null);
					cpfCidField.requestFocus();
				} else {
					String cpf = cpfCidField.getText();

					Cidadao c = new Cidadao();
					c.setCpfCid(cpf);
					c.consultar();

					// Preenchendo os campos do fomulário com os dados vindos do banco
					if (c.getNomeCid() == null) {
						JOptionPane.showMessageDialog(null, "CPF Inválido!!!", "Atenção", JOptionPane.WARNING_MESSAGE);
						cpfCidField.setText("");
						cpfCidField.requestFocus();

						// Deixando os campos editáves
						nomeCidField.setEnabled(false);
						dtNascCidField.setEnabled(false);
						telCidField.setEnabled(false);
						celCidField.setEnabled(false);
						emailCidField.setEnabled(false);
						endCidField.setEnabled(false);
						numCidField.setEnabled(false);
						cepCidField.setEnabled(false);
						ufCidField.setEnabled(false);
						cidCidField.setEnabled(false);
						bairroCidField.setEnabled(false);
						btnBuscarCep.setEnabled(false);

						// Limpando os campos
						nomeCidField.setText(null);
						dtNascCidField.setText(null);
						telCidField.setText(null);
						celCidField.setText(null);
						emailCidField.setText(null);
						endCidField.setText(null);
						numCidField.setText(null);
						cepCidField.setText(null);
						ufCidField.setText(null);
						cidCidField.setText(null);
						bairroCidField.setText(null);
					} else {
						nomeCidField.setText(c.getNomeCid());
						dtNascCidField.setText(c.getDtNascCidFormatado());
						telCidField.setText(c.getTelCid());
						celCidField.setText(c.getCelCid());
						emailCidField.setText(c.getEmailCid());
						endCidField.setText(c.getEnderecoCid());
						numCidField.setText(c.getNumCid());
						cepCidField.setText(c.getCepCid());
						ufCidField.setText(c.getUfCid());
						cidCidField.setText(c.getCidCid());
						bairroCidField.setText(c.getBairroCid());

						// Deixando os campos editáves
						nomeCidField.setEnabled(true);
						dtNascCidField.setEnabled(true);
						telCidField.setEnabled(true);
						celCidField.setEnabled(true);
						emailCidField.setEnabled(true);
						endCidField.setEnabled(true);
						numCidField.setEnabled(true);
						cepCidField.setEnabled(true);
						ufCidField.setEnabled(true);
						cidCidField.setEnabled(true);
						bairroCidField.setEnabled(true);
						btnBuscarCep.setEnabled(true);					
					}
				}
			}
		});
		btnBuscarCid.setForeground(Color.WHITE);
		btnBuscarCid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarCid.setBorder(null);
		btnBuscarCid.setBackground(new Color(54, 191, 191));
		btnBuscarCid.setBounds(354, 152, 63, 32);
		btnBuscarCid.setFocusPainted(false);
		btnBuscarCid.setCursor(cursorMao);
		contentPane.add(btnBuscarCid);

		JLabel lblNomeCid = new JLabel("Nome do Cidad\u00E3o *");
		lblNomeCid.setBounds(437, 131, 302, 14);
		lblNomeCid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblNomeCid);

		nomeCidField = new JTextField();
		nomeCidField.setEnabled(false);
		nomeCidField.setBounds(437, 152, 302, 32);
		nomeCidField.setColumns(10);
		nomeCidField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (nomeCidField.getText().length() >= 55)
					e.consume();
			}
		});
		contentPane.add(nomeCidField);

		JLabel lblDtNascCid = new JLabel("Data de Nascimento *");
		lblDtNascCid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDtNascCid.setBounds(239, 195, 178, 14);
		contentPane.add(lblDtNascCid);

		dtNascCidField = new JTextField();
		try {
			javax.swing.text.MaskFormatter dataNasc = new javax.swing.text.MaskFormatter("##/##/####");
			dtNascCidField = new javax.swing.JFormattedTextField(dataNasc);
		} catch (Exception e) {
		}
		dtNascCidField.setEnabled(false);
		dtNascCidField.setColumns(10);
		dtNascCidField.setBounds(239, 214, 178, 32);
		contentPane.add(dtNascCidField);

		JLabel lblTelCid = new JLabel("Telefone");
		lblTelCid.setBounds(437, 195, 140, 14);
		lblTelCid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblTelCid);

		telCidField = new JTextField();
		try {
			javax.swing.text.MaskFormatter tel = new javax.swing.text.MaskFormatter("(##) ####-####");
			telCidField = new javax.swing.JFormattedTextField(tel);
		} catch (Exception e) {
		}
		telCidField.setEnabled(false);
		telCidField.setColumns(10);
		telCidField.setBounds(437, 214, 140, 32);
		telCidField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});
		contentPane.add(telCidField);

		celCidField = new JTextField();
		try {
			javax.swing.text.MaskFormatter cel = new javax.swing.text.MaskFormatter("(##) #####-####");
			celCidField = new javax.swing.JFormattedTextField(cel);
			celCidField.setEnabled(false);
		} catch (Exception e) {
		}
		celCidField.setColumns(15);
		celCidField.setBounds(599, 214, 140, 32);
		contentPane.add(celCidField);

		JLabel lblCelular = new JLabel("Celular *");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCelular.setBounds(599, 195, 140, 14);
		contentPane.add(lblCelular);

		JLabel lblEmailCid = new JLabel("E-mail *");
		lblEmailCid.setBounds(239, 256, 500, 14);
		lblEmailCid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblEmailCid);

		emailCidField = new JTextField();
		emailCidField.setEnabled(false);
		emailCidField.setColumns(10);
		emailCidField.setBounds(239, 276, 500, 32);
		emailCidField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (emailCidField.getText().length() >= 45)
					e.consume();
			}
		});
		contentPane.add(emailCidField);

		JLabel lblCepCid = new JLabel("CEP *");
		lblCepCid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCepCid.setBounds(239, 316, 178, 14);
		contentPane.add(lblCepCid);

		cepCidField = new JTextField();
		try {
			javax.swing.text.MaskFormatter cep = new javax.swing.text.MaskFormatter("#####-###");
			cepCidField = new javax.swing.JFormattedTextField(cep);
			cepCidField.setEnabled(false);
		} catch (Exception e) {
		}
		cepCidField.setColumns(10);
		cepCidField.setBounds(239, 335, 105, 32);
		contentPane.add(cepCidField);

		btnBuscarCep = new JButton("BUSCAR");
		btnBuscarCep.setEnabled(false);
		btnBuscarCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cepCidField.getText().isBlank() || "     -   ".equals(cepCidField.getText())) {
					JOptionPane.showMessageDialog(null, "Preencha o campo: CEP *", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					cepCidField.setText(null);
					cepCidField.requestFocus();
				} else {
					buscarCep(cepCidField.getText());
					numCidField.requestFocus();
				}
			}
		});
		btnBuscarCep.setForeground(Color.WHITE);
		btnBuscarCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarCep.setBorder(null);
		btnBuscarCep.setBackground(new Color(54, 191, 191));
		btnBuscarCep.setBounds(354, 335, 63, 32);
		btnBuscarCep.setFocusPainted(false);
		btnBuscarCep.setCursor(cursorMao);
		contentPane.add(btnBuscarCep);

		JLabel lblEndCid = new JLabel("Endere\u00E7o *");
		lblEndCid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEndCid.setBounds(437, 315, 178, 14);
		contentPane.add(lblEndCid);

		endCidField = new JTextField();
		endCidField.setEnabled(false);
		endCidField.setColumns(10);
		endCidField.setBounds(437, 335, 200, 32);
		endCidField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (endCidField.getText().length() >= 65)
					e.consume();
			}
		});
		contentPane.add(endCidField);

		JLabel lblNumCid = new JLabel("N\u00BA / Compl. *");
		lblNumCid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumCid.setBounds(653, 316, 86, 14);
		contentPane.add(lblNumCid);

		numCidField = new JTextField();
		numCidField.setEnabled(false);
		numCidField.setColumns(10);
		numCidField.setBounds(653, 335, 86, 32);
		numCidField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (numCidField.getText().length() >= 15)
					e.consume();
			}
		});
		contentPane.add(numCidField);

		JLabel lblBairroCid = new JLabel("Bairro *");
		lblBairroCid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBairroCid.setBounds(239, 378, 178, 14);
		contentPane.add(lblBairroCid);

		bairroCidField = new JTextField();
		bairroCidField.setEnabled(false);
		bairroCidField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (bairroCidField.getText().length() >= 25)
					e.consume();
			}
		});
		bairroCidField.setColumns(10);
		bairroCidField.setBounds(239, 398, 178, 32);
		contentPane.add(bairroCidField);

		JLabel lblCidCid = new JLabel("Cidade *");
		lblCidCid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCidCid.setBounds(437, 378, 200, 14);
		contentPane.add(lblCidCid);

		cidCidField = new JTextField();
		cidCidField.setEnabled(false);
		cidCidField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (cidCidField.getText().length() >= 25)
					e.consume();
			}
		});
		cidCidField.setColumns(10);
		cidCidField.setBounds(437, 398, 200, 32);
		contentPane.add(cidCidField);

		JLabel lblUfCid = new JLabel("UF *");
		lblUfCid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUfCid.setBounds(653, 379, 86, 14);
		contentPane.add(lblUfCid);

		ufCidField = new JTextField();
		ufCidField.setEnabled(false);
		ufCidField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (ufCidField.getText().length() >= 2)
					e.consume();
			}
		});
		ufCidField.setColumns(10);
		ufCidField.setBounds(653, 398, 86, 32);
		contentPane.add(ufCidField);

		// Botão "Excluir"
		JButton btnExcluirCid = new JButton("EXCLUIR");
		btnExcluirCid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = cpfCidField.getText();

				Cidadao c = new Cidadao();
				c.setCpfCid(cpf);
				c.consultar();
				if (cpfCidField.getText().isBlank() || "   .   .   -  ".equals(cpfCidField.getText())) {
					JOptionPane.showMessageDialog(null, "Para EXCLUIR cidadãos preencha o campo: CPF *", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					cpfCidField.setText(null);
					cpfCidField.requestFocus();
				} else {
					if (c.getNomeCid() == null) {
						JOptionPane.showMessageDialog(null, "CPF Inválido!", "Atenção", JOptionPane.WARNING_MESSAGE);
						cpfCidField.setText(null);
						cpfCidField.requestFocus();
					} else if (!"".equals(nomeCidField.getText())) {
						int reply = JOptionPane.showConfirmDialog(null, "Tem certeza?", "Mensagem",
								JOptionPane.YES_NO_OPTION);
						if (reply == JOptionPane.YES_OPTION) {
							if (nomeCidField.isEnabled() == false) {
								nomeCidField.setText(c.getNomeCid());
								dtNascCidField.setText(c.getDtNascCidFormatado());
								telCidField.setText(c.getTelCid());
								celCidField.setText(c.getCelCid());
								emailCidField.setText(c.getEmailCid());
								endCidField.setText(c.getEnderecoCid());
								numCidField.setText(c.getNumCid());
								cepCidField.setText(c.getCepCid());
								ufCidField.setText(c.getUfCid());
								cidCidField.setText(c.getCidCid());
								bairroCidField.setText(c.getBairroCid());
							} else {
								c.apagar();
								JOptionPane.showMessageDialog(null, "Cidadão excluido com sucesso!", "Mensagem",
										JOptionPane.INFORMATION_MESSAGE);
							}
						}

						// Limpando os campos
						nomeCidField.setText(null);
						cpfCidField.setText(null);
						dtNascCidField.setText(null);
						telCidField.setText(null);
						celCidField.setText(null);
						emailCidField.setText(null);
						endCidField.setText(null);
						numCidField.setText(null);
						cepCidField.setText(null);
						ufCidField.setText(null);
						cidCidField.setText(null);
						bairroCidField.setText(null);

						// Deixando os campos bloquedos
						nomeCidField.setEnabled(false);
						dtNascCidField.setEnabled(false);
						telCidField.setEnabled(false);
						celCidField.setEnabled(false);
						emailCidField.setEnabled(false);
						endCidField.setEnabled(false);
						numCidField.setEnabled(false);
						cepCidField.setEnabled(false);
						ufCidField.setEnabled(false);
						cidCidField.setEnabled(false);
						bairroCidField.setEnabled(false);
						btnBuscarCep.setEnabled(false);
						cpfCidField.requestFocus();
					} else {
						nomeCidField.setText(c.getNomeCid());
						dtNascCidField.setText(c.getDtNascCidFormatado());
						telCidField.setText(c.getTelCid());
						celCidField.setText(c.getCelCid());
						emailCidField.setText(c.getEmailCid());
						endCidField.setText(c.getEnderecoCid());
						numCidField.setText(c.getNumCid());
						cepCidField.setText(c.getCepCid());
						ufCidField.setText(c.getUfCid());
						cidCidField.setText(c.getCidCid());
						bairroCidField.setText(c.getBairroCid());

						nomeCidField.setEnabled(true);
						dtNascCidField.setEnabled(true);
						telCidField.setEnabled(true);
						celCidField.setEnabled(true);
						emailCidField.setEnabled(true);
						endCidField.setEnabled(true);
						numCidField.setEnabled(true);
						cepCidField.setEnabled(true);
						ufCidField.setEnabled(true);
						cidCidField.setEnabled(true);
						bairroCidField.setEnabled(true);
						btnBuscarCep.setEnabled(true);
					}
				}
			}
		});
		btnExcluirCid.setForeground(Color.WHITE);
		btnExcluirCid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluirCid.setFocusPainted(false);
		btnExcluirCid.setBorder(null);
		btnExcluirCid.setBackground(new Color(54, 191, 191));
		btnExcluirCid.setBounds(309, 448, 130, 32);
		btnExcluirCid.setCursor(cursorMao);
		contentPane.add(btnExcluirCid);

		// Botão "Alterar"
		JButton btnAlterarCid = new JButton("ALTERAR");
		btnAlterarCid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cpfCidField.getText().isBlank() || "   .   .   -  ".equals(cpfCidField.getText())) {
					
					JOptionPane.showMessageDialog(null, "Para ALTERAR cidadãos preencha o campo: CPF *", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					cpfCidField.requestFocus();
				} else {
					String cpf = cpfCidField.getText();

					Cidadao c = new Cidadao();
					c.setCpfCid(cpf);
					c.consultar();

					// Preenchendo os campos do fomulário com os dados vindos do banco
					if (c.getNomeCid() == null) {
						JOptionPane.showMessageDialog(null, "CPF Inválido!", "Atenção", JOptionPane.WARNING_MESSAGE);
						cpfCidField.setText(null);
						cpfCidField.requestFocus();
					} else if (nomeCidField.isEnabled() == false) {
						nomeCidField.setText(c.getNomeCid());
						dtNascCidField.setText(c.getDtNascCidFormatado());
						telCidField.setText(c.getTelCid());
						celCidField.setText(c.getCelCid());
						emailCidField.setText(c.getEmailCid());
						endCidField.setText(c.getEnderecoCid());
						numCidField.setText(c.getNumCid());
						cepCidField.setText(c.getCepCid());
						ufCidField.setText(c.getUfCid());
						cidCidField.setText(c.getCidCid());
						bairroCidField.setText(c.getBairroCid());

						// Deixando os campos editáves
						nomeCidField.setEnabled(true);
						dtNascCidField.setEnabled(true);
						telCidField.setEnabled(true);
						celCidField.setEnabled(true);
						emailCidField.setEnabled(true);
						endCidField.setEnabled(true);
						numCidField.setEnabled(true);
						cepCidField.setEnabled(true);
						ufCidField.setEnabled(true);
						cidCidField.setEnabled(true);
						bairroCidField.setEnabled(true);
						btnBuscarCep.setEnabled(true);
					} else {
						String dtNascCid = dtNascCidField.getText();
						if (nomeCidField.getText().isBlank()) {
							JOptionPane.showMessageDialog(null, "Preencha o campo: Nome do Cidadão *", "Atenção",
									JOptionPane.WARNING_MESSAGE);
							nomeCidField.setText(null);
							nomeCidField.requestFocus();
						} else if (dtNascCidField.getText().isBlank() || "  /  /    ".equals(dtNascCidField.getText())) {
							JOptionPane.showMessageDialog(null, "Preencha o campo: Data de Nascimento *", "Atenção",
									JOptionPane.WARNING_MESSAGE);
							dtNascCidField.setText(null);
							dtNascCidField.requestFocus();
						} else if (c.checkDate(dtNascCid) == true) {
						
						/* else if (telCidField.getText().isBlank() || "(  )     -    ".equals(telCidField.getText())) {
							JOptionPane.showMessageDialog(null, "Preencha o campo: Telefone *", "Atenção",
									JOptionPane.WARNING_MESSAGE);
							telCidField.setText(null);
							telCidField.requestFocus();
						} */ if (celCidField.getText().isBlank() || "(  )      -    ".equals(celCidField.getText())) {
							JOptionPane.showMessageDialog(null, "Preencha o campo: Celular *", "Atenção",
									JOptionPane.WARNING_MESSAGE);
							celCidField.setText(null);
							celCidField.requestFocus();
						} else if(emailCidField.getText().isBlank()) {
							JOptionPane.showMessageDialog(null, "Preencha o campo: E-mail *", "Atenção",
									JOptionPane.WARNING_MESSAGE);
							emailCidField.setText(null);
							emailCidField.requestFocus();
						} else if (cepCidField.getText().isBlank() || "     -   ".equals(cepCidField.getText())) {
							JOptionPane.showMessageDialog(null, "Preencha o campo: CEP *", "Atenção",
									JOptionPane.WARNING_MESSAGE);
							cepCidField.setText(null);
							cepCidField.requestFocus();
						} else if (endCidField.getText().isBlank()) {
							JOptionPane.showMessageDialog(null, "Preencha o campo: Endereço *", "Atenção",
									JOptionPane.WARNING_MESSAGE);
							endCidField.setText(null);
							endCidField.requestFocus();
						} else if (numCidField.getText().isBlank()) {
							JOptionPane.showMessageDialog(null, "Preencha o campo: Nº / Compl. *", "Atenção",
									JOptionPane.WARNING_MESSAGE);
							numCidField.setText(null);
							numCidField.requestFocus();
						} else if (bairroCidField.getText().isBlank()) {
							JOptionPane.showMessageDialog(null, "Preencha o campo: Bairro *", "Atenção",
									JOptionPane.WARNING_MESSAGE);
							bairroCidField.setText(null);
							bairroCidField.requestFocus();
						} else if (cidCidField.getText().isBlank()) {
							JOptionPane.showMessageDialog(null, "Preencha o campo: Cidade *", "Atenção",
									JOptionPane.WARNING_MESSAGE);
							cidCidField.setText(null);
							cidCidField.requestFocus();
						} else if (ufCidField.getText().isBlank()) {
							JOptionPane.showMessageDialog(null, "Preencha o campo: UF *", "Atenção",
									JOptionPane.WARNING_MESSAGE);
							ufCidField.setText(null);
							ufCidField.requestFocus();
						}  else {
							String nomeCid = nomeCidField.getText();
							String cpfCid = cpfCidField.getText();
							String telCid = telCidField.getText();
							String celCid = celCidField.getText();
							String emailCid = emailCidField.getText();
							String enderecoCid = endCidField.getText();
							String numCid = numCidField.getText();
							String cepCid = cepCidField.getText();
							String ufCid = ufCidField.getText();
							String cidCid = cidCidField.getText();
							String bairroCid = bairroCidField.getText();

							c.setNomeCid(nomeCid);
							c.setCpfCid(cpfCid);
							c.setTelCid(telCid);
							c.setCelCid(celCid);
							c.setDtNascCid(dtNascCid);
							c.setEmailCid(emailCid);
							c.setEnderecoCid(enderecoCid);
							c.setNumCid(numCid);
							c.setCepCid(cepCid);
							c.setUfCid(ufCid);
							c.setCidCid(cidCid);
							c.setBairroCid(bairroCid);
							c.alterar();

							JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!", "Mensagem",
									JOptionPane.INFORMATION_MESSAGE);

							// Limpando os campos
							nomeCidField.setText(null);
							cpfCidField.setText(null);
							dtNascCidField.setText(null);
							telCidField.setText(null);
							celCidField.setText(null);
							emailCidField.setText(null);
							endCidField.setText(null);
							numCidField.setText(null);
							cepCidField.setText(null);
							ufCidField.setText(null);
							cidCidField.setText(null);
							bairroCidField.setText(null);

							// Deixando os campos bloquedos
							nomeCidField.setEnabled(false);
							dtNascCidField.setEnabled(false);
							telCidField.setEnabled(false);
							celCidField.setEnabled(false);
							emailCidField.setEnabled(false);
							endCidField.setEnabled(false);
							numCidField.setEnabled(false);
							cepCidField.setEnabled(false);
							ufCidField.setEnabled(false);
							cidCidField.setEnabled(false);
							bairroCidField.setEnabled(false);
							btnBuscarCep.setEnabled(false);
							cpfCidField.requestFocus();
						}
						} else {
							dtNascCidField.setText(null);
							dtNascCidField.requestFocus();
						}
					}
				}
			}
		});
		btnAlterarCid.setBounds(458, 448, 130, 32);
		btnAlterarCid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlterarCid.setForeground(Color.WHITE);
		btnAlterarCid.setBorder(null);
		btnAlterarCid.setBackground(new Color(54, 191, 191));
		btnAlterarCid.setFocusPainted(false);
		btnAlterarCid.setCursor(cursorMao);
		contentPane.add(btnAlterarCid);

		// Botão "Voltar"
		JButton btnVoltarCid = new JButton("VOLTAR");
		btnVoltarCid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuInicial menuInicial = new MenuInicial();
				menuInicial.setTitle("Controle de Vacinação - Menu Inicial");
				menuInicial.setResizable(false);
				menuInicial.setVisible(true);
				menuInicial.setLocationRelativeTo(null);
				menuInicial.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		btnVoltarCid.setBounds(608, 448, 130, 32);
		btnVoltarCid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltarCid.setForeground(Color.WHITE);
		btnVoltarCid.setBorder(null);
		btnVoltarCid.setBackground(new Color(54, 191, 191));
		btnVoltarCid.setFocusPainted(false);
		btnVoltarCid.setCursor(cursorMao);
		contentPane.add(btnVoltarCid);
	}

	public void buscarCep(String cep) {
		String json;

		try {
			URL url = new URL("http://viacep.com.br/ws/" + cep + "/json");
			java.net.URLConnection urlConnection = url.openConnection();
			InputStream is = urlConnection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			StringBuilder jsonSb = new StringBuilder();

			br.lines().forEach(l -> jsonSb.append(l.trim()));
			json = jsonSb.toString();

			// JOptionPane.showMessageDialog(null, json);

			json = json.replaceAll("[{},:]", "");
			json = json.replaceAll("\"", "\n");
			String array[] = new String[30];
			array = json.split("\n");

			// JOptionPane.showMessageDialog(null, array);

			enderecoCid = array[7];
			bairroCid = array[15];
			cidadeCid = array[19];
			ufCid = array[23];

			endCidField.setText(enderecoCid);
			bairroCidField.setText(bairroCid);
			cidCidField.setText(cidadeCid);
			ufCidField.setText(ufCid);
			// JOptionPane.showMessageDialog(null, logradouro + " " + bairro + " " + cidade
			// + " " + uf);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}