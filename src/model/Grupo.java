
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gomes
 */
public class Grupo {
    private int numeroGrupo = 0;
    
    private static List<Publicador> listaPublicadores = new ArrayList<>();
    
    private static List<Grupo> listaGrupos = new ArrayList<>();

    public Grupo() {
    }

    public int getNumeroGrupo() {
        return numeroGrupo;
    }

    public void setNumeroGrupo(int numeroGrupo) {
        this.numeroGrupo = numeroGrupo;
    }

    public static List<Grupo> getListaGrupos() {
        return listaGrupos;
    }

    public static void setListaGrupos(List<Grupo> listaGrupos) {
        Grupo.listaGrupos = listaGrupos;
    }
    
    /**
     * Cria um novo grupo
     */
    public void criarGrupo() {
        listaGrupos.add(this);
    }
    
    /**
     * Exclui um grupo
     */
    public void excluirGrupo() {
        listaGrupos.remove(this);
    }
    
    /**
     * Adiciona um publicador ao grupo
     * @param publicador 
     */
    public void adicionarPublicador(Publicador publicador) {
        listaPublicadores.add(publicador);
    }
    
    /**
     * Removeu um publicador do grupo
     * @param publicador 
     */
    public void removerPublicador(Publicador publicador) {
        listaPublicadores.remove(publicador);
    }
    
    /**
     * Exine a lista de publicadores cadastrado no grupo
     * @return 
     */
    public static List<Publicador> listarPublicadores() {
        return listaPublicadores;
    }
    
    /**
     * Exibe os grupos cadastrados
     * @return 
     */
    public static List<Grupo> listarGrupos() {
        return listaGrupos;
    }
    
}
