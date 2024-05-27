package entities;
import java.time.Year;

public abstract class Veiculo {
    private String typeVeicolo;
    private String marca;
    private String modelo;
    private int ano;
    private String placa;

    public static final int MAX_TEMPO_USO = 30;

    //sobrescrever nas classes filhas
    public abstract double calcularImposto();

    @Override
    public String toString() {
        return this.getTypeVeicolo() + " " 
               + this.getMarca() + " " 
               + this.getModelo() + " " 
               + this.getAno()  + " "
               + this.getPlaca() + " "
               ;

    }
    public Veiculo(){
        this("","","",1900," ");
    }
    public Veiculo(String typeVeicolo,String marca, String modelo, int ano, String placa) {
        this.typeVeicolo = typeVeicolo;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
    }

    public final int calcularTempoDeUso() {
        int anoAtual = Year.now().getValue();
        //int tempoUso = anoAtual - this.ano;
        //return tempoUso;
        return this.calcularTempoDeUso(anoAtual);
    }
    public final int calcularTempoDeUso(int anoBase) {
        int tempoUso = anoBase - this.ano;
        return tempoUso;
    }
    
    //Métodos Getters and Setters
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getTypeVeicolo() {
        return typeVeicolo;
    }

    public void setTypeVeicolo(String typeVeicolo) {
        this.typeVeicolo = typeVeicolo;
    }
    void ligar() {
        System.out.println("Veículo Ligado!");
    }
}
