package Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class Carteira {

	private String cpfCid;
	private String nomeCid;
	private String telCid;
	private String emailCid;
	private String nomeVac;
	private String identificacaoVac;
	private int idVac;
	private int idCart;
	private int qtdDoses;
	private int intervDias;
	private LocalDate dt1Dose;
	private LocalDate dt2Dose;

	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public int getQtdDoses() {
		return qtdDoses;
	}

	public void setQtdDoses(int qtdDoses) {
		this.qtdDoses = qtdDoses;
	}
	
	public int getIntervDias() {
		return intervDias;
	}
	
	public String getIdentificacaoVac() {
		return identificacaoVac;
	}

	public void setIdentificacaoVac(String identificacaoVac) {
		this.identificacaoVac = identificacaoVac;
	}

	public String getCpfCid() {
		return cpfCid;
	}

	public void setCpfCid(String cpfCid) {
		this.cpfCid = cpfCid;
	}

	public int getIdVac() {
		return idVac;
	}

	public void setIdVac(int idVac) {
		this.idVac = idVac;
	}

	public int getIdCart() {
		return idCart;
	}

	public void setIdCart(int idCart) {
		this.idCart = idCart;
	}

	public LocalDate getDt1Dose() {
		return dt1Dose;
	}

	/**
	 * retorna a data formatada “dd/MM/yyyy”
	 * 
	 * @return String
	 */

	public String getDt1DoseFormatado() {
		if (dt1Dose != null) {
			return formato.format(dt1Dose);
		} else {
			return "";
		}
	}

	// passando como parâmetro uma data no formato string “dd/mm/yyyy”
	public void setDt1Dose(String d) {
		dt1Dose = LocalDate.parse(d, formato);
	}

	// passando como parâmetro uma data vinda do banco de dados.
	public LocalDate setDt1Dose(java.sql.Date d) {
		return dt1Dose = d.toLocalDate();
	}

	public LocalDate getDt2Dose() {
		return dt2Dose;
	}

	/**
	 * retorna a data formatada “dd/MM/yyyy”
	 * 
	 * @return String
	 */

	public String getDt2DoseFormatado() {
		if (dt2Dose != null) {
			return formato.format(dt2Dose);
		} else {
			return "";
		}
	}

	// passando como parâmetro uma data no formato string “dd/mm/yyyy”
	public void setDt2Dose(String d) {
		if (d != null && !"".equals(d)) {
			dt2Dose = LocalDate.parse(d, formato);
		}
	}

	// passando como parâmetro uma data vinda do banco de dados.
	public LocalDate setDt2Dose(java.sql.Date d) {
		return dt2Dose = d.toLocalDate();
	}

	public String getNomeVac() {
		return nomeVac;
	}

	public void setNomeVac(String nomeVac) {
		this.nomeVac = nomeVac;
	}

	public String getNomeCid() {
		return nomeCid;
	}

	public void setNomeCid(String nomeCid) {
		this.nomeCid = nomeCid;
	}

	public String getTelCid() {
		return telCid;
	}

	public void setTelCid(String telCid) {
		this.telCid = telCid;
	}

	public String getEmailCid() {
		return emailCid;
	}

	public void setEmailCid(String emailCid) {
		this.emailCid = emailCid;
	}

	// INSERIR
	public void inserir() {
		// 1: Definir o comando SQL
		String sql = "INSERT INTO tb_carteira(cpfCid, identificacaoVac, data_1dose, data_2dose) VALUES (?, ?, ?, ?);";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setString(1, cpfCid);
			ps.setString(2, identificacaoVac);
			ps.setDate(3, java.sql.Date.valueOf(dt1Dose));
			if (dt2Dose == null) {
				ps.setDate(4, null);
			} else {
				ps.setDate(4, java.sql.Date.valueOf(dt2Dose));
			}
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
				telCid = rs.getString("telCid");
				emailCid = rs.getString("emailCid");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// CONSULTAR
	public void consultarVac() { // findById()
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
				qtdDoses = rs.getInt("qtdDoses");
				intervDias = rs.getInt("intervDias");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// CONSULTAR
	public void consultarCart() { // findById()
		// 1: Definir o comando SQL
		String sql = "SELECT * FROM tb_carteira where cpfCid = ?";
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
				dt1Dose = setDt1Dose(rs.getDate("data_1dose"));
				if (rs.getObject("data_2dose") != null) {
					dt2Dose = setDt2Dose(rs.getDate("data_2dose"));
				}
				identificacaoVac = rs.getString("identificacaoVac");
				idCart = rs.getInt("idCarteira");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ALTERAR
	public void alterar() {
		// 1: Definir o comando SQL
		String sql = "UPDATE tb_carteira SET idCarteira = ?, data_2dose = ?  WHERE cpfCid = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setInt(1, idCart);
			ps.setDate(2, java.sql.Date.valueOf(dt2Dose));
			ps.setString(3, cpfCid);
			// 5: Executa o comando
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// EXCLUIR
	public void apagar() {
		// 1: Definir o comando SQL
		String sql = "DELETE FROM tb_carteira WHERE cpfCid = ?";
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

	// PREVISAO
	public void getPrevisao() {
		// 1: Definir o comando SQL
		String sql = "select tb_cidadao.nomeCid, tb_carteira.data_1dose + interval intervDias day as data_2dose\r\n"
				+ "from tb_carteira, tb_vacina, tb_cidadao\r\n" + "where tb_carteira.identificacaoVac = ?\r\n"
				+ "and tb_vacina.identificacaoVac = ?\r\n" + "and tb_cidadao.cpfCid = ?\r\n"
				+ "and tb_carteira.cpfCid = ?;";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c1 = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c1.prepareStatement(sql);
			ps.setString(1, identificacaoVac);
			ps.setString(2, identificacaoVac);
			ps.setString(3, cpfCid);
			ps.setString(4, cpfCid);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dt2Dose = setDt2Dose(rs.getDate("data_2Dose"));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public boolean checkDt1Dose(String data) {
		int dia = Integer.parseInt(data.substring(0,2));
		int mes = Integer.parseInt(data.substring(3,5));
		int ano = Integer.parseInt(data.substring(6, 10));
		boolean a;

		if (dia >= 1 && dia <= 31) {
			if(mes >= 1 && mes <= 12) {
				if (ano >= 1900) {
					setDt1Dose(data);
				} else {
					JOptionPane.showMessageDialog(null, "Data 1ª Dose inválida!", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					return a = false;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Data 1ª Dose inválida!", "Atenção",
						JOptionPane.WARNING_MESSAGE);
				return a = false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Data 1ª Dose inválida!", "Atenção",
					JOptionPane.WARNING_MESSAGE);
			return a = false;
		}
		return a = true;
	}
	
	public boolean checkDt2Dose(String data) {
		int dia = Integer.parseInt(data.substring(0,2));
		int mes = Integer.parseInt(data.substring(3,5));
		int ano = Integer.parseInt(data.substring(6, 10));
		boolean a;
	    getPrevisao();
		
		int diaPrevisao = Integer.parseInt(getDt2DoseFormatado().substring(0,2));
		int mesPrevisao = Integer.parseInt(getDt2DoseFormatado().substring(3,5));
		int anoPrevisao = Integer.parseInt(getDt2DoseFormatado().substring(6, 10));
		
		if (ano == anoPrevisao) {
			if(mes == mesPrevisao && mes <= 12) {
				if (dia >= diaPrevisao && dia <= 31) {
					setDt2Dose(data);
				} else {
					JOptionPane.showMessageDialog(null, "Data 2ª Dose inválida!", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					return a = false;
				}
			} else if (mes > mesPrevisao) {
				if (dia <= 31) {
					setDt2Dose(data);
				} else {
					JOptionPane.showMessageDialog(null, "Data 2ª Dose inválida!", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					return a = false;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Data 2ª Dose inválida!", "Atenção",
						JOptionPane.WARNING_MESSAGE);
				return a = false;
			}
		} else if (ano > anoPrevisao ) {
			if (mes <= 12) {
				if (dia <= 31) {
					setDt2Dose(data);
				} else {
					JOptionPane.showMessageDialog(null, "Data 2ª Dose inválida!", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					return a = false;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Data 2ª Dose inválida!", "Atenção",
						JOptionPane.WARNING_MESSAGE);
				return a = false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Data 2ª Dose inválida!", "Atenção",
					JOptionPane.WARNING_MESSAGE);
			return a = false;
		}
		return a = true;
	}
}