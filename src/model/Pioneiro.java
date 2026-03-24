
package model;

/**
 *
 * @author conta
 */
public class Pioneiro {
    private String tipoPioneiro;
    private int horas;
    private String obervacao;

    public Pioneiro(String tipoPioneiro, int horas, String obervacao) {
        this.tipoPioneiro = tipoPioneiro;
        this.horas = horas;
        this.obervacao = obervacao;
    }

    public String getTipoPioneiro() {
        return tipoPioneiro;
    }

    public void setTipoPioneiro(String tipoPioneiro) {
        this.tipoPioneiro = tipoPioneiro;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getObervacao() {
        return obervacao;
    }

    public void setObervacao(String obervacao) {
        this.obervacao = obervacao;
    }
    
    

    public static String exibirTipo() {
        return null;
    }
    
    public static String informarObservacao() {
        return null;
    }

}
