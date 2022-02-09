package Janelas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
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
import java.awt.Toolkit;

public class CadastroCidadao extends JFrame {

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

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCidadao frame = new CadastroCidadao();
					frame.setResizable(false);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Controle de Vacinação - Cadastro de Cidadãos");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public CadastroCidadao() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroCidadao.class.getResource("/Imagens/Icone.png")));
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
		lblImagem.setIcon(new ImageIcon(CadastroCidadao.class.getResource("/Imagens/CadastroCid.png")));
		lblImagem.setBounds(0, 0, 120, 120);
		panelImagem.add(lblImagem);

		// (Panel) Topo da Tela
		JPanel panelTopo = new JPanel();
		panelTopo.setBounds(0, 0, 834, 98);
		panelTopo.setBackground(new Color(31, 146, 191));
		contentPane.add(panelTopo);
		panelTopo.setLayout(null);

		JLabel lblTitulo = new JLabel("Cadastro de Cidad\u00E3os");
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

		JLabel lblNomeCid = new JLabel("Nome do Cidad\u00E3o *");
		lblNomeCid.setBounds(239, 127, 500, 14);
		lblNomeCid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblNomeCid);

		nomeCidField = new JTextField();
		nomeCidField.setBounds(239, 148, 500, 32);
		nomeCidField.setColumns(10);
		nomeCidField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (nomeCidField.getText().length() >= 55)
					e.consume();
			}
		});
		contentPane.add(nomeCidField);

		JLabel lblCpfCid = new JLabel("CPF *");
		lblCpfCid.setBounds(239, 190, 178, 14);
		lblCpfCid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblCpfCid);

		cpfCidField = new JTextField();
		try {
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("###.###.###-##");
			cpfCidField = new javax.swing.JFormattedTextField(format_textField4);
			// format_textField4.setPlaceholderCharacter('_');
		} catch (Exception e1) {
		}
		cpfCidField.setBounds(239, 210, 178, 32);
		cpfCidField.setColumns(10);
		cpfCidField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});
		contentPane.add(cpfCidField);

		JLabel lblDtNascCid = new JLabel("Data de Nascimento *");
		lblDtNascCid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDtNascCid.setBounds(239, 252, 178, 14);
		contentPane.add(lblDtNascCid);

		dtNascCidField = new JTextField();
		try {
			javax.swing.text.MaskFormatter dataNasc = new javax.swing.text.MaskFormatter("##/##/####");
			dtNascCidField = new javax.swing.JFormattedTextField(dataNasc);
		} catch (Exception e) {
		}
		dtNascCidField.setColumns(10);
		dtNascCidField.setBounds(239, 272, 178, 32);
		contentPane.add(dtNascCidField);

		JLabel lblTelCid = new JLabel("Telefone");
		lblTelCid.setBounds(437, 190, 140, 14);
		lblTelCid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblTelCid);

		telCidField = new JTextField();
		try {
			javax.swing.text.MaskFormatter tel = new javax.swing.text.MaskFormatter("(##) ####-####");
			telCidField = new javax.swing.JFormattedTextField(tel);
		} catch (Exception e) {
		}
		telCidField.setColumns(15);
		telCidField.setBounds(437, 210, 140, 32);
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
		} catch (Exception e) {
		}
		celCidField.setColumns(15);
		celCidField.setBounds(599, 210, 140, 32);
		contentPane.add(celCidField);

		JLabel lblCelular = new JLabel("Celular *");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCelular.setBounds(599, 191, 140, 14);
		contentPane.add(lblCelular);

		JLabel lblEmailCid = new JLabel("E-mail *");
		lblEmailCid.setBounds(437, 252, 302, 14);
		lblEmailCid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblEmailCid);

		emailCidField = new JTextField();
		emailCidField.setColumns(10);
		emailCidField.setBounds(437, 272, 302, 32);
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
		} catch (Exception e) {
		}
		cepCidField.setColumns(10);
		cepCidField.setBounds(239, 335, 105, 32);
		contentPane.add(cepCidField);

		JButton btnBuscarCep = new JButton("BUSCAR");
		btnBuscarCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cepCidField.getText().isBlank() || "     -   ".equals(cepCidField.getText())) {
					JOptionPane.showMessageDialog(null, "Preencha o campo: CEP *", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					cepCidField.setText(null);
					cepCidField.requestFocus();
				} else {
					buscarCep(cepCidField.getText());
					endCidField.setText(enderecoCid);
					bairroCidField.setText(bairroCid);
					cidCidField.setText(cidadeCid);
					ufCidField.setText(ufCid);
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
		ufCidField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (ufCidField.getText().length() >= 2)
					e.consume();
			}
		});
		ufCidField.setColumns(10);
		ufCidField.setBounds(653, 398, 86, 32);
		contentPane.add(ufCidField);

		// Botão "Cadastrar"
		JButton btnCadastrarCid = new JButton("CADASTRAR");
		btnCadastrarCid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cidadao c = new Cidadao();
				
				String cpfCid = cpfCidField.getText();
				String nomeCid = nomeCidField.getText();
				String dtNascCid = dtNascCidField.getText();
				String telCid = telCidField.getText();
				String celCid = celCidField.getText();
				String emailCid = emailCidField.getText();
				String enderecoCid = endCidField.getText();
				String numCid = numCidField.getText();
				String cepCid = cepCidField.getText();
				String ufCid = ufCidField.getText();
				String cidCid = cidCidField.getText();
				String bairroCid = bairroCidField.getText();
				
				c.setCpfCid(cpfCid);
				c.consultar();
				
				if (c.getNomeCid() != null) {
					JOptionPane.showMessageDialog(null, "Esse CPF já se encontra cadastrado no nosso sistema!!!", "Atenção",
							JOptionPane.WARNING_MESSAGE);
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
					
					cpfCidField.requestFocus();
				}
				else if (nomeCidField.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo: Nome do Cidadão *", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					nomeCidField.setText(null);
					nomeCidField.requestFocus();
				} else if (cpfCidField.getText().isBlank() || "   .   .   -  ".equals(cpfCidField.getText())) {
					JOptionPane.showMessageDialog(null, "Preencha o campo: CPF *", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					cpfCidField.setText(null);
					cpfCidField.requestFocus();
				}/* else if (telCidField.getText().isBlank() ||
					  "(  )     -    ".equals(telCidField.getText())) {
					  JOptionPane.showMessageDialog(null, "Preencha o campo: Telefone",
					  "Atenção", JOptionPane.WARNING_MESSAGE); 
					  telCidField.setText(null);
					  telCidField.requestFocus(); 
				} */ else if (celCidField.getText().isBlank() ||
					  "(  )      -    ".equals(celCidField.getText())) {
					  JOptionPane.showMessageDialog(null, "Preencha o campo: Celular *", "Atenção",
					  JOptionPane.WARNING_MESSAGE); 
					  celCidField.setText(null);
					  celCidField.requestFocus(); 
			    } else if (dtNascCidField.getText().isBlank() || "  /  /    ".equals(dtNascCidField.getText())) {
					JOptionPane.showMessageDialog(null, "Preencha o campo: Data de Nascimento *", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					dtNascCidField.setText(null);
					dtNascCidField.requestFocus();
				} else if(c.checkDate(dtNascCid) == true) {
			        if(emailCidField.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo: Email *", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					emailCidField.setText(null);
					emailCidField.requestFocus();
				} else if(cepCidField.getText().isBlank() || "     -   ".equals(cepCidField.getText())) {
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
				} else if(bairroCidField.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo: Bairro *", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					bairroCidField.setText(null);
					bairroCidField.requestFocus();
				} else if(cidCidField.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo: Cidade *", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					cidCidField.setText(null);
					cidCidField.requestFocus();
				} else if(ufCidField.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo: UF *", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					ufCidField.setText(null);
					ufCidField.requestFocus();
				} else {
					c.setNomeCid(nomeCid);
					c.setCpfCid(cpfCid);
					c.setTelCid(telCid);
					c.setCelCid(celCid);
					c.setEmailCid(emailCid);
					c.setEnderecoCid(enderecoCid);
					c.setNumCid(numCid);
					c.setCepCid(cepCid);
					c.setUfCid(ufCid);
					c.setCidCid(cidCid);
					c.setBairroCid(bairroCid);
					
					c.inserir();

					JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Mensagem",
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
					nomeCidField.requestFocus();
				}
				} else {
					dtNascCidField.setText(null);
					dtNascCidField.requestFocus();
				}
			}
		});
		btnCadastrarCid.setBounds(458, 448, 130, 32);
		btnCadastrarCid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrarCid.setForeground(Color.WHITE);
		btnCadastrarCid.setBorder(null);
		btnCadastrarCid.setBackground(new Color(54, 191, 191));
		btnCadastrarCid.setFocusPainted(false);
		btnCadastrarCid.setCursor(cursorMao);
		contentPane.add(btnCadastrarCid);

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