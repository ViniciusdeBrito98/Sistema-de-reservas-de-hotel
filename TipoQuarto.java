public enum TipoQuarto {
    LUXO("Luxo", 400.0),
    STANDARD("Standard", 200.0);

    private final String nome;
    private final double valorDiaria;

    TipoQuarto(String nome, double valorDiaria) {
        this.nome = nome;
        this.valorDiaria = valorDiaria;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    @Override
    public String toString() {
        return nome + " (R$" + valorDiaria + ")";
    }
}
