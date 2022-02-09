package Janelas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import Conexao.Carteira;
import Conexao.Vacina;

import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CadastroCarteira extends JFrame {

	private JPanel contentPane;
	private JTextField cpfCidField;
	private JTextField emailCidField;
	private JTextField telCidField;
	private JTextField nomeVacField;
	private JTextField idVacField;
	//private JTextField dt2DoseField;
	private JTextField idCartField;
	private JTextField nomeCidField;
	private JTextField dt1DoseField;
	private JButton btnBuscarVac;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCarteira frame = new CadastroCarteira();
					frame.setResizable(false);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Controle de Vacinação - Cadastro de Carteiras");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public CadastroCarteira() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroCarteira.class.getResource("/Imagens/Icone.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setBackground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);

		// Mouse (Mão)
		Cursor cursorMao = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);

		// Imagem (cabeçalho)
		JPanel panelImagem = new JPanel();
		panelImagem.setBounds(76, 38, 120, 120);
		contentPane.add(panelImagem);
		panelImagem.setLayout(null);

		JLabel lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon(CadastroCarteira.class.getResource("/Imagens/CadastroCart.png")));
		lblImagem.setBounds(0, 0, 120, 120);
		panelImagem.add(lblImagem);

		// (Panel) Topo da Tela
		JPanel panelTopo = new JPanel();
		panelTopo.setBounds(0, 0, 834, 98);
		panelTopo.setBackground(new Color(31, 146, 191));
		contentPane.add(panelTopo);
		panelTopo.setLayout(null);

		JLabel lblTitulo = new JLabel("Cadastro de Carteiras");
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
		lblBarraLateral.setIcon(new ImageIcon(CadastroCarteira.class.getResource("/Imagens/Carteira.png")));
		lblBarraLateral.setBounds(0, 0, 120, 345);
		panelBarraLateral.add(lblBarraLateral);

		JSeparator separatorVac = new JSeparator();
		separatorVac.setBounds(76, 161, 120, 10);
		separatorVac.setForeground(new Color(54, 191, 191));
		separatorVac.setBackground(new Color(54, 191, 191));
		contentPane.add(separatorVac);

		// Formulário
		JLabel lblCpfCid = new JLabel("CPF *");
		lblCpfCid.setBounds(238, 145, 105, 14);
		lblCpfCid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblCpfCid);

		cpfCidField = new JTextField();
		try {
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("###.###.###-##");
			cpfCidField = new javax.swing.JFormattedTextField(format_textField4);
		} catch (Exception e1) {
		}
		cpfCidField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// Limpando os campos e bloqueando
				nomeCidField.setText(null);
				telCidField.setText(null);
				emailCidField.setText(null);
				idVacField.setText(null);
				nomeVacField.setText(null);
				idCartField.setText(null);
				dt1DoseField.setText(null);
				
				nomeCidField.setEnabled(false);
				telCidField.setEnabled(false);
				emailCidField.setEnabled(false);
				idVacField.setEnabled(false);
				nomeVacField.setEnabled(false);
				idCartField.setEnabled(false);
				dt1DoseField.setEnabled(false);
				btnBuscarVac.setEnabled(false);
				
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});
		cpfCidField.setBounds(238, 166, 105, 32);
		cpfCidField.setColumns(10);
		contentPane.add(cpfCidField);

		JButton btnBuscarCpf = new JButton("BUSCAR");
		btnBuscarCpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cpfCidField.getText().isBlank() || "   .   .   -  ".equals(cpfCidField.getText())) {
					JOptionPane.showMessageDialog(null, "Preencha o campo: CPF *", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					cpfCidField.setText(null);
					cpfCidField.requestFocus();
				} else {
					String cpf = cpfCidField.getText();

					Carteira c = new Carteira();
					c.setCpfCid(cpf);
					c.consultarCart();
					c.consultar();
					if(c.getNomeCid() != null) {
					if (c.getIdCart() != 0) {
						JOptionPane.showMessageDialog(null, "Este usuário já possui uma carteira!!!", "Atenção",
								JOptionPane.WARNING_MESSAGE);
						cpfCidField.setText(null);
						cpfCidField.requestFocus();
					} else {
						c.consultar();

					// Preenchendo os campos do fomulário com os dados vindos do banco e habilitando
					// novo campo
					nomeCidField.setText(c.getNomeCid());
					telCidField.setText(c.getTelCid());
					emailCidField.setText(c.getEmailCid());
					idVacField.setEnabled(true);
					btnBuscarVac.setEnabled(true);
					
					idVacField.requestFocus();
				}
			} else {
				JOptionPane.showMessageDialog(null, "CPF Inválido!!!", "Atenção",
						JOptionPane.WARNING_MESSAGE);
				cpfCidField.setText(null);
				cpfCidField.requestFocus();
			}
		}
			}});
		btnBuscarCpf.setForeground(Color.WHITE);
		btnBuscarCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarCpf.setBorder(null);
		btnBuscarCpf.setBackground(new Color(54, 191, 191));
		btnBuscarCpf.setBounds(353, 166, 73, 32);
		btnBuscarCpf.setFocusPainted(false);
		btnBuscarCpf.setCursor(cursorMao);
		contentPane.add(btnBuscarCpf);

		JLabel lblNomeCid = new JLabel("Nome do Cidad\u00E3o *");
		lblNomeCid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNomeCid.setBounds(436, 144, 302, 14);
		contentPane.add(lblNomeCid);

		nomeCidField = new JTextField();
		nomeCidField.setEnabled(false);
		nomeCidField.setBounds(436, 166, 302, 32);
		contentPane.add(nomeCidField);
		nomeCidField.setColumns(10);

		JLabel lblTelCid = new JLabel("Telefone *");
		lblTelCid.setBounds(238, 208, 105, 14);
		lblTelCid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblTelCid);

		telCidField = new JTextField();
		telCidField.setEnabled(false);
		telCidField.setBounds(238, 228, 188, 32);
		telCidField.setColumns(10);
		contentPane.add(telCidField);

		JLabel lblEmailCid = new JLabel("E-mail *");
		lblEmailCid.setBounds(436, 207, 302, 14);
		lblEmailCid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblEmailCid);

		emailCidField = new JTextField();
		emailCidField.setEnabled(false);
		emailCidField.setBounds(436, 228, 302, 32);
		emailCidField.setColumns(10);
		contentPane.add(emailCidField);

		JLabel lblIdVac = new JLabel("ID da Vacina *");
		lblIdVac.setBounds(238, 270, 189, 14);
		lblIdVac.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblIdVac);

		idVacField = new JTextField();
		idVacField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// Limpando os campos e bloqueando
				nomeVacField.setText(null);
				idCartField.setText(null);
				dt1DoseField.setText(null);
				
				nomeVacField.setEnabled(false);
				idCartField.setEnabled(false);
				dt1DoseField.setEnabled(false);
				
				 if (idVacField.getText().length() >= 4)
	                    e.consume();
			}
		});
		idVacField.setEnabled(false);
		idVacField.setColumns(10);
		idVacField.setBounds(238, 290, 105, 32);
		contentPane.add(idVacField);

		btnBuscarVac = new JButton("BUSCAR");
		btnBuscarVac.setEnabled(false);
		btnBuscarVac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idVacField.isEnabled() == false && idVacField.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Para habilitar a BUSCA preencha o campo: CPF *", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					cpfCidField.setText(null);
					cpfCidField.requestFocus();
				} else if (idVacField.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo: ID da Vacina *", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					idVacField.setText(null);
					idVacField.requestFocus();
				} else {
					String identificacaoVac = idVacField.getText();

					Carteira v = new Carteira();
					v.setIdentificacaoVac(identificacaoVac);
					v.consultarVac();
					
					if (v.getNomeVac() == null) {
						JOptionPane.showMessageDialog(null, "ID Inválido!!!", "Atenção",
								JOptionPane.WARNING_MESSAGE);
						idVacField.setText(null);
						idVacField.requestFocus();
					}

					// Preenchendo os campos do fomulário com os dados vindos do banco e habilitando
					// novo campo
					else {
					nomeVacField.setText(v.getNomeVac());
					dt1DoseField.setEnabled(true);
					dt1DoseField.requestFocus();
					}
				}
			}
		});
		btnBuscarVac.setForeground(Color.WHITE);
		btnBuscarVac.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarVac.setBorder(null);
		btnBuscarVac.setBackground(new Color(54, 191, 191));
		btnBuscarVac.setBounds(353, 288, 73, 32);
		btnBuscarVac.setFocusPainted(false);
		btnBuscarVac.setCursor(cursorMao);
		contentPane.add(btnBuscarVac);

		JLabel lblNomeVac = new JLabel("Nome da Vacina *");
		lblNomeVac.setBounds(436, 270, 302, 14);
		lblNomeVac.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblNomeVac);

		nomeVacField = new JTextField();
		nomeVacField.setEnabled(false);
		nomeVacField.setColumns(10);
		nomeVacField.setBounds(436, 290, 302, 32);
		contentPane.add(nomeVacField);

		JLabel lblIdCart = new JLabel("ID da Carteira");
		lblIdCart.setForeground(Color.LIGHT_GRAY);
		lblIdCart.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdCart.setBounds(238, 333, 105, 14);
		contentPane.add(lblIdCart);

		idCartField = new JTextField();
		idCartField.setEnabled(false);
		idCartField.setColumns(10);
		idCartField.setBounds(238, 352, 105, 32);
		contentPane.add(idCartField);

		JLabel lblDt1Dose = new JLabel("Data 1\u00AA Dose *");
		lblDt1Dose.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDt1Dose.setBounds(353, 333, 188, 14);
		contentPane.add(lblDt1Dose);

		dt1DoseField = new JTextField();
		try {
			javax.swing.text.MaskFormatter data1Dose = new javax.swing.text.MaskFormatter("##/##/####");
			dt1DoseField = new javax.swing.JFormattedTextField(data1Dose);
		} catch (Exception e) {
		}
		dt1DoseField.setEnabled(false);
		dt1DoseField.setColumns(10);
		dt1DoseField.setBounds(353, 353, 188, 32);
		contentPane.add(dt1DoseField);
		/*
		 * JLabel lblDt2Dose = new JLabel("Data 2\u00BA Dose (Previs\u00E3o)");
		 * lblDt2Dose.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 * lblDt2Dose.setBounds(550, 333, 188, 14); contentPane.add(lblDt2Dose);
		 * 
		 * dt2DoseField = new JTextField("");
		 * 
		 * try { javax.swing.text.MaskFormatter data2Dose = new
		 * javax.swing.text.MaskFormatter("##/##/####"); dt2DoseField = new
		 * javax.swing.JFormattedTextField(data2Dose); } catch (Exception e) { }
		 * 
		 * dt2DoseField.setEnabled(false); dt2DoseField.setColumns(10);
		 * dt2DoseField.setBounds(551, 353, 187, 32); contentPane.add(dt2DoseField);
		 */
		JButton btnCadastrarCart = new JButton("CADASTRAR");
		btnCadastrarCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cpfCidField.getText().isBlank() || "   .   .   -  ".equals(cpfCidField.getText())) {
					JOptionPane.showMessageDialog(null, "Preencha o campo: CPF *", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					cpfCidField.setText(null);
					cpfCidField.requestFocus();
				} else {
					String cpf = cpfCidField.getText();
					String dt1Dose = dt1DoseField.getText();
					
					Carteira c = new Carteira();
					c.setCpfCid(cpf);
					c.consultarCart();
					c.consultar();
					
					if(c.getNomeCid() != null) {
					if (c.getIdCart() != 0) {
						JOptionPane.showMessageDialog(null, "Este usuário já possui uma carteira!!!", "Atenção",
								JOptionPane.WARNING_MESSAGE);
						cpfCidField.setText(null);
						cpfCidField.requestFocus();
					} else {
						c.consultar();
						
						// Preenchendo os campos do fomulário com os dados vindos do banco e habilitando
						// novo campo
						nomeCidField.setText(c.getNomeCid());
						telCidField.setText(c.getTelCid());
						emailCidField.setText(c.getEmailCid());
						idVacField.setEnabled(true);
						btnBuscarVac.setEnabled(true);
						if (idVacField.getText().isBlank()) {
							JOptionPane.showMessageDialog(null, "Preencha o campo: ID da Vacina *", "Atenção",
									JOptionPane.WARNING_MESSAGE);
							idVacField.setText(null);
							idVacField.requestFocus();
						} else {
							String identificacaoVac = idVacField.getText();
							
							c.setIdentificacaoVac(identificacaoVac);
							c.consultarVac();
							
							if (c.getNomeVac() == null) {
								JOptionPane.showMessageDialog(null, "ID Inválido!!!", "Atenção",
										JOptionPane.WARNING_MESSAGE);
								idVacField.setText(null);
								idVacField.requestFocus();
							} else {
								nomeVacField.setText(c.getNomeVac());
								dt1DoseField.setEnabled(true);
							if ("  /  /    ".equals(dt1DoseField.getText()) || dt1DoseField.getText().isBlank()) {
								JOptionPane.showMessageDialog(null, "Preencha o campo: Data 1ª Dose *", "Atenção",
										JOptionPane.WARNING_MESSAGE);
								dt1DoseField.setText(null);
								dt1DoseField.requestFocus();
							} else if (c.checkDt1Dose(dt1Dose) == true) {
							// String dt2Dose = dt2DoseField.getText();
							String nomeCid = nomeCidField.getText();
							String telCid = telCidField.getText();
							String emailCid = emailCidField.getText();
							String nomeVac = nomeVacField.getText();
							
							c.setIdentificacaoVac(identificacaoVac);
							c.setCpfCid(cpf);
							c.setDt1Dose(dt1Dose);
							// c.setDt2Dose(dt2Dose);
							c.setNomeCid(nomeCid);
							c.setTelCid(telCid);
							c.setEmailCid(emailCid);
							c.setNomeVac(nomeVac);
							c.inserir();
							
							Vacina v = new Vacina();
							
							v.setIdentificacaoVac(identificacaoVac);
							v.consultar();
							
							if (v.getQtdDoses() == 1) {
								JOptionPane.showMessageDialog(null,
										"Cadastro efetuado com sucesso! \n",
										"Mensagem", JOptionPane.INFORMATION_MESSAGE);
								
								// Limpando os campos e bloqueando
								cpfCidField.setText(null);
								dt1DoseField.setText(null);
								// dt2DoseField.setText(null);
								nomeCidField.setText(null);
								nomeVacField.setText(null);
								telCidField.setText(null);
								emailCidField.setText(null);
								idVacField.setText(null);
								cpfCidField.setText(null);
								idVacField.setEnabled(false);
								dt1DoseField.setEnabled(false);
								cpfCidField.requestFocus();
								
							} else {
							
							c.getPrevisao();

							JOptionPane.showMessageDialog(null,
									"Cadastro efetuado com sucesso! \n" + "Previsão 2ª Dose: " + c.getDt2DoseFormatado(),
									"Mensagem", JOptionPane.INFORMATION_MESSAGE);

							// Limpando os campos e bloqueando
							cpfCidField.setText(null);
							dt1DoseField.setText(null);
							// dt2DoseField.setText(null);
							nomeCidField.setText(null);
							nomeVacField.setText(null);
							telCidField.setText(null);
							emailCidField.setText(null);
							idVacField.setText(null);
							cpfCidField.setText(null);
							idVacField.setEnabled(false);
							dt1DoseField.setEnabled(false);
							btnBuscarVac.setEnabled(false);
							cpfCidField.requestFocus();
							}
						} else {
							dt1DoseField.setText(null);
							dt1DoseField.requestFocus();
						}
					}
						}
				}
					} else {
					JOptionPane.showMessageDialog(null, "CPF Inválido!!!", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					cpfCidField.setText(null);
					cpfCidField.requestFocus();
				}
				}
			}
			});
		btnCadastrarCart.setBounds(458, 448, 130, 32);
		btnCadastrarCart.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrarCart.setForeground(Color.WHITE);
		btnCadastrarCart.setBorder(null);
		btnCadastrarCart.setBackground(new Color(54, 191, 191));
		btnCadastrarCart.setFocusPainted(false);
		btnCadastrarCart.setCursor(cursorMao);
		contentPane.add(btnCadastrarCart);

		JButton btnVoltarCart = new JButton("VOLTAR");
		btnVoltarCart.addActionListener(new ActionListener() {
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
		btnVoltarCart.setBounds(608, 448, 130, 32);
		btnVoltarCart.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltarCart.setForeground(Color.WHITE);
		btnVoltarCart.setBorder(null);
		btnVoltarCart.setBackground(new Color(54, 191, 191));
		btnVoltarCart.setFocusPainted(false);
		btnVoltarCart.setCursor(cursorMao);
		contentPane.add(btnVoltarCart);
	}
}