package Janelas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Conexao.Relatorio;
import Conexao.Vacina;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class BuscaVacina extends JFrame {

	private JPanel contentPane;
	public static JTable tbVacinas;
	private JTextField nomeVacField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscaVacina frame = new BuscaVacina();
					frame.setResizable(false);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Controle de Vacinação - Busca de Vacinas");
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				Vacina v = new Vacina();
				DefaultTableModel modelo = (DefaultTableModel) tbVacinas.getModel();
				v.buscarVacinas(modelo);
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BuscaVacina() {	
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConsultaVacina.class.getResource("/Imagens/Icone.png")));
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

		JLabel lblTitulo = new JLabel("Busca de Vacinas");
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
		lblBarraLateral.setIcon(new ImageIcon(CadastroVacina.class.getResource("/Imagens/Vacina.png")));
		lblBarraLateral.setBounds(0, 0, 120, 345);
		panelBarraLateral.add(lblBarraLateral);

		JSeparator separatorVac = new JSeparator();
		separatorVac.setBounds(76, 161, 120, 10);
		separatorVac.setForeground(new Color(54, 191, 191));
		separatorVac.setBackground(new Color(54, 191, 191));
		contentPane.add(separatorVac);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(242, 202, 557, 242);
		contentPane.add(scrollPane);
		
		JLabel lblNomeVac = new JLabel("Buscar");
		lblNomeVac.setBounds(242, 122, 302, 14);
		lblNomeVac.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblNomeVac);

		nomeVacField = new JTextField();
		nomeVacField.setBounds(242, 147, 302, 32);
		nomeVacField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				String nomeVac = nomeVacField.getText();
				Vacina v = new Vacina();
				DefaultTableModel modelo = (DefaultTableModel) tbVacinas.getModel();
                if (nomeVacField.getText().isBlank()) {
                	v.buscarVacinas(modelo);
                } else {
    				v.setNomeVac(nomeVac);
                    v.buscarVacinas(modelo);
                    v.buscarVacinasPorDados(modelo);
                }
                
				if (nomeVacField.getText().length() >= 45) {
					e.consume();
				}
			}
		});
		contentPane.add(nomeVacField);
		nomeVacField.setColumns(10);

		tbVacinas = new JTable();
		tbVacinas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbVacinas.setModel(new DefaultTableModel(new Object[][] { { null, null, null}, },
				new String[] { "Identificação", "Nome", "Fabricante"}) {
			boolean[] columnEditables = new boolean[] { false, false, false};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tbVacinas);
		
		JButton btnVoltarVac = new JButton("VOLTAR");
		btnVoltarVac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaVacina ConsultaVacina = new ConsultaVacina();
				ConsultaVacina.setTitle("Controle de Vacinação - Consulta de Vacinas");
				ConsultaVacina.setResizable(false);
				ConsultaVacina.setVisible(true);
				ConsultaVacina.setLocationRelativeTo(null);
				ConsultaVacina.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		btnVoltarVac.setForeground(Color.WHITE);
		btnVoltarVac.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltarVac.setFocusPainted(false);
		btnVoltarVac.setBorder(null);
		btnVoltarVac.setBackground(new Color(54, 191, 191));
		btnVoltarVac.setBounds(669, 455, 130, 32);
		contentPane.add(btnVoltarVac);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomeVacField.setText(null);
				Vacina v = new Vacina();
				DefaultTableModel modelo = (DefaultTableModel) tbVacinas.getModel();
				v.buscarVacinas(modelo);
				JOptionPane.showMessageDialog(null, "Tabela limpa!",
						"Atenção", JOptionPane.WARNING_MESSAGE);
				modelo.setNumRows(1);
				v.buscarVacinas(modelo);
				nomeVacField.requestFocus();
			}
		});
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setFocusPainted(false);
		btnLimpar.setBorder(null);
		btnLimpar.setBackground(new Color(54, 191, 191));
		btnLimpar.setBounds(515, 455, 130, 32);
		contentPane.add(btnLimpar);
		
		JButton btnSelecionar = new JButton("SELECIONAR");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vacina v = new Vacina();
				DefaultTableModel modelo = (DefaultTableModel) tbVacinas.getModel();
				if (tbVacinas.getSelectionModel().isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione uma Vacina!",
							"Atenção", JOptionPane.WARNING_MESSAGE);
					nomeVacField.setText(null);
					nomeVacField.requestFocus();
					v.buscarVacinas(modelo);
				} else {
					int linha = tbVacinas.getSelectedRow();
					String identificacaoVac = (tbVacinas.getValueAt(linha, 0)).toString();
					String nomeVac = (tbVacinas.getValueAt(linha, 1)).toString();
					String fabricanteVac = (tbVacinas.getValueAt(linha, 2)).toString();
					v.setIdentificacaoVac(identificacaoVac);
					v.setNomeVac(nomeVac);
					v.setFabricanteVac(fabricanteVac);
					v.consultar();
					
					ConsultaVacina ConsultaVacina = new ConsultaVacina(v);
					ConsultaVacina.setTitle("Controle de Vacinação - Consulta de Vacinas");
					ConsultaVacina.setResizable(false);
					ConsultaVacina.setVisible(true);
					ConsultaVacina.setLocationRelativeTo(null);
					ConsultaVacina.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					
					/*ConsultaVacina.idVacField.setText(v.getIdentificacaoVac());
					ConsultaVacina.nomeVacField.setText(v.getNomeVac());
					ConsultaVacina.nomeVacField.setEnabled(true);
					ConsultaVacina.fabricanteVacField.setText(v.getFabricanteVac());
					ConsultaVacina.fabricanteVacField.setEnabled(true);
					ConsultaVacina.qtdDosesField.setText(Integer.toString(v.getQtdDoses()));
					ConsultaVacina.qtdDosesField.setEnabled(true);
					ConsultaVacina.intervDiasField.setText(Integer.toString(v.getIntervDias()));
					ConsultaVacina.intervDiasField.setEnabled(true);*/
					
					dispose();
				}
			}
		});
		btnSelecionar.setForeground(Color.WHITE);
		btnSelecionar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSelecionar.setFocusPainted(false);
		btnSelecionar.setBorder(null);
		btnSelecionar.setBackground(new Color(54, 191, 191));
		btnSelecionar.setBounds(568, 147, 130, 30);
		contentPane.add(btnSelecionar);
	}
}
