
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
            
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
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
            
            System.out.println("Erro ao listar: " + e.getMessage());
            
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
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
        
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
    
    public int contarPublicadores(int numeroGrupo) {

        int quantidade = 0;

        String sql = "SELECT COUNT(*) FROM publicador WHERE numero_grupo = ?";

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, numeroGrupo);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    quantidade = rs.getInt(1);
                }
            }

        } catch (Exception e) {
            System.out.println("Erro ao contar publicadores: " + e.getMessage());
        }

        return quantidade;
    }
    
    public void removerPublicadorDoGrupo(int numeroGrupo, int publicadorId) {

        try (Connection conn = new Conexao().getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                 "DELETE FROM grupo_publicador WHERE numero_grupo = ? AND publicador_id = ?")) {

            stmt.setInt(1, numeroGrupo);
            stmt.setInt(2, publicadorId);

            stmt.execute();

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
