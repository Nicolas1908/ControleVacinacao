package Janelas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import Conexao.Vacina;

public class CadastroVacina extends JFrame {

	private JPanel contentPane;
	private JTextField idVacField;
	private JTextField nomeVacField;
	private JTextField fabricanteVacField;
	private JTextField qtdDosesField;
	private JTextField intervDiasField;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroVacina frame = new CadastroVacina();
					frame.setResizable(false);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Controle de Vacinação - Cadastro de Vacinas");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public CadastroVacina() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroVacina.class.getResource("/Imagens/Icone.png")));
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
		lblImagem.setIcon(new ImageIcon(CadastroVacina.class.getResource("/Imagens/CadastroVac.png")));
		lblImagem.setBounds(0, 0, 120, 120);
		panelImagem.add(lblImagem);

		// (Panel) Topo da Tela
		JPanel panelTopo = new JPanel();
		panelTopo.setBounds(0, 0, 834, 98);
		panelTopo.setBackground(new Color(31, 146, 191));
		contentPane.add(panelTopo);
		panelTopo.setLayout(null);

		JLabel lblTitulo = new JLabel("Cadastro de Vacinas");
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
				if (idVacField.getText().length() >= 4)
					e.consume();
			}
		});
		contentPane.add(idVacField);
		idVacField.setColumns(10);

		JLabel lblNomeVac = new JLabel("Nome da Vacina *");
		lblNomeVac.setBounds(364, 145, 374, 14);
		lblNomeVac.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblNomeVac);

		nomeVacField = new JTextField();
		nomeVacField.setBounds(364, 166, 374, 32);
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
		fabricanteVacField.setBounds(238, 228, 500, 32);
		fabricanteVacField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (fabricanteVacField.getText().length() >= 45)
					e.consume();
			}
		});
		fabricanteVacField.setColumns(10);
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
		intervDiasField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				} else if (c == KeyEvent.VK_0 && "".equals(intervDiasField.getText())) {
					e.consume();
				}
			}
		});
		intervDiasField.setBounds(364, 290, 105, 32);
		intervDiasField.setColumns(10);
		intervDiasField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (intervDiasField.getText().length() >= 3)
					e.consume();
			}
		});
		contentPane.add(intervDiasField);

		JButton btnCadastrarVac = new JButton("CADASTRAR");
		btnCadastrarVac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vacina v = new Vacina();
				
				String identificacaoVac = idVacField.getText();
				v.setIdentificacaoVac(identificacaoVac);
				v.consultar();
				
				if (v.getNomeVac() != null) {
					JOptionPane.showMessageDialog(null, "Essa vacina já se encontra cadastrado no nosso sistema!!!", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					idVacField.setText(null);
					idVacField.requestFocus();
				}
				else if (idVacField.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo: ID da Vacina *", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					idVacField.setText(null);
					idVacField.requestFocus();
				} else if (nomeVacField.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo: Nome *", "Atenção",
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
					v.setIdentificacaoVac(identificacaoVac);
					v.setNomeVac(nomeVac);
					v.setFabricanteVac(fabricanteVac);
					v.setQtdDoses(qtdDoses);
					v.setIntervDias(intervDias);
					v.inserir();

					JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Mensagem",
							JOptionPane.INFORMATION_MESSAGE);

					// Limpando os campos
					idVacField.setText(null);
					nomeVacField.setText(null);
					fabricanteVacField.setText(null);
					qtdDosesField.setText(null);
					intervDiasField.setText(null);
					intervDiasField.setEnabled(true);
					idVacField.requestFocus();
				}
			}
		});
		btnCadastrarVac.setBounds(458, 448, 130, 32);
		btnCadastrarVac.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrarVac.setForeground(Color.WHITE);
		btnCadastrarVac.setBorder(null);
		btnCadastrarVac.setBackground(new Color(54, 191, 191));
		btnCadastrarVac.setFocusPainted(false);
		btnCadastrarVac.setCursor(cursorMao);
		contentPane.add(btnCadastrarVac);

		JButton btnVoltarVac = new JButton("VOLTAR");
		btnVoltarVac.setBounds(608, 448, 130, 32);
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
		btnVoltarVac.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltarVac.setForeground(Color.WHITE);
		btnVoltarVac.setBorder(null);
		btnVoltarVac.setBackground(new Color(54, 191, 191));
		btnVoltarVac.setFocusPainted(false);
		btnVoltarVac.setCursor(cursorMao);
		contentPane.add(btnVoltarVac);
	}
}