
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Publicador;

/**
 *
 * @author conta
 */
public class PublicadorDAO {
    
    private Conexao conexao = new Conexao();
    
    public void salvar(Publicador p) {

        String sql = "INSERT INTO publicador (nome, modalidade, ativo, numero_grupo) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = new Conexao().getConnection();
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getModalidade());
            stmt.setString(3, p.getAtivo());
            stmt.setInt(4, p.getNumeroDoGrupo());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao salvar publicador: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
    
    public List<Publicador> listarPorGrupo(int numeroGrupo) {

        List<Publicador> lista = new ArrayList<>();

        String sql = "SELECT * FROM publicador WHERE numero_grupo = ?";

        try (Connection conn = new Conexao().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, numeroGrupo);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Publicador p = new Publicador();

                p.setNome(rs.getString("nome"));
                p.setModalidade(rs.getString("modalidade"));
                p.setAtivo(rs.getString("ativo"));
                p.setNumeroDoGrupo(rs.getInt("numero_grupo"));

                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar publicadores: " + e.getMessage());
        }

        return lista;
    }
    
    public void excuir(String nome, int numeroGrupo) {

        String sql = "DELETE FROM publicador WHERE nome = ? AND numero_grupo = ?";

        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = new Conexao().getConnection();
            stmt = con.prepareStatement(sql);

            stmt.setString(1, nome);
            stmt.setInt(2, numeroGrupo);

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao remover publicador: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
    
    public List<Publicador> buscarPorNomeEGrupo(String nome, int numeroGrupo) {

        List<Publicador> lista = new ArrayList<>();

        String sql = "SELECT * FROM publicador WHERE LOWER(nome) LIKE ? AND numero_grupo = ?";

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = new Conexao().getConnection();
            stmt = con.prepareStatement(sql);

            stmt.setString(1, "%" + nome + "%");
            stmt.setInt(2, numeroGrupo);

            rs = stmt.executeQuery();

            while (rs.next()) {
                Publicador p = new Publicador();
                p.setNome(rs.getString("nome"));
                p.setModalidade(rs.getString("modalidade"));
                p.setAtivo(rs.getString("ativo"));

                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar publicador: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }

        return lista;
    }
    
    public int contarPublicadores(int numeroGrupo) {
        
        int quantidade = 0;
        
        try {
            String sql = "SELECT COUNT(*) FROM grupo_publicador WHERE numero_grupo = ?";
            Connection conn = conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, numeroGrupo);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                quantidade = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        
        return quantidade;
    }
}
