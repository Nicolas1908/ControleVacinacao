package Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

public class Relatorio {
	public void getRelatorio(DefaultTableModel modelo) {
		// 1: Definir o comando SQL
		String sql = "select tb_cidadao.nomeCid, tb_cidadao.telCid, tb_cidadao.celCid, tb_cidadao.emailCid, tb_vacina.intervDias, tb_carteira.data_1dose + interval intervDias day as data_2dose\r\n"
				+ "        from tb_carteira, tb_vacina, tb_cidadao\r\n"
				+ "        where tb_carteira.identificacaoVac = tb_vacina.identificacaoVac\r\n"
				+ "        and tb_carteira.data_2dose is null\r\n"
				+ "        and tb_carteira.data_1dose != tb_carteira.data_1dose + interval intervDias day\r\n"
				+ "        and tb_cidadao.cpfCid = tb_carteira.cpfCid\r\n"
				+ "        and tb_carteira.data_1dose + interval intervDias day\r\n"
				+ "        between curdate() and (curdate() + interval 14 day);";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			modelo.setNumRows(0);

			while (rs.next()) {
				if (rs.getString("celCid").isBlank() || "(  )      -    ".equals(rs.getString("celCid"))) {
				modelo.addRow(new Object[] { rs.getString("nomeCid"), rs.getString("telCid"), rs.getString("emailCid"),
						rs.getString("data_2dose") });
				} else {
					modelo.addRow(new Object[] { rs.getString("nomeCid"), rs.getString("celCid"), rs.getString("emailCid"),
							rs.getString("data_2dose") });
				}
			}
			rs.close();
			c.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}