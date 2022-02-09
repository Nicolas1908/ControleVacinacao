package Janelas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConsultaCarteira extends JFrame {

	private JPanel contentPane;
	private JTextField cpfCidField;
	private JTextField emailCidField;
	private JTextField telCidField;
	private JTextField nomeVacField;
	private JTextField idVacField;
	private JTextField dt2DoseField;
	private JTextField dt2DoseField_1;
	private JTextField idCartField;
	private JTextField nomeCidField;
	private JTextField dt1DoseField;
	private JLabel lblDt2Dose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaCarteira frame = new ConsultaCarteira();
					frame.setResizable(false);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Controle de Vacinação - Consulta de Carteiras");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public ConsultaCarteira() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConsultaCarteira.class.getResource("/Imagens/Icone.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Mouse (Mão)
		Cursor cursorMao = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);

		// Imagem (cabeçalho)
		JPanel panelImagem = new JPanel();
		panelImagem.setBounds(76, 38, 120, 120);
		contentPane.add(panelImagem);
		panelImagem.setLayout(null);

		JLabel lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon(ConsultaCarteira.class.getResource("/Imagens/ConsultaCart.png")));
		lblImagem.setBounds(0, 0, 120, 120);
		panelImagem.add(lblImagem);

		// (Panel) Topo da Tela
		JPanel panelTopo = new JPanel();
		panelTopo.setBounds(0, 0, 834, 98);
		panelTopo.setBackground(new Color(31, 146, 191));
		contentPane.add(panelTopo);
		panelTopo.setLayout(null);

		JLabel lblTitulo = new JLabel("Consulta de Carteiras");
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
		lblBarraLateral.setIcon(new ImageIcon(ConsultaCarteira.class.getResource("/Imagens/Carteira.png")));
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
				//Limpando
				nomeCidField.setText("");
				nomeVacField.setText("");
				telCidField.setText("");
				emailCidField.setText("");
				dt1DoseField.setText("");
				dt2DoseField.setText("");
				idCartField.setText("");
				idVacField.setText("");
				
				//Bloqueando
				nomeCidField.setEnabled(false);
				nomeVacField.setEnabled(false);
				telCidField.setEnabled(false);
				emailCidField.setEnabled(false);
				dt1DoseField.setEnabled(false);
				dt2DoseField.setEnabled(false);
				idCartField.setEnabled(false);
				idVacField.setEnabled(false);
				
				// Deixando visivel
				lblDt2Dose.setVisible(true);
				dt2DoseField.setVisible(true);
				
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
					if(c.getIdCart() == 0) {
						JOptionPane.showMessageDialog(null, "O Usuário não possui uma carteira!!!", "Atenção",
								JOptionPane.WARNING_MESSAGE);
						cpfCidField.setText(null);
						cpfCidField.requestFocus();
					} else {
					c.consultar();
					c.consultarVac();
					
					if (c.getQtdDoses() == 1) {
						dt2DoseField.setVisible(false);
						lblDt2Dose.setVisible(false);
						
						// Preenchendo os campos do fomulário com os dados vindos do banco e habilitando
						// campos
						nomeCidField.setText(c.getNomeCid());
						nomeVacField.setText(c.getNomeVac());
						telCidField.setText(c.getTelCid());
						emailCidField.setText(c.getEmailCid());
						dt1DoseField.setText(c.getDt1DoseFormatado());
						dt2DoseField.setText(c.getDt2DoseFormatado());
						idCartField.setText(Integer.toString(c.getIdCart()));
						idVacField.setText(c.getIdentificacaoVac());
					} else {

					// Preenchendo os campos do fomulário com os dados vindos do banco e habilitando
					// campos
					nomeCidField.setText(c.getNomeCid());
					nomeVacField.setText(c.getNomeVac());
					telCidField.setText(c.getTelCid());
					emailCidField.setText(c.getEmailCid());
					dt1DoseField.setText(c.getDt1DoseFormatado());
					dt2DoseField.setText(c.getDt2DoseFormatado());
					idCartField.setText(Integer.toString(c.getIdCart()));
					idVacField.setText(c.getIdentificacaoVac());
					dt2DoseField.setEnabled(true);
					
					dt2DoseField.requestFocus();
					
					if (dt2DoseField.getText().isBlank() || "  /  /    ".equals(dt2DoseField.getText())) {
						c.getPrevisao();
						lblDt2Dose.setText("2º Dose (Previs\u00E3o): " + c.getDt2DoseFormatado());
					} else {
						lblDt2Dose.setText("Data 2º Dose *");
					} 
					}
					}
				} else {
					JOptionPane.showMessageDialog(null, "CPF Inválido!!!", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					cpfCidField.setText("");
					cpfCidField.requestFocus();
				}
				}
			}
		});
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
		idVacField.setEnabled(false);
		idVacField.setColumns(10);
		idVacField.setBounds(238, 290, 188, 32);
		contentPane.add(idVacField);

		JLabel lblNomeVac = new JLabel("Nome da Vacina *");
		lblNomeVac.setBounds(436, 270, 302, 14);
		lblNomeVac.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblNomeVac);

		nomeVacField = new JTextField();
		nomeVacField.setEnabled(false);
		nomeVacField.setColumns(10);
		nomeVacField.setBounds(436, 290, 302, 32);
		contentPane.add(nomeVacField);

		JLabel lblIdCart = new JLabel("ID da Carteira *");
		lblIdCart.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdCart.setBounds(238, 333, 105, 14);
		contentPane.add(lblIdCart);

		idCartField = new JTextField();
		idCartField.setEnabled(false);
		idCartField.setColumns(10);
		idCartField.setBounds(238, 352, 105, 32);
		contentPane.add(idCartField);

		JLabel lblDt1Dose = new JLabel("Data 1\u00BA Dose *");
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

		lblDt2Dose = new JLabel("Data 2\u00BA Dose");
		lblDt2Dose.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDt2Dose.setBounds(550, 333, 188, 14);
		contentPane.add(lblDt2Dose);

		dt2DoseField = new JTextField("");
		try {
			javax.swing.text.MaskFormatter data2Dose = new javax.swing.text.MaskFormatter("##/##/####");
			dt2DoseField = new javax.swing.JFormattedTextField(data2Dose);
			dt2DoseField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					String cpf = cpfCidField.getText();
					Carteira c = new Carteira();
					
					c.setCpfCid(cpf);
					c.consultarCart();
					c.consultarVac();
					
					if (!"".equals(c.getDt2DoseFormatado())) {
					c.getPrevisao();
					lblDt2Dose.setText("2º Dose (Previs\u00E3o): " + c.getDt2DoseFormatado());
					}
				}
			});
		} catch (Exception e) {
		}
		dt2DoseField.setEnabled(false);
		dt2DoseField.setColumns(10);
		dt2DoseField.setBounds(551, 353, 187, 32);
		contentPane.add(dt2DoseField);

		JButton btnExcluirCart = new JButton("EXCLUIR");
		btnExcluirCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = cpfCidField.getText();
				Carteira c = new Carteira();
				
				c.setCpfCid(cpf);
				c.consultarCart();
				c.consultar();
				if (cpfCidField.getText().isBlank() || "   .   .   -  ".equals(cpfCidField.getText())) {
					JOptionPane.showMessageDialog(null, "Para EXCLUIR carteiras preencha o campo: CPF *", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					cpfCidField.setText(null);
					cpfCidField.requestFocus();
				} else if (c.getNomeCid() != null) {
					if(c.getIdCart() == 0) {
						JOptionPane.showMessageDialog(null, "O Usuário não possui uma carteira!!!", "Atenção",
								JOptionPane.WARNING_MESSAGE);
						cpfCidField.setText(null);
						cpfCidField.requestFocus();
				} else {
					c.consultarVac();
					if (dt2DoseField.isEnabled() == false) {
						nomeCidField.setText(c.getNomeCid());
						nomeVacField.setText(c.getNomeVac());
						telCidField.setText(c.getTelCid());
						emailCidField.setText(c.getEmailCid());
						dt1DoseField.setText(c.getDt1DoseFormatado());
						dt2DoseField.setText(c.getDt2DoseFormatado());
						idCartField.setText(Integer.toString(c.getIdCart()));
						idVacField.setText(c.getIdentificacaoVac());
						dt2DoseField.setEnabled(true);
						dt2DoseField.requestFocus();
						
						if (dt2DoseField.getText().isBlank() || "  /  /    ".equals(dt2DoseField.getText())) {
							c.getPrevisao();
							lblDt2Dose.setText("2º Dose (Previs\u00E3o): " + c.getDt2DoseFormatado());
						} else {
							lblDt2Dose.setText("Data 2º Dose *");
						}
					} else {
					
						int reply = JOptionPane.showConfirmDialog(null, "Tem certeza?", "Mensagem", JOptionPane.YES_NO_OPTION);
						if (reply == JOptionPane.YES_OPTION) {
							c.setCpfCid(cpf);
							c.apagar();
							
							JOptionPane.showMessageDialog(null, "Cidadão excluido com sucesso!", "Mensagem",
									JOptionPane.INFORMATION_MESSAGE);
						}

					// Limpando os campos e bloqueando
					lblDt2Dose.setText("Data 2º Dose (Previsão)");
					nomeCidField.setText(null);
					cpfCidField.setText(null);
					dt1DoseField.setText(null);
					dt2DoseField.setText(null);
					telCidField.setText(null);
					emailCidField.setText(null);
					idVacField.setText(null);
					idCartField.setText(null);
					nomeVacField.setText(null);
					dt2DoseField.setEnabled(false);
					cpfCidField.requestFocus();
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "CPF Inválido!!!", "Atenção",
						JOptionPane.WARNING_MESSAGE);
				cpfCidField.setText(null);
				cpfCidField.requestFocus();
			}}
		});
		btnExcluirCart.setForeground(Color.WHITE);
		btnExcluirCart.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluirCart.setFocusPainted(false);
		btnExcluirCart.setBorder(null);
		btnExcluirCart.setBackground(new Color(54, 191, 191));
		btnExcluirCart.setBounds(309, 448, 130, 32);
		btnExcluirCart.setCursor(cursorMao);
		contentPane.add(btnExcluirCart);

		JButton btnAlterarCart = new JButton("ALTERAR");
		btnAlterarCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = cpfCidField.getText();

				Carteira c = new Carteira();
				c.setCpfCid(cpf);
				c.consultarCart();
				c.consultar();
				
				if (cpfCidField.getText().isBlank() || "   .   .   -  ".equals(cpfCidField.getText())) {
					JOptionPane.showMessageDialog(null, "Preencha o campo: CPF *", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					cpfCidField.requestFocus();
				} else if (c.getNomeCid() != null) {
					if(c.getIdCart() == 0) {
						JOptionPane.showMessageDialog(null, "O Usuário não possui uma carteira!!!", "Atenção",
								JOptionPane.WARNING_MESSAGE);
						cpfCidField.setText(null);
						cpfCidField.requestFocus();
			} else {
				c.consultarVac();
				if (dt2DoseField.isEnabled() == false) {
					nomeCidField.setText(c.getNomeCid());
					nomeVacField.setText(c.getNomeVac());
					telCidField.setText(c.getTelCid());
					emailCidField.setText(c.getEmailCid());
					dt1DoseField.setText(c.getDt1DoseFormatado());
					dt2DoseField.setText(c.getDt2DoseFormatado());
					idCartField.setText(Integer.toString(c.getIdCart()));
					idVacField.setText(c.getIdentificacaoVac());
					dt2DoseField.setEnabled(true);
					dt2DoseField.requestFocus();
					
					if (dt2DoseField.getText().isBlank() || "  /  /    ".equals(dt2DoseField.getText())) {
						c.getPrevisao();
						lblDt2Dose.setText("2º Dose (Previs\u00E3o): " + c.getDt2DoseFormatado());
					} else {
						lblDt2Dose.setText("Data 2º Dose *");
					}
				} else if("  /  /    ".equals(dt2DoseField.getText()) && dt2DoseField.isEnabled() != false) {
					JOptionPane.showMessageDialog(null, "Preencha o campo: Data 2ª Dose *", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					dt2DoseField.setText(null);
					dt2DoseField.requestFocus();
				} else {
					//String dt1Dose = dt1DoseField.getText();
					String dt2Dose = dt2DoseField.getText();
					if (c.checkDt2Dose(dt2Dose) == true) {
					String cpfCid = cpfCidField.getText();
					
					int idCart = Integer.parseInt(idCartField.getText());

					Carteira c2 = new Carteira();
					c2.setCpfCid(cpfCid);
					c2.setDt2Dose(dt2Dose);
					c2.setIdCart(idCart);
					c2.alterar();

					JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!", "Mensagem",
							JOptionPane.INFORMATION_MESSAGE);

					// Limpando os campos e bloqueando
					lblDt2Dose.setText("Data 2º Dose (Previsão)");
					nomeCidField.setText(null);
					cpfCidField.setText(null);
					dt1DoseField.setText(null);
					dt2DoseField.setText(null);
					telCidField.setText(null);
					emailCidField.setText(null);
					idVacField.setText(null);
					idCartField.setText(null);
					nomeVacField.setText(null);
					dt1DoseField.setEnabled(false);
					dt2DoseField.setEnabled(false);
					cpfCidField.requestFocus();
					} else {
						dt2DoseField.setText(null);
						dt2DoseField.requestFocus();
					}
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "CPF Inválido!!!", "Atenção",
					JOptionPane.WARNING_MESSAGE);
			cpfCidField.setText(null);
			cpfCidField.requestFocus();
		}
		}});
		btnAlterarCart.setBounds(458, 448, 130, 32);
		btnAlterarCart.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlterarCart.setForeground(Color.WHITE);
		btnAlterarCart.setBorder(null);
		btnAlterarCart.setBackground(new Color(54, 191, 191));
		btnAlterarCart.setFocusPainted(false);
		btnAlterarCart.setCursor(cursorMao);
		contentPane.add(btnAlterarCart);

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