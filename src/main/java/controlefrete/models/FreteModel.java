package controlefrete.models;

public class FreteModel {
    private String destino;
    private double peso;
    private double valor;

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "FreteModel {" +
                "destino='" + destino + '\'' +
                ", peso=" + peso +
                ", valor=" + valor +
                '}';
    }
}
