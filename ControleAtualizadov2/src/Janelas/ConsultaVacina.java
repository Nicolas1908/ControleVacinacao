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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Conexao.Vacina;

public class ConsultaVacina extends JFrame {

	private JPanel contentPane;
	private JTextField idVacField;
	private JTextField nomeVacField;
	private JTextField fabricanteVacField;
	private JTextField qtdDosesField;
	private JTextField intervDiasField;

	/**
	 * Launch the application.
	 */

	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaVacina frame = new ConsultaVacina();
					frame.setResizable(false);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Controle de Vacinação - Consulta de Vacinas");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	
	private void ConstrucaoGeral() {
		System.out.println("Nós estamos aqui!");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConsultaVacina.class.getResource("/Imagens/Icone.png")));
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
		lblImagem.setIcon(new ImageIcon(ConsultaVacina.class.getResource("/Imagens/ConsultaVac.png")));
		lblImagem.setBounds(0, 0, 120, 120);
		panelImagem.add(lblImagem);

		// (Panel) Topo da Tela
		JPanel panelTopo = new JPanel();
		panelTopo.setBounds(0, 0, 834, 98);
		panelTopo.setBackground(new Color(31, 146, 191));
		contentPane.add(panelTopo);
		panelTopo.setLayout(null);

		JLabel lblTitulo = new JLabel("Consulta de Vacinas");
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
		lblBarraLateral.setIcon(new ImageIcon(CadastroVacina.class.getResource("/Imagens/Vacina.png")));
		lblBarraLateral.setBounds(0, 0, 120, 345);
		panelBarraLateral.add(lblBarraLateral);

		JSeparator separatorVac = new JSeparator();
		separatorVac.setBounds(76, 161, 120, 10);
		separatorVac.setForeground(new Color(54, 191, 191));
		separatorVac.setBackground(new Color(54, 191, 191));
		contentPane.add(separatorVac);

		// Formulário
		JLabel lblIdVac = new JLabel("ID da Vacina *");
		lblIdVac.setBounds(238, 145, 105, 14);
		lblIdVac.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblIdVac);

		idVacField = new JTextField();
		idVacField.setBounds(238, 166, 105, 32);
		idVacField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				// Desativando Campos
				nomeVacField.setEnabled(false);
				fabricanteVacField.setEnabled(false);
				qtdDosesField.setEnabled(false);
				intervDiasField.setEnabled(false);

				// Limpando campos

				nomeVacField.setText("");
				fabricanteVacField.setText("");
				qtdDosesField.setText("");
				intervDiasField.setText("");

				if (idVacField.getText().length() >= 4)
					e.consume();
			}
		});
		contentPane.add(idVacField);
		idVacField.setColumns(10);

		JButton btnBuscarVac = new JButton("BUSCAR");
		btnBuscarVac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idVacField.getText().isBlank()) {
					/*JOptionPane.showMessageDialog(null, "Preencha o campo: ID da Vacina *", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					idVacField.setText(null);
					idVacField.requestFocus();*/
					Vacina v = new Vacina();
					BuscaVacina BuscaVacina = new BuscaVacina();
					BuscaVacina.setTitle("Controle de Vacinação - Busca de Vacinas");
					BuscaVacina.setResizable(false);
					BuscaVacina.setVisible(true);
					BuscaVacina.setLocationRelativeTo(null);
					BuscaVacina.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					DefaultTableModel modelo = (DefaultTableModel) BuscaVacina.tbVacinas.getModel();
					v.buscarVacinas(modelo);
					
					dispose();
				} else {
					String identificacaoVac = idVacField.getText();

					Vacina v = new Vacina();
					v.setIdentificacaoVac(identificacaoVac);
					v.consultar();

					// Preenchendo os campos do fomulário com os dados vindos do banco
					if (v.getNomeVac() == null) {
						JOptionPane.showMessageDialog(null, "ID Inválido!!!", "Atenção",
								JOptionPane.WARNING_MESSAGE);
						
						/*
						idVacField.setText(null);
						idVacField.requestFocus();
						// Desativando Campos
						nomeVacField.setEnabled(false);
						fabricanteVacField.setEnabled(false);
						qtdDosesField.setEnabled(false);
						intervDiasField.setEnabled(false);
						
						// Limpando campos
						
						nomeVacField.setText(null);
						fabricanteVacField.setText(null);
						qtdDosesField.setText(null);
						intervDiasField.setText(null);
						*/
						BuscaVacina BuscaVacina = new BuscaVacina();
						BuscaVacina.setTitle("Controle de Vacinação - Busca de Vacinas");
						BuscaVacina.setResizable(false);
						BuscaVacina.setVisible(true);
						BuscaVacina.setLocationRelativeTo(null);
						BuscaVacina.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
						DefaultTableModel modelo = (DefaultTableModel) BuscaVacina.tbVacinas.getModel();
						v.buscarVacinas(modelo);
						
						dispose();
						
					} else {
					
					nomeVacField.setText(v.getNomeVac());
					fabricanteVacField.setText(v.getFabricanteVac());
					qtdDosesField.setText(Integer.toString(v.getQtdDoses()));
					intervDiasField.setText(Integer.toString(v.getIntervDias()));

					if (!"1".equals(qtdDosesField.getText())) {
						intervDiasField.setEnabled(true);
					}

					// Deixando os campos editáves
					nomeVacField.setEnabled(true);
					fabricanteVacField.setEnabled(true);
					qtdDosesField.setEnabled(true);
					}
				}
			}
		});
		btnBuscarVac.setForeground(Color.WHITE);
		btnBuscarVac.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarVac.setBorder(null);
		btnBuscarVac.setBackground(new Color(54, 191, 191));
		btnBuscarVac.setBounds(353, 166, 73, 32);
		btnBuscarVac.setFocusPainted(false);
		btnBuscarVac.setCursor(cursorMao);
		contentPane.add(btnBuscarVac);

		JLabel lblNomeVac = new JLabel("Nome da Vacina *");
		lblNomeVac.setBounds(436, 145, 302, 14);
		lblNomeVac.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblNomeVac);

		nomeVacField = new JTextField();
		nomeVacField.setEnabled(false);
		nomeVacField.setBounds(436, 166, 302, 32);
		nomeVacField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (nomeVacField.getText().length() >= 45)
					e.consume();
			}
		});
		contentPane.add(nomeVacField);
		nomeVacField.setColumns(10);

		JLabel lblFabricanteVac = new JLabel("Fabricante *");
		lblFabricanteVac.setBounds(238, 208, 500, 14);
		lblFabricanteVac.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblFabricanteVac);

		fabricanteVacField = new JTextField();
		fabricanteVacField.setEnabled(false);
		fabricanteVacField.setBounds(238, 228, 500, 32);
		fabricanteVacField.setColumns(10);
		fabricanteVacField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (fabricanteVacField.getText().length() >= 45)
					e.consume();
			}
		});
		contentPane.add(fabricanteVacField);

		JLabel lblQtdDosesVac = new JLabel("Qtd. de Doses *");
		lblQtdDosesVac.setBounds(238, 270, 105, 14);
		lblQtdDosesVac.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblQtdDosesVac);

		qtdDosesField = new JTextField();
		qtdDosesField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				} else if (c == KeyEvent.VK_0 || c == KeyEvent.VK_3 || c == KeyEvent.VK_4 || c == KeyEvent.VK_5
						|| c == KeyEvent.VK_6 || c == KeyEvent.VK_7 || c == KeyEvent.VK_8 || c == KeyEvent.VK_9) {
					e.consume();
				} else if (c == KeyEvent.VK_1 && "".equals(qtdDosesField.getText())) {
					intervDiasField.setEnabled(false);
					intervDiasField.setText("0");

				} else if (c == KeyEvent.VK_2 && "".equals(qtdDosesField.getText())) {
					intervDiasField.requestFocus();
				} else if (!(c == KeyEvent.VK_1) && "".equals(qtdDosesField.getText())) {
					intervDiasField.setEnabled(true);
					intervDiasField.setText("");
				}
			}
		});
		qtdDosesField.setEnabled(false);
		qtdDosesField.setBounds(238, 290, 105, 32);
		qtdDosesField.setColumns(10);
		qtdDosesField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (qtdDosesField.getText().length() >= 1)
					e.consume();
			}
		});
		contentPane.add(qtdDosesField);

		JLabel lblIntervDiasVac = new JLabel("Intervalo (Dias) *");
		lblIntervDiasVac.setBounds(364, 270, 105, 14);
		lblIntervDiasVac.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblIntervDiasVac);

		intervDiasField = new JTextField();
		intervDiasField.setEnabled(false);
		intervDiasField.setBounds(364, 290, 105, 32);
		intervDiasField.setColumns(10);
		intervDiasField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				} else if (c == KeyEvent.VK_0 && "".equals(intervDiasField.getText())) {
					e.consume();
				} else if (intervDiasField.getText().length() >= 3) {
					e.consume();
				}
			}
		});
		contentPane.add(intervDiasField);

		JButton btnExcluirVac = new JButton("EXCLUIR");
		btnExcluirVac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String identificacaoVac = idVacField.getText();
				Vacina v = new Vacina();
				
				if (idVacField.getText().isBlank()) {
					/*
					JOptionPane.showMessageDialog(null, "Para EXCLUIR vacinas preencha o campo: ID da Vacina *",
							"Atenção", JOptionPane.WARNING_MESSAGE);
					idVacField.setText(null);
					idVacField.requestFocus();
					*/
					
					BuscaVacina BuscaVacina = new BuscaVacina();
					BuscaVacina.setTitle("Controle de Vacinação - Busca de Vacinas");
					BuscaVacina.setResizable(false);
					BuscaVacina.setVisible(true);
					BuscaVacina.setLocationRelativeTo(null);
					BuscaVacina.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					DefaultTableModel modelo = (DefaultTableModel) BuscaVacina.tbVacinas.getModel();
					v.buscarVacinas(modelo);
					
					dispose();
				} else {
					v.setIdentificacaoVac(identificacaoVac);
					v.consultar();
					
					if (v.getNomeVac() == null) {
						JOptionPane.showMessageDialog(null, "ID Inválido!!!", "Atenção",
								JOptionPane.WARNING_MESSAGE);
						/*
						idVacField.setText("");
						idVacField.requestFocus();
						*/
						
						BuscaVacina BuscaVacina = new BuscaVacina();
						BuscaVacina.setTitle("Controle de Vacinação - Busca de Vacinas");
						BuscaVacina.setResizable(false);
						BuscaVacina.setVisible(true);
						BuscaVacina.setLocationRelativeTo(null);
						BuscaVacina.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
						DefaultTableModel modelo = (DefaultTableModel) BuscaVacina.tbVacinas.getModel();
						v.buscarVacinas(modelo);
						
						dispose();
						
					} else if(nomeVacField.isEnabled() == false) {
						nomeVacField.setText(v.getNomeVac());
						fabricanteVacField.setText(v.getFabricanteVac());
						qtdDosesField.setText(Integer.toString(v.getQtdDoses()));
						intervDiasField.setText(Integer.toString(v.getIntervDias()));

						// Deixando os campos editáves
						nomeVacField.setEnabled(true);
						fabricanteVacField.setEnabled(true);
						qtdDosesField.setEnabled(true);
						intervDiasField.setEnabled(true);
				} else {
					
					int reply = JOptionPane.showConfirmDialog(null, "Tem certeza?", "Mensagem", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						v.setIdentificacaoVac(identificacaoVac);
						v.apagar();
						
						JOptionPane.showMessageDialog(null, "Vacina excluida com sucesso!", "Mensagem",
								JOptionPane.INFORMATION_MESSAGE);
					}

					// Limpando os campos
					idVacField.setText(null);
					nomeVacField.setText(null);
					fabricanteVacField.setText(null);
					qtdDosesField.setText(null);
					intervDiasField.setText(null);

					// Deixando os campos bloquedos
					nomeVacField.setEnabled(false);
					fabricanteVacField.setEnabled(false);
					qtdDosesField.setEnabled(false);
					intervDiasField.setEnabled(false);
					idVacField.requestFocus();
				}}
			}
		});
		btnExcluirVac.setForeground(Color.WHITE);
		btnExcluirVac.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluirVac.setFocusPainted(false);
		btnExcluirVac.setBorder(null);
		btnExcluirVac.setBackground(new Color(54, 191, 191));
		btnExcluirVac.setBounds(309, 448, 130, 32);
		btnExcluirVac.setCursor(cursorMao);
		contentPane.add(btnExcluirVac);

		JButton btnAlterarVac = new JButton("ALTERAR");
		btnAlterarVac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idVacField.getText().isBlank()) {
					/*
					JOptionPane.showMessageDialog(null, "Para ALTERAR vacinas preencha o campo: ID da Vacina *",
							"Atenção", JOptionPane.WARNING_MESSAGE);
					idVacField.setText(null);
					idVacField.requestFocus();
					*/
					BuscaVacina BuscaVacina = new BuscaVacina();
					BuscaVacina.setTitle("Controle de Vacinação - Busca de Vacinas");
					BuscaVacina.setResizable(false);
					BuscaVacina.setVisible(true);
					BuscaVacina.setLocationRelativeTo(null);
					BuscaVacina.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					DefaultTableModel modelo = (DefaultTableModel) BuscaVacina.tbVacinas.getModel();
					Vacina v = new Vacina();
					v.buscarVacinas(modelo);
					
					dispose();
				} else {
					Vacina v = new Vacina();
					String identificacaoVac = idVacField.getText();
					v.setIdentificacaoVac(identificacaoVac);
					v.consultar();
					
					if (v.getNomeVac() == null) {
						JOptionPane.showMessageDialog(null, "ID Inválido!!!", "Atenção",
								JOptionPane.WARNING_MESSAGE);
						/*
						idVacField.setText("");
						idVacField.requestFocus();
						*/
						
						BuscaVacina BuscaVacina = new BuscaVacina();
						BuscaVacina.setTitle("Controle de Vacinação - Busca de Vacinas");
						BuscaVacina.setResizable(false);
						BuscaVacina.setVisible(true);
						BuscaVacina.setLocationRelativeTo(null);
						BuscaVacina.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
						DefaultTableModel modelo = (DefaultTableModel) BuscaVacina.tbVacinas.getModel();
						v.buscarVacinas(modelo);
						
						dispose();
						
					} else if(nomeVacField.isEnabled() == false) {
						nomeVacField.setText(v.getNomeVac());
						fabricanteVacField.setText(v.getFabricanteVac());
						qtdDosesField.setText(Integer.toString(v.getQtdDoses()));
						intervDiasField.setText(Integer.toString(v.getIntervDias()));

						// Deixando os campos editáves
						nomeVacField.setEnabled(true);
						fabricanteVacField.setEnabled(true);
						qtdDosesField.setEnabled(true);
						intervDiasField.setEnabled(true);
				} else {
					
					if (nomeVacField.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo: Nome da Vacina *", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					nomeVacField.setText(null);
					nomeVacField.requestFocus();
				} else if (fabricanteVacField.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo: Fabricante *", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					fabricanteVacField.setText(null);
					fabricanteVacField.requestFocus();
				} else if (qtdDosesField.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo: Qtd. de Doses *", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					qtdDosesField.setText(null);
					qtdDosesField.requestFocus();
				} else if (intervDiasField.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo: Intervalo (Dias) *", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					intervDiasField.setText(null);
					intervDiasField.requestFocus();
				} else {
					String nomeVac = nomeVacField.getText();
					String fabricanteVac = fabricanteVacField.getText();
					int qtdDoses = Integer.parseInt(qtdDosesField.getText());
					int intervDias = Integer.parseInt(intervDiasField.getText());

					v.setNomeVac(nomeVac);
					v.setFabricanteVac(fabricanteVac);
					v.setQtdDoses(qtdDoses);
					v.setIntervDias(intervDias);
					v.alterar();

					JOptionPane.showMessageDialog(null, "Vacina alterada com sucesso!", "Mensagem",
							JOptionPane.INFORMATION_MESSAGE);

					// Limpando os campos
					idVacField.setText(null);
					nomeVacField.setText(null);
					fabricanteVacField.setText(null);
					qtdDosesField.setText(null);
					intervDiasField.setText(null);

					// Deixando os campos bloquedos
					nomeVacField.setEnabled(false);
					fabricanteVacField.setEnabled(false);
					qtdDosesField.setEnabled(false);
					intervDiasField.setEnabled(false);
					idVacField.requestFocus();
				}}
			}}
		});
		btnAlterarVac.setBounds(458, 448, 130, 32);
		btnAlterarVac.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlterarVac.setForeground(Color.WHITE);
		btnAlterarVac.setBorder(null);
		btnAlterarVac.setBackground(new Color(54, 191, 191));
		btnAlterarVac.setFocusPainted(false);
		btnAlterarVac.setCursor(cursorMao);
		contentPane.add(btnAlterarVac);

		JButton btnVoltarVac = new JButton("VOLTAR");
		btnVoltarVac.addActionListener(new ActionListener() {
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
		btnVoltarVac.setBounds(608, 448, 130, 32);
		btnVoltarVac.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltarVac.setForeground(Color.WHITE);
		btnVoltarVac.setBorder(null);
		btnVoltarVac.setBackground(new Color(54, 191, 191));
		btnVoltarVac.setFocusPainted(false);
		btnVoltarVac.setCursor(cursorMao);
		contentPane.add(btnVoltarVac);
	}

	public ConsultaVacina() {
		ConstrucaoGeral();
	}
	public ConsultaVacina(Vacina v) {
		ConstrucaoGeral();
		this.idVacField.setText(v.getIdentificacaoVac());
		this.nomeVacField.setText(v.getNomeVac());
		this.nomeVacField.setEnabled(true);
		this.fabricanteVacField.setText(v.getFabricanteVac());
		this.fabricanteVacField.setEnabled(true);
		this.qtdDosesField.setText(Integer.toString(v.getQtdDoses()));
		this.qtdDosesField.setEnabled(true);
		this.intervDiasField.setText(Integer.toString(v.getIntervDias()));
		this.intervDiasField.setEnabled(true);
	}
}