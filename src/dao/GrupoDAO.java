
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import model.Grupo;

/**
 *
 * @author conta
 */
public class GrupoDAO {
    
    private Conexao conexao = new Conexao();
    
    /**
     * 
     * @param grupo 
     */
    public void salvar(Grupo grupo) {
        Connection conn = conexao.getConnection();
        
        try {
            String sql = "INSERT INTO grupo (numero_grupo) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, grupo.getNumeroGrupo());
            stmt.execute();
            
            System.out.println("Grupo salvo com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }
    
    /**
     * 
     * @return 
     */
    public List<Grupo> listar() {
        List<Grupo> lista = new ArrayList<>();
        Connection conn = conexao.getConnection();
        
        try {
            String sql = "SELECT * FROM grupo";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                Grupo g = new Grupo();
                g.setNumeroGrupo(rs.getInt("numero_grupo"));
                lista.add(g);
            }
            
        } catch (SQLException e) {
            System.out.println("eRRO AO LISTAR: " + e.getMessage());
        }
        
        return lista;
    }
    
    public void excluir(int numeroGrupo) {
        Connection conn = conexao.getConnection();
        
        try {
            String sql = "DELETE FROM grupo WHERE numero_grupo = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, numeroGrupo);
            stmt.execute();
            
            System.out.println("Grupo exluído!");
            
        } catch (SQLException e) {
            System.out.println("Erro ao excluir o grupo: " +e.getMessage());
        }
    }

}
