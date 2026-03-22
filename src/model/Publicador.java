
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gomes
 */
public class Publicador {
    private String nome;
    private String grupo;
    private boolean participou;
    private Pioneiro tipo;
    private int quantidadeEstudos;
    
    private static List<Publicador> listaPublicadores = new ArrayList<>();
    
    public Publicador() {
        //defalt
    }

    public Publicador(
            String nome,
            String grupo,
            boolean participou,
            Pioneiro tipo,
            int quantidadeEstudos) {
        this.nome = nome;
        this.grupo = grupo;
        this.participou = participou;
        this.tipo = tipo;
        this.quantidadeEstudos = quantidadeEstudos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public boolean isParticipacao() {
        return participou;
    }

    public void setParticipacao(boolean participou) {
        this.participou = participou;
    }

    public Pioneiro getTipo() {
        return tipo;
    }

    public void setTipo(Pioneiro tipo) {
        this.tipo = tipo;
    }

    public int getQuantidadeEstudos() {
        return quantidadeEstudos;
    }

    public void setQuantidadeEstudos(int quantidadeEstudos) {
        this.quantidadeEstudos = quantidadeEstudos;
    }
    
    public void cadastrar() {
        listaPublicadores.add(this); 
    }
    
    public static List<Publicador> listar() {
        return listaPublicadores;
    }
    

}
