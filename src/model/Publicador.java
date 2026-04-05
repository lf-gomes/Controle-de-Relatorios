
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gomes
 */
public class Publicador {
    private String nome;
    private String modalidade;
    private String ativo;
    private int quantidaDeEstudos;
    private int numeroDoGrupo;
    
    private static List<Publicador> listaPublicadores = new ArrayList<>();
    
    public Publicador() {
        //defalt
    }

    public Publicador(String nome, String modalidade, String ativo, int quantidaDeEstudos, int numeroDoGrupo) {
        this.nome = nome;
        this.modalidade = modalidade;
        this.ativo = ativo;
        this.quantidaDeEstudos = quantidaDeEstudos;
        this.numeroDoGrupo = numeroDoGrupo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public int getNumeroDoGrupo() {
        return numeroDoGrupo;
    }

    public void setNumeroDoGrupo(int numeroDoGrupo) {
        this.numeroDoGrupo = numeroDoGrupo;
    }

    public int getQuantidaDeEstudos() {
        return quantidaDeEstudos;
    }

    public void setQuantidaDeEstudos(int quantidaDeEstudos) {
        this.quantidaDeEstudos = quantidaDeEstudos;
    }

    public static List<Publicador> getListaPublicadores() {
        return listaPublicadores;
    }

    public static void setListaPublicadores(List<Publicador> listaPublicadores) {
        Publicador.listaPublicadores = listaPublicadores;
    }
}
