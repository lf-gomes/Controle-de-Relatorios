
package model;

/**
 *
 * @author conta
 */
public class Relatorio {
    private String nomePublicador;
    private String grupo;
    private String mes;
    private int PublicadoresQunatidade;
    private int PublicadoresRelatando;
    private int PublicadoresEstudos;
    private int PioneiroAuxiliarQuantidade;	
    private int PioneiroAuxiliarEstudos;
    private int PioneiroRegularQuantidade;	
    private int PioneiroRegularEstudos;
    private int TotaldeEstudos;

    public Relatorio(String nomePublicador, String grupo, int PublicadoresQunatidade, int PublicadoresRelatando, int PublicadoresEstudos, int PioneiroAuxiliarQuantidade, int PioneiroAuxiliarEstudos, int PioneiroRegularQuantidade, int PioneiroRegularEstudos, int TotaldeEstudos, String mes) {
        this.nomePublicador = nomePublicador;
        this.grupo = grupo;
        this.PublicadoresQunatidade = PublicadoresQunatidade;
        this.PublicadoresRelatando = PublicadoresRelatando;
        this.PublicadoresEstudos = PublicadoresEstudos;
        this.PioneiroAuxiliarQuantidade = PioneiroAuxiliarQuantidade;
        this.PioneiroAuxiliarEstudos = PioneiroAuxiliarEstudos;
        this.PioneiroRegularQuantidade = PioneiroRegularQuantidade;
        this.PioneiroRegularEstudos = PioneiroRegularEstudos;
        this.TotaldeEstudos = TotaldeEstudos;
        this.mes = mes;
    }

    public String getNomePublicador() {
        return nomePublicador;
    }

    public void setNomePublicador(String nomePublicador) {
        this.nomePublicador = nomePublicador;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getPublicadoresQunatidade() {
        return PublicadoresQunatidade;
    }

    public void setPublicadoresQunatidade(int PublicadoresQunatidade) {
        this.PublicadoresQunatidade = PublicadoresQunatidade;
    }

    public int getPublicadoresRelatando() {
        return PublicadoresRelatando;
    }

    public void setPublicadoresRelatando(int PublicadoresRelatando) {
        this.PublicadoresRelatando = PublicadoresRelatando;
    }

    public int getPublicadoresEstudos() {
        return PublicadoresEstudos;
    }

    public void setPublicadoresEstudos(int PublicadoresEstudos) {
        this.PublicadoresEstudos = PublicadoresEstudos;
    }

    public int getPioneiroAuxiliarQuantidade() {
        return PioneiroAuxiliarQuantidade;
    }

    public void setPioneiroAuxiliarQuantidade(int PioneiroAuxiliarQuantidade) {
        this.PioneiroAuxiliarQuantidade = PioneiroAuxiliarQuantidade;
    }

    public int getPioneiroAuxiliarEstudos() {
        return PioneiroAuxiliarEstudos;
    }

    public void setPioneiroAuxiliarEstudos(int PioneiroAuxiliarEstudos) {
        this.PioneiroAuxiliarEstudos = PioneiroAuxiliarEstudos;
    }

    public int getPioneiroRegularQuantidade() {
        return PioneiroRegularQuantidade;
    }

    public void setPioneiroRegularQuantidade(int PioneiroRegularQuantidade) {
        this.PioneiroRegularQuantidade = PioneiroRegularQuantidade;
    }

    public int getPioneiroRegularEstudos() {
        return PioneiroRegularEstudos;
    }

    public void setPioneiroRegularEstudos(int PioneiroRegularEstudos) {
        this.PioneiroRegularEstudos = PioneiroRegularEstudos;
    }

    public int getTotaldeEstudos() {
        return TotaldeEstudos;
    }

    public void setTotaldeEstudos(int TotaldeEstudos) {
        this.TotaldeEstudos = TotaldeEstudos;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
    
    
    /**
     * Métodos
     */
    public static void calcularPublicadores() {

    }
    
    public static void calcularTotalEstudo() {
         
     }
    
    public static void calcularMediaAssistencia() {
        
    }
    
    public static void calcularPublicadoresRelatando() {
        
    }
    
    public static void exibirRelatorio() {
        System.out.println(
                "Publicadores\n"
                + "     > Quantidade Relatando: \n"
                + "     > Quantidade Estudos: \n");
        
        System.out.println(
                "Pioneiros Auxiliares\n"
                + "     > Quantidade Relatando: \n"
                + "     > Quantidade Estudos: \n");
        
        System.out.println(
                "Pioneiros Regulares\n"
                + "     > Quantidade Relatando: \n"
                + "     > Quantidade Estudos: \n");
        
        System.out.println(
                "Média de Assistência as Reuniões\n"
                + "     > Meio de Semana: \n"
                + "     > Final de Semana: \n");
        
        System.out.println(
                "Média de Assistência as Reuniões\n"
                + "     > Meio de Semana: \n"
                + "     > Final de Semana: \n");

        System.out.println("Total Estudos (com missionários): \n");
        System.out.println("---------- Fim do Reltório ----------");
    }

}
