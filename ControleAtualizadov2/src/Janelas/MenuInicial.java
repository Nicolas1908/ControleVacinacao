package Janelas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MenuInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuInicial frame = new MenuInicial();
					frame.setResizable(false);
					frame.setVisible(true);
					frame.setTitle("Controle de Vacinação - Menu Inicial");
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuInicial() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuInicial.class.getResource("/Imagens/Icone.png")));
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
		lblImagem.setIcon(new ImageIcon(MenuInicial.class.getResource("/Imagens/MenuInicial.png")));
		lblImagem.setBounds(0, 0, 120, 120);
		panelImagem.add(lblImagem);

		// (Panel) Topo da Tela
		JPanel panelTopo = new JPanel();
		panelTopo.setBounds(0, 0, 834, 98);
		panelTopo.setBackground(new Color(31, 146, 191));
		contentPane.add(panelTopo);
		panelTopo.setLayout(null);

		JLabel lblTitulo = new JLabel("Ol\u00E1, o que deseja fazer a seguir?");
		lblTitulo.setForeground(SystemColor.text);
		lblTitulo.setFont(new Font("Verdana", Font.PLAIN, 23));
		lblTitulo.setBounds(211, 56, 394, 31);
		panelTopo.add(lblTitulo);

		JButton btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setToolTipText("Sair");
		btnSair.setIcon(new ImageIcon(MenuInicial.class.getResource("/Imagens/Bot\u00E3oSair.png")));
		btnSair.setBounds(757, 56, 31, 31);
		btnSair.setFocusPainted(false);
		btnSair.setContentAreaFilled(false);
		btnSair.setCursor(cursorMao);
		btnSair.setBorderPainted(false);
		panelTopo.add(btnSair);

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
		lblBarraLateral.setIcon(new ImageIcon(MenuInicial.class.getResource("/Imagens/Controle.png")));
		lblBarraLateral.setBounds(0, 0, 120, 345);
		panelBarraLateral.add(lblBarraLateral);

		JSeparator separatorVac = new JSeparator();
		separatorVac.setBounds(76, 161, 120, 10);
		separatorVac.setForeground(new Color(54, 191, 191));
		separatorVac.setBackground(new Color(54, 191, 191));
		contentPane.add(separatorVac);

		// Menus e Botões

		// Cadastrar Vacina
		JPanel panelMenu1 = new JPanel();
		panelMenu1.setBounds(307, 166, 120, 120);
		contentPane.add(panelMenu1);
		panelMenu1.setLayout(null);

		JButton btnCadastroVac = new JButton("");
		btnCadastroVac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroVacina cadastroVacina = new CadastroVacina();
				cadastroVacina.setTitle("Controle de Vacinação - Cadastro de Vacinas");
				cadastroVacina.setResizable(false);
				cadastroVacina.setVisible(true);
				cadastroVacina.setLocationRelativeTo(null);
				cadastroVacina.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		btnCadastroVac.setIcon(new ImageIcon(MenuInicial.class.getResource("/Imagens/MenuCadastroVac.png")));
		btnCadastroVac.setBounds(0, 0, 120, 120);
		btnCadastroVac.setFocusPainted(false);
		btnCadastroVac.setCursor(cursorMao);
		btnCadastroVac.setBorder(null);
		panelMenu1.add(btnCadastroVac);

		// Cadastrar Cidadão
		JPanel panelMenu3 = new JPanel();
		panelMenu3.setBounds(452, 166, 120, 120);
		contentPane.add(panelMenu3);
		panelMenu3.setLayout(null);

		JButton btnCadastroCid = new JButton("");
		btnCadastroCid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroCidadao cadastroCidadao = new CadastroCidadao();
				cadastroCidadao.setTitle("Controle de Vacinação - Cadastro de Cidadãos");
				cadastroCidadao.setResizable(false);
				cadastroCidadao.setVisible(true);
				cadastroCidadao.setLocationRelativeTo(null);
				cadastroCidadao.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		btnCadastroCid.setIcon(new ImageIcon(MenuInicial.class.getResource("/Imagens/MenuCadastroCid.png")));
		btnCadastroCid.setBounds(0, 0, 120, 120);
		btnCadastroCid.setFocusPainted(false);
		btnCadastroCid.setCursor(cursorMao);
		btnCadastroCid.setBorder(null);
		panelMenu3.add(btnCadastroCid);

		// Cadastrar Carteiras
		JPanel panelMenu5 = new JPanel();
		panelMenu5.setBounds(597, 166, 120, 120);
		contentPane.add(panelMenu5);
		panelMenu5.setLayout(null);

		JButton btnCadastroCart = new JButton("");
		btnCadastroCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroCarteira cadastroCarteira = new CadastroCarteira();
				cadastroCarteira.setTitle("Controle de Vacinação - Cadastro de Carteiras");
				cadastroCarteira.setResizable(false);
				cadastroCarteira.setVisible(true);
				cadastroCarteira.setLocationRelativeTo(null);
				cadastroCarteira.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		btnCadastroCart.setIcon(new ImageIcon(MenuInicial.class.getResource("/Imagens/MenuCadastroCart.png")));
		btnCadastroCart.setBounds(0, 0, 120, 120);
		btnCadastroCart.setFocusPainted(false);
		btnCadastroCart.setCursor(cursorMao);
		btnCadastroCart.setBorder(null);
		panelMenu5.add(btnCadastroCart);

		// Consultar Vacinas
		JPanel panelMenu2 = new JPanel();
		panelMenu2.setBounds(307, 299, 120, 120);
		contentPane.add(panelMenu2);
		panelMenu2.setLayout(null);

		JButton btnConsultaVac = new JButton("");
		btnConsultaVac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaVacina consultaVacina = new ConsultaVacina();
				consultaVacina.setTitle("Controle de Vacinação - Consulta de Vacinas");
				consultaVacina.setResizable(false);
				consultaVacina.setVisible(true);
				consultaVacina.setLocationRelativeTo(null);
				consultaVacina.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		btnConsultaVac.setIcon(new ImageIcon(MenuInicial.class.getResource("/Imagens/MenuConsultaVac.png")));
		btnConsultaVac.setBounds(0, 0, 120, 120);
		btnConsultaVac.setFocusPainted(false);
		btnConsultaVac.setCursor(cursorMao);
		btnConsultaVac.setBorder(null);
		panelMenu2.add(btnConsultaVac);

		// Consultar Cidadãos
		JPanel panelMenu4 = new JPanel();
		panelMenu4.setBounds(452, 299, 120, 120);
		contentPane.add(panelMenu4);
		panelMenu4.setLayout(null);

		JButton btnConsultaCid = new JButton("");
		btnConsultaCid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaCidadao consultaCidadao = new ConsultaCidadao();
				consultaCidadao.setTitle("Controle de Vacinação - Consulta de Cidadãos");
				consultaCidadao.setResizable(false);
				consultaCidadao.setVisible(true);
				consultaCidadao.setLocationRelativeTo(null);
				consultaCidadao.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		btnConsultaCid.setIcon(new ImageIcon(MenuInicial.class.getResource("/Imagens/MenuConsultaCid.png")));
		btnConsultaCid.setBounds(0, 0, 120, 120);
		btnConsultaCid.setFocusPainted(false);
		btnConsultaCid.setCursor(cursorMao);
		btnConsultaCid.setBorder(null);
		panelMenu4.add(btnConsultaCid);

		// Consultar Carteiras
		JPanel panelMenu6 = new JPanel();
		panelMenu6.setBounds(597, 299, 120, 120);
		contentPane.add(panelMenu6);
		panelMenu6.setLayout(null);

		JButton btnConsultaCart = new JButton("");
		btnConsultaCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaCarteira consultaCarteira = new ConsultaCarteira();
				consultaCarteira.setTitle("Controle de Vacinação - Consulta de Carteiras");
				consultaCarteira.setResizable(false);
				consultaCarteira.setVisible(true);
				consultaCarteira.setLocationRelativeTo(null);
				consultaCarteira.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		btnConsultaCart.setIcon(new ImageIcon(MenuInicial.class.getResource("/Imagens/MenuConsultaCart.png")));
		btnConsultaCart.setBounds(0, 0, 120, 120);
		btnConsultaCart.setFocusPainted(false);
		btnConsultaCart.setCursor(cursorMao);
		btnConsultaCart.setBorder(null);
		panelMenu6.add(btnConsultaCart);

		// Relatórios
		JButton btnRelatorios = new JButton("RELAT\u00D3RIOS");
		btnRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelatorioTela relatorio = new RelatorioTela();
				relatorio.setTitle("Controle de Vacinação - Relatórios");
				relatorio.setResizable(false);
				relatorio.setVisible(true);
				relatorio.setLocationRelativeTo(null);
				relatorio.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		btnRelatorios.setBounds(307, 430, 410, 32);
		btnRelatorios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRelatorios.setForeground(Color.WHITE);
		btnRelatorios.setBorder(null);
		btnRelatorios.setBackground(new Color(54, 191, 191));
		btnRelatorios.setFocusPainted(false);
		btnRelatorios.setCursor(cursorMao);
		contentPane.add(btnRelatorios);

		// Rodapé
		JLabel lblCopyright = new JLabel("Controle de Vacina\u00E7\u00E3o - USJT \u00A9 2021");
		lblCopyright.setForeground(Color.GRAY);
		lblCopyright.setHorizontalAlignment(SwingConstants.CENTER);
		lblCopyright.setBounds(307, 486, 410, 14);
		contentPane.add(lblCopyright);

	}
}