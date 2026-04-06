
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import dao.Conexao;

/**
 *
 * @author conta
 */
public class RelatorioDAO {
    
    private Conexao conexao = new Conexao();
    
    public boolean salvar(int publicadorId, String participou, String modalidade, int horas, int estudos) {

        String sql = """
            INSERT INTO relatorio (publicador_id, participou, modalidade, horas, estudos)
            VALUES (?, ?, ?, ?, ?)
            ON DUPLICATE KEY UPDATE
                participou = VALUES(participou),
                modalidade = VALUES(modalidade),
                horas = VALUES(horas),
                estudos = VALUES(estudos)
        """;

        try (Connection conn = new Conexao().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, publicadorId);
            stmt.setString(2, participou);
            stmt.setString(3, modalidade);
            stmt.setInt(4, horas);
            stmt.setInt(5, estudos);

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /** 
     * CORAÇÃO DO SISTEMA
     * 
     */
    
    public Object[] gerarResumo() {

        String sql = """
            SELECT 
                SUM(CASE WHEN modalidade = 'Publicador' THEN 1 ELSE 0 END) AS pub_total,
                SUM(CASE WHEN modalidade = 'Publicador' AND participou = 'Sim' THEN 1 ELSE 0 END) AS pub_relataram,
                SUM(CASE WHEN modalidade = 'Publicador' THEN IFNULL(estudos,0) ELSE 0 END) AS pub_estudos,

                SUM(CASE WHEN modalidade = 'Pioneiro Auxiliar' THEN 1 ELSE 0 END) AS aux_total,
                SUM(CASE WHEN modalidade = 'Pioneiro Auxiliar' THEN IFNULL(estudos,0) ELSE 0 END) AS aux_estudos,

                SUM(CASE WHEN modalidade = 'Pioneiro Regular' THEN 1 ELSE 0 END) AS reg_total,
                SUM(CASE WHEN modalidade = 'Pioneiro Regular' THEN IFNULL(estudos,0) ELSE 0 END) AS reg_estudos,

                SUM(IFNULL(estudos,0)) AS total_estudos

            FROM relatorio
        """;

        try (Connection con = new Conexao().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return new Object[]{
                    rs.getInt("pub_total"),
                    rs.getInt("pub_relataram"),
                    rs.getInt("pub_estudos"),
                    rs.getInt("aux_total"),
                    rs.getInt("aux_estudos"),
                    rs.getInt("reg_total"),
                    rs.getInt("reg_estudos"),
                    rs.getInt("total_estudos")
                };
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Object[]{0,0,0,0,0,0,0,0};
    }
}
