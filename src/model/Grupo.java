
package model;

/**
 *
 * @author Gomes
 */
public class Grupo {
    private int numeroGrupo;

    /**
     * Construtor padrão (vazio)
     */
    public Grupo() {
    }
    
    /**
     * Retorna o número do grupo
     * @return numeroGrupo
     */
    public int getNumeroGrupo() {
        return numeroGrupo;
    }
    
    /**
     * Define o número do grupo
     * @param numeroGrupo 
     */
    public void setNumeroGrupo(int numeroGrupo) {
        this.numeroGrupo = numeroGrupo;
    }

// código obsoleto após implementação com banco de dados
//    /**
//     * Cria um novo grupo
//     */
//    public void criarGrupo() {
//        listaGrupos.add(this);
//    }
//    
//    /**
//     * Exclui um grupo
//     */
//    public void excluirGrupo() {
//        listaGrupos.remove(this);
//    }
//    
//    /**
//     * Adiciona um publicador ao grupo
//     * @param publicador 
//     */
//    public void adicionarPublicador(PublicadorMODEL publicador) {
//        if (publicador != null && !listaPublicadores.contains(publicador)) {
//            listaPublicadores.add(publicador);
//        }
//    }
//    
//    /**
//     * Removeu um publicador do grupo
//     * @param publicador 
//     */
//    public void removerPublicador(int index) {
//        if (index >= 0 && index < listaPublicadores.size()) {
//            listaPublicadores.remove(index);
//        } 
//    }
//    
//    /**
//     * Exine a lista de publicadores cadastrado no grupo
//     * @return 
//     */
//    public List<Publicador> getPublicadores() {
//        return listaPublicadores;
//    }
//    
//    /**
//     * Exibe os grupos cadastrados
//     * @return 
//     */
//    public static List<Grupo> listarGrupos() {
//        return listaGrupos;
//    }
    
}
