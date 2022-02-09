package Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

public class Vacina {

	private int idVac;
	private String identificacaoVac;
	private String nomeVac;
	private String fabricanteVac;
	private int qtdDoses;
	private int intervDias;
	
	public int getIdVac() {
		return idVac;
	}

	public void setIdVac(int idVac) {
		this.idVac = idVac;
	}

	public String getIdentificacaoVac() {
		return identificacaoVac;
	}

	public void setIdentificacaoVac(String identificacaoVac) {
		this.identificacaoVac = identificacaoVac;
	}

	public String getNomeVac() {
		return nomeVac;
	}

	public void setNomeVac(String nomeVac) {
		this.nomeVac = nomeVac;
	}

	public String getFabricanteVac() {
		return fabricanteVac;
	}

	public void setFabricanteVac(String fabricanteVac) {
		this.fabricanteVac = fabricanteVac;
	}

	public int getQtdDoses() {
		return qtdDoses;
	}

	public void setQtdDoses(int qtdDoses) {
		this.qtdDoses = qtdDoses;
	}

	public int getIntervDias() {
		return intervDias;
	}

	public void setIntervDias(int intervDias) {
		this.intervDias = intervDias;
	}

	// INSERIR
	public void inserir() {
		// 1: Definir o comando SQL
		String sql = "INSERT INTO tb_vacina(idVac, identificacaoVac, nomeVac, fabricanteVac, qtdDoses, intervDias) VALUES (?, ?, ?, ?, ?, ?);";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setInt(1, idVac);
			ps.setString(2, identificacaoVac);
			ps.setString(3, nomeVac);
			ps.setString(4, fabricanteVac);
			ps.setInt(5, qtdDoses);
			ps.setInt(6, intervDias);
			// 5: Executa o comando
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// CONSULTAR
	public void consultar() { // findById()
		// 1: Definir o comando SQL
		String sql = "SELECT * FROM tb_vacina where identificacaoVac = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, identificacaoVac);
			// 4: Executa o comando e guarda
			// o resultado em um ResultSet
			ResultSet rs = ps.executeQuery();
			// 5: itera sobre o resultado
			if (rs.next()) {
				nomeVac = rs.getString("nomeVac");
				fabricanteVac = rs.getString("fabricanteVac");
				qtdDoses = rs.getInt("qtdDoses");
				intervDias = rs.getInt("intervDias");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ALTERAR
	public void alterar() {
		// 1: Definir o comando SQL
		String sql = "UPDATE tb_vacina SET nomeVac = ?, fabricanteVac = ?, qtdDoses = ?, intervDias = ? WHERE identificacaoVac = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setString(1, nomeVac);
			ps.setString(2, fabricanteVac);
			ps.setInt(3, qtdDoses);
			ps.setInt(4, intervDias);
			ps.setString(5, identificacaoVac);
			// 5: Executa o comando
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// EXCLUIR
	public void apagar() {
		// 1: Definir o comando SQL
		String sql = "DELETE FROM tb_vacina WHERE identificacaoVac = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setString(1, identificacaoVac);
			// 5: Executa o comando
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void buscarVacinas(DefaultTableModel modelo) {
		String sql = "select * from tb_vacina";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			modelo.setNumRows(0);
			// 4: Executa o comando e guarda
			// o resultado em um ResultSet
			ResultSet rs = ps.executeQuery();
			// 5: itera sobre o resultado
			while (rs.next()) {
				modelo.addRow(new Object[] { rs.getString("identificacaoVac"),rs.getString("nomeVac"), rs.getString("fabricanteVac")});
			}
			rs.close();
			ps.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void buscarVacinasPorDados(DefaultTableModel modelo) {
		String sql = "select * from tb_vacina\r\n"
				+ "where identificacaoVac like ?\r\n"
				+ "or nomeVac like ?\r\n"
				+ "or fabricanteVac like ?;";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, "%" + nomeVac + "%");
			ps.setString(2, "%" + nomeVac + "%");
			ps.setString(3, "%" + nomeVac + "%");
			modelo.setNumRows(0);
			// 4: Executa o comando e guarda
			// o resultado em um ResultSet
			ResultSet rs = ps.executeQuery();
			// 5: itera sobre o resultado
			while (rs.next()) {
				modelo.addRow(new Object[] { rs.getString("identificacaoVac"),rs.getString("nomeVac"), rs.getString("fabricanteVac")});
			}
			rs.close();
			ps.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}