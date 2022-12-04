package controlefrete.enums;

public enum FreteEstadosEnum {
    SC(1, "Santa Catarina"),
    SP(2, "Sao Paulo");

    private int valor;
    private String descricao;

    FreteEstadosEnum(int valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public int getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
}
