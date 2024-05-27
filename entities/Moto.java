package entities;
public final class Moto extends Veiculo{
    private boolean partidaEletrica;


    @Override
    public String toString() {
        String partida = this.getPartidaEletrica() ? "Sim" : "Não";
            return " " +this.getTypeVeicolo() 
            + "" + this.getMarca()
            + " " + this.getModelo()
            + " " + this.getAno()
            + " - Part. Elétrica: " + partida;
    }

    public boolean getPartidaEletrica() {
        return partidaEletrica;
    }
    public void setPartidaEletrica(boolean partidaEletrica) {
        this.partidaEletrica = partidaEletrica;
    }
    public Moto(String typeVeicolo,String marca, String modelo, int ano, String placa, boolean partidaEletrica) {
        super(typeVeicolo,marca, modelo, ano, placa);
        this.partidaEletrica = partidaEletrica;
    }

    @Override
    public double calcularImposto() {
        return 500.0;
    }
    
    
}
