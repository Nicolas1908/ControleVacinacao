package Janelas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Conexao.ConnectionFactory;
import Conexao.Relatorio;

public class RelatorioTela extends JFrame {

	private JPanel contentPane;
	private JTable tbRelatorio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioTela frame = new RelatorioTela();
					frame.setResizable(false);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Controle de Vacinação - Relatórios");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RelatorioTela() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RelatorioTela.class.getResource("/Imagens/Icone.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);

		// Mouse (Mão)
		Cursor cursorMao = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		// Imagem (cabeçalho)
		JPanel panelImagem = new JPanel();
		panelImagem.setBounds(76, 38, 120, 120);
		contentPane.add(panelImagem);
		panelImagem.setLayout(null);

		JLabel lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon(RelatorioTela.class.getResource("/Imagens/MenuRelatorio.png")));
		lblImagem.setBounds(0, 0, 120, 120);
		panelImagem.add(lblImagem);

		// (Panel) Topo da Tela
		JPanel panelTopo = new JPanel();
		panelTopo.setBounds(0, 0, 834, 98);
		panelTopo.setBackground(new Color(31, 146, 191));
		contentPane.add(panelTopo);
		panelTopo.setLayout(null);

		JLabel lblTitulo = new JLabel("Relat\u00F3rio - 2\u00AA Dose");
		lblTitulo.setForeground(SystemColor.text);
		lblTitulo.setFont(new Font("Verdana", Font.PLAIN, 23));
		lblTitulo.setBounds(211, 56, 394, 31);
		panelTopo.add(lblTitulo);

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
		lblBarraLateral.setIcon(new ImageIcon(RelatorioTela.class.getResource("/Imagens/Relatorio.png")));
		lblBarraLateral.setBounds(0, 0, 120, 345);
		panelBarraLateral.add(lblBarraLateral);

		JSeparator separatorVac = new JSeparator();
		separatorVac.setBounds(76, 161, 120, 10);
		separatorVac.setForeground(new Color(54, 191, 191));
		separatorVac.setBackground(new Color(54, 191, 191));
		contentPane.add(separatorVac);

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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(242, 166, 496, 258);
		contentPane.add(scrollPane);

		tbRelatorio = new JTable();
		tbRelatorio.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, },
				new String[] { "Nome", "Telefone", "E-mail", "Previsão 2ª Dose" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tbRelatorio);

		JButton btnNewButton = new JButton("CONSULTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio r = new Relatorio();
                DefaultTableModel modelo = (DefaultTableModel) tbRelatorio.getModel();
                r.getRelatorio(modelo);
			}
		});
		btnNewButton.setBounds(458, 448, 130, 32);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(54, 191, 191));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setCursor(cursorMao);
		contentPane.add(btnNewButton);

		JLabel lblCamposObg = new JLabel("RELA\u00C7\u00C3O DE CIDAD\u00C3OS ");
		lblCamposObg.setBounds(242, 135, 371, 14);
		contentPane.add(lblCamposObg);
		lblCamposObg.setForeground(Color.DARK_GRAY);

		JLabel lblPerodoDias = new JLabel("Per\u00EDodo: 14 dias");
		lblPerodoDias.setForeground(Color.DARK_GRAY);
		lblPerodoDias.setBounds(646, 135, 92, 14);
		contentPane.add(lblPerodoDias);
	}
}