package Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class Cidadao {

	private int idCid;
	private String nomeCid;
	private String cpfCid;
	private LocalDate dtNascCid;
	private String telCid;
	private String celCid;
	private String emailCid;
	private String enderecoCid;
	private String numCid;
	private String cepCid;
	private String bairroCid;
	private String cidCid;
	private String ufCid;

	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public int getIdCid() {
		return idCid;
	}

	public void setIdCid(int idCid) {
		this.idCid = idCid;
	}

	public String getNomeCid() {
		return nomeCid;
	}

	public void setNomeCid(String nomeCid) {
		this.nomeCid = nomeCid;
	}

	public String getCpfCid() {
		return cpfCid;
	}

	public void setCpfCid(String cpfCid) {
		this.cpfCid = cpfCid;
	}

	public LocalDate getDtNascCid() {
		return dtNascCid;
	}

	/**
	 * retorna a data formatada “dd/MM/yyyy”
	 * 
	 * @return String
	 */

	public String getDtNascCidFormatado() {
		if (dtNascCid != null) {
			return formato.format(dtNascCid);
		} else {
			return "";
		}
	}

	// passando como parâmetro uma data no formato string “dd/mm/yyyy”
	public void setDtNascCid(String d) {
		dtNascCid = LocalDate.parse(d, formato);
	}

	// passando como parâmetro uma data vinda do banco de dados.
	public LocalDate setDtNascCid(java.sql.Date d) {
		return dtNascCid = d.toLocalDate();
	}

	public String getTelCid() {
		return telCid;
	}

	public void setTelCid(String telCid) {
		this.telCid = telCid;
	}

	public String getCelCid() {
		return celCid;
	}

	public void setCelCid(String celCid) {
		this.celCid = celCid;
	}

	public String getEmailCid() {
		return emailCid;
	}

	public void setEmailCid(String emailCid) {
		this.emailCid = emailCid;
	}
	
	public String getCepCid() {
		return cepCid;
	}

	public void setCepCid(String cepCid) {
		this.cepCid = cepCid;
	}

	public String getEnderecoCid() {
		return enderecoCid;
	}

	public void setEnderecoCid(String enderecoCid) {
		this.enderecoCid = enderecoCid;
	}

	public String getNumCid() {
		return numCid;
	}

	public void setNumCid(String numCid) {
		this.numCid = numCid;
	}

	public String getBairroCid() {
		return bairroCid;
	}

	public void setBairroCid(String bairroCid) {
		this.bairroCid = bairroCid;
	}

	public String getCidCid() {
		return cidCid;
	}

	public void setCidCid(String cidadeCid) {
		this.cidCid = cidadeCid;
	}

	public String getUfCid() {
		return ufCid;
	}

	public void setUfCid(String ufCid) {
		this.ufCid = ufCid;
	}

	// INSERIR
	public void inserir() {
		// 1: Definir o comando SQL
		String sql = "INSERT INTO tb_cidadao(nomeCid, cpfCid, dtNascCid, telCid, celCid, emailCid, enderecoCid, numCid, cepCid, ufCid, cidCid, bairroCid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setString(1, nomeCid);
			ps.setString(2, cpfCid);
			ps.setDate(3, java.sql.Date.valueOf(dtNascCid));
			ps.setString(4, telCid);
			ps.setString(5, celCid);
			ps.setString(6, emailCid);
			ps.setString(7, enderecoCid);
			ps.setString(8, numCid);
			ps.setString(9, cepCid);
			ps.setString(10, ufCid);
			ps.setString(11, cidCid);
			ps.setString(12, bairroCid);
			// 5: Executa o comando
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// CONSULTAR
	public void consultar() { // findById()
		// 1: Definir o comando SQL
		String sql = "SELECT * FROM tb_cidadao where cpfCid = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, cpfCid);
			// 4: Executa o comando e guarda
			// o resultado em um ResultSet
			ResultSet rs = ps.executeQuery();
			// 5: itera sobre o resultado
			if (rs.next()) {
				nomeCid = rs.getString("nomeCid");
				dtNascCid = setDtNascCid(rs.getDate("dtNascCid"));
				idCid = rs.getInt("idCid");
				telCid = rs.getString("telCid");
				celCid = rs.getString("celCid");
				emailCid = rs.getString("emailCid");
				enderecoCid = rs.getString("enderecoCid");
				numCid = rs.getString("numCid");
				cepCid = rs.getString("cepCid");
				ufCid = rs.getString("ufCid");
				cidCid = rs.getString("cidCid");
				bairroCid = rs.getString("bairroCid");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ALTERAR
	public void alterar() {
		// 1: Definir o comando SQL
		String sql = "UPDATE tb_cidadao SET idCid = ?, nomeCid = ?, dtNascCid = ?, telCid = ?, celCid = ?, emailCid = ?, enderecoCid = ?, numCid = ?, cepCid = ?, ufCid = ?, cidCid = ?, bairroCid = ? WHERE cpfCid = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setInt(1, idCid);
			ps.setString(2, nomeCid);
			ps.setDate(3, java.sql.Date.valueOf(dtNascCid));
			ps.setString(4, telCid);
			ps.setString(5, celCid);
			ps.setString(6, emailCid);
			ps.setString(7, enderecoCid);
			ps.setString(8, numCid);
			ps.setString(9, cepCid);
			ps.setString(10, ufCid);
			ps.setString(11, cidCid);
			ps.setString(12, bairroCid);
			ps.setString(13, cpfCid);
			// 5: Executa o comando
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// EXCLUIR
	public void apagar() {
		// 1: Definir o comando SQL
		String sql = "DELETE FROM tb_cidadao WHERE cpfCid = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setString(1, cpfCid);
			// 5: Executa o comando
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean checkDate(String data) {
		int dia = Integer.parseInt(data.substring(0,2));
		int mes = Integer.parseInt(data.substring(3,5));
		int ano = Integer.parseInt(data.substring(6, 10));
		boolean a;

		if (dia >= 1 && dia <= 31) {
			if(mes >= 1 && mes <= 12) {
				if (ano >= 1900) {
					setDtNascCid(data);
				}
				else {
					JOptionPane.showMessageDialog(null, "Data de nascimento inválida!", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					return a = false;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Data de nascimento inválida!", "Atenção",
						JOptionPane.WARNING_MESSAGE);
				return a = false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Data de nascimento inválida!", "Atenção",
					JOptionPane.WARNING_MESSAGE);
			return a = false;
		}
		return a = true;
	}
}