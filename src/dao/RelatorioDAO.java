
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import dao.Conexao;

/**
 *
 * @author conta
 */
public class RelatorioDAO {
    
    private Conexao conexao = new Conexao();
    
    public void salvar(int publicadorId, String participou, String modalidade, int horas, int estudos) {

        Connection conn = conexao.getConnection();

        try {
            String sql = "INSERT INTO relatorio (publicador_id, participou, modalidade, horas, estudos) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, publicadorId);
            stmt.setString(2, participou);
            stmt.setString(3, modalidade);
            stmt.setInt(4, horas);
            stmt.setInt(5, estudos);

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro ao salvar relatório: " + e.getMessage());
        }
    }

}
